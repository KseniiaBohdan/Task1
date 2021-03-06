package task1.container;

import java.util.*;
import java.util.function.Predicate;

public class MyList<T> implements List<T> {

    private static final double COEFICIENT = 1.5;
    private Object[] items = new Object[100];
    private int size = 0;

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) == -1 ? false : true;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator iterator() {
        return new MyIterator<>();
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @param predicate property for selecting elements
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator iterator(Predicate predicate) {
        return new MyIterator<T>(predicate);
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence.
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     */
    @Override
    public Object[] toArray() {
        return ((size > 0) ? items : new Object[0]);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param o element to be appended to this list
     * @return true if list was changed
     */
    @Override
    public boolean add(Object o) {
        int s = size;
        if (size + 1 > items.length) {
            Object[] temp = Arrays.copyOf(items, items.length);
            items = new Object[(int) (items.length * COEFICIENT)];
            items = Arrays.copyOf(temp, temp.length);
        }
        items[size] = o;
        size++;
        return s != size;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain
     * the element, it is unchanged.
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null) ? items[i] == null : items[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list.
     *
     * @param c collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public boolean addAll(Collection c) {
        return addAll(size, c);
    }

    /**
     * Inserts all of the elements in the specified collection into this
     * list at the specified position.
     *
     * @param index index at which to insert the first element
     * @param c     collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public boolean addAll(int index, Collection c) {
        indexValid(index);
        int s = size;
        System.arraycopy(items, index, c, 0, c.size());
        size += c.size();
        return (size != s);
    }

    private void indexValid(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public T get(int index) {
        indexValid(index);
        return (T) items[index];
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public Object set(int index, Object element) {
        indexValid(index);
        Object o = items[index];
        items[index] = element;
        return o;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, Object element) {
        indexValid(index);
        System.arraycopy(items, index + 1, items, index, size);
        items[index] = element;
        size++;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public T remove(int index) {
        indexValid(index);
        T element = get(index);
        if (index < size - 1 && index > 0) {
            System.arraycopy(items, index, items, index + 1, size - 1);
        } else {
            items[index] = null;
        }
        --size;
        return element;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null) ? items[i] == o : items[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if ((o == null) ? items[i] == o : items[i].equals(o)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public boolean retainAll(Collection c) {
        int s = size;
        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(i);
            }
        }
        return (s != size);
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection.
     *
     * @param c collection containing elements to be removed from this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public boolean removeAll(Collection c) {
        int s = size;
        for (Object ob : c) {
            if (contains(ob)) {
                remove(ob);
            }
        }
        return (size != s);
    }

    /**
     * Returns true if this list contains all of the elements of the
     * specified collection.
     *
     * @param c collection to be checked for containment in this list
     * @return true if this list contains all of the elements of the
     * specified collection
     */
    @Override
    public boolean containsAll(Collection c) {
        for (Object ob : c) {
            if (!contains(ob)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an array containing all of the elements in this list in
     * proper sequence.
     *
     * @param a the array into which the elements of this list are to
     *          be stored.
     * @return an array containing the elements of this list
     */
    @Override
    public Object[] toArray(Object[] a) {
        if (a.length >= size) {
            System.arraycopy(a, 0, items, 0, size);
        } else {
            a = new Object[size];
            System.arraycopy(a, 0, items, 0, size);
        }
        return a;
    }

    class MyIterator<T> implements Iterator<T> {

        private boolean flag = false;
        private int index = -1;
        private Predicate<T> predicate;

        private MyIterator(Predicate predicate) {
            this.predicate = predicate;
        }

        private MyIterator() {
            predicate = t -> true;
        }

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return (index < size - 1);
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (hasNext()) {
                index++;
                flag = true;
                return predicate.test((T) items[index]) ? (T) items[index] : next();
            } else {
                throw new NoSuchElementException();
            }
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator.
         *
         * @throws IllegalStateException if the next method has not
         *                               yet been called, or the remove method has already
         *                               been called after the last call to the next
         *                               method
         */
        @Override
        public void remove() {
            if (flag == true) {
                flag = false;
                if (index < size - 1 && index > 0) {
                    System.arraycopy(items, index, items, index + 1, size - index - 1);
                } else {
                    items[index] = null;
                }
                --size;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}

