package generics.threeuple.contract;

public interface Threeuple<T, E, S> {

    T getItem1();

    void setItem1(T item1);

    E getItem2();

    void setItem2(E item2);

    S getItem3();

    void setItem3(S item3);
}
