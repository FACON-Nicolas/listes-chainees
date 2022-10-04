package org.example.listes;

public interface IListe<T> {

    boolean addInHead(T elt);
    boolean addInQueue(T elt);
    boolean removeFirstOcc(T elt);
    int size();
    boolean isEmpty();

}
