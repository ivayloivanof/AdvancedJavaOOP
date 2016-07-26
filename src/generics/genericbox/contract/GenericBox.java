package generics.genericbox.contract;

import java.util.List;

public interface GenericBox<T> {

    List<T> getCollection();

    void addGenericType(T next);

    void swapElements(int first, int last);

    <S extends Comparable<S>> int getCountOfGreaterElement(List<S> list, S t);
}
