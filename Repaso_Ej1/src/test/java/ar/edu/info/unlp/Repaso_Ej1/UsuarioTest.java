package ar.edu.info.unlp.Repaso_Ej1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    Usuario pedro;

    @BeforeEach
    public void setUp() {
        pedro = new Usuario("Pedro");
        pedro.postearTweet("Holaa");
        pedro.postearTweet("Buenas Tardes!!");
    }


    @Test
    public void testPostearTweet(){
        assertFalse(pedro.postearTweet(""));
        assertFalse(pedro.postearTweet("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"));
        assertTrue(pedro.postearTweet("Hola! Soy Pedro :D"));
    }
}
