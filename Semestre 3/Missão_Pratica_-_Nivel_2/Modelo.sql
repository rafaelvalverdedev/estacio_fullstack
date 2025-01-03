USE model;

CREATE SEQUENCE sequencia
    START WITH 1   -- Inicia a sequência a partir de 1
    INCREMENT BY 1 -- Incrementa de 1 em 1
    MINVALUE 1     -- Valor mínimo permitido (1)
    NO CYCLE;      -- Não reinicia a sequência quando atingir o valor máximo
	
	
CREATE TABLE Produtos (
  idProduto  INTEGER   NOT NULL ,
  nome  TEXT    ,
  quantidade  TEXT    ,
  preco_venda  TEXT      ,
PRIMARY KEY(idProduto ));


CREATE TABLE Usuarios (
  idUsuario INTEGER   NOT NULL ,
  login TEXT    ,
  senha  TEXT      ,
PRIMARY KEY(idUsuario));


CREATE TABLE Pessoa_Juridica (
  idPessoaJuridica INTEGER   NOT NULL ,
  nome  TEXT    ,
  cnpj INTEGER    ,
  endereco  TEXT    ,
  telefone TEXT    ,
  email TEXT      ,
PRIMARY KEY(idPessoaJuridica));


CREATE TABLE Pessoa_Fisica (
  idPessoaFisica INTEGER   NOT NULL ,
  nome TEXT    ,
  cpf INTEGER    ,
  endereco TEXT     ,
  telefone TEXT    ,
  email TEXT       ,
PRIMARY KEY(idPessoaFisica));


CREATE TABLE movimentacao (
  idMovimento INTEGER   NOT NULL ,
  idUsuario INTEGER    ,
  idPessoa INTEGER    ,
  idProduto INTEGER    ,
  quantidade INTEGER    ,
  tipo VARCHAR(1)    ,
  valorUnitario INTEGER      ,
PRIMARY KEY(idMovimento));