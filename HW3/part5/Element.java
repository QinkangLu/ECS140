public abstract class Element{
	public abstract void Print();
    public abstract Sequence flatten();
    public abstract void flattenHelp(Sequence s);
    public abstract Element copy();
}
