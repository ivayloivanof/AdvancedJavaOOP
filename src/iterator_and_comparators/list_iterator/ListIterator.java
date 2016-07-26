package iterator_and_comparators.list_iterator;

import iterator_and_comparators.list_iterator.interfaces.Iterator;

/**
 * Created by ivanof on 7/26/16.
 */
public class ListIterator implements Iterator{

    /**
     * Move an internal index position to the next index in the list,
     * the method should return true if it successfully moved and false if there is no next index.
     *
     * @return true / false
     */
    @Override
    public boolean Move() {
        return false;
    }

    /**
     * Return true if there is a next index and false if the index is already at the last element of the list
     *
     * @return true / false
     */
    @Override
    public boolean HasNext() {
        return false;
    }

    /**
     * Print the element at the current internal index,
     * calling Print on a collection without elements should throw an appropriate
     * exception with the message "Invalid Operation!".
     *
     * @print "Invalid Operation!"
     */
    @Override
    public void Print() {

    }
}
