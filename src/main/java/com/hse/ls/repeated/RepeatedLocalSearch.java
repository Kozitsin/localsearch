package com.hse.ls.repeated;

import com.hse.ls.common.entity.LocalSearch;
import com.hse.ls.common.entity.LocalSearchContext;
import com.hse.ls.common.entity.Solution;

public class RepeatedLocalSearch extends LocalSearch {

    public RepeatedLocalSearch(final LocalSearchContext context) {
        super(context);
    }

    @Override
    public Solution solve() {
        context.best = new Solution(context.problem);
        Solution current = new Solution(context.problem);

        while (!context.shouldBreak()) {
            perturb(current);
            context.storeBest(current);
        }

        return context.best;
    }
}
