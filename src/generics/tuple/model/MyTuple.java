package generics.tuple.model;

import generics.tuple.contract.Tuple;

public class MyTuple<T, E> implements Tuple<T, E> {

    private T item1;
    private E item2;

    public MyTuple(T item1, E item2) {
        super();
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public T getItem1() {
        return item1;
    }

    @Override
    public void setItem1(T item1) {
        this.item1 = item1;
    }

    @Override
    public E getItem2() {
        return item2;
    }

    @Override
    public void setItem2(E item2) {
        this.item2 = item2;
    }

}
