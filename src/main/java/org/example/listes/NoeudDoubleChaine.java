package org.example.listes;

public class NoeudDoubleChaine<T> {

    private NoeudDoubleChaine<T> previous;
    private NoeudDoubleChaine<T> next;
    private T elt;

    public NoeudDoubleChaine(T elt, NoeudDoubleChaine<T> previous, NoeudDoubleChaine<T> next) {
        this.elt = elt;
        this.previous = previous;
        this.next = next;
    }

    public NoeudDoubleChaine(T elt) {
        this(elt, null, null);
    }

    public NoeudDoubleChaine<T> getNext() {
        return next;
    }

    public void setNext(NoeudDoubleChaine<T> next) {
        this.next = next;
    }

    public void setPrevious(NoeudDoubleChaine<T> previous) {
        this.previous = previous;
    }

    public NoeudDoubleChaine<T> getPrevious() {
        return previous;
    }

    public T getElt() {
        return elt;
    }

    public void setElt(T elt) {
        this.elt = elt;
    }

    @Override
    public String toString() {
        return " " + elt;
    }
}
