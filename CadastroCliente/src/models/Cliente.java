package models;

import java.util.Date;

public class Cliente {
    private int codigo;
    private String cpf;
    private String nome;
    private Date nascimento;
    private String telefone;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int COD) {
        this.codigo = COD;
    }
    
    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    } 
}
