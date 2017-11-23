public class MyInteger extends Element{
	int content;

	public MyInteger(){
		content = 0;
	}

	public int Get(){
		return content;
	}

	public void Set(int val){
		content = val;
	}

	public void Print(){
		System.out.print(content);
	}
}