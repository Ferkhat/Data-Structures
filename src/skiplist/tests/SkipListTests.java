package skiplist.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import skiplist.SkipList;

import static org.junit.Assert.*;

public class SkipListTests {

    SkipList<Integer> sl;
    @Before
    public void setUp() throws Exception {
        System.out.println("JUnit: Setting up!");
        sl = new SkipList<>(1);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("JUnit: Shutting down!");
        sl = null;
        assertNull(sl);
    }

    @Test
    public void insert() {
        System.out.println("JUnit: Running insertion test!");
        for(int i = 0; i < 10; i++){
            sl.insert(i);
        }

        assertTrue(sl.search(3));
    }

    @Test
    public void search() {
    }
}