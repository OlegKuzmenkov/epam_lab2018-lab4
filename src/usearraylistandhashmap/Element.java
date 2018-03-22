/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package usearraylistandhashmap;

/**
 *
 * @author nrg
 */
public class Element<T> {

    private Element<T> next;
    private Element<T> previous;
    private T t;

    public Element() {
        this.next = null;
        this.previous = null;
    }

    public Element(Element<T> previous) {
        this.next = null;
        this.previous = previous;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }

    public Element<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Element<T> previous) {
        this.previous = previous;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

}
