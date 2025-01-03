package model;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable  {
    private String cnpj;

    // Construtor padrão
    public PessoaJuridica() {}

    // Construtor completo
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    // Método exibir (polimórfico)
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
    }
    
    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
