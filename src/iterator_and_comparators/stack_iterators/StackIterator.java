package iterator_and_comparators.stack_iterators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackIterator<T> implements Iterable<T>{
    private LinkedList<T> data;

    public StackIterator() {
        this.data = new LinkedList<>();
    }

    public void push(T element){
        this.data.add(element);
    }

    public T pop(){
        if (this.data.isEmpty()){
            throw new IllegalStateException("No elements");
        }
        return this.data.remove(this.data.size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = data.size() - 1;

            @Override
            public boolean hasNext() {
                return this.index >= 0;
            }

            @Override
            public T next() {
                if (hasNext()){
                    return data.get(this.index--);
                }

                throw new NoSuchElementException();
            }
        };
    }
}
