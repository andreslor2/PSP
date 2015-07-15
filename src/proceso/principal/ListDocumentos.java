package proceso.principal;

import java.io.Serializable;
import java.util.List;

public class ListDocumentos implements Serializable
{
    private List<String> LisDocumentos; 
   
  
   public List<String> getDocumento() 
     {
       return LisDocumentos;
     }
   
  public void setDocumento(List<String> Doc) 
    {
        this.LisDocumentos = Doc;
    }
}
