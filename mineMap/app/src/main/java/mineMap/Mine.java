package mineMap;

import java.util.Objects;

public class Mine {
    private int col; // col <= 10
    private int row; // row <= 8

    public Mine(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public static Mine generate() {
        int randCol = (int)(Math.random() * 100) % 10;
        int randRow = (int)(Math.random() * 100) % 8;

        return new Mine(randCol, randRow);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mine mine = (Mine) o;
        return col == mine.col && row == mine.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }
}
