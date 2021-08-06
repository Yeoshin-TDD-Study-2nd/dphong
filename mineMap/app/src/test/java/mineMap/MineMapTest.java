package mineMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class MineMapTest {
    MineMap mineMap;

    @BeforeEach
    void setUp() {
        this.mineMap = new MineMap(10, 8);
    }

    @Test
    void create() {
        assertNotNull(mineMap);
    }

    @Test
    void getSize() {
        assertEquals(10, mineMap.getWidth());
        assertEquals(8, mineMap.getHeight());
    }

    @Test
    void getMineList() {
        Set<Mine> list = mineMap.getMineList();

        assertNotNull(list);
    }

    @Test
    void setMineList() {
        mineMap.setMineList();

        Set<Mine> mineList = mineMap.getMineList();
        mineList.forEach(mine -> System.out.println(mine.getRow() + "//" + mine.getCol()));

        assertNotNull(mineList);
        assertEquals(10, mineList.size());
    }

    @Test
    void insertMinesToMap() {
        mineMap.setMineList();

        int[][] map = mineMap.insertMinesToMap();

        assertNotNull(map);
        assertDoesNotThrow(() -> {
            int count = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 10; j++) {
                    if (map[i][j] == -1) {
                        count++;
                    }
                }
            }

            if (count != 10) {
                throw new Exception("지뢰가 잘못 만들어졌다.");
            }
        });
    }

    @Test
    void printMap() {
        mineMap.setMineList();
        mineMap.insertMinesToMap();
        mineMap.printMap();
    }

    @Test
    void addNumberAroundMine() {
        mineMap.setMineList();
        mineMap.insertMinesToMap();
        mineMap.printMap();

        List<Mine> mines = mineMap.getMineList().stream().collect(Collectors.toList());
        Mine mine = mines.get(0);

        System.out.println(mine.getRow() + "///" + mine.getCol());

        mineMap.addNumberAroundMine(mine);

        mineMap.printMap();
    }

    @Test
    void setNumberAroundMine() {
        mineMap.setMineList();
        mineMap.insertMinesToMap();
        mineMap.setNumberAroundMine();
        mineMap.printMap();
    }
}
