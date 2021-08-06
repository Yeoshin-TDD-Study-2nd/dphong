package mineMap;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MineTest {
    private int row;
    private int col;

    @Test
    void create() {
        Mine mine = new Mine(1, 2);

        assertNotNull(mine);
        assertEquals(1, mine.getCol());
        assertEquals(2, mine.getRow());
    }

    @Test
    void generateMine() {
        Mine mine = Mine.generate();

        System.out.println(mine.getCol());
        System.out.println(mine.getRow());
        assertTrue(mine.getCol() <= 10);
        assertTrue(mine.getRow() <= 8);
    }

    @RepeatedTest(100)
    void createRandomPos() {
        int randCol = (int)(Math.random() * 10) % 8;

        System.out.println(randCol);
    }
}
