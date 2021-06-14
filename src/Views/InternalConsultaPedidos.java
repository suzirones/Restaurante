package Views;

import Entidade.Cliente;
import Entidade.Pedido;
import Negocio.ClienteNegocio;
import Negocio.PedidoNegocio;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

public class InternalConsultaPedidos extends javax.swing.JInternalFrame {

    private ClienteComboboxModel clienteCombobox;

    public InternalConsultaPedidos() {
        initComponents();
        
        clienteCombobox = new ClienteComboboxModel();
        
        ClienteNegocio clientenegocio = new ClienteNegocio();
        ArrayList<Cliente> listaCliente = clientenegocio.listaClienteTodos();

        for (int i = 0; i < listaCliente.size(); i++) {
            clienteCombobox.addClientes(listaCliente.get(i));
        }
        
        this.cboClientes.setModel(clienteCombobox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboClientes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Consulta Pedidos por Cliente");

        jLabel2.setText("Cliente");

        cboClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboClientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboClientesItemStateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Pedido", "Cliente", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboClientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboClientesItemStateChanged
        // TODO add your handling code here:
        // showMessageDialog(null, ((Cliente)this.cboClientes.getSelectedItem()).getCpf());
        carregueListagemPedidos(((Cliente)this.cboClientes.getSelectedItem()).getCpf());
    }//GEN-LAST:event_cboClientesItemStateChanged


    private void carregueListagemPedidos(String codigoPessoa) {
        
        try {
            PedidoNegocio vendanegocio = new PedidoNegocio();
            ArrayList<Pedido> listaPedido = vendanegocio.listaPedidoPorCliente(codigoPessoa);
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);
            
             for (Pedido pedido : listaPedido) {
                 model.addRow(new Object[] 
                {
                   pedido.getCodigoPedido(),
                   pedido.getCliente().getNome(),
                   String.format("%.2f", pedido.getValortotal()),
                }); 
             }
              
         } catch (Exception e) {
             showMessageDialog(null, e.getMessage());
         }

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
