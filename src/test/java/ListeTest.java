import org.example.listes.Liste;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListeTest {

    Liste<Integer> ints;

    @BeforeEach
    void setUp() {
        ints = new Liste<>();
    }

    @AfterEach
    void down() { ints = null; }

    @Test
    void sizeTest() {
        assertEquals(0, ints.size());
        ints.addInQueue(1);
        assertEquals(1, ints.size());
        ints.addInQueue(2);
        assertEquals(2, ints.size());
        ints.removeFirstOcc(2);
        assertEquals(1, ints.size());
    }

    @Test
    void isEmptyTest() {
        assertTrue(ints.isEmpty());
        ints.addInQueue(1);
        assertFalse(ints.isEmpty());
    }

    @Test
    void addInHeadTest() {
        assertNull(ints.getHead());
        ints.addInHead(3);
        assertEquals(" 3", ints.toString());
    }

    @Test
    void removeFirstOccTest() {
        ints.addInHead(1);
        ints.addInHead(2);
        ints.addInHead(3);
        ints.addInHead(4);
        ints.addInHead(5);
        ints.addInHead(6);
        ints.addInHead(7);
        ints.addInHead(8);
        ints.addInHead(9);
        ints.addInHead(10);
        ints.addInQueue(1);
        ints.removeFirstOcc(10);
        ints.removeFirstOcc(1);
        ints.removeFirstOcc(1);
        ints.removeFirstOcc(7);
        assertEquals(" 9 8 6 5 4 3 2", ints.toString());
    }

    @Test
    void getLastOccTest() {
        ints.addInQueue(1);
        ints.addInQueue(2);
        ints.addInQueue(3);
        ints.addInQueue(4);
        ints.addInQueue(5);
        ints.addInQueue(6);
        ints.addInQueue(7);
        ints.addInQueue(8);
        ints.addInQueue(9);
        ints.addInQueue(10);
        ints.addInQueue(1);
        assertNull(ints.getLastOccurence(-1));
        assertEquals(3, ints.getLastOccurence(3).getElt());
    }

    @Test
    void removeAllOccTest() {
        ints.addInQueue(1);
        ints.addInQueue(7);
        ints.addInQueue(2);
        ints.addInQueue(1);
        ints.addInQueue(3);
        ints.removeAllOccurence(1);
        assertEquals(" 7 2 3", ints.toString());
    }

    @Test
    void concatTest() {
        ints.addInQueue(1);
        ints.addInQueue(1);
        ints.addInQueue(2);
        ints.addInQueue(1);
        Liste<Integer> ints2 = new Liste<>();
        ints2.addInQueue(3);
        ints2.addInQueue(1);
        ints2.addInQueue(2);
        ints2.addInQueue(1);
        ints.concat(ints2);
        assertEquals(" 1 1 2 1 3 1 2 1", ints.toString());
    }

    @Test
    void reverseTest() {
        ints.addInQueue(1);
        ints.addInQueue(1);
        ints.addInQueue(2);
        ints.addInQueue(1);
        assertEquals(" 1 2 1 1", ints.reversed().toString());
    }

    @Test
    void insertAfterElt() {
        ints.addInQueue(1);
        ints.addInQueue(2);
        ints.addInQueue(3);
        ints.addInQueue(4);
        ints.insertAfterElt(2, 6);
        assertEquals(" 1 2 6 3 4", ints.toString());
    }

    @Test
    void equalsTest() {
        Liste<Integer> ints2 = new Liste<>();
        ints2.addInQueue(1);
        ints.addInQueue(1);
        assertEquals(ints, ints2);
        ints2.addInHead(3);
        assertNotEquals(ints, ints2);
    }

    @Test
    void moveEltOnHeadTest() {
        assertFalse(ints.moveHeadOnNext());
        ints.addInQueue(2);
        ints.addInQueue(2);
        assertTrue(ints.moveHeadOnNext());
    }
}
