public class Matriz {

    public Matriz(int ncol, int nrow) {
        this.ncol = ncol;
        this.nrow = nrow;
    }

    public int getRows() { return nrow; }
    public int getCols() { return ncol; }

    public static void main(String[] args) {
        Matriz m = new Matriz(1,2);
        System.out.println("rows = " + m.getRows());
        System.out.println("columns = " + m.getCols());
    }

    private int ncol, nrow;
}
