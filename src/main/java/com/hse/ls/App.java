package com.hse.ls;

import com.hse.ls.common.entity.LocalSearch;
import com.hse.ls.common.entity.LocalSearchContext;
import com.hse.ls.common.entity.Problem;
import com.hse.ls.common.entity.Solution;
import com.hse.ls.common.exceptions.DataProcessingException;
import com.hse.ls.common.io.Reader;
import com.hse.ls.common.io.Writer;
import com.hse.ls.guided.GuidedLocalSearch;
import com.hse.ls.iterated.IteratedLocalSearch;
import com.hse.ls.repeated.RepeatedLocalSearch;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class App {
    private static final String GLS = "gls";
    private static final String ILS = "ils";
    private static final String RLS = "rls";

    public static void main(String[] args) {
        if (ArrayUtils.isEmpty(args)) {
            throw new DataProcessingException("Arguments can not be empty!");
        }

        if (args.length != 2) {
            throw new DataProcessingException("There should be only 2 arguments!");
        }

        String fileName = args[0];
        if (StringUtils.isEmpty(fileName)) {
            throw new DataProcessingException("FileName must be specified!");
        }

        String algo = args[1];
        if (StringUtils.isEmpty(fileName)) {
            throw new DataProcessingException("Algorithm must be specified!");
        }

        Problem p = Reader.read(fileName);
        LocalSearch localSearch;
        LocalSearchContext context;
        switch (algo) {
            case GLS:
                context = new LocalSearchContext(p, 10000);
                localSearch = new GuidedLocalSearch(context);
                break;
            case ILS:
                context = new LocalSearchContext(p, 1000000);
                localSearch = new IteratedLocalSearch(context);
                break;
            case RLS:
                context = new LocalSearchContext(p, 10000000);
                localSearch = new RepeatedLocalSearch(context);
                break;
            default:
                throw new DataProcessingException("Unknown algorithm specified. Should be one of: {gls, ils, rls}.");
        }
        Solution solution = localSearch.solve();

        Writer.write(fileName + ".sol", solution);
    }
}
