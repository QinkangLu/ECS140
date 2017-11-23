// test additional methods of Sequence


class Test3 {

   public static void main(String args[]) {
	TestPart3();
   }

   static void dbl_line() {
	System.out.println();
	System.out.println();
   }

   public static void TestPart3() {
	MyChar c_arr[] = new MyChar[4];
	MyInteger i_arr[] = new MyInteger[5];
	
	for (int i = 0; i < 4; i++) {
		c_arr[i] = new MyChar();
		i_arr[i] = new MyInteger();
	}
	i_arr[4] = new MyInteger();

	c_arr[0].Set('y');  
	c_arr[1].Set('n'); 
	c_arr[2].Set('o'); 
	c_arr[3].Set(']'); 

	i_arr[0].Set(4);
        i_arr[1].Set(42);
        i_arr[2].Set(1);
        i_arr[3].Set(41);
	i_arr[4].Set(297);

	Sequence s_arr[] = new Sequence[4];
	s_arr[0] = new Sequence();
	s_arr[1] = new Sequence();
	s_arr[0].add(i_arr[0], 0);
	s_arr[0].add(i_arr[1], 1);
	s_arr[1].add(c_arr[1], 0);
	s_arr[1].add(i_arr[2], 1);
	s_arr[1].add(c_arr[2], 2);

	Sequence s = new Sequence();
	
	s.add(c_arr[0], 0);
	s.add(s_arr[0], 1);
	s.add(s_arr[1], 2);
	s.add(c_arr[3], 3);
	s.add(i_arr[3], 4);
	s.add(i_arr[4], 5);

	for (int i = 0; i < 3; i++) {
	        s_arr[i] = new Sequence();

		for (int j = 0; j < 3; j++) {
			i_arr[j] = new MyInteger();
			c_arr[j] = new MyChar();
			
			i_arr[j].Set((j+1)*(j+1));
			c_arr[j].Set((char)(j+65));
			s_arr[i].add(i_arr[j], 0);
			s_arr[i+1] = new Sequence();
			s_arr[i+1].add(c_arr[j], 0);
			s_arr[i].add(s_arr[i+1], 0);
		}
	}

	// create "nested" sequences.. some members refer to the same element 	
	for (int i = 1; i < 4; i++)
		s_arr[0].add(s_arr[i], 0);

	s.add(s_arr[0], 0);
	
	// Test print
	System.out.print("Sequence  s : ");
	System.out.println(s.length() + " elements:");
	s.Print();
	dbl_line();

	// print s.first() - "nested" member
	System.out.print ("Member at location s[0] : ");
	s.first().Print();
	dbl_line();
	
	// flatten s
	System.out.print ("Original sequence s : ");
	s.Print();
	dbl_line();
	Sequence sFlat = s.flatten();
	System.out.print ("Flattened sequence sFlat : ");
	sFlat.Print();
	dbl_line();

	// flatten 1-member sequence
	s_arr[0] = new Sequence();
	s_arr[0].add(i_arr[2], 0);
	System.out.print ("Sequence ss : ");
	s_arr[0].Print();
	dbl_line();
	System.out.print ("Flattened sequence ss : ");
	(s_arr[0].flatten()).Print();
	dbl_line();

	// alter member of s and print s and sFlat
//((MyChar)(((Sequence)(((Sequence)(s.index(0))).index(0))).index(0))).Set('g');

	((MyChar)(s.index(1))).Set('g');
	System.out.print ("Modified sequence s : ");
	s.Print();
	dbl_line();
	System.out.print ("Old flattened sequence s : ");
	sFlat.Print();
	dbl_line();

	// do deep copy
	Sequence sCopy = (Sequence)s.copy();
	// modify s
	((MyChar)(s.index(1))).Set('y');
	System.out.print ("Modified sequence s : ");
	s.Print();
	dbl_line();

	// compare with OLD s .. should differ!
	System.out.print ("Old copy of s (sCopy) : ");
	sCopy.Print();
	dbl_line();

	// no infinite loops if deep COPY of sequence is added to itself
	s.add(s.copy(), s.length());
	System.out.print("Copy of sequence added to itself : ");
	s.Print(); // shouldn't loop indefinitely
	dbl_line();
   }

}
