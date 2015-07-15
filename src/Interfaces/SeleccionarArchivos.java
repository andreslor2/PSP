package Interfaces;

import Admin.mensajes.AdminMensajes;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import proceso.principal.Procesprincipal;

public class SeleccionarArchivos extends javax.swing.JFrame {
 AdminMensajes mensaje=new AdminMensajes();
   private JProgressBar jProgBar;
   public SeleccionarArchivos() 
    {  
           try 
           {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            initComponents();
            } 
           catch (Exception e) 
           {
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        archivos_file = new javax.swing.JFileChooser();
        jProgresBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carga de  archivo  ANI - CATT");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/allusico.PNG")).getImage());
        setResizable(false);

        archivos_file.setCurrentDirectory(new java.io.File("C:\\Users\\daniel\\Desktop"));
        archivos_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivos_fileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(archivos_file, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgresBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(archivos_file, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgresBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void archivos_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivos_fileActionPerformed
     final Procesprincipal Pp = new Procesprincipal();
       if (evt.getActionCommand().equals("ApproveSelection")) 
        {
           updatePgressbar(25,true);
           Pp.generarTrama(archivos_file.getSelectedFile(),jProgresBar); 
        } 
       else 
        {
           System.exit(0);
        } 
    }//GEN-LAST:event_archivos_fileActionPerformed

    public void updatePgressbar(final int valor,final boolean limpiar)
     {
         if(limpiar)
         {
             if (valor<=100) 
             {
                jProgresBar.revalidate();
                jProgresBar.repaint();
                jProgresBar.setValue(valor);
                jProgresBar.setStringPainted(true);
                jProgresBar.update(jProgresBar.getGraphics());
                SwingUtilities.updateComponentTreeUI(jProgresBar);   
             }
         }
         else
         {
                jProgresBar.revalidate();
                jProgresBar.repaint();
                jProgresBar.setValue(0);
                jProgresBar.setStringPainted(true);
                jProgresBar.update(jProgresBar.getGraphics());
                SwingUtilities.updateComponentTreeUI(jProgresBar); 
         }
     }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JFileChooser archivos_file;
    public javax.swing.JProgressBar jProgresBar;
    // End of variables declaration//GEN-END:variables
}