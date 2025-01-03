package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo {
    private List<PessoaFisica> lista = new ArrayList<>();

    // Método para inserir uma nova PessoaFisica
    public void inserir(PessoaFisica pessoaFisica) {
        lista.add(pessoaFisica);
    }

    // Método para alterar uma PessoaFisica existente
    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == pessoaFisica.getId()) {
                lista.set(i, pessoaFisica);
                return;
            }
        }
    }

    // Método para excluir uma PessoaFisica pelo ID
    public void excluir(int id) {
        lista.removeIf(pessoa -> pessoa.getId() == id);
    }

    // Método para obter uma PessoaFisica pelo ID
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : lista) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    // Método para obter todas as PessoasFisicas
    public List<PessoaFisica> obterTodos() {
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
            lista = (List<PessoaFisica>) ois.readObject();
        }
    }
}
