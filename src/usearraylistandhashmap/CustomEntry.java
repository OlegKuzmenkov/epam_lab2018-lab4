/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package usearraylistandhashmap;

/**
 *
 * @author nrg
 */
class CustomEntry<K, V> {

    K key;
    V value;
    CustomEntry<K, V> next = null;

    public CustomEntry<K, V> getNext() {
        return next;
    }

    public void setNext(CustomEntry<K, V> next) {
        this.next = next;
    }

    public CustomEntry(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
