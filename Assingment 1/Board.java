
public class Board {
    private int numRows, numCols;
    private Cell cells[], rows[], cols[], blocks[];

    public String toString() {
        String res = "";
        for (int r = 0; r < numRows * numCols; r++) {
            if (r % numRows == 0) {
                res += horizLine() + "\n";
            }
            for (int c = 0; c < numRows * numCols; c++) {
                if (c % numCols == 0) {
                    res += "|";
                }
                res += cells[r * numRows * numCols + c];
            }
            res += "|\n";
        }

        res += horizLine();
        return res;
    }

    public String horizLine() {
        String res = "";
        for (int i = 0; i < numRows + 1 + (numRows * numCols * (String.valueOf(numRows * numCols).length() + 2)); i++) {
            res += "-";
        }
        return res;
    }

    public void testLinks() {
        System.out.println("Rows forward");

        for (int r = 0; r < numRows * numCols; r++) {
            System.out.print("Row " + r + "\t");
            Cell ptr = rows[r];
            while (ptr != null) {
                System.out.print(indexOf(ptr) + " ");
                ptr = ptr.right;
            }
            System.out.println();
        }

        System.out.println("Cols forward");

        for (int c = 0; c < numRows * numCols; c++) {
            System.out.print("Col " + c + "\t");
            Cell ptr = cols[c];
            while (ptr != null) {
                System.out.print(indexOf(ptr) + " ");
                ptr = ptr.below;
            }
            System.out.println();
        }

        System.out.println("Blocks");
        for (int b = 0; b < numRows * numCols; b++) {
            System.out.print("Block " + b + "\t");
            Cell ptr = blocks[b];
            while (ptr != null) {
                System.out.print(indexOf(ptr) + " ");
                ptr = ptr.block;
            }
            System.out.println();
        }
    }

    public void testCells() {
        System.out.println("Cell\tCoord\tBlock\ttoString");
        for (Cell c : cells) {
            System.out.println(indexOf(c) + "\t(" + c.r + "," + c.c + ")\t" + c.b + "\t" + c);
        }
    }

    public int indexOf(Cell c) {
        for (int i = 0; i < numRows * numRows * numCols * numCols; i++) {
            if (cells[i].equals(c)) {
                return i;
            }
        }
        return -1;
    }

    public Cell cellAt(int r, int c) {
        if (r < 0 || r >= numRows * numCols || c < 0 || c >= numRows * numCols) {
            return null;
        }
        return cells[r * numRows * numCols + c];
    }

    /*
     * Don't change anything above this line
     */

    public Board(int r, int c, String boardString) {
        numRows = r;
        numCols = c;
        cells = new Cell[numRows * numCols * numCols * numRows];

        String[] values = boardString.split(" ");
        for (int i = 0; i < values.length; i++) {
            cells[i] = new Cell(numRows, numCols, values[i]);
        }

        setLinks();

    }

    public void setLinks() {
        // Initialize 2D arrays for rows, columns, and blocks
        rows = new Cell[numRows * numCols];
        cols = new Cell[numRows * numCols];
        blocks = new Cell[numRows * numCols];
        // Set col heads
        for (int i = 0; i < numRows * numCols; i++) {
            cols[i] = cells[i];
        }
        // set row heads
        // int rowcounter = 0;
        // for (int i = 0; i < (numRows * numCols * numRows * numCols); i++) {
        // if (i % (numRows * numCols) == 0) {
        // rows[rowcounter] = cells[i];
        // rowcounter++;
        // }
        // }
        ///// rows
        for (int i = 0; i < numRows * numCols; i++) {
            rows[i] = cells[numRows * numCols * i];
        }

        int rowcounters = 0;

        for (int k = 0; k < numRows * numCols; k++) {
            rowcounters = numCols * numRows * k;
            for (int j = 0; j < numRows * numCols - 1; j++) {
                cells[rowcounters + j].right = cells[rowcounters + j + 1];
            }

            for (int m = 0; m < numRows * numCols; m++)
                cells[rowcounters + m].r = k;
        }

        // int k+=numRows;
        // int j+=numCols;

        int blockcounters = 0;

        for (int k = 0; k < numCols; k++) {
            for (int j = 0; j < numRows; j++) {
                if (true)
                    blocks[blockcounters] = cells[(k * numCols * numRows * numRows) + (j * numCols)];
                blockcounters++;
            }
        }

        for (int i = 0; i < numRows * numCols * numRows * numCols; i++) {
            // if ((i + 1) % (numCols * numCols) != 0)
            // cells[i].right = cells[i + 1];

            if (i + numCols * numRows < cells.length)
                cells[i].below = cells[i + numCols * numRows];

        }
        int cellscounter;
        cellscounter = -1;

        for (int i = 0; i < numRows * numCols; i++) {
            int j = 0;
            while (j < numCols * numRows) {
                cellscounter = cellscounter + 1;
                // cells[cellscounter].r = i;
                cells[cellscounter].c = j;
                j++;
            }
        }

        int counterssss = 0;
        for (int i = 0; i < numRows * numCols; i++) {
            for (int j = 0; j < numRows * numCols; j++) {

                if ((1 + j) % numCols != 0) {
                    cells[counterssss].block = cells[counterssss + 1];
                } else {
                    if (i < (numCols * numRows) - 1)
                        cells[counterssss].block = cells[counterssss - (numCols - 1) + numRows * numCols];
                }
                if ((1 + i) % numRows == 0 && (j + 1) % numCols == 0)
                    cells[counterssss].block = null;
                counterssss++;
            }

        }
        for (int m = 0; m < numCols * numRows; m++) {
            for (Cell ptrtoblock = blocks[m]; ptrtoblock != null; ptrtoblock = ptrtoblock.block) {
                ptrtoblock.b = m;
            }
        }

        // Cell[][] cells2D = new Cell[numRows][numCols];
        // Cell[][] rows2D = new Cell[numRows][numCols];
        // Cell[][] cols2D = new Cell[numCols][numRows];
        // Cell[][] blocks2D = new Cell[numRows][numCols];

        // // Convert 1D cells array to 2D array
        // for (int i = 0; i < numRows; i++) {
        // for (int j = 0; j < numCols; j++) {
        // cells2D[i][j] = cells[i * numCols + j];
        // }
        // }

        // // Set up rows and columns arrays
        // for (int i = 0; i < numRows; i++) {
        // for (int j = 0; j < numCols; j++) {
        // rows2D[i][j] = cells2D[i][j];
        // cols2D[j][i] = cells2D[i][j];
        // }
        // }

        // // Set up blocks array
        // for (int i = 0; i < numRows; i++) {
        // for (int j = 0; j < numCols; j++) {
        // int blockRow = i / 3;
        // int blockCol = j / 3;
        // blocks2D[blockRow][blockCol * 3] = cells2D[i][j];

        // if (j % 3 == 2) {
        // blocks2D[blockRow][(blockCol * 3) + 1] = cells2D[i][j - 1];
        // blocks2D[blockRow][(blockCol * 3) + 2] = cells2D[i][j - 2];
        // }
        // }
        // }

        // // Link the cells within each row, column, and block
        // for (int i = 0; i < numRows; i++) {
        // for (int j = 0; j < numCols; j++) {
        // Cell currCell = cells2D[i][j];
        // currCell.below = (i == numRows - 1) ? null : cells2D[i + 1][j];
        // currCell.right = (j == numCols - 1) ? null : cells2D[i][j + 1];
        // currCell.block = blocks2D[i / 3][j / 3];

        // if (rows2D[i][j] == currCell) {
        // currCell.blockstarter = blocks2D[i / 3][j / 3];
        // }
        // }
        // }
    }

    public void fullProp() {

        for (int i = 0; i < numCols * numCols * numRows * numRows; i++) {
            propCell(cells[i]);
        }
    }

    public void propCell(Cell cell) {
        if (cell.value == null) {
            return;
        }
        int rownumber = cell.r;
        Cell ptr;
        for (ptr = rows[rownumber]; ptr != null; ptr = ptr.right) {

            if (ptr != cell) {
                ptr.removeVal(cell.value);
            }

        }

        int colnumber = cell.c;
        Cell ptrcol;
        for (ptrcol = cols[colnumber]; ptrcol != null; ptrcol = ptrcol.right) {

            if (ptrcol != cell) {
                ptrcol.removeVal(cell.value);
            }
        }

        int blocknumber = cell.b;
        Cell ptrblock;
        for (ptrblock = blocks[blocknumber]; ptrblock != null; ptrblock = ptrblock.right) {

            if (ptrblock != cell) {
                ptrblock.removeVal(cell.value);
            }
        }

    }

    public void solve() {
        int count = 0;
        while (soleCandidate() || uniqueCandidate() || duplicateCells()) {

            count++;

        }

        System.out.println("Number of moves: { " + count + " }");

    }

    public boolean soleCandidate() {
        for (int i = 0; i < numRows * numCols * numRows * numCols; i++) {
            Cell c = cells[i];

            if (c.possibleValues != null && c.possibleValues.head != null && c.possibleValues.length == 1) {

                int value = c.possibleValues.head.data;
                c.setVal(value);
                propCell(c);
                return true;
            }
        }
        return false;

    }

    public boolean uniqueCandidate() {
        for (int i = 0; i < numRows * numCols; i++) {
            Cell row = rows[i];
            int[] counts = new int[numRows * numCols];
            Cell rowPtr = row;
            while (rowPtr != null) {
                if (rowPtr.possibleValues != null) {
                    Node<Integer> nodePtr = rowPtr.possibleValues.head;
                    while (nodePtr != null) {
                        counts[nodePtr.data - 1]++;
                        nodePtr = nodePtr.next;
                    }
                }
                rowPtr = rowPtr.right;
            }
            for (int j = 0; j < numRows * numCols; j++) {
                if (counts[j] == 1) {
                    rowPtr = row;
                    while (rowPtr != null) {
                        if (rowPtr.possibleValues != null && rowPtr.possibleValues.contains(j + 1)) {
                            rowPtr.setVal(j + 1);
                            propCell(rowPtr);
                            return true;
                        }
                        rowPtr = rowPtr.right;
                    }
                    return true;
                }
            }
        }
        // cols
        for (int i = 0; i < numRows * numCols; i++) {
            Cell col = cols[i];
            int[] counts = new int[numRows * numCols];
            Cell colPtr = col;
            while (colPtr != null) {
                if (colPtr.possibleValues != null) {
                    Node<Integer> nodePtr = colPtr.possibleValues.head;
                    while (nodePtr != null) {
                        counts[nodePtr.data - 1]++;
                        nodePtr = nodePtr.next;
                    }
                }
                colPtr = colPtr.below;
            }
            for (int j = 0; j < numRows * numCols; j++) {
                if (counts[j] == 1) {
                    colPtr = col;
                    while (colPtr != null) {
                        if (colPtr.possibleValues != null && colPtr.possibleValues.contains(j + 1)) {
                            colPtr.setVal(j + 1);
                            propCell(colPtr);
                            return true;
                        }
                        colPtr = colPtr.below;
                    }
                    return true;
                }
            }
        }
        // blocks
        for (int i = 0; i < numRows * numCols; i++) {
            Cell block = blocks[i];
            int[] counts = new int[numRows * numCols];
            Cell blockPtr = block;
            while (blockPtr != null) {
                if (blockPtr.possibleValues != null) {
                    Node<Integer> nodePtr = blockPtr.possibleValues.head;
                    while (nodePtr != null) {
                        counts[nodePtr.data - 1]++;
                        nodePtr = nodePtr.next;
                    }
                }
                blockPtr = blockPtr.block;
            }
            for (int j = 0; j < numRows * numCols; j++) {
                if (counts[j] == 1) {
                    blockPtr = block;
                    while (blockPtr != null) {
                        if (blockPtr.possibleValues != null && blockPtr.possibleValues.contains(j + 1)) {
                            blockPtr.setVal(j + 1);
                            propCell(blockPtr);
                            return true;
                        }
                        blockPtr = blockPtr.block;
                    }
                    return true;
                }
            }
        }

        return false;
    }

    public boolean duplicateCells() {

        for (int row = 0; row < numRows; row++) {
            Cell rowPtr = rows[row];
            while (rowPtr != null) {
                if (rowPtr.possibleValues != null && rowPtr.possibleValues.length == 2) {
                    Cell secondPtr = rowPtr.right;
                    while (secondPtr != null) {
                        if (rowPtr.possibleValues.equals(secondPtr.possibleValues)) {
                            Cell thirdPtr = rows[row];
                            boolean change = false;
                            while (thirdPtr != null) {
                                if ((thirdPtr != secondPtr) && (thirdPtr != rowPtr)
                                        && thirdPtr.possibleValues != null) {
                                    change = (change || thirdPtr.possibleValues.remove(rowPtr.possibleValues));
                                }
                                thirdPtr = thirdPtr.right;
                            }
                            if (change) {
                                return true;
                            }
                        }
                        secondPtr = secondPtr.right;
                    }
                }
                rowPtr = rowPtr.right;
            }
        }
        // cols
        for (int col = 0; col < numRows; col++) {
            Cell colPtr = cols[col];
            while (colPtr != null) {
                if (colPtr.possibleValues != null && colPtr.possibleValues.length == 2) {
                    Cell secondPtr = colPtr.below;
                    while (secondPtr != null) {
                        if (colPtr.possibleValues.equals(secondPtr.possibleValues)) {
                            Cell thirdPtr = cols[col];
                            boolean change = false;
                            while (thirdPtr != null) {
                                if ((thirdPtr != secondPtr) && (thirdPtr != colPtr)
                                        && thirdPtr.possibleValues != null) {
                                    change = (change || thirdPtr.possibleValues.remove(colPtr.possibleValues));
                                }
                                thirdPtr = thirdPtr.below;
                            }
                            if (change) {
                                return true;
                            }
                        }
                        secondPtr = secondPtr.below;
                    }
                }
                colPtr = colPtr.below;
            }
        }
        // blocks
        for (int block = 0; block < numRows; block++) {
            Cell blockPtr = blocks[block];
            while (blockPtr != null) {
                if (blockPtr.possibleValues != null && blockPtr.possibleValues.length == 2) {
                    Cell secondPtr = blockPtr.block;
                    while (secondPtr != null) {
                        if (blockPtr.possibleValues.equals(secondPtr.possibleValues)) {
                            Cell thirdPtr = blocks[block];
                            boolean change = false;
                            while (thirdPtr != null) {
                                if ((thirdPtr != secondPtr) && (thirdPtr != blockPtr)
                                        && thirdPtr.possibleValues != null) {
                                    change = (change || thirdPtr.possibleValues.remove(blockPtr.possibleValues));
                                }
                                thirdPtr = thirdPtr.block;
                            }
                            if (change) {
                                return true;
                            }
                        }
                        secondPtr = secondPtr.block;
                    }
                }
                blockPtr = blockPtr.block;
            }
        }
        return false;
    }

}
