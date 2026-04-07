package ar.edu.info.unlp.Repaso_Ej2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PapelTest {
    Papel papel;

    @BeforeEach
    public void setUp() {
        papel = new Papel();
    }

    @Test
    public void testJuegos() {
        assertEquals("Papel", papel.contraPiedra().toString());
        assertEquals("Empate", papel.contraPapel().toString());
        assertEquals("Tijera", papel.contraTijera().toString());
        assertEquals("Lagarto", papel.contraLagarto().toString());
        assertEquals("Papel", papel.contraSpock().toString());
    }
}
