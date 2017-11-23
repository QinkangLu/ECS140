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

	public void add(Element elm, int pos){
        if(pos > length() || pos < 0){
            System.err.println("OutOfBound");
            System.exit(1);
        }
        
		if (pos == 0) {
			next = new Sequence(elm, next);
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
		for (int i = 0; i < length() && iter.next != null; i++) {
			iter = iter.next;
			iter.content.Print();
			System.out.print(" ");
		}
		System.out.print("]");
	}
}
