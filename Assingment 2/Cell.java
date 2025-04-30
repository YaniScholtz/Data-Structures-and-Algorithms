public class Cell implements Comparable<Cell> {
    int databaseRow;
    String value;

    public Cell(int row, String value) {
        databaseRow = row;
        this.value = value;

    }

    public int getrow() {
        return databaseRow;
    }

    @Override
    public int compareTo(Cell o) {
        return value.compareTo(o.value);
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(((Cell) obj).value);
    }

    @Override
    public String toString() {
        return value + "{" + databaseRow + "}";
    }
}
