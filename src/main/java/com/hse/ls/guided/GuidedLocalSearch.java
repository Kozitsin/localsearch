package com.hse.ls.guided;

import com.hse.ls.common.entity.LocalSearch;
import com.hse.ls.common.entity.Problem;
import com.hse.ls.common.entity.Solution;
import org.apache.commons.math3.util.MathArrays;

import java.util.stream.IntStream;

public class GuidedLocalSearch extends LocalSearch {

    public GuidedLocalSearch(Problem problem) {
        super(problem);
    }

    private Solution init() {
        Solution s = new Solution(problem);
        MathArrays.shuffle(s.locations);
        s.evaluate(problem);
        return s;
    }

    @Override
    public Solution solve() {
        Solution best = new Solution(problem);
        Solution current = init();

        //int[] penalties = new int[];
        return null;
    }
}
