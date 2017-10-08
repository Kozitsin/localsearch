package com.hse.ls.repeated;

import com.hse.ls.common.entity.LocalSearch;
import com.hse.ls.common.entity.Problem;
import com.hse.ls.common.entity.Solution;
import org.apache.commons.math3.util.MathArrays;

public class RepeatedLocalSearch extends LocalSearch {
    private static final int ITERATIONS_WITHOUT_IMPROVEMENT = 1000000;

    public RepeatedLocalSearch(Problem problem) {
        super(problem);
    }

    private void perturb(Solution s) {
        MathArrays.shuffle(s.locations);
        s.evaluate();
    }

    @Override
    public Solution solve() {
        int k = 0;

        Solution best = new Solution(problem);
        Solution current = new Solution(problem);

        while (ITERATIONS_WITHOUT_IMPROVEMENT > k) {
            perturb(current);
            if (current.cost < best.cost) {
                current.copyTo(best);
                k = 0;
            }
            k++;
        }
        return best;
    }
}
