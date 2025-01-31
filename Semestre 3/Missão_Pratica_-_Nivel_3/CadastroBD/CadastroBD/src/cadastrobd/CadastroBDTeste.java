/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd;

import cadastrobd.model.*;
import cadastrobd.model.util.SequenceManager;
import java.sql.SQLException;

public class CadastroBDTeste {
    public static void main(String[] args) {
        try {
            
             // Obtém o próximo ID da sequência 'sequencia2'
            int novoId = SequenceManager.getValue("sequencia2");
                        
            PessoaFisicaDAO dao = new PessoaFisicaDAO();
            PessoaFisica pf = new PessoaFisica(novoId, "João", "Rua A", "São Paulo", "SP", "11999999999", "joao@email.com", "123.456.789-00");
            dao.incluir(pf);
            
            pf.exibir();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
