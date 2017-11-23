
class Test4 {

   public static void main(String args[]) {
	TestPart4();	
   }

   public static void PrintSeq(String str, Sequence s) {
	System.out.print("Printing sequence: " + str + " of ");
	System.out.println(s.length() + " elements:");
	s.Print();
	System.out.println();
   }

  public static void TestPart4() {
	System.out.println(">>=====  Testing Part 4 =====<<");
	Sequence s1 = new Sequence();
	Sequence s2 = new Sequence();
	SequenceIterator it1, it2;

	// Add elements to seq
	for (int j=0; j < 10; j++) {
	   MyInteger i = new MyInteger(); 
	   i.Set(j);
	   s1.add(i, j);
	}
	PrintSeq("s1", s1);
	for (int j=0; j < 10; j++) {
	   MyChar c = new MyChar(); 
	   c.Set( (char)(j+65));
	   s2.add(c, j);
	}
	PrintSeq("s2", s2);
	s1.add(s2, 10);
	System.out.println("Adding s2 to s1... ");
	PrintSeq("s1", s1);

	// Iterate through and print each element
        System.out.println("**** Test SequenceIterator - iterate through and print each element");
	Element elm;
	System.out.print("!");
	for (it1 = s1.begin(); !it1.equal(s1.end()); it1.advance()) {
	   elm = it1.get();
	   elm.Print();
	   System.out.print("!");
	}
	System.out.println();

	s1.delete(10);	
	Element e1, e2;
	// Cross of s1 and s2
        System.out.println("**** Test SequenceIterator - print cross of s1 and s2");
	for (it1 = s1.begin(); !it1.equal(s1.end()); it1.advance()) {
	   for (it2 = s2.begin(); !it2.equal(s2.end()); it2.advance()) {
		e1 = it1.get();
		e2 = it2.get();
		e1.Print();	
		System.out.print(" X ");
		e2.Print();
		System.out.println();
	   }	
  	}

	// Test two iterators over one Sequence
        System.out.println("**** Test SequenceIterator - print cross of s1 and s1");
	for (it1 = s1.begin(); !it1.equal(s1.end()); it1.advance()) {
	   for (it2 = s1.begin(); !it2.equal(s1.end()); it2.advance()) {
		e1 = it1.get();
		e2 = it2.get();
		e1.Print();	
		System.out.print(" X ");
		e2.Print();
		System.out.println();
	   }	
  	}
   }
}
