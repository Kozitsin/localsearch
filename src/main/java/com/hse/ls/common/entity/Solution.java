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

    /**
     * {@see http://www.lsi.upc.es/~mallba/public/library/TabuSearch/qap.html/}
     */
    public int evaluate(Problem p) {
        cost = 0;
        int n = locations.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = locations[i];
                int b = locations[j];
                cost += p.flow[i][j] * p.distance[a][b];
            }
        }
        return cost;
    }

    @Override
    public String toString() {
        return Arrays.toString(locations);
    }
}
