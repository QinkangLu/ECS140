
public class Pair{
    MyChar key;
    Element value;
    
    public Pair(){
        key = new MyChar();
    }
    
    public Pair(MyChar k, Element v){
        key = k;
        value = v;
    }
    
    //compare which Pair is greater based on its key
    public boolean isGreater(Pair p){
        return key.isGreater(p.key);
    }
    
    public boolean equal(MyChar k){
        return key.equal(k);
    }
    
    public void Print(){
        System.out.print("(");
        key.Print();
        System.out.print(" ");
        value.Print();
        System.out.print(")");
    }
    
    public Pair copy(){
        return new Pair(this.key, this.value);
    }
}
