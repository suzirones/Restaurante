package Views;

import Entidade.Cliente;
import Entidade.Pedido;
import Entidade.Produto;
import Negocio.ClienteNegocio;
import Negocio.IClienteNegocio;
import Negocio.IPedidoNegocio;
import Negocio.IProdutoNegocio;
import Negocio.PedidoNegocio;
import Negocio.ProdutoNegocio;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

public class InternalCadastroPedidos extends javax.swing.JInternalFrame {

    private ProdutoComboboxModel produtoCombobox;
    private ClienteComboboxModel clienteCombobox;
    private PedidoTableModel vendaItemTModel;
    
    public InternalCadastroPedidos() {
        initComponents();
        
        // Produto Combo Box
        produtoCombobox = new ProdutoComboboxModel();
        
        ProdutoNegocio produtonegocio = new ProdutoNegocio();
        ArrayList<Produto> listaProduto = produtonegocio.listaProdutoTodos();

        for (int i = 0; i < listaProduto.size(); i++) {
            produtoCombobox.addProdutos(listaProduto.get(i));
        }
        
        this.cboProdutos.setModel(produtoCombobox);

        // Cliente Combo Box
        clienteCombobox = new ClienteComboboxModel();
        
        ClienteNegocio clientenegocio = new ClienteNegocio();
        ArrayList<Cliente> listaCliente = clientenegocio.listaClienteTodos();

        for (int i = 0; i < listaCliente.size(); i++) {
            clienteCombobox.addClientes(listaCliente.get(i));
        }
        
        this.cboCliente.setModel(clienteCombobox);

        // Table Model
        vendaItemTModel = new PedidoTableModel();
        jTable1.setModel(vendaItemTModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        FieldCodigoPedido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        cboProdutos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        FieldQuantidade = new javax.swing.JTextField();
        btAdicionar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta Pedidos por Cliente");

        FieldCodigoPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FieldCodigoPedidoFocusLost(evt);
            }
        });

        jLabel2.setText("Código Pedido");

        jLabel3.setText("Produto");

        cboProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Quantidade");

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Valor Unitário"
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

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel5.setText("Cliente");

        cboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExcluir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FieldCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(FieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionar)
                    .addComponent(btRemover))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int codigoPedido = 0;
        
        try {
            codigoPedido = Integer.parseInt(this.FieldCodigoPedido.getText());
        } catch (Exception e) {
             codigoPedido = 0;
             this.FieldCodigoPedido.setText("");
        }
        
        IPedidoNegocio pedidoNegocio = new PedidoNegocio();
        
        if (codigoPedido > 0) {
            if (pedidoNegocio.excluirPedido(codigoPedido)){
                limpeCampos(true);
                showMessageDialog(null, "Pedido Excluído com Sucesso!");
                } else {
                    showMessageDialog(null, "Pedido Não Excluído!");
                }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limpeCampos(true);
        
        IPedidoNegocio pedidoNegocio = new PedidoNegocio();
        
        int proximoCodigo = pedidoNegocio.ObterProximoCodigoPedido();
        FieldCodigoPedido.setText(String.valueOf(proximoCodigo));
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        
        int codigoPedido = 0;
        int quantidadePedido = 0;
        
        try {
            codigoPedido = Integer.parseInt(this.FieldCodigoPedido.getText());
        } catch (Exception e) {
             codigoPedido = 0;
             this.FieldCodigoPedido.setText("");
        }
        
        try {
            quantidadePedido = Integer.parseInt(this.FieldQuantidade.getText());
        } catch (Exception e) {
             quantidadePedido = 0;
             this.FieldCodigoPedido.setText("");
        }
        
        Pedido pedido = new Pedido();
        Produto produtoSel = (Produto)this.produtoCombobox.getSelectedItem();
        
        Cliente cliente = new Cliente();
        Cliente clienteSel = (Cliente)this.clienteCombobox.getSelectedItem();
        
        if (produtoSel.getCodigo() == 0) {
            showMessageDialog(null, "Produto Não Selecionado!");
            return;
        }
        
        if (clienteSel.getCpf() == null && clienteSel.getCpf() == "") {
            showMessageDialog(null, "Cliente Não Selecionado!");
            return;
        }
        
        pedido.setCodigoPedido(codigoPedido);
        pedido.setProduto(new Produto (produtoSel.getCodigo(), produtoSel.getNome()));
        pedido.setCliente(new Cliente (clienteSel.getCpf()));
        pedido.setQuantidade (quantidadePedido);
        pedido.setValortotal(produtoSel.getPreco());
        
        vendaItemTModel.addPedido(pedido);
        
        produtoCombobox.clearSelectedItem();
        this.FieldQuantidade.setText("");
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        int codigoPedido = 0;
        
        try {
            codigoPedido = Integer.parseInt(this.FieldCodigoPedido.getText());
        } catch (Exception e) {
             codigoPedido = 0;
             this.FieldCodigoPedido.setText("");
        }
        
        IPedidoNegocio pedidoNegocio = new PedidoNegocio();
        
        if (codigoPedido > 0) {
            pedidoNegocio.excluirPedido(codigoPedido);
            
            if (!pedidoNegocio.inserirPedido(vendaItemTModel.getArray())) {
                    showMessageDialog(null, "Pedido Não Inserido!");
            } else {
                showMessageDialog(null, "Pedido Inserido!");
                limpeCampos(true);
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void FieldCodigoPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FieldCodigoPedidoFocusLost
        int codigoPedido = 0;
        
        try {
            codigoPedido = Integer.parseInt(this.FieldCodigoPedido.getText());
        } catch (Exception e) {
             codigoPedido = 0;
             limpeCampos(true);
             return;
        }
        
        limpeCampos(false);
        
        IPedidoNegocio pedidoNegocio = new PedidoNegocio();
        List<Pedido> listagemPedidos = new ArrayList<>();
        
        if (codigoPedido > 0) {
            listagemPedidos = pedidoNegocio.listaPedidoPorPedido(codigoPedido);

        clienteCombobox.setSelectedItemPorCodigo(listagemPedidos.get(0).getCliente().getCpf());
            
        for (Pedido itemPedido: listagemPedidos) {
            vendaItemTModel.addPedido(itemPedido);
            }            
        }        
    }//GEN-LAST:event_FieldCodigoPedidoFocusLost

    private void limpeCampos(boolean limpeCodigo) {
        
        if (limpeCodigo) {
            FieldCodigoPedido.setText("");
        }
        FieldQuantidade.setText("");
        produtoCombobox.clearSelectedItem();
        clienteCombobox.clearSelectedItem();
        vendaItemTModel.reset();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FieldCodigoPedido;
    private javax.swing.JTextField FieldQuantidade;
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JComboBox<String> cboProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
