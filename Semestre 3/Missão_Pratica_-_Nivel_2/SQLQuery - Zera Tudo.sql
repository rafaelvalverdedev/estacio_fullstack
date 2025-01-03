DROP SEQUENCE sequencia;

delete FROM movimentacao;
delete FROM Pessoa_Fisica;
delete FROM Pessoa_Juridica;
delete FROM Produtos;
delete FROM Usuarios;

drop table movimentacao;
drop table Pessoa_Fisica;
drop table Pessoa_Juridica;
drop table Produtos;
drop table Usuarios;

TRUNCATE TABLE Produtos;
TRUNCATE TABLE Usuarios;
TRUNCATE TABLE movimentacoes;
TRUNCATE TABLE Pessoa_Fisica;
TRUNCATE TABLE Pessoa_Juridica;