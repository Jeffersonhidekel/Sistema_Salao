
package Modelo;

public class ProdutoConsumo{
   private String nome;
 private long  codigoProduto;
    private String valorcompra;
    
  public ProdutoConsumo(){}  
  public ProdutoConsumo(String nome, long codigoProduto, String valorcompra) {
        this.nome = nome;
        this.codigoProduto = codigoProduto;
        this.valorcompra = valorcompra;
  }
void adicionarProduto(){
        
}
void removerProduto(){
    
}
void verProduto(){
    
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(String valorcompra) {
        this.valorcompra = valorcompra;
    }

   

    
}
