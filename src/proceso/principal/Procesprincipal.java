package proceso.principal;

import Admin.mensajes.AdminMensajes;
import Interfaces.Logeo;
import Interfaces.SeleccionarArchivos;
import conexion.BD.ConnectOracle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 * @author andres.velez
 */
public class Procesprincipal 
{
    private static String IpCorrrecta;
    public JProgressBar jProBar;
    public static void main(String[] args) 
    {
//        final Logeo log=new Logeo();
//        log.setLocationRelativeTo(null);
//        log.setVisible(true);
        new Procesprincipal().iniciarPrograma();
    }
      
 public void iniciarPrograma() 
   {
    SeleccionarArchivos app = new SeleccionarArchivos();
    app.setLocationRelativeTo(null);
    app.setVisible(true);
   }  
   
  public void generarTrama(File archivo,JProgressBar jProgBar) 
    {
        jProBar =jProgBar;
        final AdminMensajes mensaje = new AdminMensajes();
        ListDocumentos ListDoc = new ListDocumentos();
        boolean estadoLectura= true;
        int contador=1;
        String Doc;
        System.out.println("Nombre archivo: " + archivo.toString());
    try 
      {
        if (archivo.toString().endsWith(".txt")) 
         {
             final InputStreamReader inputReader= new InputStreamReader(new FileInputStream(archivo), "UTF-8");
             final BufferedReader bufferreader  = new BufferedReader(inputReader);
             
            if (archivo.length()>0) 
              { 
              List<String> lisDoc = new ArrayList<String>();
              String linea = bufferreader.readLine().trim();
              linea = validarLinea(linea.trim());
              Doc = EstructuraTrama(linea.trim());
              
              if (!Doc.split(",")[0].equals("EDC")) 
                {   
                  lisDoc.add(linea.trim());
                  linea = bufferreader.readLine();
                     while (linea != null && !linea.isEmpty()) 
                       {
                          contador++;
                          linea = validarLinea(linea.trim());
                          Doc = EstructuraTrama(linea.trim());
                         if (!Doc.split(",")[0].equals("EDC") ) 
                            {
                             lisDoc.add(linea.trim());
                             linea = bufferreader.readLine();
                             }  
                         else
                           {
                              mensaje.imprimirMensaje("<html>Error en la linea : <b>"+contador+"</b>"+
                                                       "<br>la linea :<b>"+linea+"</b> no tiene un documento valido</html>");
                              estadoLectura=false;
                              break;   
                           }
                       }  
                      bufferreader.close();
                      inputReader.close();   
                     if(estadoLectura)
                      {
                        updateProgressbar(60);
                        ConnectOracle conexionOra= new ConnectOracle(); 
                        ListDoc.setDocumento(lisDoc);
                        final String Respuesta = conexionOra.DatosApp(1,ListDoc);
                        
                        if (Respuesta.toString().trim().startsWith("000"))
                         {
                           
                           updateProgressbar(100);
                           final String Suma=Respuesta.toString().split(",")[1];
                           final String Media=Respuesta.toString().split(",")[2];
                           final String Desviacion=Respuesta.toString().split(",")[3];
                           mensaje.imprimirMensaje("<html>El archivo se cargo correctamente,"+"<br> La suma de los elementos es :<b>"+Suma+"</b>"+
                                                   "<br>La media de los elementos es :<b>"+Media+"</b>"+
                                                   "<br>La desviacion estandar de los elementos es :<b>"+Desviacion+"</b>"+"</b></html>");
                         
                         }
                        else 
                        {
                           mensaje.imprimirMensaje("Error al cargar archivo, no existe conexion con la base de datos");
                           updateProgressbar(0);
                        }
                        ListDoc=null;
                        
                      }                  
              
                }
              
                else 
                   {
                      mensaje.imprimirMensaje("<html>Error en la linea : <b>"+contador+"</b>"+
                                              "<br>Detalle de  linea :<b>"+linea+"</b> no tiene un documento valido</html>");
                      updateProgressbar(0);
                   }
              
              } 
                else 
                 {
                  mensaje.imprimirMensaje("El archivo seleccionado esta vacio");
                  updateProgressbar(0);
                 }
               System.out.println("YA INGRESÉ AL ARCHIVO .TXT, hay una excepcion");     
         } 
           else 
            {
                mensaje.imprimirMensaje("<html>El archivo que desea cargar no tiene extencion <b>.txt</b> </html>");
                updateProgressbar(0);
            }
         } 
        catch (Exception ex)
         {
            mensaje.imprimirMensaje("<html>Error al cargar  archivo, verifique la estructura y la extension del archivo he intente nuevamente</html>"+
                                    "<br>"+ex+"</html>");
            updateProgressbar(0);
         }
     }
   
  private String validarLinea(String dato) 
    {
        final StringBuilder retorno = new StringBuilder();
        for (int i = 0; i < dato.length(); i++) 
        {
           if ((int) dato.charAt(i) != 0) 
            {
              retorno.append(dato.charAt(i));
            }
        }
        return retorno.toString();
    }

   public void closeApp()
    {
        System.exit(0);
    }
     
  private String EstructuraTrama(final String linea) 
    {
        final StringBuilder Respondo = new StringBuilder();
        final String Numero = (linea.trim());
          try 
            {
              Float.parseFloat(Numero.trim());
              Respondo.append(linea.toString().trim());
            } 
           catch (NumberFormatException n) 
            {
              Respondo.append("EDC,").append(linea);////Error de Numero
            } 
        return Respondo.toString();
      }
  
     
      public void updateProgressbar(final int valor)
        {
          jProBar.revalidate();
          jProBar.repaint();
          jProBar.setValue(valor);
          jProBar.setStringPainted(true);
          jProBar.update(jProBar.getGraphics());
          SwingUtilities.updateComponentTreeUI(jProBar);  
        }
      }