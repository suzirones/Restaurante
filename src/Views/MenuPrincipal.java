package Views;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem7 = new javax.swing.JMenuItem();
        DesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuCliente = new javax.swing.JMenuItem();
        jMenuProdutos = new javax.swing.JMenuItem();
        jMenuPedidos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuConsClientes = new javax.swing.JMenuItem();
        jMenuConsProdutos = new javax.swing.JMenuItem();
        jMenuConsPedidos = new javax.swing.JMenuItem();

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restaurante");

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastro");

        jMenuCliente.setText("Cliente");
        jMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClienteActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCliente);

        jMenuProdutos.setText("Produtos");
        jMenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuProdutos);

        jMenuPedidos.setText("Pedidos");
        jMenuPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPedidosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuPedidos);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Consultas");

        jMenuConsClientes.setText("Clientes");
        jMenuConsClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsClientesActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuConsClientes);

        jMenuConsProdutos.setText("Produtos");
        jMenuConsProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsProdutosActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuConsProdutos);

        jMenuConsPedidos.setText("Pedidos");
        jMenuConsPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsPedidosActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuConsPedidos);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuConsClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsClientesActionPerformed
        InternalConsultaClientes consultaclientes = new InternalConsultaClientes();
        DesktopPane.add(consultaclientes);
        consultaclientes.setVisible(true);
    }//GEN-LAST:event_jMenuConsClientesActionPerformed

    private void jMenuConsProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsProdutosActionPerformed
        InternalConsultaProdutos consultaProdutos = new InternalConsultaProdutos();
        DesktopPane.add(consultaProdutos);
        consultaProdutos.setVisible(true);
    }//GEN-LAST:event_jMenuConsProdutosActionPerformed

    private void jMenuConsPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsPedidosActionPerformed
        JOptionPane.showMessageDialog(null, "Consulta Pedidos!");
    }//GEN-LAST:event_jMenuConsPedidosActionPerformed

    private void jMenuPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPedidosActionPerformed
        JOptionPane.showMessageDialog(null, "Cadastro Pedidos!");
    }//GEN-LAST:event_jMenuPedidosActionPerformed

    private void jMenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutosActionPerformed
        InternalCadastroProduto cadastroProdutos = new InternalCadastroProduto();
        DesktopPane.add(cadastroProdutos);
        cadastroProdutos.setVisible(true);
    }//GEN-LAST:event_jMenuProdutosActionPerformed

    private void jMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClienteActionPerformed
        // TODO add your handling code here:
        InternalCadastroCliente cadastrocliente = new InternalCadastroCliente();
        DesktopPane.add(cadastrocliente);
        cadastrocliente.setVisible(true);

    }//GEN-LAST:event_jMenuClienteActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCliente;
    private javax.swing.JMenuItem jMenuConsClientes;
    private javax.swing.JMenuItem jMenuConsPedidos;
    private javax.swing.JMenuItem jMenuConsProdutos;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuPedidos;
    private javax.swing.JMenuItem jMenuProdutos;
    // End of variables declaration//GEN-END:variables
}
