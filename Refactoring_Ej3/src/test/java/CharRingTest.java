import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharRingTest {

    CharRing charRing;

    @BeforeEach
    public void setUp(){
        charRing = new CharRing("Hola Mundo!");
    }

    @Test
    public void testNext(){
        assertEquals('H', charRing.next());
        assertEquals('o', charRing.next());
        assertEquals('l', charRing.next());
        assertEquals('a', charRing.next());
        assertEquals(' ', charRing.next());
        assertEquals('M', charRing.next());
        assertEquals('u', charRing.next());
        assertEquals('n', charRing.next());
        assertEquals('d', charRing.next());
        assertEquals('o', charRing.next());
        assertEquals('!', charRing.next());
        assertEquals('H', charRing.next());
    }
}
