package generics.customlist.model.impl;

import generics.customlist.model.contracts.CustomList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CustomListImpl<T> implements CustomList<T>, Comparator<T> {

    private List<T> myCustomList;

    public CustomListImpl() {
        this.myCustomList = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        this.myCustomList.add(element);
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > myCustomList.size() - 1) {
            return null;
        }
        return this.myCustomList.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.myCustomList.contains(element);
    }

    @Override
    public void swap(int index1, int index2) {

        if (index1 > myCustomList.size() || index2 > myCustomList.size() || index1 < 0 || index2 < 0
                || index1 == index2) {
            return;
        }

        if (index1 > index2) {
            int temp = index2;
            index2 = index1;
            index1 = temp;
        }

        T lastT = myCustomList.remove(index2);
        T firstT = myCustomList.remove(index1);

        if (myCustomList.size() > index1) {
            myCustomList.add(index1, lastT);
        } else {
            myCustomList.add(lastT);
        }

        if (myCustomList.size() > index2) {
            myCustomList.add(index2, firstT);
        } else {
            myCustomList.add(firstT);
        }

    }

    @Override
    public int countGreaterThat(T element) {
        int result = 0;
        for (T t : myCustomList) {
            if (compare(t, element) > 0) {
                result++;
            }
        }
        return result;
    }

    @Override
    public T getMax() {
        if (myCustomList.size() == 0) {
            return null;
        }
        T temp = myCustomList.get(0);
        for (T t : myCustomList) {
            if (compare(t, temp) > 0) {
                temp = t;
            }
        }
        return temp;
    }

    @Override
    public T getMin() {
        if (myCustomList.size() == 0) {
            return null;
        }
        T temp = myCustomList.get(0);
        for (T t : myCustomList) {
            if (compare(t, temp) < 0) {
                temp = t;
            }
        }
        return temp;
    }

    @Override
    public int compare(T o1, T o2) {
        return o1.toString().compareTo(o2.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Iterator<T> itr = myCustomList.iterator();
        while (itr.hasNext()) {
            sb.append(itr.next() + "\n");
        }

        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override
    public T getElementOfIndex(int index) {
        return myCustomList.get(index);
    }

    @Override
    public int getSize() {
        return myCustomList.size();
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < myCustomList.size() - 1;
            }

            @Override
            public T next() {
                if (index < myCustomList.size()) {
                    return myCustomList.get(index++);
                } else {
                    return null;
                }
            }
        };
    }
}
