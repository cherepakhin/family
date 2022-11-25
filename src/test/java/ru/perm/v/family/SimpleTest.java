package ru.perm.v.family;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

    class A{

    };
    class B {

    };


    @Test
    void simpleTest() {
        if(null==null)  {
            System.out.println("null==null");
        }
        assertTrue(null==null);
        A a = null;
        B b = null;
        assertEquals(a,b);
        a = new A();
        b = new B();
        assertNotEquals(a,b);
//        A aa;
//        B bb = null;
//        if(aa==bb)  {
//            System.out.println("===");
//        }
    }
}
