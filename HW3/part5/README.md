# Part 5: Two Dimensional Sequences
Define a class Matrix by extending Sequence. Matrix represents a two dimensional array of integers, and
defines the following methods:
```
class Matrix extends Sequence {
    // constructor for creating a matrix of specific number of rows and columns
    Matrix(int rowsize, int colsize);
    void Set(int rowsize, int colsize, int value); // set the value of an element
    int Get(int rowsize, int colsize); // get the value of an element
    Matrix Sum(Matrix mat); // return the sum of two matrices: mat & this
    Matrix Product(Matrix mat); // return the product of two matrices: mat & this
    void Print(); // print the elements of matrix
}
```
