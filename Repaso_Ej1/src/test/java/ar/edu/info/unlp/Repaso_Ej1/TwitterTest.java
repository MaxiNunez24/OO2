package ar.edu.info.unlp.Repaso_Ej1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

public class TwitterTest {

    Twitter twitter;
    Usuario pedro, juan;

    @BeforeEach
    public void setUp(){
        pedro = new Usuario("Pedro");
        juan = new Usuario("Juan");
        twitter = new Twitter();
    }


    @Test
    public void testAgregarUsuario(){
        assertTrue(twitter.agregarUsuario(pedro));
        assertFalse(twitter.agregarUsuario(pedro));
        assertTrue(twitter.agregarUsuario(juan));
    }

    // TODO: Testear con AssertEquals si un ReTweet a un tweet eliminado imprime el mensaje correspondiente
}
