# Part 1: Class Definitions
The first part of this homework requires you to define and implement the classes and their member methods. Use the names *Element*, *MyInteger*, *MyChar* and *Sequence* for your class definitions. Note that there is an is-a relationship between *Element* and *MyInteger*, *MyChar* and *Sequence* classes.

* Define a constructor for each class. *MyInteger* objects are initialized to 0, *MyChar* objects to '0', and Sequence to an empty sequence, i.e., a sequence with zero elements.

* Define Get and Set methods for Char and Integer:
```
class MyChar extends Element {
    public MyChar() { ... }
    public char Get() { ... }
    public void Set(char val) { ... }
    ...
}
class MyInteger extends Element {
    public MyInteger() { ... }
    public int Get() { ... }
    public void Set(int val) { ... }
    ...
}
```

Methods *Get* and *Set*, respectively, are used to access and modify the value associated with an object. For instance, invocation of *Get* over a *MyInteger* object returns the integer value associated with the object.
