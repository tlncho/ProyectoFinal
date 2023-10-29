
package Vistas;

import javax.swing.JOptionPane;

/**
 *
 * @author Julian Rios
 */
public class Escritorio extends javax.swing.JFrame {

    public Escritorio() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuSiniestros = new javax.swing.JMenu();
        menuBusqueda = new javax.swing.JMenu();
        menuEstadisticas = new javax.swing.JMenu();
        menuMapas = new javax.swing.JMenu();
        menuAdministarcion = new javax.swing.JMenu();
        itemBomberos = new javax.swing.JMenuItem();
        itemCuarteles = new javax.swing.JMenuItem();
        itemBrigadas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Proyecto Final - TUDS - Grupo 7 - COM 2");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, -1, 30));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bombero.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 580));

        menuSiniestros.setText("Siniestros");
        menuSiniestros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(menuSiniestros);

        menuBusqueda.setText("Busqueda/Listado");
        menuBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(menuBusqueda);

        menuEstadisticas.setText("Informes/Estadisticas");
        menuEstadisticas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(menuEstadisticas);

        menuMapas.setText("Mapas");
        menuMapas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(menuMapas);

        menuAdministarcion.setText("Administración");
        menuAdministarcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        itemBomberos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemBomberos.setText("Bomberos");
        menuAdministarcion.add(itemBomberos);

        itemCuarteles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemCuarteles.setText("Cuarteles");
        menuAdministarcion.add(itemCuarteles);

        itemBrigadas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemBrigadas.setText("Brigadas");
        menuAdministarcion.add(itemBrigadas);

        jMenuBar1.add(menuAdministarcion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Esta seguro de cerrar la aplicación?", "ATENCION !!!", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Escritorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemBomberos;
    private javax.swing.JMenuItem itemBrigadas;
    private javax.swing.JMenuItem itemCuarteles;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAdministarcion;
    private javax.swing.JMenu menuBusqueda;
    private javax.swing.JMenu menuEstadisticas;
    private javax.swing.JMenu menuMapas;
    private javax.swing.JMenu menuSiniestros;
    // End of variables declaration//GEN-END:variables
}
