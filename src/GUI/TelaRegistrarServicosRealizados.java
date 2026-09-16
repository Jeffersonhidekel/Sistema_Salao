/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Modelo.ServicosRealizados;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.event.ListSelectionEvent;

 
public class TelaRegistrarServicosRealizados extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaRegistrarServicosRealizados.class.getName());
     
      private DefaultTableModel modelo;
      private int proximoId = 1;
      
      private final DateTimeFormatter formatoData =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private javax.swing.JFrame telaAnterior;
      
      
    public TelaRegistrarServicosRealizados() {
         initComponents();
        
         configurarMascaraData();
         configurarTabela();
         configurarCombos();
    }
    
     private void configurarMascaraData() {
        try {
            javax.swing.text.MaskFormatter mascara =
                    new javax.swing.text.MaskFormatter("##/##/####");

            mascara.setPlaceholderCharacter('_');

            txtData.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(mascara)
            );

        } catch (java.text.ParseException ex) {
            logger.severe("Erro na máscara de data");
        }
    }
      private void configurarTabela() {
        txtIdAtendimento.setEditable(false);

        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {
                carregarDadosTabela();
            }
        });
      }   
      private void configurarCombos() {
        
          cboCliente.removeAllItems();
    cboServico.removeAllItems();

    cboCliente.addItem("Selecione...");
    cboServico.addItem("Selecione...");

    try {
        
        DAO.ClienteDAO clienteDao = new DAO.ClienteDAO(); 
        
        
        for (Modelo.Cliente cliente : clienteDao.listarTodos()) { 
            
            cboCliente.addItem(cliente.getNome()); 
        }

        
        DAO.ServicoDAO servicoDao = new DAO.ServicoDAO(); 
        
        
        for (Modelo.Servico servico : servicoDao.listar()) {
            
            cboServico.addItem(servico.getNome()); 
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar dados nas ComboBoxes: " + e.getMessage());
    }
          
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDadosAtendimento = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        labelServico = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        labelAtendimentoRealizados = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox<>();
        cboServico = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelIdAtendimento = new javax.swing.JLabel();
        txtIdAtendimento = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnRegistrarServico = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtValorServico = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Serviço Realizado");

        labelDadosAtendimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelDadosAtendimento.setForeground(new java.awt.Color(102, 0, 153));
        labelDadosAtendimento.setText("Dados do Atendimento");

        labelCliente.setText("Cliente:");

        labelServico.setText("Serviço:");

        labelData.setText("Data:");

        txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##/##/####"))));
        txtData.addActionListener(this::txtDataActionPerformed);

        labelAtendimentoRealizados.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelAtendimentoRealizados.setForeground(new java.awt.Color(102, 0, 153));
        labelAtendimentoRealizados.setText("Atendimentos Realizados");

        cboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboCliente.addActionListener(this::cboClienteActionPerformed);

        cboServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboServico.addActionListener(this::cboServicoActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Serviço", "Valor do Serviço (R$)", "Data"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        labelIdAtendimento.setText("ID Atendimento:");

        txtIdAtendimento.addActionListener(this::txtIdAtendimentoActionPerformed);

        btnNovo.setBackground(new java.awt.Color(102, 0, 153));
        btnNovo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("Novo");
        btnNovo.addActionListener(this::btnNovoActionPerformed);

        btnRegistrarServico.setBackground(new java.awt.Color(102, 0, 153));
        btnRegistrarServico.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegistrarServico.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarServico.setText("Registrar Serviço");
        btnRegistrarServico.addActionListener(this::btnRegistrarServicoActionPerformed);

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

        jLabel1.setText("Valor do Serviço(R$):");

        txtValorServico.addActionListener(this::txtValorServicoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(27, 27, 27)
                        .addComponent(btnAlterar)
                        .addGap(25, 25, 25)
                        .addComponent(btnLimpar)
                        .addGap(29, 29, 29)
                        .addComponent(btnExcluir)
                        .addGap(28, 28, 28)
                        .addComponent(btnRegistrarServico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelAtendimentoRealizados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelDadosAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)))
                            .addComponent(labelServico)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelIdAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorServico, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnLimpar)
                    .addComponent(btnVoltar)
                    .addComponent(btnExcluir)
                    .addComponent(btnRegistrarServico))
                .addGap(27, 27, 27)
                .addComponent(labelDadosAtendimento)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdAtendimento)
                    .addComponent(txtIdAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelServico, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtValorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAtendimentoRealizados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      private boolean validarValorServico() {
        try {
            Double.valueOf(txtValorServico.getText().replace(",", "."));
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Informe um valor numérico válido!");
            return false;
        }
    }
      private LocalDate pegarData() {
        try {
            String texto = txtData.getText();

            if (texto.contains("_")) return null;

            return LocalDate.parse(texto, formatoData);

        } catch (DateTimeParseException e) {
            return null;
        }
    }
      
    public TelaRegistrarServicosRealizados(javax.swing.JFrame telaAnterior) {
        this();
        
        this.telaAnterior = telaAnterior;
       
         preencherTabela();
        
    }
  
      
    private void cboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClienteActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtIdAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAtendimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAtendimentoActionPerformed

    private void cboServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboServicoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limparCampos();
        jTable1.clearSelection();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnRegistrarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarServicoActionPerformed
  
        
        if (cboCliente.getSelectedIndex() <= 0) {
        JOptionPane.showMessageDialog(this, "Selecione um cliente!");
        return;
    }

    if (cboServico.getSelectedIndex() <= 0) {
        JOptionPane.showMessageDialog(this, "Selecione um serviço!");
        return;
    }

    if (txtValorServico.getText().trim().isEmpty() || !validarValorServico()) {
        return;
    }

    LocalDate data = pegarData();

    if (data == null) {
        JOptionPane.showMessageDialog(this, "Data inválida! Use dd/MM/yyyy");
        return;
    }

    try {
        
        ServicosRealizados servicoRealizado = new ServicosRealizados();
        
        
        servicoRealizado.setIdcliente(cboCliente.getSelectedIndex()); 
        servicoRealizado.setIdservico(String.valueOf(cboServico.getSelectedIndex())); 
        servicoRealizado.setValorServico(Double.parseDouble(txtValorServico.getText().replace(",", ".")));
 
        servicoRealizado.setdataServico(data.toString());

        
        DAO.ServicosRealizadosDAO dao = new DAO.ServicosRealizadosDAO();
        dao.inserir(servicoRealizado);

            

        JOptionPane.showMessageDialog(this, "Serviço registrado no banco com sucesso!");
        limparCampos();
        preencherTabela();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao salvar no banco: " + e.getMessage());
    }
   
    }//GEN-LAST:event_btnRegistrarServicoActionPerformed
  
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
 
        
        int linha = jTable1.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um atendimento na tabela!");
        return;
    }

    if (cboCliente.getSelectedIndex() <= 0 ||
        cboServico.getSelectedIndex() <= 0 ||
        txtValorServico.getText().trim().isEmpty() ||
        txtData.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
        return;
    }

    if (!validarValorServico()) return;

    LocalDate data = pegarData();

    if (data == null) {
        JOptionPane.showMessageDialog(this, "Data inválida!");
        return;
    }

    try {
        
        ServicosRealizados servico = new ServicosRealizados();
        
        int idAtendimento = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
        servico.setIdAtendimento(idAtendimento);
        
        servico.setIdcliente(cboCliente.getSelectedIndex()); 
        servico.setIdservico(String.valueOf(cboServico.getSelectedIndex()));
        servico.setValorServico(Double.parseDouble(txtValorServico.getText().replace(",", ".")));
        servico.setdataServico(data.toString());

        
        DAO.ServicosRealizadosDAO dao = new DAO.ServicosRealizadosDAO();
        dao.atualizar(servico);

        
        modelo.setValueAt(cboCliente.getSelectedItem(), linha, 1);
        modelo.setValueAt(cboServico.getSelectedItem(), linha, 2);
        modelo.setValueAt(txtValorServico.getText(), linha, 3);
        modelo.setValueAt(data.format(formatoData), linha, 4);

        JOptionPane.showMessageDialog(this, "Registro alterado no banco com sucesso!");

        limparCampos();
        jTable1.clearSelection();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao alterar no banco: " + e.getMessage());
    }

        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
               limparCampos();
               jTable1.clearSelection();
    }//GEN-LAST:event_btnLimparActionPerformed
    

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
             if (this.telaAnterior != null) {
            this.telaAnterior.setVisible(true); 
            this.dispose();                     
        }

    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
   
        int linha = jTable1.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um atendimento na tabela!");
        return;
    }

    int resp = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente excluir este registro do banco?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
    );

    if (resp == JOptionPane.YES_OPTION) {
        try {
           
            String idAtendimentoStr = modelo.getValueAt(linha, 0).toString();
            
            DAO.ServicosRealizadosDAO dao = new DAO.ServicosRealizadosDAO();
            dao.excluir(idAtendimentoStr);

            
            modelo.removeRow(linha);
            JOptionPane.showMessageDialog(this, "Registro excluído do banco com sucesso!");
            limparCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir no banco: " + e.getMessage());
        }
    }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtValorServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorServicoActionPerformed
  
    private void limparCampos() {
       
        txtIdAtendimento.setText("");
        txtValorServico.setText("");
        txtData.setText("");

        cboCliente.setSelectedIndex(0);
        cboServico.setSelectedIndex(0);
 
        cboCliente.requestFocus();
    
    }
    
      private void carregarDadosTabela() {

        int linha = jTable1.getSelectedRow();

        if (linha != -1) {

            txtIdAtendimento.setText(modelo.getValueAt(linha, 0).toString());
            cboCliente.setSelectedItem(modelo.getValueAt(linha, 1).toString());
            cboServico.setSelectedItem(modelo.getValueAt(linha, 2).toString());
            txtValorServico.setText(modelo.getValueAt(linha, 3).toString());
            txtData.setText(modelo.getValueAt(linha, 4).toString());
        }
      }
      
      private void preencherTabela() {
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        
        try {
            DAO.ServicosRealizadosDAO dao = new DAO.ServicosRealizadosDAO();
            
            for (ServicosRealizados s : dao.listar()) {
                modelo.addRow(new Object[]{
                    s.getIdAtendimento(),
                    s.getIdcliente(), 
                    s.getIdservico(),
                    s.getValorServico(),
                    s.getdataServico()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados do banco: " + e.getMessage());
        }
    }

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaRegistrarServicosRealizados().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRegistrarServico;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JComboBox<String> cboServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelAtendimentoRealizados;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelDadosAtendimento;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelIdAtendimento;
    private javax.swing.JLabel labelServico;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtIdAtendimento;
    private javax.swing.JTextField txtValorServico;
    // End of variables declaration//GEN-END:variables
}
