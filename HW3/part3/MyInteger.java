public class MyInteger extends Element{
	int content;

	public MyInteger(){
		content = 0;
	}
    
    public MyInteger(int value){
        content = value;
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
    
    public Sequence flatten(){
        System.err.println("Integer cannot be flattened");
        System.exit(1);
        return null;
    }
    
    public void flattenHelp(Sequence s){
        System.err.println("Integer cannot be flattened");
        System.exit(1);
    }
    
    public MyInteger copy(){
        return new MyInteger(this.content);
    }
}
