package com.hse.ls.repeated;

import com.hse.ls.TestUtils;
import com.hse.ls.common.entity.Problem;
import com.hse.ls.common.entity.Solution;
import com.hse.ls.common.io.Reader;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RepeatedLSTest extends TestUtils {

    @Test
    public void readShouldReturnCorrectProblemEntity() {
        Problem p = Reader.read(getFile("tai20a"));

        RepeatedLocalSearch rls = new RepeatedLocalSearch(p);
        Solution s = rls.solve();

        Set<Integer> set = IntStream.of(s.locations).boxed().collect(Collectors.toCollection(HashSet::new));
        Assert.assertEquals(set.size(), s.locations.length);

        System.out.println(s.toString());
        System.out.println("Cost: " + s.cost);
    }
}
