package com.hse.ls.iterated;

import com.hse.ls.common.entity.LocalSearch;
import com.hse.ls.common.entity.Problem;
import com.hse.ls.common.entity.Solution;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.util.MathArrays;

public class IteratedLocalSearch extends LocalSearch {
    private static final int ITERATIONS_WITHOUT_IMPROVEMENT = 10000;
    private Solution best;
    public IteratedLocalSearch(Problem problem) {
        super(problem);
    }

    private void perturb(Solution s) {
        MathArrays.shuffle(s.locations);
        s.evaluate();
    }

    private Solution localSearch(Solution s) {
        int[] locations =  ArrayUtils.clone(s.locations);


        Solution current;

        for (int i = 0; i < locations.length; i++) {
            for (int j = i + 1; j < locations.length; j++) {
                ArrayUtils.swap(locations, i, j);
                current = new Solution(problem, ArrayUtils.clone(locations));

                if (current.cost < best.cost) {
                    current.copyTo(best);
                }

                ArrayUtils.swap(locations, i, j);
            }
        }

        return best;
    }

    @Override
    public Solution solve() {

        int i = 0;

        Solution current = new Solution(problem);
        best = new Solution(current);

        while (ITERATIONS_WITHOUT_IMPROVEMENT > i){
            perturb(current);
            localSearch(current);

            i++;
        }

        return best;
    }
}

