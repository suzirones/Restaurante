package Views;

import Entidade.Cliente;
import javax.swing.JOptionPane;

import Entidade.Produto;
import Negocio.ClienteNegocio;
import Negocio.IClienteNegocio;
import Negocio.ProdutoNegocio;
import Negocio.IProdutoNegocio;
import java.text.DecimalFormat;
import java.util.HashSet;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import jdk.nashorn.internal.objects.NativeString;

public class InternalCadastroProduto extends javax.swing.JInternalFrame {

    public InternalCadastroProduto() {
        initComponents();
        FieldCodigo.setText("");
        FieldNome.setText("");
        FieldValor.setText("");
        PrepareTela();
    }

        private void PrepareTela()  {
        
        try {
            MaskFormatter formatacaoCodigo = new MaskFormatter("####");
            formatacaoCodigo.setValueContainsLiteralCharacters(false);
            // FieldCodigo.setFormatterFactory(new DefaultFormatterFactory(formatacaoCodigo));

            MaskFormatter formatacaoValor = new MaskFormatter("#.##");
            formatacaoValor.setPlaceholderCharacter(' ');
            formatacaoValor.setValueContainsLiteralCharacters(false);
            // FieldValor.setFormatterFactory(new DefaultFormatterFactory(formatacaoValor));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FieldNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        FieldValor = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        FieldCodigo = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro Produto");

        jLabel2.setText("Nome");

        jLabel4.setText("Valor");

        FieldNome.setText("Digite Nome");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        FieldValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel3.setText("Código");

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        FieldCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FieldCodigoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FieldNome)
                    .addComponent(FieldValor, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(FieldCodigo))
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(FieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btExcluir))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        try {
            Produto produto = new Produto();
            
            AjusteCodigo();
            //preenchendo variaveis
            produto.setCodigo(Integer.parseInt(FieldCodigo.getText()));
            produto.setNome(FieldNome.getText());
            produto.setPreco(Double.parseDouble(FieldValor.getText().replace(",", ".")));
            
            //Salvar
            IProdutoNegocio produtoNegocio = new ProdutoNegocio();
            
            if (produtoNegocio.atualizarProduto(produto)) {
                LimparCampos();
                JOptionPane.showMessageDialog(null, "Produto Atualizado com Sucesso!");
            } else {
                if (produtoNegocio.inserirProduto(produto)) {
                    LimparCampos();
                    JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Produto Não Cadastrado!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void LimparCampos() {
        FieldNome.setText("");
        FieldValor.setText("");
        FieldCodigo.setText("");
    }
    
    private void AjusteCodigo() {
        try {
            
            if (FieldCodigo.getText().length()>4) {
                FieldCodigo.setText(NativeString.substr(FieldCodigo.getText(), 0, 4));
            }
            
            String codigoFormatado = String.format("%04d", Integer.parseInt(FieldCodigo.getText()));
            FieldCodigo.setText(codigoFormatado);
        } catch (Exception e) {
            FieldCodigo.setText("");
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void FieldCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FieldCodigoFocusLost
        
        AjusteCodigo();
        IProdutoNegocio produtoNegocio = new ProdutoNegocio();
        Produto produto = produtoNegocio.listaProdutoPorCodigo(Integer.parseInt(FieldCodigo.getText()));

        try {
            if (produto.getCodigo() > 0) {
                    FieldNome.setText(produto.getNome());
                    FieldValor.setText(String.valueOf(produto.getPreco()));
            } else {
                    FieldNome.setText("");
                    FieldValor.setText("");
            }    
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_FieldCodigoFocusLost

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        IProdutoNegocio produtoNegocio = new ProdutoNegocio();
        
        if (produtoNegocio.excluirProduto(Integer.parseInt(FieldCodigo.getText()))){
            FieldCodigo.setText("");
            FieldNome.setText("");
            FieldValor.setText("");
            JOptionPane.showMessageDialog(null, "Produto Excluído com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Produto Não Excluído!");
        }
    }//GEN-LAST:event_btExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FieldCodigo;
    private javax.swing.JTextField FieldNome;
    private javax.swing.JFormattedTextField FieldValor;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
