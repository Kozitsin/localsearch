package com.hse.ls.guided;

import com.hse.ls.common.entity.LocalSearch;
import com.hse.ls.common.entity.Problem;
import com.hse.ls.common.entity.Solution;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GuidedLocalSearch extends LocalSearch {
    private static final int ITERATIONS_WITHOUT_IMPROVEMENT = 10000;

    private int[] penalties;

    private GuidedSolution best;

    public GuidedLocalSearch(Problem problem) {
        super(problem);
        penalties = new int[problem.dim * problem.dim];
    }

    private GuidedSolution localSearch(GuidedSolution prev) {
        int[] locations =  ArrayUtils.clone(prev.locations);

        GuidedSolution localBest = new GuidedSolution(prev);
        GuidedSolution current;

        for (int i = 0; i < locations.length; i++) {
            for (int j = i + 1; j < locations.length; j++) {
                ArrayUtils.swap(locations, i, j);
                current = new GuidedSolution(problem, ArrayUtils.clone(locations), penalties);

                if (current.augmentedCost < localBest.augmentedCost) {
                    current.copyTo(localBest);
                }

                if (current.cost < best.cost) {
                    current.copyTo(best);
                }

                ArrayUtils.swap(locations, i, j);
            }
        }

        return localBest;
    }

    @Override
    public Solution solve() {
        int k = 0;
        GuidedSolution current = new GuidedSolution(problem, penalties);
        best = new GuidedSolution(current);

        while (ITERATIONS_WITHOUT_IMPROVEMENT > k) {
            current = localSearch(current);
            current.calculateUtility(penalties);
            updatePenalties(current);
            k++;
        }
        return best;
    }

    private void updatePenalties(final GuidedSolution current) {
        double max = Arrays.stream(current.features)
                .parallel()
                .mapToDouble(f -> f.utility)
                .max().getAsDouble();

        IntStream.range(0, current.features.length)
                .parallel()
                .filter(ix -> current.features[ix].utility == max)
                .forEach(ix -> penalties[ix]++);
    }
}
