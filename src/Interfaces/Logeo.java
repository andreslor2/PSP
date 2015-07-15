package Interfaces;

import Admin.mensajes.AdminMensajes;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import proceso.autenticar.AutenticarDirecActivo;
import proceso.principal.Procesprincipal;

public class Logeo extends javax.swing.JFrame {

    public Logeo() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            initComponents();
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuario = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/allusico.PNG")).getImage());
        setName("frmLogueo"); // NOI18N
        setResizable(false);

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("User:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Password:");

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addComponent(usuario))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonAceptar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
       final AdminMensajes mensaje = new AdminMensajes();
       final AutenticarDirecActivo autenticar=new AutenticarDirecActivo();
       
        if(usuario.getText().isEmpty() &&  convertirChar(password.getPassword()).isEmpty())
         {
           mensaje.imprimirMensaje("<html>Debe ingresar un usuario y contraseña valido<html>");    
         }
        else if(usuario.getText().isEmpty())
         {
            mensaje.imprimirMensaje("<html>Debe ingresar un usuario valido<html>");    
         }
        else if(convertirChar(password.getPassword()).isEmpty())
         {
            mensaje.imprimirMensaje("<html>Debe ingresar un password valido<html>");    
         }
        else
        {
           final boolean respuestaLogueo=autenticar.autenticarLDAP(usuario.getText().trim(), convertirChar(password.getPassword()).trim()); 
           if(respuestaLogueo)
            {
              final Procesprincipal Pprincipal = new Procesprincipal();
              Pprincipal.iniciarPrograma();
              this.dispose(); 
            }
           else
           {
             mensaje.imprimirMensaje("<html>Error al autenticar usuario, verifique que su <br>" +
                                     " usuario de red no este bloqueado</html>");   
           }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
     final AdminMensajes mensaje = new AdminMensajes();
     final AutenticarDirecActivo autenticar=new AutenticarDirecActivo();
       
        if(usuario.getText().isEmpty() &&  convertirChar(password.getPassword()).isEmpty())
         {
           mensaje.imprimirMensaje("<html>Debe ingresar un usuario y contraseña valido<html>");    
         }
        else if(usuario.getText().isEmpty())
         {
            mensaje.imprimirMensaje("<html>Debe ingresar un usuario valido<html>");    
         }
        else if(convertirChar(password.getPassword()).isEmpty())
         {
            mensaje.imprimirMensaje("<html>Debe ingresar un password valido<html>");    
         }
        else
        {
           final boolean respuestaLogueo=autenticar.autenticarLDAP(usuario.getText().trim(), convertirChar(password.getPassword()).trim()); 
           if(respuestaLogueo)
            {
              final Procesprincipal Pprincipal = new Procesprincipal();
              Pprincipal.iniciarPrograma();
              this.dispose(); 
            }
           else
           {
             mensaje.imprimirMensaje("<html>Error al autenticar usuario, verifique que su <br>" +
                                     " usuario de red no este bloqueado</html>");   
           }
        }
    }//GEN-LAST:event_passwordActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
 final AdminMensajes mensaje = new AdminMensajes();
       final AutenticarDirecActivo autenticar=new AutenticarDirecActivo();
       
        if(usuario.getText().isEmpty() &&  convertirChar(password.getPassword()).isEmpty())
         {
           mensaje.imprimirMensaje("<html>Debe ingresar un usuario y contraseña valido<html>");    
         }
        else if(usuario.getText().isEmpty())
         {
            mensaje.imprimirMensaje("<html>Debe ingresar un usuario valido<html>");    
         }
        else if(convertirChar(password.getPassword()).isEmpty())
         {
            mensaje.imprimirMensaje("<html>Debe ingresar un password valido<html>");    
         }
        else
        {
           final boolean respuestaLogueo=autenticar.autenticarLDAP(usuario.getText().trim(), convertirChar(password.getPassword()).trim()); 
           if(respuestaLogueo)
            {
              final Procesprincipal Pprincipal = new Procesprincipal();
              Pprincipal.iniciarPrograma();
              this.dispose(); 
            }
           else
           {
             mensaje.imprimirMensaje("<html>Error al autenticar usuario, verifique que su <br>" +
                                     " usuario de red no este bloqueado</html>");   
           }
        }
    }//GEN-LAST:event_usuarioActionPerformed

    private String convertirChar(final char[] dato) {
        char character;
        StringBuilder retorno = new StringBuilder();
        for (int i = 0; i < dato.length; i++) {
            character = dato[i];
            retorno.append(character);
        }
        return retorno.toString();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
