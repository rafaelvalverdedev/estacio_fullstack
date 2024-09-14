const mongoose = require('./conexao');

const LivroSchema = new mongoose.Schema({
  titulo: String,
  codEditora: String,
  resuno: String,
  autores: String
});

const Livro = mongoose.model('Livro', LivroSchema, 'livros');

module.exports = Livro;
