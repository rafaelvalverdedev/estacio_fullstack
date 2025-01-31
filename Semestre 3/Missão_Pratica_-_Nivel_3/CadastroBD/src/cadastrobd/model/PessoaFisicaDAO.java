package cadastrobd.model;

import cadastrobd.model.util.ConectorBD;
import java.sql.*;

public class PessoaFisicaDAO {
    public void incluir(PessoaFisica pessoa) throws SQLException {
        String sqlPessoa = "INSERT INTO Pessoa (id, nome, logradouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sqlFisica = "INSERT INTO PessoaFisica (id, cpf) VALUES (?, ?)";

        try (Connection conn = ConectorBD.getConnection();
             PreparedStatement stmtPessoa = ConectorBD.getPrepared(conn, sqlPessoa);
             PreparedStatement stmtFisica = ConectorBD.getPrepared(conn, sqlFisica)) {
            
            stmtPessoa.setInt(1, pessoa.id);
            stmtPessoa.setString(2, pessoa.nome);
            stmtPessoa.setString(3, pessoa.logradouro);
            stmtPessoa.setString(4, pessoa.cidade);
            stmtPessoa.setString(5, pessoa.estado);
            stmtPessoa.setString(6, pessoa.telefone);
            stmtPessoa.setString(7, pessoa.email);
            stmtPessoa.executeUpdate();

            stmtFisica.setInt(1, pessoa.id);
            stmtFisica.setString(2, pessoa.cpf);
            stmtFisica.executeUpdate();
        }
    }
}
