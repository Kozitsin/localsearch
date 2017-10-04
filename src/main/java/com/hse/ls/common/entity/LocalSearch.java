package com.hse.ls.common.entity;

public abstract class LocalSearch {
    protected final Problem problem;

    public LocalSearch(final Problem problem) {
        this.problem = problem;
    }

    public abstract Solution solve();
}
