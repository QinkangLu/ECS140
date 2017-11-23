# Part 2: Additional Methods
Extend the definitions of the classes by defining the following methods:
1. Define a Print member method for each class. Different objects are printed in the following manner:
    * Element: Define Print to be an abstract method.
    * MyInteger: Print the corresponding integer value.
    * MyChar: Print the quoted value of a MyChar object, e.g., 'c'.
    * Sequence: Print a sequence by surrounding the values of the elements in [, ], e.g.,
        [ [ 1 ] [ 2 ] `3' `c' [ 1 3 [`4' `5'] ] ]
        
2. Define the following methods for the Sequence class:
    * Define method first to return the first element of the sequence:


Element first();
* Define a method rest that returns the rest of the elements of the seqence:
    ```
    Sequence rest();
    ```
    Note that rest does NOT create a new sequence; it merely points to the rest of the elements of the original sequence.
* Define a method length to return the number of elements in a Sequence object:
    ```
    int length();
    ```
* Define a method add to add an element at a specified position:
    ```
    void add(Element elm, int pos);
    ```
    If an element already exists at pos, elm is inserted at pos. All elements starting at location pos are pushed to the right. If pos is not between 0 and the length of the Sequence object, flag an error and exit.
* Define a delete method to remove an element at a specified position:
    ```
    void delete(int pos);
    ```
    After deleting the element at pos, all elements to the right of pos
