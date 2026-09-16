package GUI;

import Modelo.Cliente;
import DAO.ClienteDAO;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class TelaCliente extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCliente.class.getName());
             private final DefaultTableModel modelo;
             private int proximoID = 1;
     private javax.swing.JFrame telaAnterior;
    
     public TelaCliente() { 
        initComponents(); 
        
        modelo = (DefaultTableModel) tabelaCliente.getModel();
        
        txtID.setEditable(false);

       
        listarValoresTabela();
  
       
        tabelaCliente.getSelectionModel().addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()){
                carregarDadosTabela(); 
            }
        });
    }
    
    private void listarValoresTabela() {
    try {
        ClienteDAO dao = new ClienteDAO();
        java.util.ArrayList<Modelo.Cliente> lista = dao.listarTodos();
        
        
        javax.swing.table.DefaultTableModel modelo = 
            (javax.swing.table.DefaultTableModel) tabelaCliente.getModel();
        
        modelo.setNumRows(0); 

        for (Cliente c : dao.listarTodos()) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getCpf(),
                c.getNascimento(),
                c.getRg(),
                c.getTelefone(),
                c.getRua(),
                c.getNumero(),
                c.getBairro(),
                c.getCidade(),
                c.getEstado(),
                c.getCep(),
                c.getComplemento(),
                c.getPontoreferencia(),
                 
                
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
    }
}
    
    private void carregarDadosTabela() {
        int linha = tabelaCliente.getSelectedRow();
        
        if (linha != -1) {
            // Pega os dados da linha clicada e joga nos campos (a ordem segue as colunas da sua tabela)
            txtID.setText(tabelaCliente.getValueAt(linha, 0) != null ? tabelaCliente.getValueAt(linha, 0).toString() : "");
            txtNome.setText(tabelaCliente.getValueAt(linha, 1) != null ? tabelaCliente.getValueAt(linha, 1).toString() : "");
            txtNascimento.setText(tabelaCliente.getValueAt(linha, 2) != null ? tabelaCliente.getValueAt(linha, 2).toString() : "");
            txtCpf.setText(tabelaCliente.getValueAt(linha, 3) != null ? tabelaCliente.getValueAt(linha, 3).toString() : "");
            txtRG.setText(tabelaCliente.getValueAt(linha, 4) != null ? tabelaCliente.getValueAt(linha, 4).toString() : "");
            txtTelefone.setText(tabelaCliente.getValueAt(linha, 5) != null ? tabelaCliente.getValueAt(linha, 5).toString() : "");
            txtCidade.setText(tabelaCliente.getValueAt(linha, 6) != null ? tabelaCliente.getValueAt(linha, 6).toString() : "");
            txtBairro.setText(tabelaCliente.getValueAt(linha, 7) != null ? tabelaCliente.getValueAt(linha, 7).toString() : "");
            txtRua.setText(tabelaCliente.getValueAt(linha, 8) != null ? tabelaCliente.getValueAt(linha, 8).toString() : "");
            txtCep.setText(tabelaCliente.getValueAt(linha, 9) != null ? tabelaCliente.getValueAt(linha, 9).toString() : "");
            txtNumero.setText(tabelaCliente.getValueAt(linha, 10) != null ? tabelaCliente.getValueAt(linha, 10).toString() : "");
            txtComplemento.setText(tabelaCliente.getValueAt(linha, 11) != null ? tabelaCliente.getValueAt(linha, 11).toString() : "");
            txtPontoReferencia.setText(tabelaCliente.getValueAt(linha, 12) != null ? tabelaCliente.getValueAt(linha, 12).toString() : "");
        }
    }
    
public TelaCliente(javax.swing.JFrame telaAnterior) {
        this(); 
        this.telaAnterior = telaAnterior; 
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        labelDadosdoCliente = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        labelNomeCompleto = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        labelEndereco = new javax.swing.JLabel();
        labelRua = new javax.swing.JLabel();
        labelBairro = new javax.swing.JLabel();
        labelTelefone = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        labelListaCliente = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtRG = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtRua = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        txtPontoReferencia = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes (Cadastro/Consulta)");

        btnNovo.setBackground(new java.awt.Color(102, 0, 153));
        btnNovo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("Novo");
        btnNovo.addActionListener(this::btnNovoActionPerformed);

        btnSalvar.setBackground(new java.awt.Color(102, 0, 153));
        btnSalvar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnAlterar.setBackground(new java.awt.Color(102, 0, 153));
        btnAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(this::btnAlterarActionPerformed);

        btnExcluir.setBackground(new java.awt.Color(102, 0, 153));
        btnExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        btnLimpar.setBackground(new java.awt.Color(102, 0, 153));
        btnLimpar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(this::btnLimparActionPerformed);

        btnVoltar.setBackground(new java.awt.Color(102, 0, 153));
        btnVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        labelDadosdoCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelDadosdoCliente.setForeground(new java.awt.Color(102, 0, 153));
        labelDadosdoCliente.setText("Dados do Cliente");

        labelID.setText("ID:");

        labelNomeCompleto.setText("Nome Completo:");

        labelCPF.setText("CPF:");

        labelEndereco.setText("Estado:");

        labelRua.setText("Rua:");

        labelBairro.setText("Bairro:");

        labelTelefone.setText("Telefone:");

        labelNumero.setText("Numero:");

        labelListaCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelListaCliente.setForeground(new java.awt.Color(102, 0, 153));
        labelListaCliente.setText("Lista de Clientes");

        txtID.setEditable(false);
        txtID.addActionListener(this::txtIDActionPerformed);

        tabelaCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Data de Nascimento", "CPF", "RG", "Telefone", "Cidade", "Bairro", "Rua", "Cep", "Número", "Complemento", "Ponto de Referência"
            }
        ));
        jScrollPane1.setViewportView(tabelaCliente);

        jLabel1.setText("RG");

        jLabel2.setText("Data de Nascimento:");

        jLabel3.setText("Cidade:");

        jLabel4.setText("Complemento:");

        jLabel5.setText("Cep:");

        jLabel6.setText("Ponto de Referência:");

        txtEstado.addActionListener(this::txtEstadoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelRua, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(labelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtCidade, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(labelDadosdoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnNovo)
                                .addGap(28, 28, 28)
                                .addComponent(btnSalvar)
                                .addGap(31, 31, 31)
                                .addComponent(btnAlterar)
                                .addGap(33, 33, 33)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpar)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnVoltar)
                                .addGap(14, 14, 14))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelListaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(txtPontoReferencia))))
                        .addGap(0, 318, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar)
                    .addComponent(btnVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDadosdoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeCompleto)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPF)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEndereco)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelBairro)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelRua)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelNumero)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPontoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addComponent(labelListaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
                limparCampos();  //Configuração do botão Novo.
                tabelaCliente.clearSelection();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
               limparCampos();                 
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
              // Não precisa colocar nada aqui                              
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // SALVAR = sempre novo registro
 int linha = tabelaCliente.getSelectedRow();

        if (linha != -1) {
            JOptionPane.showMessageDialog(this,
                    "Use ALTERAR para editar ou NOVO para cadastrar.");
            return;
        }

        if (txtNome.getText().trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nome inválido!");
            return;
        }

        if (!txtCpf.getText().matches("\\d{11}")) {
            JOptionPane.showMessageDialog(this, "CPF inválido!");
            return;
        }

        if (!txtTelefone.getText().isEmpty()
                && !txtTelefone.getText().matches("\\d{10,11}")) {
            JOptionPane.showMessageDialog(this, "Telefone inválido!");
            return;
        }

        // CPF duplicado
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String cpf = modelo.getValueAt(i, 3).toString();
            if (cpf.equals(txtCpf.getText().trim())) {
                JOptionPane.showMessageDialog(this, "CPF já cadastrado!");
                return;
            }
        }

        Cliente cliente = new Cliente();
    cliente.setNome(txtNome.getText());
    cliente.setNascimento(txtNascimento.getText());
    cliente.setCpf(txtCpf.getText());
    cliente.setRg(txtRG.getText());
    cliente.setTelefone(txtTelefone.getText());
    cliente.setRua(txtRua.getText());
    cliente.setNumero(txtNumero.getText());
    cliente.setBairro(txtBairro.getText());
    cliente.setCidade(txtCidade.getText());
    cliente.setEstado(txtEstado.getText());
    cliente.setCep(txtCep.getText());
    cliente.setComplemento(txtComplemento.getText());
    cliente.setPontoreferencia(txtPontoReferencia.getText());

    ClienteDAO dao = new ClienteDAO();
    dao.inserir(cliente);
    
    JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
    limparCampos();
    listarValoresTabela();

        proximoID++;

        JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");

        limparCampos();
        tabelaCliente.clearSelection();
    }//GEN-LAST:event_btnSalvarActionPerformed
   
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
   if (txtID.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela primeiro!");
        return;
    }

    Cliente cliente = new Cliente();
    
    // Passando o ID que identifica o registro
    cliente.setId(Long.parseLong(txtID.getText()));
    cliente.setNome(txtNome.getText());
    cliente.setNascimento(txtNascimento.getText());
    cliente.setCpf(txtCpf.getText());
    cliente.setRg(txtRG.getText());
    cliente.setTelefone(txtTelefone.getText());
    cliente.setRua(txtRua.getText());
    cliente.setNumero(txtNumero.getText());
    cliente.setBairro(txtBairro.getText());
    cliente.setCidade(txtCidade.getText());
    cliente.setEstado(txtEstado.getText());
    cliente.setCep(txtCep.getText());
    cliente.setComplemento(txtComplemento.getText());
    cliente.setPontoreferencia(txtPontoReferencia.getText());

    ClienteDAO dao = new ClienteDAO();
    dao.atualizar(cliente);
    
    JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
    limparCampos();
    listarValoresTabela();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
   
      if (txtID.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela primeiro!");
        return;
    }

    String id = txtID.getText();
    
    ClienteDAO dao = new ClienteDAO();
    dao.excluir(id);
    
    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
    limparCampos();
    listarValoresTabela();

    }//GEN-LAST:event_btnExcluirActionPerformed
    
    
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
              if (this.telaAnterior != null) {
            this.telaAnterior.setVisible(true); 
            this.dispose();                     
        }
     
                
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

      private void limparCampos() {

        txtID.setText("");
        txtNome.setText("");
        txtNascimento.setText("");
        txtCpf.setText("");
        txtRG.setText("");
        txtTelefone.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtRua.setText("");
        txtCep.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
        txtPontoReferencia.setText("");

        txtNome.requestFocus();
    
} 
    
    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {                                            
    int setar = tabelaCliente.getSelectedRow();
    
    // O número indica o índice da coluna na tabela (começa em 0)
    txtID.setText(tabelaCliente.getModel().getValueAt(setar, 0).toString());
    txtNome.setText(tabelaCliente.getModel().getValueAt(setar, 1).toString());
    txtNascimento.setText(tabelaCliente.getModel().getValueAt(setar, 2).toString());
    txtCpf.setText(tabelaCliente.getModel().getValueAt(setar, 3).toString());
    txtRG.setText(tabelaCliente.getModel().getValueAt(setar, 4).toString());
    txtTelefone.setText(tabelaCliente.getModel().getValueAt(setar, 5).toString());
    txtRua.setText(tabelaCliente.getModel().getValueAt(setar, 6).toString());
    txtNumero.setText(tabelaCliente.getModel().getValueAt(setar, 7).toString());
    txtBairro.setText(tabelaCliente.getModel().getValueAt(setar, 8).toString());
    txtCidade.setText(tabelaCliente.getModel().getValueAt(setar, 9).toString());
    txtEstado.setText(tabelaCliente.getModel().getValueAt(setar, 10).toString());
    txtCep.setText(tabelaCliente.getModel().getValueAt(setar, 11).toString());
    txtComplemento.setText(tabelaCliente.getModel().getValueAt(setar, 12).toString());
    txtPontoReferencia.setText(tabelaCliente.getModel().getValueAt(setar, 13).toString());
}

    /**
     * @param args the command line arguments
     */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelDadosdoCliente;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelListaCliente;
    private javax.swing.JLabel labelNomeCompleto;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelRua;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtID;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPontoReferencia;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

}
