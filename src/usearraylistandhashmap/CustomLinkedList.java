/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package usearraylistandhashmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author nrg
 */
public class CustomLinkedList<T> implements List<T> {

    private Element<T> top;
    private int size;

    public CustomLinkedList() {
        this.top = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Return element by index
     */
    private Element<T> getByIndex(int index) {
        Element<T> element = null;
        if (!isEmpty() && (index >= 0 && index < size)) {
            element = top;
            for(int i=1; i<= index; i++){
                element = element.getNext();
            }
        }
        return element;
    }

    /**
     * Add element to the end of the list
     */
    public boolean add(T e) {
        Element<T> element = new Element<T>();
        if(size == 0){
            top = element;
            element.setPrevious(null);
            element.setNext(null);
        }
        if(size == 1){
            getByIndex(size-1).setNext(element);
            element.setNext(null);
            element.setPrevious(top);
        }
        if(size > 1){
            getByIndex(size-1).setNext(element);
            element.setPrevious(getByIndex(size-1));
            element.setNext(null);
        }
        element.setT(e);
        size++;

        return true;
    }

    /**
     * Add element by the index
     */
    public void add(int index, T e) {
        if(index > size+1){
            System.out.println("Wrong index");
            return;
        }
        // add to the end
        if(index == size+1){
            add(e);
            return;
        }

        Element<T> element = new Element<T>();
        // add to the beginning
        if(index == 1){
            top.setPrevious(element);
            element.setNext(top);
            top = element;
        }
        else{
        // add to the middle
        Element<T> current = getByIndex(index-1);
        Element<T> previous = current.getPrevious();

        //set links
        previous.setNext(element);
        element.setPrevious(previous);
        element.setNext(current);
        current.setPrevious(element);
        }

        element.setT(e);
        size++;

    }
    /**
     * Remove element by the value
     */
     public boolean remove(Object obj) {
        T value = (T)obj;
        Element<T> element = top;
        for(int i=1; i<= size; i++){
            if(element.getT().equals(value)){
                remove(i);
                break;
            }
            element = element.getNext();
        }

        return true;
    }
     /**
     * Remove element by the index
     */
     public T remove(int index) {
        if(index > size){
            System.out.println("Wrong index!");
            return null;
        }
        // remove from the beginning
        if(index == 1){
            top = top.getNext();
            top.setPrevious(null);
            size--;
            return null;
        }
        // remove from the end
        if(index == size){
            Element<T> current = getByIndex(index-1);
            Element<T> previous = current.getPrevious();
            current.setPrevious(null);
            previous.setNext(null);
        }
        // remove from the middle
        else{
            Element<T> current = getByIndex(index-1);
            Element<T> previous = current.getPrevious();

            previous.setNext(current.getNext());
            current.getNext().setPrevious(previous);
        }

        size--;
        return null;
    }

     /**
     * Get element by the index
     */
     public T get(int index) {
        return getByIndex(index-1).getT();
    }

      /**
     * Set new value of element by the index
     */

    public T set(int index, T element) {
        if(index > size || index < 1){
            System.out.println("Wrong index!");
            return null;
        }
        getByIndex(index-1).setT(element);
        return element;
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
