package Views;

import Entidade.Cliente;
import Entidade.Garcom;
import Entidade.Produto;
import javax.swing.JOptionPane;

import Entidade.Venda;
import Entidade.VendaItem;
import Negocio.ClienteNegocio;
import Negocio.GarcomNegocio;
import Negocio.VendaNegocio;
import Negocio.IVendaNegocio;
import Negocio.ProdutoNegocio;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class InternalCadastroVenda extends javax.swing.JInternalFrame {

    private Object ComboBoxTipoVenda;
    private ClienteComboboxModel clienteCombobox;
    private GarcomComboboxModel garcomCombobox;
    private ProdutoComboboxModel produtoCombobox;
    private VendaItemTableModel vendaItemTModel;
    
    public InternalCadastroVenda() {
        initComponents();
        
        clienteCombobox = new ClienteComboboxModel();
        garcomCombobox = new GarcomComboboxModel();  
        produtoCombobox = new ProdutoComboboxModel();
        vendaItemTModel = new VendaItemTableModel();
        
        jItemVenda.setModel(vendaItemTModel);
        
        ClienteNegocio clientenegocio = new ClienteNegocio();
        ArrayList<Cliente> listaCliente = clientenegocio.listaClienteTodos();

        GarcomNegocio garcomnegocio = new GarcomNegocio();
        ArrayList<Garcom> listaGarcom = garcomnegocio.listaGarcomTodos();
        
        ProdutoNegocio produtonegocio = new ProdutoNegocio();
        ArrayList<Produto> listaProduto = produtonegocio.listaProdutoTodos();
        
        for (int i = 0; i < listaCliente.size(); i++) {
            clienteCombobox.addClientes(listaCliente.get(i));
        }
        
        for (int i = 0; i < listaGarcom.size(); i++) {
            garcomCombobox.addGarcons(listaGarcom.get(i));
        }

        for (int i = 0; i < listaProduto.size(); i++) {
            produtoCombobox.addProdutos(listaProduto.get(i));
        }
        this.cboCliente.setModel(clienteCombobox);
        this.cboGarcom.setModel(garcomCombobox);
        this.cboProduto.setModel(produtoCombobox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboGarcom = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        cboProduto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTxtQuantidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jBtnAdicionar = new javax.swing.JButton();
        jBtnRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jItemVenda = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro Venda");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel5.setText("Cliente");

        cboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClienteActionPerformed(evt);
            }
        });

        jLabel6.setText("Garçom");

        jLabel7.setText("Produto");

        jLabel8.setText("Qntd");

        jLabel9.setText("Qntde");

        jBtnAdicionar.setText("Adicionar");
        jBtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarActionPerformed(evt);
            }
        });

        jBtnRemover.setText("Remover");
        jBtnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverActionPerformed(evt);
            }
        });

        jItemVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Produto", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jItemVenda);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cboGarcom, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addGap(86, 86, 86)
                                .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jBtnAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnRemover)
                                .addGap(108, 108, 108))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1))
                                .addContainerGap())))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboGarcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdicionar)
                    .addComponent(jBtnRemover))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(271, Short.MAX_VALUE)))
        );

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
                        .addGap(267, 267, 267)
                        .addComponent(btSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jBtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarActionPerformed
        Produto produtoSel = (Produto)this.produtoCombobox.getSelectedItem();
        
        VendaItem venda = new VendaItem();
        venda.setIdProduto(produtoSel.getIdProduto());
        venda.setDescricaoProduto(produtoSel.getNome());
        venda.setQuantidade(Integer.parseInt(this.jTxtQuantidade.getText()));
        
        vendaItemTModel.addVendaItem(venda);
    }//GEN-LAST:event_jBtnAdicionarActionPerformed

    private void cboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClienteActionPerformed

    private void jBtnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverActionPerformed
        if (this.jItemVenda.getSelectedRow() != 1) {
            vendaItemTModel.removeVendaItem(this.jItemVenda.getSelectedRow());
        }
    }//GEN-LAST:event_jBtnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JComboBox<String> cboGarcom;
    private javax.swing.JComboBox<String> cboProduto;
    private javax.swing.JButton jBtnAdicionar;
    private javax.swing.JButton jBtnRemover;
    private javax.swing.JTable jItemVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtQuantidade;
    // End of variables declaration//GEN-END:variables
}
