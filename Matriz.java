public class Matriz {

    public Matriz(int ncol, int nrow) {
        if (ncol <= 0) {
            throw new IndexOutOfBoundsException(Integer.toString(ncol));
        }
        if (nrow <= 0) {
            throw new IndexOutOfBoundsException(Integer.toString(nrow));
        }
        this.ncol = ncol;
        this.nrow = nrow;
    }

    public int getRows() { return nrow; }
    public int getCols() { return ncol; }

    public static void main(String[] args) {
        Matriz m = new Matriz(1,2);
        System.out.println("rows = " + m.getRows());
        System.out.println("columns = " + m.getCols());

        //Matriz wrong_m1 = new Matriz(1, -2);
        Matriz wrong_m2 = new Matriz(0, -2);
    }

    private int ncol, nrow;
}
