package proceso.autenticar;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 *
 * @author andres.velez
 */
public class AutenticarDirecActivo 
{   
//  public static void main(String[] args) 
//   {  
//        
//        AutenticarDirecActivo ldapContn = new AutenticarDirecActivo();  
//        boolean ctx = ldapContn.autenticarLDAP("alexander.lopez.o","XXXXXXXX"); 
//        if(ctx){
//            System.out.println("conexion exitosa");   
//        } else{
//            System.out.println("usuario o contraeña invalidos");
//        }
//       
//        
//    }  
      public boolean autenticarLDAP(String usuario , String password){  
        
        boolean retorno=true;
//        LdapContext ctx ; 
//        
//        try
//        {  
//            Hashtable env = new Hashtable();  
//            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");  
//            env.put(Context.SECURITY_AUTHENTICATION, "Simple");  
//              
//            env.put(Context.SECURITY_PRINCIPAL, usuario+"@multienlace.com.co");  
//            env.put(Context.SECURITY_CREDENTIALS, password);  
//          
//            env.put(Context.PROVIDER_URL, "ldap://sm1dc01w8s.multienlace.com.co:389/");  
//           
//            ctx = new InitialLdapContext(env, null); 
//            
//            ctx.close();
//           
//        }
//       catch(NamingException ex)
//        { 
//            retorno=false;
//        }
//        String s1 ="andres";
//        System.out.println("Usuario: "+ usuario + "Password:  "+password);
//        if (usuario ==s1)
//        {
//            if (password==s1)
//            {
//            System.out.println("conexion exitosa");
//            }
//            
//        }else{
//            System.out.println("usuario o contraeña invalidos");
//            retorno=false;
//        }
//        System.out.println("Retorno:  "+retorno);
        return retorno;
        
    }  
    
}
