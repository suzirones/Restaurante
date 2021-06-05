package Views;

import Entidade.Cliente;
import Entidade.Garcom;
import javax.swing.JOptionPane;

import Entidade.Venda;
import Negocio.ClienteNegocio;
import Negocio.GarcomNegocio;
import Negocio.VendaNegocio;
import Negocio.IVendaNegocio;
import java.util.ArrayList;
import java.util.HashSet;

public class InternalCadastroVenda extends javax.swing.JInternalFrame {

    private Object ComboBoxTipoVenda;
    private ClienteComboboxModel clienteCombobox;
    private GarcomComboboxModel garcomCombobox;
    
    public InternalCadastroVenda() {
        initComponents();
        
        clienteCombobox = new ClienteComboboxModel();
        garcomCombobox = new GarcomComboboxModel();  
        
        ClienteNegocio clientenegocio = new ClienteNegocio();
        ArrayList<Cliente> listaCliente = clientenegocio.listaClienteTodos();

        GarcomNegocio garcomnegocio = new GarcomNegocio();
        ArrayList<Garcom> listaGarcom = garcomnegocio.listaGarcomTodos();
        
        for (int i = 0; i < listaCliente.size(); i++) {
            clienteCombobox.addClientes(listaCliente.get(i));
        }
        
        for (int i = 0; i < listaGarcom.size(); i++) {
            garcomCombobox.addGarcons(listaGarcom.get(i));
        }

        this.cboCliente.setModel(clienteCombobox);
        this.cboGarcom.setModel(garcomCombobox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox<>();
        btSalvar = new javax.swing.JButton();
        cboGarcom = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro Venda");

        jLabel5.setText("Cliente");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel6.setText("Garçom");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(btSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cboCliente, 0, 160, Short.MAX_VALUE)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cboGarcom, 0, 159, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboGarcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(btSalvar)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        try {
            
             Cliente clienteSel = (Cliente) this.clienteCombobox.getSelectedItem();
             // JOptionPane.showMessageDialog(null, clienteSel.getNome());
             
             Garcom garcomSel = (Garcom)this.garcomCombobox.getSelectedItem();
             // JOptionPane.showMessageDialog(null, garcomSel.getNome());
             
            Venda venda = new Venda();
            //preenchendo variaveis
            venda.setDadosCliente(new Cliente(clienteSel.getIdCliente()));
            venda.setDadosGarcom(new Garcom(garcomSel.getIdGarcom()));
            venda.setValorTotal(0);
            
            //Salvar
            IVendaNegocio vendaNegocio = new VendaNegocio();
            boolean isSucesso = vendaNegocio.inserirVenda(venda) == 1 ? true : false;

            if (isSucesso) {
            JOptionPane.showMessageDialog(null, "Venda Cadastrado com Sucesso!");
            } else {
            JOptionPane.showMessageDialog(null, "Venda Não Cadastrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JComboBox<String> cboGarcom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
