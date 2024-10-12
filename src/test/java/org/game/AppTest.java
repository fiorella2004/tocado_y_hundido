package org.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testAdd() {
        App calculator = new App();
        int result = calculator.add(2, 3);
        assertEquals(5, result, "2 + 3 debería ser 5");
    }
}