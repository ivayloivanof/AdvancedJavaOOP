package generics.threeuple.model;

import generics.threeuple.contract.Threeuple;

public class MyThreeuple<T, E, S> implements Threeuple<T, E, S> {

    private T item1;
    private E item2;
    private S item3;

    public MyThreeuple(T item1, E item2, S item3) {
        super();
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
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

    @Override
    public S getItem3() {
        return item3;
    }

    @Override
    public void setItem3(S item3) {
        this.item3 = item3;
    }

}
