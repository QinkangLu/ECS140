public class Sequence extends Element{
	Element content;
	Sequence next;


	public Sequence(){
	}

	public Sequence(Element c, Sequence n){
		content = c;
		next = n;
	}
    
	public Element first(){
		return this.next.content;
	}

	public Sequence rest(){
		return this.next;
	}

	public int length(){
		if (next == null) {
			return 0;
		}
		return next.length() + 1;
	}
    
    public Element index(int pos){
        if( pos >= length() || pos < 0){
            System.err.println("invalid pos. " + pos + " len " + length());
            System.exit(1);
        }
        Sequence iter = this.next;
        for(int i = 0; i != pos && iter != null; i++){
            iter = iter.next;
        }
        return iter.content;
        
    }
    
    
    public void flattenHelp(Sequence new_seq){
        Sequence iter = this.next;
        for(int i = 0; i < length() && iter != null; i++){
            if(iter.content instanceof Sequence){
                iter.content.flattenHelp(new_seq);
            } else {
                new_seq.add(iter.content, new_seq.length());
            }
            iter = iter.next;
        }
    }
    
    public Sequence flatten(){
        Sequence new_seq = new Sequence();
        Sequence iter = this.next;
        for(int i = 0; i < length() && iter != null; i++){
            if(iter.content instanceof Sequence){
                iter.content.flattenHelp(new_seq);
            } else {
                new_seq.add(iter.content, new_seq.length());
            }
            iter = iter.next;
        }
        return new_seq;
    }
    
    /*
    public Sequence flatten(){
        return this.copy().flattenHelp();
    }*/
    
    public Sequence copy(){ //deep copy
        Sequence new_seq = new Sequence();
        Sequence iter = this.next;
        for(int i = 0; i < length() && iter != null; i++){
            new_seq.add(iter.content.copy(), i);
            iter = iter.next;
        }
        return new_seq;
    }

	public void add(Element elm, int pos){
		
		if (pos == 0) {
			next = new Sequence(elm, null);
			return;
		}
		if (next != null) {
			next.add(elm, pos-1);
		}
		
	}

	public void delete(int pos){
		if (pos == 0 && next != null) {
			next = next.next;
			return;
		} else if (pos == 0 && next == null) {
			next = null;
			return;
		}
		if (next != null) {
			next.delete(pos-1);
		}
		
	}

	public void Print(){
		Sequence iter = this;
		System.out.print("[ ");
		for (int i = 0; i < length(); i++) {
			iter = iter.next;
			iter.content.Print();
			System.out.print(" ");
		}
		System.out.print("]");
	}
    
    public SequenceIterator begin(){
        return new SequenceIterator(this);
    }
    
    public SequenceIterator find(int pos){
        Sequence iter = this.next;
        for(int i = 0; i != pos && iter != null; i++){
            iter = iter.next;
        }
        return new SequenceIterator(iter);
    }
    
    public SequenceIterator end(){
        return new SequenceIterator(null);
    }
}
