package cadastrobd.model;

public class PessoaFisica extends Pessoa {
    String cpf;

    public PessoaFisica(int idPessoaFisica, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cpf) {
        super(idPessoaFisica, nome, logradouro, cidade, estado, telefone, email);
        this.cpf = cpf;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + cpf);
    }
}
