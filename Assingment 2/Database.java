
@SuppressWarnings("unchecked")
public class Database {
    String[][] database;
    String[] columnNames;
    Treap<Cell>[] indexes;
    int maxSize;
    int currentsize;

    public Database(String[] cols, int maxSize) {
        this.maxSize = maxSize;
        currentsize = 0;
        database = new String[maxSize][cols.length];
        columnNames = new String[cols.length];
        for (int i = 0; i < cols.length; i++) {
            columnNames[i] = cols[i];
        }
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < columnNames.length; j++) {
                database[i][j] = null;
            }
        }

        indexes = new Treap[columnNames.length];
        for (int i = 0; i < columnNames.length; i++)
            indexes[i] = null;

    }

    private int HelperIndex(String col) throws DatabaseException {

        for (int i = 0; i < columnNames.length; i++) {
            if (col == columnNames[i]) {
                return i;
            }
        }
        throw DatabaseException.invalidColumnName(col);

    }

    public void insert(String[] newRowDetails) throws DatabaseException {
        if (newRowDetails.length != columnNames.length) {
            throw DatabaseException.invalidNumberOfColums();
        }
        int findemptyrow = -1;
        for (int i = 0; i < database.length; i++) {
            if (database[i][0] == null) {
                findemptyrow = i;
            }
        }

        for (int i = 0; i < columnNames.length; i++) {
            if (indexes[i] != null) {
                Cell newcell = new Cell(findemptyrow, newRowDetails[i]);
                try {
                    if (indexes[i].access(newcell) == null) {
                        indexes[i].insert(newcell);
                    } else
                        throw DatabaseException.duplicateInsert(newRowDetails[i]);
                } catch (DatabaseException e) {
                    throw e;
                }
            }
        }
        currentsize++;
        if (currentsize > maxSize) {
            throw DatabaseException.databaseFull();
        }
        for (int i = 0; i < database.length; i++) {
            if (database[i][0] == null) {
                for (int j = 0; j < columnNames.length; j++) {
                    database[i][j] = newRowDetails[j];
                }
                break;
            }
        }
    }

    public String[] removeFirstWhere(String col, String data) throws DatabaseException {
        int colIndex = HelperIndex(col);
        // int i = 0;
        // Checks if database is empty
        boolean empty = true;
        for (int i = 0; i < database.length; i++) {
            if (database[i][0] != null) {
                empty = false;
            }
        }
        if (empty) {
            return new String[0];
        }
        if (indexes[colIndex] != null) {
            Node<Cell> newcell = indexes[colIndex].remove(new Cell(-1, data));
            if (newcell != null) {
                String[] rowdata = new String[columnNames.length];
                for (int i = 0; i < columnNames.length; i++) {
                    rowdata[i] = database[newcell.data.getrow()][i];
                    database[newcell.data.getrow()][i] = null;
                }

                for (int i = 0; i < columnNames.length; i++) {
                    if (indexes[i] != null && (i != colIndex)) {
                        indexes[i].remove(new Cell(-1, rowdata[i]));
                    }
                }
                return rowdata;
            } else
                return new String[0];

        } else {
            String[] rowdata = new String[0];
            for (int k = 0; k < database.length; k++) {
                if (database[k][colIndex] == data) {
                    rowdata = new String[columnNames.length];
                    for (int i = 0; i < columnNames.length; i++) {
                        rowdata[i] = database[k][i];
                        database[k][i] = null;
                        if (indexes[i] != null) {
                            indexes[i].remove(new Cell(-1, rowdata[i]));
                        }
                    }
                    break;
                }

            }
            return rowdata;
        }
    }

    public String[][] removeAllWhere(String col, String data) throws DatabaseException {
        int colindex = HelperIndex(col);
        if (colindex == -1)
            throw DatabaseException.invalidColumnName(col);

        // String[] removearr = removeFirstWhere(col, data);
        String[][] finalremove = new String[maxSize][columnNames.length];

        int counts = 0;
        boolean flag = true;
        do
            while (counts < finalremove.length && flag) {
                finalremove[counts] = removeFirstWhere(col, data);
                if (finalremove[counts].length == 0) {
                    flag = false;
                } else {
                    counts++;
                }
            }
        while (flag);
        String[][] returner = new String[counts][columnNames.length];
        for (int i = 0; i < counts; i++) {
            returner[i] = finalremove[i];
        }
        return returner;
    }

    public String[] findFirstWhere(String col, String data) throws DatabaseException {
        int colIndex = 0;
        try {
            int tryer = HelperIndex(col);
            colIndex = tryer;
        } catch (DatabaseException e) {
            throw e;
        }

        if (indexes[colIndex] != null) {

            Node<Cell> newcell = indexes[colIndex].access(new Cell(-1, data));
            if (newcell != null) {
                String[] rowdata = database[newcell.data.getrow()];
                return rowdata;

            } else {
                return new String[0];
            }
        } else {
            String[] rowdata = new String[0];
            for (int k = 0; k < database.length; k++) {
                if (database[k][colIndex] == data) {
                    rowdata = database[k];
                    break;
                }
            }
            return rowdata;
        }
    }

    public String[][] findAllWhere(String col, String data) throws DatabaseException {
        int colindex = HelperIndex(col);
        if (colindex == -1)
            throw DatabaseException.invalidColumnName(col);
        int counter = 0;
        String[][] finalremove = new String[maxSize][columnNames.length];
        for (int i = 0; i < finalremove.length; i++) {
            finalremove[i][0] = null;
        }
        if (indexes[colindex] == null) {
            for (int i = 0; i < database.length; i++) {
                if (database[i][colindex] == data) {
                    finalremove[counter] = database[i];
                    counter++;
                }
            }
        } else {
            if (indexes[colindex].access(new Cell(-1, data)) == null) {
                return new String[0][columnNames.length];
            } else {
                for (int i = 0; i < database.length; i++) {
                    if (database[i][colindex] == data) {
                        finalremove[counter] = database[i];
                        counter++;
                    }
                }
            }
        }
        String[][] results = new String[counter][columnNames.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = finalremove[i];
        }
        return results;
    }

    public String[] updateFirstWhere(String col, String updateCondition, String data) throws DatabaseException {
        int colIndex = HelperIndex(col);

        if (indexes[colIndex] != null) {

            Node<Cell> newcell = indexes[colIndex].remove(new Cell(-1, updateCondition));
            if (newcell != null) {
                indexes[colIndex].insert(new Cell(newcell.data.getrow(), data));
                String[] getRow = new String[columnNames.length];
                database[newcell.data.getrow()][colIndex] = data;
                getRow = database[newcell.data.getrow()];
                return getRow;
            } else {
                return new String[0];
            } // } else {
              // return new String[0];
        } else {
            String[] rowdata = new String[0];
            for (int k = 0; k < maxSize; k++) {
                if (database[k][colIndex] == updateCondition) {
                    database[k][colIndex] = data;
                    rowdata = database[k];
                    // database[k] = null;
                    break;

                }

            }
            return rowdata;
        }
    }

    public String[][] updateAllWhere(String col, String updateCondition, String data) throws DatabaseException {
        int colindex = HelperIndex(col);
        if (colindex == -1)
            throw DatabaseException.invalidColumnName(col);

        String[] updatearr = updateFirstWhere(col, updateCondition, data);
        String[][] finalupdate = new String[maxSize][columnNames.length];

        int counts = 0;
        while (updatearr.length != 0) {
            finalupdate[counts] = updatearr;
            updatearr = updateFirstWhere(col, updateCondition, data);
            counts++;
        }
        String[][] resultant = new String[counts][columnNames.length];
        for (int i = 0; i < counts; i++) {
            if (finalupdate[i].length != 0)
                resultant[i] = finalupdate[i];
        }
        return resultant;
    }

    public Treap<Cell> generateIndexOn(String col) throws DatabaseException {
        int colIndex = -1;
        try {
            int tryier = HelperIndex(col);
            colIndex = tryier;
        } catch (DatabaseException e) {
            throw e;
        }
        Treap<Cell> newTreap = new Treap<>();
        // Checks if empty
        boolean emptychecker = true;
        for (int i = 0; i < database.length; i++) {
            if (database[i][0] != null) {
                emptychecker = false;
            }
        }
        if (emptychecker) {
            return newTreap;
        }
        if (database.length == 0)
            return newTreap;

        if (indexes[colIndex] != null) {
            return indexes[colIndex];
        } else {
            try {
                for (int i = 0; i < database.length; i++) {// call treaps insert.
                    if (database[i][0] != null) {
                        newTreap.insert(new Cell(i, database[i][colIndex]));
                    }
                }
                indexes[colIndex] = newTreap;
                return newTreap;
            } catch (DatabaseException e) {
                indexes[colIndex] = null;
                throw e;
            }
        }
    }

    public Treap<Cell>[] generateIndexAll() throws DatabaseException {
        Treap<Cell>[] results = new Treap[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            try {
                results[i] = generateIndexOn(columnNames[i]);
            } catch (DatabaseException e) {
                results[i] = null;
            }
        }
        return results;
    }

    public int countOccurences(String col, String data) throws DatabaseException {
        int colindex = HelperIndex(col);

        if (colindex == -1) {
            throw DatabaseException.invalidColumnName(col);
        }

        int counter = 0;

        if (database == null)
            return 0;
        for (int i = 0; i < maxSize; i++) {
            if (database[i][colindex] == data)
                counter++;
        }

        if (counter == 0)
            return 0;

        return counter;

    }
}
