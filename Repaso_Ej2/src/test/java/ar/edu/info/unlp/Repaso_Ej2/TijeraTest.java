package ar.edu.info.unlp.Repaso_Ej2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TijeraTest {
    Tijera tijera;

    @BeforeEach
    public void setUp() {
        tijera = new Tijera();
    }

    @Test
    public void testJuegos() {
        assertEquals("Piedra", tijera.contraPiedra().toString());
        assertEquals("Tijera", tijera.contraPapel().toString());
        assertEquals("Empate", tijera.contraTijera().toString());
        assertEquals("Tijera", tijera.contraLagarto().toString());
        assertEquals("Spock", tijera.contraSpock().toString());
    }

}
