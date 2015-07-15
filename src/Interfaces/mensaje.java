package Interfaces;
import proceso.principal.Procesprincipal;

public class mensaje extends javax.swing.JFrame
{ 
   private static boolean conectado=false;
   
    public void setframeAbierto(final boolean sconectado) 
    {
        conectado = sconectado;
    }

    private boolean isframeAbierto() 
    {
        return conectado;
    }
    public mensaje(){initComponents();}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mensaje_label = new javax.swing.JLabel();
        aceptar_boton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mensaje de Aplicacion");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        mensaje_label.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mensaje_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensaje_label.setText("jLabel1");

        aceptar_boton.setText("Aceptar");
        aceptar_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar_botonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mensaje_label, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(aceptar_boton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mensaje_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(aceptar_boton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void aceptar_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar_botonActionPerformed
       SeleccionarArchivos app = new SeleccionarArchivos();
        Procesprincipal pp=new Procesprincipal();
        
        if (isframeAbierto()) 
        {
          this.dispose();
          System.exit(0);
        }
          this.dispose(); 
    }//GEN-LAST:event_aceptar_botonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       this.dispose();
    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar_boton;
    public javax.swing.JLabel mensaje_label;
    // End of variables declaration//GEN-END:variables
}