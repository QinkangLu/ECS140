# Part 4: Iterator over Sequence
Define a SequenceIterator class to serve as an iterator over Sequence objects. An iterator object is used to iterate over a data structure. Note also that there can be multiple SequenceIterator objects for a Sequence object.

    The Sequence class must be extended to implement the following member methods:
```
class Sequence extends Element {
    SequenceIterator begin();
    SequenceIterator end();
    ...
}
```

Method begin returns a SequenceIterator object that points to the first element of the sequence. Method end, on the other hand, returns a SequenceIterator object that points to a special value after the last element of a Sequence object. This special value is used merely to indicate that an iterator has gone beyond the last element of a Sequence object. It can be implemented by adding an extra dummy element to a Sequence object.

Define the following methods for SequenceIterator:
1. advance to advance a SequenceIterator to the next element in a Sequence object.
2. get to return the object to which the SequenceIterator object points.
3. equal to determine if two SequenceIterator objects point to the same element.

The interface of the SequenceIterator class may look like the following:
```
class SequenceIterator {
    ...
    public bool equal (SequenceIterator other) { ... }
    SequenceIterator advance();
    Element get();
    ...
}

```
The following code fragment shows a possible usage of the iterator:
```
Sequence seq;
SequenceIterator it;
for (it = seq.begin(); !it.equal(seq.end()); it.advance()) {
    (it.get()).f();
}
```
The above applies method f over all elements of seq.
