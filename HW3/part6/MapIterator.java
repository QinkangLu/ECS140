
public class MapIterator extends Map{
    Map map;
    
    public MapIterator(Map m){
        map = m;
    }
    
    public int length(){
        return map.length();
    }
    
    public Pair get(){
        return map.first();
    }

    public MapIterator advance(){
        map = map.rest();
        return new MapIterator(map);
    }
    
    public boolean equal(MapIterator other){
        return this.map == other.map;
    }
}
