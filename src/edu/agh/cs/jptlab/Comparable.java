package edu.agh.cs.jptlab;

public class Comparable<T> implements IComparable<T> {

    public T value;

    public Comparable(T newValue)
    {
        value = newValue;
    }

    public boolean isGreaterThan(IComparable<T> comparableElement)
    {
        return compare(value, comparableElement.getValue()) > 0;
    }


    public boolean isLessThan(IComparable<T> comparableElement)
    {
        return compare(value, comparableElement.getValue()) < 0;
    }

    public boolean isEqual(IComparable<T> comparableElement) {
        return compare(value, comparableElement.getValue()) == 0;
    }

    public T getValue()
    {
        return value;
    }

    private int compare(T value1, T value2)
    {
        if(value instanceof Integer)
        {
            return compareIntegers((Integer) value1, (Integer) value2);
        }

        if(value instanceof String)
        {
            return compareStrings((String)value1, (String)value2);
        }

        else return 0;
    }

    private int compareStrings(String value1, String value2) {
        return value1.compareTo(value2);
    }

    private int compareIntegers(int value1, int value2)
    {
        if (value1 > value2)
            return 1;
        else if (value1 == value2)
            return 0;
        else
            return -1;
    }

}
