/* CONSULTA DADOS COMPLETOS DE PESSOAS FÍSICAS */
SELECT * FROM Pessoa_Fisica;

/* CONSULTA DADOS COMPLETOS DE PESSOAS JURÍDICAS */
SELECT * FROM Pessoa_Juridica;
s
/* MOVIMENTACAO DE ENTRADA, COM PRODUT, FORNECEDOR, QUANTIDADE, PRECO UNITARIO E VALOR TOTAL */
SELECT 
    m.idPessoa,
    m.quantidade,
    m.valorUnitario,
    m.quantidade * m.valorUnitario AS valor_total
	PF.nome, -- Nome do produto
FROM 
    movimentacao m
--JOIN 
--	Produtos p ON m.idProduto = p.idProduto

JOIN
	Pessoa_Fisica PF ON m.idPessoa = PF.idPessoaFisica
WHERE 
    m.tipo = 'E';
