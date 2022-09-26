import org.example.listes.ListeTriee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListeTrieeTest {

    ListeTriee<Integer> ints;

    @BeforeEach
    void setUp() {
        ints = new ListeTriee<>();
    }

    @AfterEach
    void tearDown() {
        ints = null;
    }

    @Test
    void estTrieeTest() {
        ints.insert(3);
        ints.insert(2);
        ints.insert(3);
        ints.insert(5);
        ints.insert(0);
        ints.insert(9);
        ints.insert(-2);
        assertTrue(ints.estTriee());
    }

    @Test
    void insertTest() {
        ints.insert(3);
        assertEquals(" 3", ints.toString());
        ints.insert(0);
        assertEquals(" 0 3", ints.toString());
    }

    @Test
    void fusionTest() {
        ListeTriee<Integer> ints2 = new ListeTriee<>();
        ListeTriee<Integer> ints3 = new ListeTriee<>();
        ints.insert(2);
        ints.insert(3);
        ints.insert(8);
        ints2.insert(5);
        ints2.insert(7);
        ints2.insert(9);
        ints3.insert(2);
        ints3.insert(3);
        ints3.insert(8);
        ints3.insert(5);
        ints3.insert(7);
        ints3.insert(9);
        ints.fusion(ints2);
        assertEquals(ints.size(), 6);
        assertTrue(ints.estTriee());
    }

}
