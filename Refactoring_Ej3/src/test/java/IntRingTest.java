import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntRingTest {

    IntRing intRing;

    @BeforeEach
    public void setUp() {
        intRing = new IntRing(new int[]{1,2,3,4,5});
    }

    @Test
    public void testNext(){
        assertEquals(1, intRing.next());
        assertEquals(2, intRing.next());
        assertEquals(3, intRing.next());
        assertEquals(4, intRing.next());
        assertEquals(5, intRing.next());
        assertEquals(1, intRing.next());
    }

}
