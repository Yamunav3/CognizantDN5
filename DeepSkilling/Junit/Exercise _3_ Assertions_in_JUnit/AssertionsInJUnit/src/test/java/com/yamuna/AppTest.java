package com.yamuna;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals("2 + 3 should equal 5", 5, 2 + 3);

        // Assert true
        assertTrue("5 should be greater than 3", 5 > 3);

        // Assert false
        assertFalse("5 should not be less than 3", 5 < 3);

        // Assert null
        assertNull("Value should be null", null);

        // Assert not null
        assertNotNull("Object should not be null", new Object());

        // Assert same (reference equality)
        String s1 = "hello";
        String s2 = "hello";
        assertSame("Same string literal should reference the same object", s1, s2);

    }

    @Test
    public void testGroupedAssertions() {
        // JUnit4 has no assertAll -- each assertion just runs sequentially.
        // If one fails, the test stops there (no grouped failure reporting).
        assertEquals(4, 2 + 2);
        assertTrue(10 > 5);
        assertFalse(1 > 2);
    }
}