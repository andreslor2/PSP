package gestor.documental;
/*
 * @author andres.velez
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Cleanup;

public class GestorDocumental 
{
    public String leerProperties(final String proper) 
    {
        final Properties prop = new Properties();
        try 
        {
            final @Cleanup
            InputStream input_stream = new FileInputStream("AppCargueDocumento.properties");
            prop.load(input_stream);
            input_stream.close();
        } 
        catch (IOException ex) 
        {
          Logger.getLogger(gestor.documental.GestorDocumental.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prop.getProperty(proper);
    }

  }
