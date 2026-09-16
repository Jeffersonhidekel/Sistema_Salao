
package Modelo;


public class ServicosRealizados {
 
private int idAtendimento;
private long idcliente;    
private String idservico;
private double ValorServico;
private String dataServico;

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public String getIdservico() {
        return idservico;
    }

    public void setIdservico(String idservico) {
        this.idservico = idservico;
    }

    public String getdataServico() {
        return dataServico;
    }

    public void setdataServico(String dataServico) {
        this.dataServico = dataServico;
    }

   public double getValorServico() {
        return ValorServico;
    }

    public void setValorServico(double ValorServico) {
        this.ValorServico = ValorServico;
    }


    
    
}
