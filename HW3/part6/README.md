# Part 6: Map
This part of the homework involves modifying the Sequence class so that the elements of a Sequence object can be stored and retrieved using a key. We will call this class Map. A Map object therefore stores a set of Pair objects. Each Pair object contains a key object and a value object. A key object refers to a MyChar object whereas a value object can refer to any type of Element. An example of a Map object is shown below:
```
[ (`1' `a') (`3' `h') (`8' 4) ]
```
This Map object contains three Pair objects: ```(`1' `a'), (`3' `h')```, and ```(`8' 4)```. The first component
in each Pair object is the key object whereas the second is the value object. Note that the elements
of the Map object are ordered according to the key object. Define the following for the Map class:

1. Define an iterator class MapIterator for the Map class. The behavior of a MapIterator object is similar to that of a SequenceIterator object. MapIterator implements all methods that SequenceIterator supports.

2. Methods begin, end, and Print. Methods begin and end are similar to those of the Sequence class (see Part 4). Method Print prints a map object in the following manner:
```
[ (`1' 1) (`2' 2) (`3' 8) ]
```
The first is the key object, and the second is the value object.

3. add method for adding a Pair object:
```
public void add(Pair inval);
```
The method add adds a Pair object, say p, in a Map object, say mp, by comparing the key value of p with the key values of the Pair objects of mp, and inserts p such that the key values of the Pair objects are in ascending order. Note that a Map object may contain Pair objects with identical keys. In the case when there are multiple Pair objects with the same key, p is added after these Pair objects.

4. find method for finding a Pair object given the key component:
```
public MapIterator find(MyChar key);
```
The argument to the find method is the key component of a Pair object. It is used to search a Map object for a Pair object. If the object exists, return a MapIterator object that points to the element. If the object does not exist, return a MapIterator object that points to the end element. If multiple Pair objects with the same key exist, return a MapIterator object that points to the first such Pair object.
