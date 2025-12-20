package ru.perm.v.family.simplejava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

    Integer i1;
    Integer i2;
    int i3;

    @Test
    void SimpleInt() {
        assertEquals(i1, i2);
        assertNull(i1);
        assertNull(i2);
        assertEquals(0, i3);
    }

    @Test
    void nullPointerException() {
        Map numberAndCount = new HashMap<Integer, Integer>();
        numberAndCount.put(1, 1);
        assertThrows(NullPointerException.class, (Executable) numberAndCount.get(3));
    }

    @Test
    void testExpectedExceptionWithParentType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Integer.parseInt("One"));
    }
}
