/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package usearraylistandhashmap;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author nrg
 */
public class CustomHashMap<K, V> implements Map<K, V>{

    private final int DEFAULT_CAPACITY = 10;
    CustomEntry<K, V> entry[];

    public CustomHashMap() {
        entry = new CustomEntry[DEFAULT_CAPACITY];
    }

    /**
     * Get element by the key
     */

    public V get(Object obj) {
        K key = (K)obj;
        int index = getIndexByHash(key);
        CustomEntry<K,V> list = entry[index];

         while (list != null) {
            if (list.getKey().equals(key))
                return list.getValue();
            list = list.next;
        }
        return null;
    }

    /**
     * Add element to the HashMap by the key and his hash
     */

    public V put(K key, V value) {
        int index = getIndexByHash(key);
        CustomEntry<K, V> list = entry[index];

        // if list is empty , enter as first element
        if (list == null) {
            entry[index] = new CustomEntry<K, V>(key, value);
        } else {
            boolean done = false;
            //if a key is found ,replace the value or add it at the end of the list
            while(list.next != null) {
                if (getHashCode(list.getKey()) == getHashCode(key) && list.getKey().equals(key)) {
                    list.setValue(value);
                    done = true;
                    break;
                }
                list = list.next;
            }
            // add at the end of the list
            if (!done)
                list.next = new CustomEntry<K, V>(key, value);
        }
        return null;
    }

    /**
     * Remove element by the key
     */

    public V remove(Object obj) {
        K key = (K)obj;
        int index = getIndexByHash(key);
        CustomEntry<K,V> list = entry[index];
        // if entry is empty
        if (list == null)
            return null;
        while (list != null) {
            if(list.getKey().equals(key)){
                // if only one element is present in the list ,set the index to null
                if (list.next == null && getPrevious(key) == null){
                    entry[index] = null;
                    return null;
                }
                CustomEntry<K,V> previous = getPrevious(key);
                CustomEntry<K,V> current = null;
                // if is first element and it is not one in the entry
                if(previous == null){
                    list = list.getNext();
                    entry[index] = list;
                }
                else{
                    current = previous.getNext();
                    previous.setNext(current.getNext());
                }
                break;
            }
            list = list.next;
        }
        return null;
    }

    /**
     * Get previous element by the key of current element
     */
    private CustomEntry<K, V> getPrevious(K key) {
        int index = getIndexByHash(key);
        CustomEntry<K,V> currentElement = entry[index];
        // if element is first and doesn't have previous
        if(currentElement.getKey().equals(key))
            return null;
        else
            currentElement = currentElement.getNext();

        // if element is not first
        CustomEntry<K,V> previousElement = entry[index];

        while (currentElement != null) {
            if (currentElement.getKey().equals(key))
                return previousElement;
            else{
                previousElement = currentElement;
                currentElement = currentElement.getNext();
            }

        }
        return null;
    }

    /**
     * Get index of entry, if key is null so his entry is null too
     */
    private int getIndexByHash(K key) {

        if(key == null)
            return 0;
        int hash = getHashCode(key);
        //System.out.println("Hashcode =  " +hash);
        return hash % 10;
    }

    /**
     * Get hashcode
     */
    private int getHashCode(K key) {
        int hash = key.hashCode();
        hash = hash*7/3;
        return hash;
    }

    /**
     * Show all entries of hashmap
     */
    public void showAllElements() {
        CustomEntry<K, V> list = null;
        for(int i =0; i<10; i++){
            list = entry[i];
                if(list != null){
                    System.out.println("Entry number "+i);
                    do{
                        System.out.println("   Element: key = "+list.getKey()+" value = "+list.getValue());
                        list = list.next;
                    }while(list != null);  
                }
                else
                    System.out.println("Entry number "+i+" is empty");
         }
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Set<K> keySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection<V> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

