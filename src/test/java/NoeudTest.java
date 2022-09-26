import org.example.listes.Noeud;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoeudTest {

    Noeud<Integer> n;

    @BeforeEach
    void setUp() {
        n = new Noeud<>();
    }

    @Test
    void constructTest() {
        assertNull(n.getElt());
        assertNull(n.getNext());

        n = new Noeud<>(3);
        assertEquals(n.getElt(), 3);
        assertNull(n.getNext());

        n = new Noeud<>(3, new Noeud<>());
        assertEquals(n.getElt(), 3);
        assertNotNull(n.getNext());
    }

    @Test
    void setEltTest() {
        assertNull(n.getElt());
        n.setElt(3);
        assertEquals(n.getElt(), 3);
    }

    @Test
    void setNextTest() {
        assertNull(n.getNext());
        n.setNext(new Noeud<>());
        assertNotNull(n.getNext());
    }

    @Test
    void equalsTest() {
        n.setElt(3);
        Noeud<Integer> n2 = new Noeud<>(3);
        assertEquals(n, n2);
    }
}
