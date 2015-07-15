package Admin.mensajes;
import Interfaces.SeleccionarArchivos;
import Interfaces.mensaje;

public class AdminMensajes 
{  
    mensaje msn = new mensaje();
    public void imprimirMensaje(String aMostrar) 
    {
        esconderMensaje();
        msn.mensaje_label.setText(aMostrar);
        msn.setLocationRelativeTo(null);
        msn.setVisible(true);    
    }
   
    public void esconderMensaje() 
    {
        final SeleccionarArchivos pp=new SeleccionarArchivos();
        pp.setVisible(false);
        msn.dispose();
    }
    
    public void estadoFramePrincipal(boolean estado) 
    {
        msn.setframeAbierto(estado);    
    }
}