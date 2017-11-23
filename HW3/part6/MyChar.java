public class MyChar extends Element{
	char content;

	public MyChar(){
		content = '0';
	}
    
    public MyChar(char c){
        content = c;
    }

	public char Get(){
		return content;
	}

    //set MyChar object
	public void Set(char val){
		content = val;
	}
    
	public void Print(){
		System.out.print("'"+content+"'");
	}
    
    //compare which character is greater
    public boolean isGreater(MyChar c){
        if((content - c.content) > 0){
            return true;
        }
        return false;
    }
    
    public boolean equal(MyChar c){
        if(content - c.content == 0){
            return true;
        }
        
        return false;
    }
    
    public Sequence flatten(){
        System.err.println("Char cannot be flattened");
        System.exit(1);
        return null;
    }
    
    public void flattenHelp(Sequence s){
        System.err.println("Char cannot be flattened");
        System.exit(1);
    }
    
    public MyChar copy(){
        return new MyChar(this.content);
    }
}
