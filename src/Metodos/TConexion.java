package Metodos;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;

public abstract class TConexion {

    protected URLConnection Con;

    public TConexion() {
        Con = null;
    }

    public URLConnection getConexion() {
        return Con;
    }

    public String getCampo(String Campo) {
        return Con.getHeaderField(Campo);
    }
    
    public abstract String TextoUrd();
    
    public boolean Conectar() {
        URL U;
        try {
            U = new URL(TextoUrd());
            Con = U.openConnection();
            return true;
        }
        catch(MalformedURLException Error){
            Error.printStackTrace();
            return false;
        }
        catch(IOException Error){
            Error.printStackTrace();
            return false;
        }
        }

    }
