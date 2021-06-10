package Views;

import javax.swing.JOptionPane;

import Entidade.Cliente;
import Negocio.ClienteNegocio;
import Negocio.IClienteNegocio;
import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class InternalCadastroCliente extends javax.swing.JInternalFrame {

    private Object ComboBoxTipoCliente;
    
    public InternalCadastroCliente() {
        initComponents();
        PrepareTela();
        
        FieldNome.setText("");
        FieldEndereco.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FieldNome = new javax.swing.JTextField();
        FieldEndereco = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        FieldCpf = new javax.swing.JFormattedTextField();
        FieldTelefone = new javax.swing.JFormattedTextField();
        btExcluir = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro Cliente");

        jLabel2.setText("CPF");

        jLabel3.setText("Telefone");

        jLabel4.setText("Nome");

        jLabel5.setText("Endereço");

        FieldNome.setText("Digite Nome");

        FieldEndereco.setText("Digite o endereço");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        FieldCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FieldCpfFocusLost(evt);
            }
        });

        FieldTelefone.setText("jFormattedTextField1");

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FieldEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                            .addComponent(FieldNome)
                            .addComponent(FieldCpf)
                            .addComponent(FieldTelefone)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExcluir)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(FieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(FieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(FieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btExcluir))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrepareTela()  {
        
        try {
            MaskFormatter formatacaoCPF = new MaskFormatter("###.###.###-##");
            formatacaoCPF.setPlaceholderCharacter(' ');  
            formatacaoCPF.setValueContainsLiteralCharacters(false);
            FieldCpf.setFormatterFactory(new DefaultFormatterFactory(formatacaoCPF));

            MaskFormatter formatacaoTelefone = new MaskFormatter("(##) #####-####");
            formatacaoTelefone.setPlaceholderCharacter(' ');
            formatacaoTelefone.setValueContainsLiteralCharacters(false);
            FieldTelefone.setFormatterFactory(new DefaultFormatterFactory(formatacaoTelefone));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        try {
            Cliente cliente = new Cliente();

            //preenchendo variaveis
            cliente.setNome(FieldNome.getText());
            cliente.setFone(retirarCaracteres(FieldTelefone.getText()));
            cliente.setEndereco(FieldEndereco.getText());
            cliente.setCpf(retirarCaracteres(FieldCpf.getText()));

            //Salvar
            IClienteNegocio clienteNegocio = new ClienteNegocio();

            if (clienteNegocio.atualizarCliente(cliente)) {
                LimparCampos();
                JOptionPane.showMessageDialog(null, "Cliente Atualizado com Sucesso!");
            } else {
                if (clienteNegocio.inserirCliente(cliente)) {
                    LimparCampos();
                    JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente Não Cadastrado!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void LimparCampos() {
        FieldNome.setText("");
        FieldTelefone.setText("");
        FieldEndereco.setText("");
        FieldCpf.setText("");
    }
    
    private void FieldCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FieldCpfFocusLost
        IClienteNegocio clienteNegocio = new ClienteNegocio();
        Cliente cliente = clienteNegocio.listaClientePorCPF(retirarCaracteres(FieldCpf.getText()));

        try {
        
            if (cliente.getCpf() != null) {
                FieldEndereco.setText(cliente.getEndereco());
                FieldTelefone.setText(cliente.getFone());
                FieldNome.setText(cliente.getNome());
            } else {
                FieldNome.setText("");
                FieldEndereco.setText("");
                FieldTelefone.setText("");
            }    
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_FieldCpfFocusLost

    private String retirarCaracteres(String parametro) {
        return parametro.replace("(", "").replace(")", "").replace("-", "").replace(".", "").replace(" ", "");
    }
    
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            IClienteNegocio clienteNegocio = new ClienteNegocio();

            if (clienteNegocio.excluirCliente(retirarCaracteres(FieldCpf.getText()))) {
                FieldNome.setText("");
                FieldEndereco.setText("");
                FieldCpf.setText("");
                FieldTelefone.setText("");
                JOptionPane.showMessageDialog(null, "Cliente Excluído com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente Não Excluído!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField FieldCpf;
    private javax.swing.JTextField FieldEndereco;
    private javax.swing.JTextField FieldNome;
    private javax.swing.JFormattedTextField FieldTelefone;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
