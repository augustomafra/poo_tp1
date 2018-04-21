public class Matriz {

    public Matriz(int nrow, int ncol) {
        if (ncol <= 0) {
            throw new IndexOutOfBoundsException("Erro: Dimensao invalida para colunas: " + Integer.toString(ncol));
        }
        if (nrow <= 0) {
            throw new IndexOutOfBoundsException("Erro: Dimensao invalida para linhas: " + Integer.toString(nrow));
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


    public Matriz add(Matriz A){
    	if(A.getRows()!=this.nrow || A.getCols()!=this.ncol){
    		throw new IndexOutOfBoundsException("Erro: A dimensões das matrizes devem ser iguais");

    	}
    	int i,j;
    	for(i=0; i<nrow; i++){
    		for(j=0; j<ncol; j++){
    			m[i][j]=m[i][j]+A.at(i,j);
    		}
    	}
        return this;
    }

    public Matriz sub(Matriz A){
    	if(A.getRows()!=this.nrow || A.getCols()!=this.ncol){
    		throw new IndexOutOfBoundsException("Erro: A dimensões das matrizes devem ser iguais");

    	}
    	int i,j;
    	for(i=0; i<nrow; i++){
    		for(j=0; j<ncol; j++){
    			m[i][j]=m[i][j]-A.at(i,j);
    		}
    	}
        return this;
    }

    public Matriz transp(){
        // TODO Tratar matriz nao quadrada
        double[][] old_m = m;
    	int i,j;
    	for(i=0; i<nrow; i++){
    		for(j=0; j<ncol; j++){
    			m[i][j]=old_m[j][i];
    		}
    	}
        int aux = nrow;
        nrow = ncol;
        ncol = aux;
        return this;
    }

    public double at(int i, int j){
    	double value=m[i][j];

    	return value;
    }

	public void set(int i, int j, double value){
    	if (i > nrow || j > ncol) {
            expand(java.lang.Math.max(i, nrow), java.lang.Math.max(j, ncol));
        }

        m[i-1][j-1]=value;

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

        Matriz p = new Matriz(2, 2);
        m.set(10, 1, 5);
        m.print();

        //Matriz wrong_m1 = new Matriz(1, -2);
        //Matriz wrong_m2 = new Matriz(0, -2);
    }

    private void expand(int new_nrow, int new_ncol) {
        if (new_ncol < ncol) {
            throw new IndexOutOfBoundsException("Erro Interno: Impossivel reduzir matriz de " + Integer.toString(ncol) + " para " + Integer.toString(new_ncol));
        }
        if (new_nrow < nrow) {
            throw new IndexOutOfBoundsException("Erro Interno: Impossivel reduzir matriz de " + Integer.toString(nrow) + " para " + Integer.toString(new_nrow));
        }

        double[][] old_m = m;
        m = new double[new_nrow][new_ncol];
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                m[i][j] = old_m[i][j];
            }
        }

        ncol = new_ncol;
        nrow = new_nrow;
    }

    private double[][] m ;
    private int ncol, nrow;
}
