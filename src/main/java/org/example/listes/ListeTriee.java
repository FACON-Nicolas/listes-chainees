package org.example.listes;

public class ListeTriee<T extends Comparable<T>> extends Liste<T> {

    public ListeTriee(Noeud<T> head) {
        super(head);
    }
    public ListeTriee() {

    }

    public boolean insert(T elt) {
        if (isEmpty() || getHead().getElt().compareTo(elt) >= 0) return addInHead(elt);
        Noeud<T> noeud = getHead();
        Noeud<T> precedent = null;
        while (noeud != null && noeud.getElt().compareTo(elt) < 0) {
            precedent = noeud;
            noeud = noeud.getNext();
        } if (precedent != null) {
            Noeud<T> n = new Noeud<>(elt, noeud);
            precedent.setNext(n);
            setSize(size()+1);
            return true;
        }
        noeud.setNext(new Noeud<>(elt));
        setSize(size()+1);
        return true;
    }

    public boolean estTriee() {
        if (isEmpty()) return false;
        Noeud<T> noeud = getHead();
        while (noeud.getNext() != null) {
            if (noeud.getElt().compareTo(noeud.getNext().getElt()) > 0) {
                return false;
            }
            noeud = noeud.getNext();
        }
        return true;
    }

    public void fusion(ListeTriee<T> liste) {
        if (liste.isEmpty()) return;
        Noeud<T> noeud = liste.getHead();
        while (noeud != null) {
            insert(noeud.getElt());
            noeud = noeud.getNext();
        }
    }
}
