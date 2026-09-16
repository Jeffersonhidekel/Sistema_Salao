package GUI;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import DAO.VendaprodutoDAO;
import Modelo.VendaProduto;


public class TelaRegistrarVendaProduto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaRegistrarVendaProduto.class.getName());
   
      private DefaultTableModel modelo;
      private int proximoId = 1;

      private final DateTimeFormatter formatoData =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");
     private javax.swing.JFrame telaAnterior;
      
    public TelaRegistrarVendaProduto() {
        initComponents();
                    
        configurarTabela();
        configurarCombos();
        configurarMascaraData();

        txtIdVenda.setEditable(false);
        listarVendas();
    }
     private void configurarTabela() {
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
    }

    private void configurarCombos() {
       
        cboCliente.addItem("Selecione...");
    try {
        DAO.ClienteDAO clienteDao = new DAO.ClienteDAO();
        java.util.ArrayList<Modelo.Cliente> listaClientes = clienteDao.listarTodos();
        for (Modelo.Cliente cliente : listaClientes) {
            cboCliente.addItem(cliente.getNome());
        }
    } catch (Exception e) {
       
    }

    cboProduto.addItem("Selecione...");
try {
   
    DAO.ProdutoVendaDAO daoDeProdutos = new DAO.ProdutoVendaDAO();
      
    java.util.ArrayList<Modelo.ProdutoVenda> listaDeProdutos = daoDeProdutos.listar();
       
    for (Modelo.ProdutoVenda p : listaDeProdutos) {
        cboProduto.addItem(p.getNome()); 
    }
} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
}
        
    }
       
private void listarVendas() {
    try {
        VendaprodutoDAO dao = new VendaprodutoDAO();
        modelo.setRowCount(0); 
        
        for (VendaProduto v : dao.listar()) {
            modelo.addRow(new Object[]{
                v.getidVendas(),
                v.getidCliente(), 
                v.getidProduto(), 
                v.getQuantidade(),
                v.getData(),
                v.getValorTotal()
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar tabela: " + e.getMessage());
    }
}
    
    private void configurarMascaraData() {
        try {
            javax.swing.text.MaskFormatter mascara =
                    new javax.swing.text.MaskFormatter("##/##/####");

            mascara.setPlaceholderCharacter('_');

            txtDataVenda.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(mascara)
            );

        } catch (java.text.ParseException ex) {
            logger.severe("Erro na máscara de data");
        }
    }
    private boolean validarQuantidade() {
        try {
            int qtd = Integer.parseInt(txtQuantidade.getText().trim());
            return qtd > 0;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Quantidade inválida!");
            return false;
        }
    }

    private LocalDate pegarData() {
        try {
            String texto = txtDataVenda.getText();
            if (texto.contains("_")) return null;

            return LocalDate.parse(texto, formatoData);

        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public TelaRegistrarVendaProduto(javax.swing.JFrame telaAnterior) {
        this(); 
        this.telaAnterior = telaAnterior; 
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDadosVenda = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        labelProduto = new javax.swing.JLabel();
        labelQuantidade = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        txtDataVenda = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtQuantidade = new javax.swing.JTextField();
        cboCliente = new javax.swing.JComboBox<>();
        cboProduto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtIdVenda = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnRegistrarVenda = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Venda de Produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        labelDadosVenda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelDadosVenda.setForeground(new java.awt.Color(102, 0, 153));
        labelDadosVenda.setText("Dados de Venda");

        labelCliente.setText("Cliente:");

        labelProduto.setText("Produto:");

        labelQuantidade.setText("Quantidade:");

        labelData.setText("Data da Venda:");

        txtDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##/##/####"))));
        txtDataVenda.addActionListener(this::txtDataVendaActionPerformed);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 153));
        jLabel6.setText("Vendas Realizadas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Produto", "Quantidade", "Data"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txtQuantidade.addActionListener(this::txtQuantidadeActionPerformed);

        cboCliente.addActionListener(this::cboClienteActionPerformed);

        jLabel7.setText("ID Venda:");

        txtIdVenda.addActionListener(this::txtIdVendaActionPerformed);

        btnNovo.setBackground(new java.awt.Color(102, 0, 153));
        btnNovo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("Novo");
        btnNovo.addActionListener(this::btnNovoActionPerformed);

        btnRegistrarVenda.setBackground(new java.awt.Color(102, 0, 153));
        btnRegistrarVenda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegistrarVenda.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarVenda.setText("Registrar Venda");
        btnRegistrarVenda.addActionListener(this::btnRegistrarVendaActionPerformed);

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

        jLabel1.setText("Valor total da Venda (R$):");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDadosVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(labelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(8, 8, 8))
                                        .addComponent(labelData, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(92, 92, 92)
                                            .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(89, 89, 89)
                                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelProduto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnNovo)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAlterar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrarVenda)
                                .addGap(18, 18, 18)
                                .addComponent(btnVoltar))))
                    .addComponent(jScrollPane1))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnRegistrarVenda)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnVoltar)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDadosVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelProduto))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelData))
                        .addGap(18, 18, 18)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataVendaActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void cboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClienteActionPerformed

    private void txtIdVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdVendaActionPerformed

    private void btnRegistrarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVendaActionPerformed
    
        if (cboCliente.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente!");
            return;
        }

        if (cboProduto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto!");
            return;
        }

        if (txtQuantidade.getText().trim().isEmpty() || !validarQuantidade()) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida!");
            return;
        }

        LocalDate data = pegarData();
        if (data == null) {
            JOptionPane.showMessageDialog(this, "Data inválida!");
            return;
        }

        int qtd = Integer.parseInt(txtQuantidade.getText().trim());

        double valorUnitario = 25.0; 
        double total = qtd * valorUnitario;

        txtValorTotal.setText(String.valueOf(total));

        VendaProduto novaVenda = new VendaProduto();

novaVenda.setQuantidade(qtd);
novaVenda.setValorTotal(total);
novaVenda.setData(data.format(formatoData)); 

novaVenda.setidCliente(cboCliente.getSelectedIndex());
novaVenda.setidProduto(cboProduto.getSelectedIndex());

VendaprodutoDAO dao = new VendaprodutoDAO();
dao.inserir(novaVenda);


modelo.addRow(new Object[]{
    proximoId, cboCliente.getSelectedItem(), cboProduto.getSelectedItem(), qtd, data.format(formatoData), total
});

        proximoId++;

        JOptionPane.showMessageDialog(this,
                "Venda registrada com sucesso!");

        limparCampos();   
    }//GEN-LAST:event_btnRegistrarVendaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if (this.telaAnterior != null) {
            this.telaAnterior.setVisible(true); 
            this.dispose();                     
        }

    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limparCampos();
        jTable1.clearSelection();     

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
           limparCampos();
          jTable1.clearSelection();   
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       
        int linha = jTable1.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma venda!");
        return;
    }

    if (!validarQuantidade()) return;

    LocalDate data = pegarData();
    if (data == null) {
        JOptionPane.showMessageDialog(this, "Data inválida!");
        return;
    }

    int qtd = Integer.parseInt(txtQuantidade.getText().trim());
    double total = qtd * 25.0; 

    try {
       
        Long idVenda = Long.parseLong(jTable1.getValueAt(linha, 0).toString());

        VendaProduto vp = new VendaProduto();
        vp.setidVendas(idVenda);
        vp.setQuantidade(qtd);
        vp.setValorTotal(total);
       
        VendaprodutoDAO dao = new VendaprodutoDAO();
        dao.atualizar(vp);

        modelo.setValueAt(cboCliente.getSelectedItem(), linha, 1);
        modelo.setValueAt(cboProduto.getSelectedItem(), linha, 2);
        modelo.setValueAt(qtd, linha, 3);
        modelo.setValueAt(data.format(formatoData), linha, 4);
        modelo.setValueAt(total, linha, 5);

        JOptionPane.showMessageDialog(this, "Venda alterada com sucesso!");
        limparCampos();
        jTable1.clearSelection();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao alterar: " + e.getMessage());
    }
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        int linha = jTable1.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma venda!");
        return;
    }

    int resp = JOptionPane.showConfirmDialog(this,
            "Deseja realmente excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);

    if (resp == JOptionPane.YES_OPTION) {
        try {
            
            Long idVenda = Long.parseLong(jTable1.getValueAt(linha, 0).toString());
            
            
            VendaprodutoDAO dao = new VendaprodutoDAO();
            dao.excluir(idVenda);

            
            modelo.removeRow(linha);

            JOptionPane.showMessageDialog(this, "Venda excluída com sucesso!");
            limparCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage());
        }
    }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_formWindowActivated
    private void limparCampos() {
        txtIdVenda.setText("");
        txtQuantidade.setText("");
        txtDataVenda.setText("");
        txtValorTotal.setText("");

        cboCliente.setSelectedIndex(0);
        cboProduto.setSelectedIndex(0);
    }

    private void carregarDadosTabela() {

        int linha = jTable1.getSelectedRow();

        if (linha != -1) {
            txtIdVenda.setText(modelo.getValueAt(linha, 0).toString());
            cboCliente.setSelectedItem(modelo.getValueAt(linha, 1).toString());
            cboProduto.setSelectedItem(modelo.getValueAt(linha, 2).toString());
            txtQuantidade.setText(modelo.getValueAt(linha, 3).toString());
            txtDataVenda.setText(modelo.getValueAt(linha, 4).toString());
            txtValorTotal.setText(modelo.getValueAt(linha, 5).toString());
        }
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new TelaRegistrarVendaProduto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRegistrarVenda;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JComboBox<String> cboProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelDadosVenda;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JFormattedTextField txtDataVenda;
    private javax.swing.JTextField txtIdVenda;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
