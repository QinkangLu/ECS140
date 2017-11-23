class Matrix extends Sequence{
    Sequence matrix;
    int row_size, col_size;
    //construtor
    public Matrix(int rowsize, int colsize){
        row_size = rowsize;
        col_size = colsize;
        matrix = new Sequence();
        
        for(int i = 0; i < rowsize; i++){
            Sequence row = new Sequence();
            matrix.add(row, matrix.length());
            for(int j = 0; j < colsize; j++){
                MyInteger pval = new MyInteger();
                row.add(pval, row.length());
            }
        }
    }
    
    public void Set(int row, int col, int value){
        //MyInteger pval = new MyInteger(value);
        Sequence row_seq  = (Sequence)matrix.index(row);
        //row_seq.delete(col);
        //row_seq.add(pval, col);
        ((MyInteger)row_seq.index(col)).Set(value);
    }
    
    public int Get(int row, int col){
        Sequence row_seq  = (Sequence)matrix.index(row);
        return ((MyInteger)row_seq.index(col)).Get();
    }
    
    public Matrix Sum(Matrix mat){
        Matrix sum = new Matrix(row_size, col_size);
        for(int i = 0; i < row_size; i++){
            for(int j = 0; j < col_size; j++){
                int value = this.Get(i, j) + mat.Get(i, j);
                sum.Set(i, j, value);
            }
        }
        
        return sum;
    }
    
    public Matrix Product(Matrix mat){
        if(this.col_size != mat.row_size){
            System.out.println("Matrix dimensions incompatible for Product");
            System.exit(-1);
        }
        
        Matrix product = new Matrix(row_size, mat.col_size);
        for(int i = 0; i < row_size; i++){
            for(int j = 0; j < mat.col_size; j++){
                int result = 0;
                for(int k = 0; k < this.col_size; k++){
                    int a = this.Get(i, k);
                    int b =  mat.Get(k, j);
                    result = result + (a * b);
                }
                product.Set(i, j, result);
            }
        }
        return product;
    }
    
    public void Print(){
        Sequence iter = matrix;
        for (int i = 0; i < row_size; i++) {
            iter = iter.next;
            iter.content.Print();
            System.out.println();
        }
    }
}
