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
public class CustomArrayList<T> implements List<T> {

    private final int DEFAULT_LENGHT = 10;
    private Object[] array;
    private int size;

    public CustomArrayList() {
        this.size = 0;
        array = new Object[DEFAULT_LENGHT];
    }

    public int size() {
        return size;
    }

    /**
    * Resize our array
    */
    private void resize(int newLength) {
      Object[] newArray = new Object[newLength];
      System.arraycopy(array, 0, newArray, 0, size);
      array = newArray;
   }

    /**
     * Remove element by the index
     */

    public T remove(int index) {
        for (int i = index; i < size; i++)
            array[i] = array[i+1];
        array[size] = null;
        size--;

        return null;
    }

    /**
     * Remove element by value
     */
    public boolean remove(Object obj) {

        for(int i=0; i < size; i++){
            if(array[i] == obj){
                remove(i);
                break;
            }
        }
        return true;
    }

    /**
     * Add element to the end of the list
     * If our array is full so resize it
     */
     public boolean add(T element) {
        if(size == array.length-1)
            resize(array.length*2);
        array[size++] = element;
        return true;
    }

     /**
     * Add element by the index
     * If our array is full so resize it
     */
     
      public void add(int index, T element) {
      if(index < 0 || index> size){
          System.out.println("Wrong index");
          return;
      }
      // add to the end
      if(index == size){
          add(element);
          return;
      }

      if(size == array.length-1)
            resize(array.length*2);

      Object[] newArray = new Object[array.length];
      size++;
      // copy array
      for(int i = 0; i<= index; i++){
          if(i == index){
              newArray[i] = element;
              for(int j=index+1; j<size ;j++)
                  newArray[j] = array[j-1];
              break;
          }
          else
              newArray[i] = array[i];
      }

      array = newArray;
    }

    /**
    * Get element by the index
    */
    public T get(int index) {
        return (T) array[index];
    }

    /**
     * Set new value of element by the index
     */
    public T set(int index, T element) {
        index--;
        if(index > size-1 || index < 0){
            System.out.println("Wrong index!");
            return null;
        }
        array[index] = element;
        return element;
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
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
