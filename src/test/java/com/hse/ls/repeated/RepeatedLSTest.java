package com.hse.ls.repeated;

import com.hse.ls.TestUtils;
import com.hse.ls.common.entity.LocalSearchContext;
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
    public void testOnSmallDataSet() {
        Problem p = new Problem(3,
                new int[][]{{1,2,3}, {4,5,6}, {7,8,9}},
                new int[][]{{10, 11, 12}, {13,14,15}, {16,17,18}});

        LocalSearchContext context = new LocalSearchContext(p, 10);
        RepeatedLocalSearch rls = new RepeatedLocalSearch(context);
        Solution s = rls.solve();

        Set<Integer> set = IntStream.of(s.locations).boxed().collect(Collectors.toCollection(HashSet::new));
        Assert.assertEquals(set.size(), s.locations.length);

        System.out.println(s.toString());
        System.out.println("Cost: " + s.cost);
    }

    @Test
    public void testOnTai20a() {
        Problem p = Reader.read(getFile("tai20a"));
        LocalSearchContext context = new LocalSearchContext(p, 5000000);
        RepeatedLocalSearch rls = new RepeatedLocalSearch(context);
        testOnFile(rls);
    }

    @Test
    public void testOnTai40a() {
        Problem p = Reader.read(getFile("tai40a"));
        LocalSearchContext context = new LocalSearchContext(p, 100000);
        RepeatedLocalSearch rls = new RepeatedLocalSearch(context);
        testOnFile(rls);
    }

    @Test
    public void testOnTai60a() {
        Problem p = Reader.read(getFile("tai60a"));
        LocalSearchContext context = new LocalSearchContext(p, 100000);
        RepeatedLocalSearch rls = new RepeatedLocalSearch(context);
        testOnFile(rls);
    }

    @Test
    public void testOnTai80a() {
        Problem p = Reader.read(getFile("tai80a"));
        LocalSearchContext context = new LocalSearchContext(p, 100000);
        RepeatedLocalSearch rls = new RepeatedLocalSearch(context);
        testOnFile(rls);
    }

    @Test
    public void testOnTai100a() {
        Problem p = Reader.read(getFile("tai100a"));
        LocalSearchContext context = new LocalSearchContext(p, 100000);
        RepeatedLocalSearch rls = new RepeatedLocalSearch(context);
        testOnFile(rls);
    }
}
