# Part 3: Additional Methods of Sequence
Class Sequence defines the following additional methods:
1. index to access the element at a particular position:
```
public Element index(int pos);
```
The method index is used to access a particular element of a Sequence object. For instance, S.index(0) returns the first element of S. If pos is not between 0 and the length of the Sequence object, flag an error and exit.

2. flatten to flatten a sequence:
```
public Sequence flatten();
```
An example usage of flatten is shown below:
```
flatten ([1 2 [1 3 4] [`s' a b] ]) = [1 2 1 3 4 `s' a b]
```
Note that flatten returns a new Sequence object.

3. copy to perform a deep copy of a Sequence object:
```
public Sequence copy();
```
