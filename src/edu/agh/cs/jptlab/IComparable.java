package edu.agh.cs.jptlab;

public interface IComparable<T>
{
    public boolean isGreaterThan(IComparable<T> value);
    public boolean isLessThan(IComparable<T> value);
    public boolean isEqual(IComparable<T> value);
    public T getValue();
}
