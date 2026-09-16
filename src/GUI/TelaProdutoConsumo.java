package GUI;

import DAO.ProdutoConsumoDAO;
import Modelo.ProdutoConsumo;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaProdutoConsumo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaProdutoConsumo.class.getName());
         private DefaultTableModel modelo;
         private int proximoID = 1;
  
      private javax.swing.JFrame telaAnterior;    
         
    public TelaProdutoConsumo() {
        initComponents();
      
        txtCodigoProduto.setEditable(false);

        
        preencherTabela(); 

        tabelaprotudos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabelaprotudos.getSelectedRow() != -1) {
                carregarDadosTabela(); 
            }
        });
    }
    
    public TelaProdutoConsumo(javax.swing.JFrame telaAnterior) {
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
        bntVoltar = new javax.swing.JButton();
        labelDadosConsumo = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        labelNomeProduto = new javax.swing.JLabel();
        labelValorCompra = new javax.swing.JLabel();
        labelListaProdutoConsumo = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCodigoProduto = new javax.swing.JTextField();
        txtValorCompra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaprotudos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Produto de Consumo");
        setResizable(false);

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
        btnAlterar.setText("Alterar ");
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

        bntVoltar.setBackground(new java.awt.Color(102, 0, 153));
        bntVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bntVoltar.setForeground(new java.awt.Color(255, 255, 255));
        bntVoltar.setText("Voltar");
        bntVoltar.addActionListener(this::bntVoltarActionPerformed);

        labelDadosConsumo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelDadosConsumo.setForeground(new java.awt.Color(102, 0, 153));
        labelDadosConsumo.setText("Dados do Consumo");

        labelCodigo.setText("Codigo:");

        labelNomeProduto.setText("Nome do Produto:");

        labelValorCompra.setText("Valor de Compra(R$):");

        labelListaProdutoConsumo.setBackground(new java.awt.Color(102, 0, 153));
        labelListaProdutoConsumo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelListaProdutoConsumo.setForeground(new java.awt.Color(102, 0, 153));
        labelListaProdutoConsumo.setText("Lista de Produto de Consumo");

        txtNome.addActionListener(this::txtNomeActionPerformed);

        txtCodigoProduto.addActionListener(this::txtCodigoProdutoActionPerformed);

        txtValorCompra.addActionListener(this::txtValorCompraActionPerformed);

        tabelaprotudos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Produto", "Valor de compra (R$)"
            }
        ));
        jScrollPane1.setViewportView(tabelaprotudos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelListaProdutoConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDadosConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addGap(20, 20, 20)
                                .addComponent(btnSalvar))
                            .addComponent(labelCodigo)
                            .addComponent(labelNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar)
                                .addGap(18, 18, 18)
                                .addComponent(bntVoltar))
                            .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovo)
                        .addComponent(btnExcluir)
                        .addComponent(btnLimpar)
                        .addComponent(btnAlterar)
                        .addComponent(bntVoltar))
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelDadosConsumo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeProduto)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValorCompra)
                    .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelListaProdutoConsumo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       if (txtCodigoProduto.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Selecione um produto na tabela primeiro!");
        return;
    }

    String codigo = txtCodigoProduto.getText();
    
    ProdutoConsumoDAO dao = new ProdutoConsumoDAO();
    dao.excluir(codigo);
    
    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
    limparCampos();
    preencherTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void bntVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltarActionPerformed
              if (this.telaAnterior != null) {
            this.telaAnterior.setVisible(true); 
            this.dispose();                     
        }

    }//GEN-LAST:event_bntVoltarActionPerformed

    private void txtCodigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProdutoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtValorCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorCompraActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
             limparCampos();
             tabelaprotudos.clearSelection();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
         limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed
   
    private void limparCampos() {
    txtCodigoProduto.setText("");
    txtNome.setText("");
    txtValorCompra.setText("");
    txtNome.requestFocus();
    
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
         if (txtNome.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Informe o nome!");
        return;
    }

    if (txtValorCompra.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Informe o valor!");
        return;
    }

  ProdutoConsumo produto = new ProdutoConsumo();
    produto.setNome(txtNome.getText());
    //produto.setCodigoProduto(txtCodigoProduto.getText());
    String valorTratado = txtValorCompra.getText().replace(",", ".");
    produto.setValorcompra(valorTratado);

    ProdutoConsumoDAO dao = new ProdutoConsumoDAO();
    dao.inserir(produto);
    
    JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
    limparCampos();
    preencherTabela();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
                                                
    if (txtCodigoProduto.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Selecione um produto pelo código primeiro!");
        return;
    }

    ProdutoConsumo produto = new ProdutoConsumo();
    produto.setNome(txtNome.getText());
    produto.setCodigoProduto(Long.parseLong(txtCodigoProduto.getText()));
    produto.setValorcompra(txtValorCompra.getText());

    ProdutoConsumoDAO dao = new ProdutoConsumoDAO();
    dao.atualizar(produto);
    
    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
    limparCampos();
    preencherTabela();

    }//GEN-LAST:event_btnAlterarActionPerformed
    private void carregarDadosTabela() {

    int linha = tabelaprotudos.getSelectedRow();

    txtCodigoProduto.setText(modelo.getValueAt(linha, 0).toString());
    txtNome.setText(modelo.getValueAt(linha, 1).toString());
    txtValorCompra.setText(modelo.getValueAt(linha, 2).toString());
}
    
    private void preencherTabela() {
        modelo = (DefaultTableModel) tabelaprotudos.getModel();
        modelo.setRowCount(0);
        
        try {
            ProdutoConsumoDAO dao = new ProdutoConsumoDAO();
            
            
            for (ProdutoConsumo p : dao.listar()) {
                modelo.addRow(new Object[]{
                    p.getCodigoProduto(),
                    p.getNome(),
                    p.getValorcompra()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar produtos: " + e.getMessage());
        }
    }
    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new TelaProdutoConsumo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVoltar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDadosConsumo;
    private javax.swing.JLabel labelListaProdutoConsumo;
    private javax.swing.JLabel labelNomeProduto;
    private javax.swing.JLabel labelValorCompra;
    private javax.swing.JTable tabelaprotudos;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValorCompra;
    // End of variables declaration//GEN-END:variables
}
