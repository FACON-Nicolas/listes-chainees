package org.example.listes;

public class Liste<T> {

    private Noeud<T> head;

    private int size;

    public Liste(Noeud<T> head) {
        this.head = head;
        size=0;
    }

    public Liste() {
        this(null);
    }

    public boolean isEmpty() {
        return size == 0 || (head == null);
    }

    public int size() {
        return size;
    }

    public boolean addInHead(T elt) {
        if (head == null || head.getElt() == null) head = new Noeud<>(elt);
        else head = new Noeud<>(elt, head);
        size++;
        return true;
    }

    public boolean addInQueue(T elt) {
        if (isEmpty()) return addInHead(elt);
        Noeud<T> noeud = head;
        while (noeud.getNext() != null) {
            noeud = noeud.getNext();
        } noeud.setNext(new Noeud<>(elt));
        size++;
        return true;
    }

    public boolean insertAfterElt(T elt, T eltToAdd) {
        if (isEmpty()) return addInHead(eltToAdd);
        Noeud<T> n = head;
        while (n.getNext() != null && !n.getElt().equals(elt))
            n = n.getNext();
        if (n.getNext() == null) return addInQueue(eltToAdd);
        n.setNext(new Noeud<T>(eltToAdd, n.getNext()));
        size++;
        return true;
    }

    public Noeud<T> getHead() {
        return head;
    }

    @Override
    public String toString() {
        String s = "";
        if (isEmpty()) return s;
        Noeud<T> n = head;
        while (n != null && n.getElt() != null) {
            s += " " + String.valueOf(n.getElt());
            n = n.getNext();
        } return s;
    }

    public boolean moveHeadOnNext() {
        if (head != null) {
            head = head.getNext();
            size--;
            return true;
        } return false;
    }

    public boolean removeFirstOcc(T elt) {
        if (isEmpty()) return false;
        if (head != null && elt.equals(head.getElt())) return moveHeadOnNext();
        Noeud<T> noeud = head;
        Noeud<T> precedent = null;
        while (noeud != null && !noeud.getElt().equals(elt)) {
            precedent = noeud;
            noeud = noeud.getNext();
        } if (noeud == null) return false;
        if (noeud.getElt().equals(elt))
            precedent.setNext(noeud.getNext());
        size--;
        return true;
    }

    public int getLastOccurence(T elt) {
        int index = -1;
        if (isEmpty()) return -1;
        Noeud n = head;
        int i = 0;
        while (n != null) {
            if (n.getElt().equals(elt)) index = i;
            i++;
            n = n.getNext();
        } return index;
    }

    public void removeAllOccurence(T elt) {
        while (getLastOccurence(elt) != -1)
            removeFirstOcc(elt);
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString()) && obj instanceof Liste<?>;
    }

    public void concat(Liste<T> liste) {
        if (isEmpty()) head = liste.head;
        Noeud<T> n = head;
        while (n.getNext() != null) n = n.getNext();
        n.setNext(liste.head);
    }

    public Liste<T> reversed() {
        Liste<T> ints = new Liste<>();
        Noeud<T> n = head;
        while (n != null) {
            ints.addInHead(n.getElt());
            n = n.getNext();
        } return ints;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
