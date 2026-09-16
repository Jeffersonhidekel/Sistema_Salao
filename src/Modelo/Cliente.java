
package Modelo;

import java.util.Date;

public class Cliente {
private long id; 
private String nome;
private String  nascimento;
private String cpf;
private String rg;
private String telefone;
private String rua;
private String numero;
private String bairro;
private String cidade;
private String estado;
private String cep;
private String complemento;
private String pontoreferencia;


public Cliente() {}

    public Cliente(long id, String nome, String cpf, String nascimento,String rg,String telefone, String rua, String numero, String bairro, String cidade, String estado, String cep, String complemento, String pontoreferencia) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.rg = rg;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.complemento = complemento;
        this.pontoreferencia = pontoreferencia;
        
        
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getPontoreferencia() {
        return pontoreferencia;
    }

    public void setPontoreferencia(String pontoreferencia) {
        this.pontoreferencia = pontoreferencia;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

   
}
