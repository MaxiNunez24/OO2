package ar.edu.info.unlp.Repaso_Ej1;

import java.util.ArrayList;

public class Twitter {

    private ArrayList<Usuario> usuarios;

    public Twitter() {
        usuarios = new ArrayList<>();
    }

    public boolean agregarUsuario(Usuario usuario){
        if(this.validarScreenName(usuario)){
            usuarios.add(usuario);
            return true;
        }
        else return false;
    }

    public void eliminarUsuario(TweetBase tweet){

    }

    private boolean validarScreenName(Usuario usuarioNuevo){
        return usuarios.stream()
                .noneMatch(usuario -> usuario.mismoScreenName(usuarioNuevo));
    }
}
