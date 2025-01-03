package cadastropoo;

import model.*;

import java.io.IOException;

public class CadastroPOO {
    public static void main(String[] args) {
        try {
            // Repositório de pessoas físicas (repo1)
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            
            // Adicionar duas pessoas físicas
            repo1.inserir(new PessoaFisica(1, "Joao Silva", "123.456.789-00", 25));
            repo1.inserir(new PessoaFisica(2, "Maria Oliveira", "987.654.321-00", 30));
            
            // Persistir dados no arquivo fixo
            String arquivoPessoasFisicas = "pessoasFisicas.dat";
            repo1.persistir(arquivoPessoasFisicas);

            // Outro repositório de pessoas físicas (repo2)
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            
            // Recuperar dados do arquivo
            repo2.recuperar(arquivoPessoasFisicas);
            
            // Exibir dados recuperados de pessoas físicas
            System.out.println("Pessoas Fisicas Armazenados.");
            for (PessoaFisica pf : repo2.obterTodos()) {
                pf.exibir();
            }

            // Repositório de pessoas jurídicas (repo3)
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            
            // Adicionar duas pessoas jurídicas
            repo3.inserir(new PessoaJuridica(1, "Empresa ABC", "12.345.678/0001-00"));
            repo3.inserir(new PessoaJuridica(2, "Corporacao XYZ", "98.765.432/0001-99"));
            
            // Persistir dados no arquivo fixo
            String arquivoPessoasJuridicas = "pessoasJuridicas.dat";
            repo3.persistir(arquivoPessoasJuridicas);

            // Outro repositório de pessoas jurídicas (repo4)
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            
            // Recuperar dados do arquivo
            repo4.recuperar(arquivoPessoasJuridicas);
            
            // Exibir dados recuperados de pessoas jurídicas
            System.out.println("\nDados de Pessoas Juridicas Armazenados:");
            for (PessoaJuridica pj : repo4.obterTodos()) {
                pj.exibir();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
