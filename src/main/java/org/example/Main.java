package org.example;

import org.example.listes.Liste;
import org.example.listes.ListeTriee;
import org.example.listes.Noeud;

public class Main {
    public static void main(String[] args) {
        ListeTriee<Integer> ints = new ListeTriee<>();
        System.out.println(ints.isEmpty());
        ints.insert(2);
        ints.insert(0);
        ints.insert(4);
        ints.insert(6);
        ints.insert(4);
        ints.insert(-1);
        System.out.println(ints);
        System.out.println(ints.estTriee());
    }
}