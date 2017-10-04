package com.hse.ls.common.entity;

/**
 * Entity describes the input parameters for Solving Quadratic Assignment Problem
 */
public class Problem {
    /**
     * Number of Plants/locations
     */
    public final int dim;

    /**
     * Distance Matrix
     */
    public final int[][] distance;

    /**
     * Flows Matrix
     */
    public final int[][] flow;

    public Problem(int dim, int[][] distance, int[][] flow) {
        this.dim = dim;
        this.distance = distance;
        this.flow = flow;
    }
}
