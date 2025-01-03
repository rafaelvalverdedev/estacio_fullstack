package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo {
    private List<PessoaJuridica> lista = new ArrayList<>();

    // Método para inserir uma nova PessoaJuridica
    public void inserir(PessoaJuridica pessoaJuridica) {
        lista.add(pessoaJuridica);
    }

    // Método para alterar uma PessoaJuridica existente
    public void alterar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == pessoaJuridica.getId()) {
                lista.set(i, pessoaJuridica);
                return;
            }
        }
    }

    // Método para excluir uma PessoaJuridica pelo ID
    public void excluir(int id) {
        lista.removeIf(pessoa -> pessoa.getId() == id);
    }

    // Método para obter uma PessoaJuridica pelo ID
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoa : lista) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    // Método para obter todas as PessoasJuridicas
    public List<PessoaJuridica> obterTodos() {
        return new ArrayList<>(lista);
    }

    // Método para persistir os dados em arquivo
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(lista);
        }
    }

    // Método para recuperar os dados de um arquivo
    @SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            lista = (List<PessoaJuridica>) ois.readObject();
        }
    }
}
