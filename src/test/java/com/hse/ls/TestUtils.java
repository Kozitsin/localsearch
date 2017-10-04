package com.hse.ls;

public abstract class TestUtils {

    protected String getFile(String problemName) {
        return this.getClass().getClassLoader().getResource(problemName).getPath();
    }
}
