package org.example.listes;

public class Noeud<T> {

    private T elt;
    private Noeud<T> next;

    public Noeud(T elt, Noeud<T> next) {
        this.elt = elt;
        this.next = next;
    }

    public Noeud(T elt) {
        this(elt, null);
    }

    public Noeud() {
        this(null);
    }

    public T getElt() {
        return elt;
    }

    public void setElt(T elt) {
        this.elt = elt;
    }

    public Noeud<T> getNext() {
        return next;
    }

    public void setNext(Noeud<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Noeud<?> n) && n.elt.equals(elt);
    }
}
