public class Matriz {

    public Matriz(int nrow, int ncol) {
        if (ncol <= 0) {
            throw new IndexOutOfBoundsException(Integer.toString(ncol));
        }
        if (nrow <= 0) {
            throw new IndexOutOfBoundsException(Integer.toString(nrow));
        }
        this.ncol = ncol;
        this.nrow = nrow;
        m = new double[nrow][ncol];
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

    public void unit(){
    	int i,j;
    	if(ncol!=nrow){
    		throw new IndexOutOfBoundsException("Erro: A matriz identidade deve ser quadrada");
    	}

    	for(i=0; i<nrow; i++){
    		for(j=0; j<ncol; j++){
    			if(i==j){
    				m[i][j]=1;
    			}else{
    				m[i][j]=0;
    			}

    		}
    	}
    }

    public void print() {
    	for(int i=0; i<nrow; i++){
            System.out.print("[");
    		for(int j=0; j<ncol-1; j++){
                System.out.print(m[i][j] + "\t");
            }
            System.out.print(m[i][ncol-1] + "]\n");
        }
    }

    public static void main(String[] args) {
        Matriz m = new Matriz(1,2);
        System.out.println("rows = " + m.getRows());
        System.out.println("columns = " + m.getCols());
        m.zeros();
        m.ones();
        //m.unit();

        m.print();

        Matriz n = new Matriz(4, 4);
        n.unit();
        n.print();

        Matriz o = new Matriz(1, 10);
        o.ones();
        o.print();

        //Matriz wrong_m1 = new Matriz(1, -2);
        //Matriz wrong_m2 = new Matriz(0, -2);
    }
    private double[][] m ;
    private int ncol, nrow;
}
