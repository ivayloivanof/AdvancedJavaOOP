package generics.tuple.contract;

public interface Tuple<T, E> {

    T getItem1();

    void setItem1(T item1);

    E getItem2();

    void setItem2(E item2);
}
