package com.hse.ls.common.io;

import com.hse.ls.common.entity.Problem;
import org.junit.Assert;
import org.junit.Test;


public class ReaderTest {
    @Test
    public void readShouldReturnCorrectProblemEntity() {
        String fileName = this.getClass().getClassLoader().getResource("tai20a").getPath();
        Problem p = Reader.read(fileName);

        Assert.assertEquals(20, p.dim);
        Assert.assertEquals(p.distance.length, p.dim);
        Assert.assertEquals(p.flow.length, p.dim);
    }
}
