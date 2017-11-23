
public class SequenceIterator extends Sequence{
    Sequence seq;
    Element ele;
    int currentPos = 0;
    
    public SequenceIterator(Element e){
        ele = e;
    }
    
    public SequenceIterator(Sequence s){
        seq = s;
    }
    
    //compare if the two SequenceIterator is pointing to the same object
    public boolean equal(SequenceIterator other){
        if(currentPos == length()){
            return true;
        }
        return false;
    }
    
    public SequenceIterator advance(){
        SequenceIterator returnVal = find(currentPos);
        currentPos++;
        return returnVal;
    }
    
    //get the element at current position
    public Element get(){
        return seq.index(currentPos);
    }
    
    public int length(){
        return seq.length();
    }
    
}
