public class Cell {
    public int numRows, numCols, r, c, b;
    public Cell below, right, block;
    public Integer value;
    public List<Integer> possibleValues;
    Cell blockstarter;

    public String toString() {
        if (value == null) {

            String res = " ";
            for (int i = 0; i < String.valueOf(numRows * numCols).length(); i++) {
                res += "-";
            }
            res += " ";
            return res;
        }
        return " " + String.format("%" + String.valueOf(numRows * numCols).length() + "d", value).replace(" ", "0")
                + " ";
    }

    /*
     * Don't change anything above this line
     */

    public Cell(int nR, int nC, String inp) {
        numRows = nR;
        numCols = nC;
        below = null;
        right = null;
        block = null;

        possibleValues = new List<>();
        if (inp.equals("-")) {
            value = null;

            for (int i = 1; i <= numCols * numRows; i++) {
                possibleValues.append(i);

            }

        } else {
            value = Integer.valueOf(inp);
            possibleValues = null;
        }

    }

    public void removeVal(int val) {

        if (possibleValues != null) {
            possibleValues.remove(val);

        }
        return;

    }

    public void setVal(int val) {

        value = val;
        possibleValues = null;
    }

}
