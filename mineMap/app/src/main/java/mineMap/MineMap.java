package mineMap;

import java.util.HashSet;

public class MineMap {
    private int width;
    private int height;
    private HashSet<Mine> mines;
    private int[][] map = new int[8][10];

    private int[] dx = {1, -1, 0, 0, 1, -1, 1, -1}; // 횡방향
    private int[] dy = {0, 0, 1, -1, -1, -1, 1, 1}; // 종방향

    public MineMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setMineList() {
        mines = new HashSet<>();

        while (mines.size() < 10) {
            mines.add(Mine.generate());
        }
    }

    public HashSet<Mine> getMineList() {
        return this.mines;
    }

    public int[][] insertMinesToMap() {
        mines.forEach(mine -> {
            map[mine.getRow()][mine.getCol()] = -1;
        });

        return map;
    }

    public void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append((map[i][j] == -1 ? "M" : map[i][j]) + "\t");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    public void addNumberAroundMine(Mine mine) {
        int row = mine.getRow();
        int col = mine.getCol();

        for (int i = 0; i < 8; i++) {
            int tempRow = row + dy[i];
            int tempCol = col + dx[i];

            if (tempRow > -1 && tempRow < height) {
                if (tempCol > -1 && tempCol < width) {
                    if (map[tempRow][tempCol] == -1) {
                        continue;
                    }

                    map[tempRow][tempCol]++;
                }
            }
        }
    }

    public void setNumberAroundMine() {
        mines.forEach(mine -> this.addNumberAroundMine(mine));
    }
}
