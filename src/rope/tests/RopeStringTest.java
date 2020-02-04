package rope.tests;

import org.junit.Before;
import org.junit.Test;
import rope.RopeNode;
import rope.RopeString;

import static org.junit.Assert.*;

public class RopeStringTest {
    RopeString rs;
    @Before
    public void setup(){
        rs = new RopeString();
        rs.root = new RopeNode();
        rs.root.setLeft(new RopeNode());
        rs.root.getLeft().setLeft(new RopeNode("test"));
        rs.root.getLeft().setRight(new RopeNode("word"));
        rs.root.setWeight(8);
        rs.root.setRight(new RopeNode("two"));
    }
    @Test
    public void test_index(){
        RopeString rs = new RopeString();

        rs.root = new RopeNode();
        rs.root.setLeft(new RopeNode("test"));
        rs.root.setRight(new RopeNode("word"));
        System.out.println(rs.index(8));
    }

    @Test
    public void test_split1(){
        RopeNode[] s;
        s = rs.split(1);
    }
    @Test
    public void test_split2(){
        RopeNode[] s;
        s = rs.split(2);
    }
    @Test
    public void test_split3(){
        RopeNode[] s;
        s = rs.split(3);
    }
    @Test
    public void test_split4(){
        RopeNode[] s;
        s = rs.split(4);
    }

    @Test
    public void test_split5(){
        RopeNode[] s;
        s = rs.split(5);
    }
    @Test
    public void test_split6(){
        RopeNode[] s;
        s = rs.split(6);
    }
    @Test
    public void test_split7(){
        RopeNode[] s;
        s = rs.split(7);
    }
    @Test
    public void test_split8(){
        RopeNode[] s;
        s = rs.split(8);
    }
    @Test
    public void test_split9(){
        RopeNode[] s;
        s = rs.split(9);
    }
    @Test
    public void test_split10(){
        RopeNode[] s;
        s = rs.split(10);
    }
    @Test
    public void test_split11(){
        RopeNode[] s;
        s = rs.split(15);
    }
}