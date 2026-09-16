
package Modelo;


public class VendaProduto {
private long idVendas;
private long  idCliente; 
private long  idProduto;
private int  quantidade;
private String data;
private double valorTotal;

  void processarPagamento(){
      
  }

    public long getidVendas() {
        return idVendas;
    }

    public void setidVendas(long idVendas) {
        this.idVendas = idVendas;
    }

    public long getidCliente() {
        return idCliente;
    }

    public void setidCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getidProduto() {
        return idProduto;
    }

    public void setidProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

   
    
}
