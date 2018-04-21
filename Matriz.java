public class Matriz {

    public Matriz(int ncol, int nrow) {
        this.ncol = ncol;
        this.nrow = nrow;
    }

    public int getRows() { return nrow; }
    public int getCols() { return ncol; }

    public void zeros(){
    	int i,j;
    	for(i=0; i<nrow; i++){
    		for(j=0; j<ncol; j++){

    			m[i][j]=0;
    		}
    	}
    }

    public void ones(){
    	int i,j;
    	for(i=0; i<nrow; i++){
    		for(j=0; j<ncol; j++){

    			m[i][j]=1;
    		}
    	}
    }

    public static void main(String[] args) {
        Matriz m = new Matriz(1,2);
        System.out.println("rows = " + m.getRows());
        System.out.println("columns = " + m.getCols());
        m.zeros();
        m.ones();
    }
    private double[][] m ;
    private int ncol, nrow;
}
