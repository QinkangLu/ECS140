
class Test6 {

   public static void main(String args[]) {
	TestPart6();	
   }

   public static void PrintSeq(String str, Sequence s) {
	System.out.print("Printing sequence: " + str + " of ");
	System.out.println(s.length() + " elements:");
	s.Print();
	System.out.println();
   }

   // Test Part 6 - Map
   public static void TestPart6() {
	System.out.println(">>=====  Testing Part 6 =====<<");

	Map map = new Map();
	Map map2 = new Map();
	MapIterator it1, it2;
	MyChar key;
	Pair p;
	
	// 1. Add pairs to map - adding in reverse order, make sure 
	//    pairs get added in ascending order
	System.out.println("**** Test adding pairs - in reverse alpha order");
	for (int j=9; j >= 0; j--) {
	   key = new MyChar();
	   key.Set( (char) (65 + j) );
	   MyInteger val = new MyInteger();
	   val.Set(j);
	   p = new Pair(key, val);
	   map.add(p); 
	}
	System.out.println("Printing contents of map:");
	map.Print(); System.out.println();

	// Another map - add pairs to map
	for (int j=0; j < 10; j++) {
	   key = new MyChar();
	   if (j % 2 == 0)
	      key.Set('Q');
	   else 
	      key.Set( (char) (65 + j) );
	   MyInteger val = new MyInteger();
	   val.Set(j);
	   p = new Pair(key, val);	// 911
	   map2.add(p); 
	}
	System.out.println("Printing contents of map2:");
	map2.Print(); System.out.println();

	// Add pairs
	System.out.println("**** Test adding pairs - add unique key pairs");
	key = new MyChar();
	key.Set('z');
	MyInteger ii = new MyInteger();
	ii.Set(333);
	p = new Pair(key, ii);
	map.add(p);
	key = new MyChar();
	key.Set('x');
	p = new Pair(key, ii);
	map.add(p);

	System.out.println("Printing contents of map after adding pairs with unique key:");
	map.Print(); System.out.println();

	// 2. Add a pair with non-unique key
	System.out.println("**** Test adding pairs - add non-unique key pair");
	Sequence seq = new Sequence();
	for (int j=0; j<5; j++) {
	   MyInteger i = new MyInteger();
	   i.Set(j*2);
	   seq.add(i, j);
	}	
	key = new MyChar();
	key.Set('B');
	p = new Pair(key, seq);
	map.add(p);

	// Add another one with the same non-unique key
	key = new MyChar();
	key.Set('B');
	p = new Pair(key, ii);
	map.add(p);

	System.out.println("Printing contents of map after adding a pair with non-unique key:");
	map.Print(); System.out.println();

	// 3. Test iterator	
	System.out.println("**** Test MapIterator");
	Pair p1, p2;
	// Cross of map and map 
	System.out.println("**** Test MapIterator - cross of map and map");
	for (it1 = map.begin(); !it1.equal(map.end()); it1.advance()) {
	   for (it2 = map.begin(); !it2.equal(map.end()); it2.advance()) {
		p1 = it1.get();
		p2 = it2.get();
		p1.Print();	
		System.out.print(" X ");
		p2.Print();
		System.out.println();
	   }	
  	}
	// Cross of map and map2
	System.out.println("**** Test MapIterator - cross of map and map2");
	for (it1 = map.begin(); !it1.equal(map.end()); it1.advance()) {
	   for (it2 = map2.begin(); !it2.equal(map2.end()); it2.advance()) {
		p1 = it1.get();
		p2 = it2.get();
		p1.Print();	
		System.out.print(" X ");
		p2.Print();
		System.out.println();
	   }	
  	}
	
	// 4. Test find
	System.out.println("**** Test find method");
	// Try to find non-existing pair
	System.out.println("**** Test find method -- non-existent key");
	key = new MyChar();
	key.Set('$');
	it1 = map2.find(key);
	if (it1.equal(map2.end()))
	   System.out.println("No such pair with key '$' found.");
	else
	   System.out.println("Uh-oh. Should not have found pair with key '$'."); 

	// Try to find existing pair
	System.out.println("**** Test find method -- existent key");
	key.Set('J');
	it1 = map2.find(key);
	if (it1.equal(map2.end()))
	   System.out.println("No such pair with key 'J' found.");
	else {
	   System.out.print("Found pair with key 'J': "); 
	   it1.get().Print();
	   System.out.println(); 
	}

	key.Set('Q');
	it1 = map2.find(key);
	if (it1.equal(map2.end()))
	   System.out.println("No such pair with key 'Q' found.");
	else {
	   System.out.print("Found pair with key 'Q': "); 
	   it1.get().Print();
	   System.out.println(); 
	}

   }
}
