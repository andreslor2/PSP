package conexion.BD;

import gestor.documental.GestorDocumental;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import proceso.principal.ListDocumentos;
//import math.*;

/**
 *
 * @author andres.velez
 */
public class ConnectOracle 
{
 private static final GestorDocumental DOCUMENTOS = new GestorDocumental();   
 public String DatosApp(final int indicador,final ListDocumentos ListDoc)
    {
        final StringBuilder respondo =new StringBuilder();
        float suma =0;
        float media =0;
        float desviacion =0;
        
     try
      {
        final List<String> listDoc = ListDoc.getDocumento();

        for(int i=0;i<listDoc.size();i++)
         {
           listDoc.get(i);
           suma = suma + Float.parseFloat(listDoc.get(i));
           //System.out.println(" Resultado momentaneo: "+suma+"\n");
         }
         media=suma/listDoc.size();
         desviacion=CalculoDesviacion(media,ListDoc);
         respondo.delete(0,respondo.length());
         respondo.append("000,"+suma+","+media+","+desviacion);
         System.out.println("\n La suma es: "+suma);
         System.out.println("\n La media es: "+media);
       }
        catch(Exception ex)
         {
           respondo.delete(0, respondo.length());
           respondo.append("000"); //Error la insertar registros en base de datos 
         }
      return respondo.toString();
    }
  
  
  private String consultas(final int indicador) 
  {
        final StringBuilder retorno = new StringBuilder();
        switch (indicador)
        {
           case 1:                  
            final String add2 ="DELETE FROM ADMINPRUEBAS.T_DOCUMENTOS";
            retorno.append(add2);
          break;
          case 2:                  
            final String add ="INSERT INTO ADMINPRUEBAS.T_DOCUMENTOS (DOCUMENTO) VALUES(?)";
            retorno.append(add);
          break;
          
        }
        return retorno.toString();
    }

    
   public  String obtenerHoraFinal() 
    {
      Date fecha = new Date();  
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha);	
      calendar.add(Calendar.HOUR, 2); 
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.mmm");
      final String HoraFinal = sdf.format(calendar.getTime());
      return HoraFinal;
    }  
   
   public float CalculoDesviacion(float media,final ListDocumentos ListDoc)
   {
   float retorno=0;
   float suma=0;
   float antes=0;
   try
      {
        final List<String> listDoc = ListDoc.getDocumento();
        for(int i=0;i<listDoc.size();i++)
         {
           listDoc.get(i);
           suma=suma+ ((Float.parseFloat(listDoc.get(i))-media)*(Float.parseFloat(listDoc.get(i))-media));
           
         }
         antes=suma/(listDoc.size()-1);
         retorno=(float) Math.sqrt(antes);
         //respondo.delete(0,respondo.length());
         //respondo.append("000,"+suma+","+media+","+desviacion);
         }
        catch(Exception ex)
         {
           //respondo.delete(0, respondo.length());
           //respondo.append("000"); //Error la insertar registros en base de datos 
         }
   
   return retorno;
   }

}
