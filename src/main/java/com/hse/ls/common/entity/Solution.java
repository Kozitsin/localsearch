package com.hse.ls.common.entity;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int[] locations;
    public int cost;

    public Solution(Problem p) {
        this.locations = IntStream.rangeClosed(0, p.dim - 1).toArray();
        this.cost = evaluate(p);
    }

    public void copyTo(Solution s) {
        s.locations = ArrayUtils.clone(this.locations);
        s.cost = this.cost;
    }

    public int evaluate(Problem p) {
        cost = 0;
        for (int i = 0; i < locations.length - 1; i++) {
            cost += p.distance[locations[i]][locations[i + 1]] * p.flow[locations[i]][locations[i + 1]];
        }
        return cost;
    }

    @Override
    public String toString() {
        return Arrays.toString(locations);
    }
}
