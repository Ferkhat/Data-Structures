package skiplist.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import skiplist.SkipList;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class SkipListTests {

    SkipList<Integer> sl;
    @Before
    public void setUp() throws Exception {
        System.out.println("JUnit: Setting up!");
        sl = new SkipList<>(10000);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("JUnit: Shutting down!");
        sl = null;
        assertNull(sl);
    }

    @Test
    public void insert_test_1() {
        System.out.println("JUnit: Running insertion test 1!");
        for(int i = 0; i < 50000; i++){
            sl.insert(i);
        }

        for(int i = 0; i < 50000; i++){
            assertTrue(sl.search(i));
        }
    }


    @Test
    public void insert_test_2() {
        System.out.println("JUnit: Running insertion test 2!");

        Random rand = new Random(200);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            int r = rand.nextInt(20000);
            arr.add(r);
            sl.insert(r);
        }

        for(int i = 0; i < 1000; i++){
            assertTrue(sl.search(arr.get(i)));
        }

        for(int i = 0; i < 1000; i++){
            int r = rand.nextInt(20000);
            if (!arr.contains(r)){
                assertTrue(!sl.search(r));
            }
        }
    }


    @Test
    public void search() {
    }
}