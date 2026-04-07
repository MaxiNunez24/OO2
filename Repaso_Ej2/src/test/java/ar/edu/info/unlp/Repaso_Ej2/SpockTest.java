package ar.edu.info.unlp.Repaso_Ej2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpockTest {

    Spock spock;

    @BeforeEach
    public void setUp() {
        spock  = new Spock();
    }

    @Test
    public void testJuegos() {
        assertEquals("Spock", spock.contraPiedra().toString());
        assertEquals("Papel", spock.contraPapel().toString());
        assertEquals("Spock", spock.contraTijera().toString());
        assertEquals("Lagarto", spock.contraLagarto().toString());
        assertEquals("Empate", spock.contraSpock().toString());
    }
}
