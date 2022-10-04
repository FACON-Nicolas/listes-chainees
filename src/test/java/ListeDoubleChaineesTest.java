import org.example.listes.ListeDoublementChainees;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListeDoubleChaineesTest {

    private ListeDoublementChainees<Integer> ints;

    @BeforeEach
    void setUp() {
        ints = new ListeDoublementChainees<>();
    }

    @AfterEach
    void tearDown() {
        ints = null;
    }

    @Test
    void addInHeadTest() {
        ints.addInHead(3);
        ints.addInHead(7);
        assertEquals(" 7 3", ints.toString());
        assertEquals(2, ints.size());
    }

    @Test
    void addInQueueTest() {
        ints.addInQueue(3);
        ints.addInQueue(7);
        assertEquals(" 3 7", ints.toString());
        assertEquals(2, ints.size());
    }

    @Test
    void moveHeadOnNextTest() {
        ints.addInQueue(3);
        ints.addInQueue(7);
        ints.addInQueue(3);
        ints.addInQueue(7);
        ints.moveHeadOnNext();
        assertNull(ints.getHead().getPrevious());
        assertEquals(3, ints.size());
        assertEquals(" 7 3 7", ints.toString());
    }

    @Test
    void getLastOccurenceTest() {
        ints.addInQueue(3);
        ints.addInQueue(7);
        ints.addInQueue(3);
        ints.addInQueue(7);
        assertEquals(ints.getQueue(), ints.getLastOccurence(7));
        assertEquals(ints.getQueue().getPrevious(), ints.getLastOccurence(3));
    }

    @Test
    void removeFirstOccTest() {
        ints.addInQueue(3);
        ints.addInQueue(7);
        ints.addInQueue(3);
        ints.addInQueue(7);
        ints.removeFirstOcc(7);
        assertEquals(" 3 3 7", ints.toString());
        ints.removeFirstOcc(5);
        assertEquals(" 3 3 7", ints.toString());
        ints.removeFirstOcc(3);
        assertEquals(" 3 7", ints.toString());
    }

    @Test
    void sizeTest() {
        ints.addInQueue(3);
        ints.addInQueue(7);
        assertEquals(2, ints.size());
        ints.addInHead(2);
        assertEquals(3, ints.size());
        ints.removeFirstOcc(5);
        assertEquals(3, ints.size());
        ints.removeFirstOcc(7);
        assertEquals(2, ints.size());
        ints.removeLastOcc(2);
        assertEquals(1, ints.size());
    }

    @Test
    void removeLastOccTest() {
        ints.addInQueue(3);
        ints.addInQueue(7);
        ints.addInQueue(3);
        ints.addInQueue(7);
        ints.removeLastOcc(3);
        assertEquals(" 3 7 7", ints.toString());
        ints.removeLastOcc(7);
        assertEquals(" 3 7", ints.toString());
    }
}
