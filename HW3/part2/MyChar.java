public class MyChar extends Element{
	char content;

	public MyChar(){
		content = '0';
	}

	public char Get(){
		return content;
	}

	public void Set(char val){
		content = val;
	}

	public void Print(){
		System.out.print("'"+content+"'");
	}
}