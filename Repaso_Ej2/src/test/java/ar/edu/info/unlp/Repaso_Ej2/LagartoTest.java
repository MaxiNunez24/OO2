package ar.edu.info.unlp.Repaso_Ej2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LagartoTest {

    Lagarto lagarto;

    @BeforeEach
    public void setUp() {
        lagarto = new Lagarto();
    }

    @Test
    public void testJuegos() {
        assertEquals("Piedra", lagarto.contraPiedra().toString());
        assertEquals("Lagarto", lagarto.contraPapel().toString());
        assertEquals("Tijera", lagarto.contraTijera().toString());
        assertEquals("Empate", lagarto.contraLagarto().toString());
        assertEquals("Lagarto", lagarto.contraSpock().toString());
    }
}
