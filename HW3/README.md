# Object-Oriented Porgramming Practice
The purpose of this programming assignment is for you to gain some experience with object-oriented programming
in Java, and in particular the ideas of inheritance, dynamic binding (virtual methods), and overriding
and overloading of methods. It will also give you some exposure to how some programming language
features are implemented, i.e., what happens “behind the scenes” when you execute a program.

Your program needs to implement several abstractions. The first abstraction
is an *Element*, of which there are many kinds: *MyInteger*, *MyChar* and *Sequence*. *MyInteger*
and *MyChar*, respectively, are class-based abstractions of int and char. Class *Sequence* is a dynamic array
of *Element* objects. A *Sequence* object, thus stores objects of type *MyInteger*, *MyChar* and *Sequence*.
The following is an example of a *Sequence* object:

```
[ 1 `a' [1 3 `b']]
```
In this example, the *Sequence* object contains three *Element* objects: 1, 'a' and another *Sequence*
object [1 3 `b']. Thus, a *Sequence* object may contain nested *Sequence* objects.
