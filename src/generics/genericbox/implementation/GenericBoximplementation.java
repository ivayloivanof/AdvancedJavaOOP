package generics.genericbox.implementation;

import generics.genericbox.contract.GenericBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericBoximplementation<T> implements GenericBox<T> {

    private List<T> collection;

    public GenericBoximplementation() {
        this.collection = new ArrayList<>();
    }

    @Override
    public List<T> getCollection() {
        return Collections.unmodifiableList(collection);
    }

    @Override
    public void addGenericType(T next) {
        collection.add(next);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T t : collection) {
            sb.append(t.getClass().getName() + ": " + t + "\n");
        }

        return sb.toString();
    }

    @Override
    public void swapElements(int first, int last) {
        if (first > collection.size() || last > collection.size() || first < 0 || last < 0 || first == last) {
            return;
        }

        T lastT = collection.remove(last);
        T firstT = collection.remove(first);

        if (collection.size() > first) {
            collection.add(first, lastT);
        } else {
            collection.add(lastT);
        }

        if (collection.size() > last) {
            collection.add(last, firstT);
        } else {
            collection.add(firstT);
        }
    }

    @Override
    public <S extends Comparable<S>> int getCountOfGreaterElement(List<S> list, S t) {
        int result = 0;

        for (S t2 : list) {
            if (t2.compareTo(t) > 0) {
                result++;
            }
        }

        return result;
    }
}
