
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
        jMenuItem5 = new javax.swing.JMenuItem();
        menuBusqueda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuEstadisticas = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
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

        jMenuItem5.setText("Gestión Siniestro");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuSiniestros.add(jMenuItem5);

        jMenuBar1.add(menuSiniestros);

        menuBusqueda.setText("Busqueda/Listado");
        menuBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem1.setText("Bomberos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuBusqueda.add(jMenuItem1);

        jMenuItem2.setText("Brigadas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuBusqueda.add(jMenuItem2);

        jMenuItem3.setText("Cuarteles");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuBusqueda.add(jMenuItem3);

        jMenuBar1.add(menuBusqueda);

        menuEstadisticas.setText("Informes/Estadisticas");
        menuEstadisticas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem4.setText("Resolucion Siniestros");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuEstadisticas.add(jMenuItem4);

        jMenuBar1.add(menuEstadisticas);

        menuAdministarcion.setText("Administración");
        menuAdministarcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        itemBomberos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemBomberos.setText("Bomberos");
        itemBomberos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBomberosActionPerformed(evt);
            }
        });
        menuAdministarcion.add(itemBomberos);

        itemCuarteles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemCuarteles.setText("Cuarteles");
        itemCuarteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCuartelesActionPerformed(evt);
            }
        });
        menuAdministarcion.add(itemCuarteles);

        itemBrigadas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemBrigadas.setText("Brigadas");
        itemBrigadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBrigadasActionPerformed(evt);
            }
        });
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

    private void itemBomberosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBomberosActionPerformed
        GestionBombero gb = new GestionBombero();
        gb.setVisible(true);
    }//GEN-LAST:event_itemBomberosActionPerformed

    private void itemBrigadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBrigadasActionPerformed
        GestionBrigada gbr = new GestionBrigada();
        gbr.setVisible(true);
    }//GEN-LAST:event_itemBrigadasActionPerformed

    private void itemCuartelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCuartelesActionPerformed
       GestionCuartel gc = new GestionCuartel();
       gc.setVisible(true);
    }//GEN-LAST:event_itemCuartelesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ListarBomberos listar = new ListarBomberos();
        listar.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ListarBrigadas lt = new ListarBrigadas();
        lt.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ListarCuarteles lc = new ListarCuarteles();
        lc.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       ResolucionSiniestros rs = new ResolucionSiniestros();
       rs.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        GestionSiniestros gs = new GestionSiniestros();
        gs.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

   
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu menuAdministarcion;
    private javax.swing.JMenu menuBusqueda;
    private javax.swing.JMenu menuEstadisticas;
    private javax.swing.JMenu menuSiniestros;
    // End of variables declaration//GEN-END:variables
}
