package Clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONArray;
import org.json.JSONException;

public class Usuario {
    private final String file = "src/Data/Usuario.json";
    private final JSONArray usuarioDatos;
    private final String usuario;
    private final String contrasena;
    
    public Usuario(String usuario, String contrasena) throws IOException, 
            JSONException {
        this.usuarioDatos = this.obtenerUsuarios();
        this.usuario = usuario;
        //this.contrasena = DigestUtils.md5Hex(contrasena);
        this.contrasena = contrasena;
    }
    
    private JSONArray obtenerUsuarios() throws IOException, JSONException {
        final String json = 
                new String((Files.readAllBytes(Paths.get(this.file))));
        return new JSONArray(json);
    }
    
    public boolean iniciarSesion() throws JSONException {
        for (int i = 0; i < usuarioDatos.length(); i++) {
            if (this.usuario.equals(usuarioDatos.getJSONObject(i)
                    .get("usuario")) && this.contrasena.
                            equals(usuarioDatos.getJSONObject(i)
                                    .get("contrasena"))) {
                return true;
            }
        }
        return false;
    }
}
