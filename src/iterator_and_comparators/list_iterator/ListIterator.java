package iterator_and_comparators.list_iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by ivanof on 7/26/16.
 */
public class ListIterator<T> implements Iterator<T> {

    private List<T> data;
    private int index;

    public ListIterator(List<T> data) {
        this.data = data;
        this.index = 0;
    }

    /**
     * Return true if there is a next index and false if the index is already at the last element of the list
     *
     * @return true / false
     */
    @Override
    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return this.data.get(this.index++);
        }

        throw new NoSuchElementException();
    }

    /**
     * Print the element at the current internal index,
     * calling Print on a collection without elements should throw an appropriate
     * exception with the message "Invalid Operation!".
     *
     * @print "Invalid Operation!"
     */
    public void print() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }

        System.out.println(this.data.get(this.index));
    }

    public void printAll() {
        this.data.stream().forEach(d -> System.out.printf("%s ", d));
        System.out.println();
    }

    /**
     * Move an internal index position to the next index in the list,
     * the method should return true if it successfully moved and false if there is no next index.
     *
     * @return true / false
     */
    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }

        return false;
    }
}