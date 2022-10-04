package org.example.listes;

public class ListeDoublementChainees<T> implements IListe<T>{

    private NoeudDoubleChaine<T> head;
    private NoeudDoubleChaine<T> queue;

    private int size;

    public ListeDoublementChainees(NoeudDoubleChaine<T> head, NoeudDoubleChaine<T> queue) {
        this.head = head;
        this.queue = queue;
        size = 0;
    }

    public ListeDoublementChainees() {
        this(null, null);
    }

    @Override
    public boolean addInHead(T elt) {
        NoeudDoubleChaine<T> noeud = new NoeudDoubleChaine<>(elt);
        if (isEmpty()) {
            head = noeud;
            queue = head;
        } else {
            noeud.setNext(head);
            head.setPrevious(noeud);
            setHead(noeud);
        } size++;
        return true;
    }

    @Override
    public boolean addInQueue(T elt) {
        NoeudDoubleChaine<T> noeud = new NoeudDoubleChaine<>(elt);
        if (isEmpty()) {
            queue = noeud;
            head = queue;
        } else {
            queue.setNext(noeud);
            noeud.setPrevious(queue);
            setQueue(noeud);
        }
        size++;
        return true;
    }

    public boolean moveHeadOnNext() {
        if (isEmpty()) return false;
        if (head.getNext() != null) {
            head.getNext().setPrevious(null);
            head = head.getNext();
            size--;
            return true;
        } return false;
    }

    @Override
    public boolean removeFirstOcc(T elt) {
        if (isEmpty()) return false;
        if (head != null && elt.equals(head.getElt())) return moveHeadOnNext();
        NoeudDoubleChaine<T> noeud = head;
        NoeudDoubleChaine<T> precedent = null;
        while (noeud != null && !noeud.getElt().equals(elt)) {
            precedent = noeud;
            noeud = noeud.getNext();
        } if (noeud == null) return false;
        if (noeud.getElt().equals(elt)) {
            if (noeud != queue) {
                precedent.setNext(noeud.getNext());
                noeud.setNext(null);
                noeud.setPrevious(null);
            } else {
                queue = queue.getPrevious();
                queue.setNext(null);
            }
        }
        size--;
        return true;
    }

    public NoeudDoubleChaine<T> getLastOccurence(T elt) {
        if (isEmpty()) return null;
        NoeudDoubleChaine<T> noeud = queue;
        while (noeud != null) {
            if (noeud.getElt().equals(elt))
                return noeud;
            noeud = noeud.getPrevious();
        } return null;
    }

    public boolean removeLastOcc(T elt) {
        if (isEmpty() || getQueue() == null) return false;
        NoeudDoubleChaine<T> noeud = getQueue();
        NoeudDoubleChaine<T> next = null;
        while (noeud != null) {
            if (noeud.getElt().equals(elt)) {
                if (noeud == queue) {
                    queue = queue.getPrevious();
                    if (queue != null) queue.setNext(null);
                } else {
                    NoeudDoubleChaine<T> p = noeud.getPrevious();
                    if (p != null) p.setNext(next);
                    if (next != null) next.setPrevious(p);
                }
                size--;
                return true;
            }
            next = noeud;
            noeud = noeud.getPrevious();
        } return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null || queue == null || size() == 0;
    }

    public NoeudDoubleChaine<T> getHead() {
        return head;
    }

    public void setHead(NoeudDoubleChaine<T> head) {
        this.head = head;
    }

    public NoeudDoubleChaine<T> getQueue() {
        return queue;
    }

    public void setQueue(NoeudDoubleChaine<T> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        String s = "";
        if (isEmpty()) return s;
        NoeudDoubleChaine<T> n  = head;
        while (n != null) {
            s += n;
            n = n.getNext();
        } return s;
    }
}
