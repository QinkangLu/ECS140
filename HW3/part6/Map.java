
public class Map{
    Pair content;
    Map next;
    
    //constructor
    public Map(){
        content = null;
        next = null;
    }
    
    public Map(Pair c, Map n){
        content = c;
        next = n;
    }
    
    //get the first pair in the Map
    public Pair first(){
        return next.content;
    }
    
    //get the rest of the paris in Map
    public Map rest(){
        return next;
    }
    
    //get the length of the Map
    public int length(){
        if (next == null) {
            return 0;
        }
        return next.length() + 1;
    }
    
    //it add the pair inval into Map in ascending order
    //it uses isGreater from MyChar
    public void add(Pair inval){
        //System.out.print("pass");
        if(this.next == null){
            this.next = new Map(inval, null);
            return;
        } else if(first().isGreater(inval)){
            next = new Map(inval, next);
            return;
        }
        
        next.add(inval);
    }
    
    public void Print(){
        Map iter = this;
        System.out.print("[ ");
        for (int i = 0; i < length(); i++) {
            iter = iter.next;
            iter.content.Print();
            System.out.print(" ");
        }
        System.out.print("]");
    }
    
    //return the first element in MapIterator
    public MapIterator begin(){
        return new MapIterator(this);
    }
    
    public MapIterator end(){
        Map iter = this;
        while( iter.next != null){
            iter = iter.next;
        }
        return new MapIterator(iter);
    }
    
    //find the pair with key and return a MapIterator
    public MapIterator find(MyChar key){
        Map iter = this.next;
        
        while(iter.next != null){
            if(iter.next.content != null && iter.next.content.equal(key) == true){
                return new MapIterator(iter);
            }
            iter = iter.next;
        }
        
        return new MapIterator(iter);
    }
    
}
