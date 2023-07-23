
package Metodos;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class TClima extends TConexion {
    
    private long Cedula;
    private String Ciudad;
    private IRespuesta Res;
    
    public TClima(IRespuesta ResCli){
        super();
        Cedula = 0;
        Ciudad = "";
        Res = ResCli;
    }
    
    public void setCedula(long Ced){
        if(Ced > 0){
        Cedula = Ced;
        }
    }
    
    public void setCiudad(String Ciud){
        Ciudad = Ciud.trim();
    }
    
    public long getCedula(){
        return Cedula;
    }
    
    public String getCiudad(){
        return Ciudad;
    }
    
    @Override
   public String TextoUrd(){
       String Dir;
       Dir = "http://pronet.somee.com/Clima.aspx?cedula=%d&ciudad=%s";
       return String.format(Dir, Cedula,Ciudad);
   }
   
   public String getEstudiante(){
       String Est;
       Est = getCampo("Estudiante");
      if(Est!=null){
           try{
                
               Est = new String(Est.getBytes("ISO-8859-1"),"UTF-8");
           }
           catch(UnsupportedEncodingException Error){
               Est = "Error Convirtiendo formato";
           }
       }else{
           Est = "Estudiiante no encontrado";
       }
       return Est;
   }
   
    public void Consultar() {
        String Linea;
        BufferedReader BR;
        InputStreamReader ISR;
        try {
            ISR = new InputStreamReader(Con.getInputStream());
            BR = new BufferedReader(ISR);
            while ((Linea = BR.readLine())!= null) {
                Linea = Linea.trim();
                if (!Linea.isEmpty()) {
                    if (!Res.Procesar(Linea)) {
                        break;
                    }
                }
            }
        } catch (IOException Error) {
            Error.printStackTrace();
        }
    }

}
