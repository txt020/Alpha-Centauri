package com.example.knowyourlimit;

import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTesting {
    @Test
    public void total_isCorrect1() {
        assertEquals(2000,
                MainMenu.addTotalBudget(3000,250,250,250,
                        250, 0),0);
    }
    @Test
    public void total_isCorrect2() {
        assertEquals(2000,
                MainMenu.addTotalBudget(3000,20,700,180,
                        100, 0),0);
    }
    @Test
    public void total_isCorrect3() {
        assertEquals(2000,
                MainMenu.addTotalBudget(3000,15.76,651.77,168.23,
                        164.24, 0),0);
    }
    @Test
    public void total_isCorrect4() {
        assertEquals(6376.34,
                MainMenu.addTotalBudget(8000,106.5,784.66,132.5,
                        600, 0),0);
    }
    @Test
    public void total_isCorrect5() {
        assertEquals(12433.45,
                MainMenu.addTotalBudget(14000,142.54,783.27,445.34,
                        195.4, 0),0);
    }
}
