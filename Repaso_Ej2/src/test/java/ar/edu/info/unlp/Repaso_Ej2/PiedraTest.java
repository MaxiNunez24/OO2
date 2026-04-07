package ar.edu.info.unlp.Repaso_Ej2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiedraTest {
    Piedra piedra;

    @BeforeEach
    public void setUp() {
        piedra = new Piedra();
    }

    @Test
    public void testJuegos() {
        assertEquals("Empate", piedra.contraPiedra().toString());
        assertEquals("Papel", piedra.contraPapel().toString());
        assertEquals("Piedra", piedra.contraTijera().toString());
        assertEquals("Piedra", piedra.contraLagarto().toString());
        assertEquals("Spock", piedra.contraSpock().toString());
    }
}
