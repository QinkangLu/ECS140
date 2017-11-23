
class Test2 {

   public static void main(String args[]) {
	TestPart2();	
   }

   public static void PrintSeq(String str, Sequence s) {
	System.out.print("Printing sequence: " + str + " of ");
	System.out.println(s.length() + " elements:");
	s.Print();
	System.out.println();
   }

   public static void TestPart2() {
        System.out.println(">>=====  Testing Part 2 =====<<");
	MyChar c;
	MyInteger i;
	Sequence s1 = new Sequence();

	// Test add/set/get
        System.out.println("**** Test add/Get/Set");
	int counter = 0;
	System.out.println("Adding Elements...");
	for (int j=0; j < 10; j++) {
	   int ii;
	   char cc;
	   i = new MyInteger();
	   c = new MyChar();

	   i.Set(j);
	   c.Set( (char) (65+j)); cc = c.Get();
	   s1.add(i, counter);
	   s1.add(c, counter+1);
	   counter += 2;

	   ii = i.Get();
	   cc = c.Get();
	   System.out.print(ii + " " + cc + " ");
	}
	System.out.println();

	// Test print
        System.out.println("**** Test Print");
	PrintSeq("s1", s1);

	// Test first/rest
        System.out.println("**** Test first/rest");
	Sequence s2 = s1.rest();
	Element elm = s1.first();

  	System.out.print("Printing head of s1: ");	
	elm.Print();
	System.out.println();
	
	PrintSeq("s2 (rest of s1)", s2);

	// add an element to the original sequence.. s2 should reflect this addition 
	i = new MyInteger();
	i.Set(99);
	s1.add(i, 3);
	
	// add an element to the head of the original sequence .. shouldn't affect s2
	i = new MyInteger();
	i.Set(99);
	s1.add(i, 0);

	PrintSeq("s1 (after adding at 3 and 0)", s1);
	PrintSeq("s2 (after adding at 3 and 0 to s1)", s2);

	Sequence t1 = s1, t2;
	Element e;
	System.out.println("Printing first of rest:");
	for (int j=0; j < 22; j++) {
	   e = t1.first();
	   t2 = t1.rest();
	   e.Print();
	   System.out.print(" ");
	   t1 = t2;
	}
	System.out.println();
	
	// Test delete
        System.out.println("**** Test delete");
	t1 = s1;
	t1.delete(0); 
	PrintSeq("Delete(0) - t1", t1);

	t1.delete(3);
	PrintSeq("Delete(3) - t1", t1);

	t1.delete(9); 
	PrintSeq("Delete(9) - t1", t1);
	
	PrintSeq("s1", s1);
   }
}
