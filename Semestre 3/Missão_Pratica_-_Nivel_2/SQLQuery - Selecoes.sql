USE model;

/* CONSULTA DADOS COMPLETOS DE PESSOAS FÍSICAS */
SELECT * FROM Pessoa_Fisica;

/* CONSULTA DADOS COMPLETOS DE PESSOAS JURÍDICAS */
SELECT * FROM Pessoa_Juridica;


/* CONSULTA DADOS COMPLETOS DE MOVIMENTACOES */
SELECT * FROM movimentacao;

/* MOVIMENTACAO DE ENTRADA, COM PRODUT, FORNECEDOR, QUANTIDADE, PRECO UNITARIO E VALOR TOTAL */
SELECT 
    m.*,
    m.quantidade * m.valorUnitario AS valor_total,
	p.nome AS nomeProduto -- Nome do produto
--	pf.nome AS nomePessoa
FROM 
    movimentacao m,
	Produtos p
--INNER JOIN
--	Pessoa_Fisica pf ON m.idPessoa = pf.idPessoaFisica
WHERE 
    m.tipo = 'E'
