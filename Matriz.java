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

    public Matriz mult(double valor) {
    	Matriz return_matrix = new Matriz(nrow,ncol);
    	int i,j;
    	for(i=0; i<nrow; i++){
    		for(j=0; j<ncol; j++){
    			return_matrix.set(i+1,j+1, m[i][j] * valor);
    		}
    	}
        return return_matrix;
    }

    public Matriz mult(Matriz A) {
       Matriz return_matrix = new Matriz(nrow,A.getCols()); 
       double aux;
        if (ncol != A.getRows()) {
    		throw new IndexOutOfBoundsException("Erro: Dimensoes incompativeis de matrizes para multiplicacao");
        }
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < A.getCols(); j++) {
                aux=0;
                for (int k = 0; k < ncol; k++) {
                    aux+=m[i][k] * A.at(k+1, j+1);
                }
                return_matrix.set(i+1,j+1,aux);
            }
        }
        return return_matrix;
    }

    public Matriz add(Matriz A){
    	Matriz return_matrix = new Matriz(nrow,ncol);
    	if(A.getRows()!=this.nrow || A.getCols()!=this.ncol){
    		throw new IndexOutOfBoundsException("Erro: A dimensões das matrizes devem ser iguais");

    	}
    	int i,j;
    	for(i=0; i<nrow; i++){
    		for(j=0; j<ncol; j++){
    			return_matrix.set(i+1,j+1,(m[i][j]+A.at(i+1,j+1)));
    		}
    	}
        return return_matrix;
    }

    public Matriz sub(Matriz A){
    	Matriz return_matrix = new Matriz(nrow,ncol);
    	if(A.getRows()!=this.nrow || A.getCols()!=this.ncol){
    		throw new IndexOutOfBoundsException("Erro: A dimensões das matrizes devem ser iguais");

    	}
    	int i,j;
    	for(i=0; i<nrow; i++){
    		for(j=0; j<ncol; j++){
    			return_matrix.set(i+1,j+1,(m[i][j]-A.at(i+1,j+1)));
    		}
    	}
        return return_matrix;
    }

    public Matriz transp(){
        double[][] old_m = m;
    	int i,j;
    	Matriz return_matrix = new Matriz(ncol,nrow);
    	for(i=0; i<ncol; i++){
    		for(j=0; j<nrow; j++){
    			return_matrix.set(i+1,j+1,(old_m[j][i]));
    		}
    	}
        int aux = nrow;
        nrow = ncol;
        ncol = aux;
        return return_matrix;
    }

    public double at(int i, int j){
    	double value=m[i-1][j-1];

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
        Matriz X = new Matriz(3,1);
        Matriz A = new Matriz(3,3);
        Matriz C = new Matriz(3,3);
        A.set(2,1,10);
        System.out.println("A");
        A.print();
       

        C.zeros();
        System.out.println("C");
        C.print();
        C=A.add(A);
        System.out.println("C=A+A");
        C.print();
        System.out.println("A=C-A");
        A=C.sub(A);
        A.print();
        System.out.println("A=+A");
        A=A.add(A);
        A.print();
        System.out.println("A=transp(C)");
        A=C.transp();
        A.print();
        X.ones();
        System.out.println("X");
        X.print();
        X=X.mult(2);
        System.out.println("X=X*2");
        X.print();
        System.out.println("C=A*X");
        C=A.mult(X);
        C.print();
        System.out.println("C=C*X");
        C=C.transp().mult(X);
        C.print();  //MANTER
        int numerolinhas=A.getRows();
        int numerocolunas=A.getCols();
        //m.unit();

     


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
