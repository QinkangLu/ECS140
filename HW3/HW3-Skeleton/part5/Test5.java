import java.math.*;

// test matrix class 

class Test5 {

   public static void main(String args[]) {
	TestPart5();
   }

   static void dbl_line() {
	System.out.println();
	System.out.println();
   }

   public static void TestPart5() {
	MyInteger i_arr[] = new MyInteger[50];

	i_arr[0] = new MyInteger();
	i_arr[0].Set(6);
	for (int i = 1; i < 50; i++) {
		i_arr[i] = new MyInteger();
		i_arr[i].Set(i*i + i - i_arr[i-1].Get()*i_arr[i-1].Get());	
	}

	for (int i = 2; i < 50; i++)
		i_arr[i].Set(i_arr[i].Get()/10000000);

	// test Set()
	Matrix m1 = new Matrix(6, 4);
        Matrix m2 = new Matrix(6, 4);
        for (int i = 0, cntr = -1; i< 6; i++) {
                for (int j = 0; j < 4; j++) {
                        if (i < 4)
                                m1.Set(i, j, i_arr[++cntr].Get());
                        if (j < 3)
                                m2.Set(i, j, i_arr[++cntr].Get());
                }
        }

	// test Print()
	System.out.println ("m1 = ");
	m1.Print();
	dbl_line();
	System.out.println ("m2 = ");
	m2.Print();
	dbl_line();
	// test Sum()
	System.out.println ("m1 + m2 = ");
	m1.Sum(m2).Print();
	dbl_line();

	m1 = new Matrix(4, 5);
	m2 = new Matrix(5, 3);
	// test Set
	for (int i = 0, cntr = -1; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			if (i < 4)
				m1.Set(i, j, i_arr[++cntr].Get());
			if (j < 3)
				m2.Set(i, j, i_arr[++cntr].Get());
		}
	}
	System.out.println ("m1 = ");
	m1.Print();
	dbl_line();

	System.out.println ("m2 = ");
	m2.Print();
	dbl_line();

	// test Product()
	Matrix m1m2 = m1.Product(m2);

	System.out.println ("Product m1 * m2 : ");
	m1m2.Print();
	dbl_line();

	// test Get
	System.out.println ("m1m2[0, 0] = "+m1m2.Get(0,0));
	System.out.println ("m1m2[3, 2] = "+m1m2.Get(3,2));
	dbl_line();

	m1 = new Matrix(1, 1);
	m2 = new Matrix(1, 5);
	m1.Set(0, 0, i_arr[3].Get());
	m2.Set(0, 0, i_arr[6].Get());
	m2.Set(0, 1, i_arr[35].Get());
	m2.Set(0, 2, i_arr[22].Get());
	m2.Set(0, 3, i_arr[12].Get());
	m2.Set(0, 4, i_arr[0].Get());

	System.out.println ("m1 = ");
	m1.Print();
	dbl_line();

	System.out.println ("m2 = ");
	m2.Print();
	dbl_line();

	m1m2 = m1.Product(m2);
	System.out.println ("m1 * m2 = ");
	m1m2.Print();
	dbl_line();

	// check for illegal matrix operation
	m1 = new Matrix(3, 3);
	m2 = new Matrix(4, 3);
	for (int i = 0, cntr = 7; i < 4; i++) {
		for (int j = 0; j < 3; j++) {
			if (i < 3)
				m1.Set(i, j, i_arr[++cntr].Get());
			m2.Set(i, j, i_arr[++cntr].Get());
		}
	}
	System.out.println("m1 = ");
	m1.Print();
	dbl_line();
	System.out.println("m2 = ");
	m2.Print();
	dbl_line();

	System.out.print("m1 * m2 = ");
	m1.Product(m2).Print();
	
   }

}
