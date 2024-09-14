const express = require('express');
const { obterLivros, incluir, excluir } = require('../modelo/livro-dao');
const router = express.Router();

// Rota GET para obter todos os livros
router.get('/', async (req, res) => {
  const livros = await obterLivros();
  res.json(livros);
});

// Rota POST para incluir um novo livro
router.post('/', async (req, res) => {
  try {
    await incluir(req.body);
    res.json({ message: 'Livro incluído com sucesso!' });
  } catch (error) {
    res.status(500).json({ message: 'Erro ao incluir o livro.' });
  }
});

// Rota DELETE para excluir um livro pelo código
router.delete('/:_id', async (req, res) => {
  try {
    await excluir(req.params._id);
    res.json({ message: 'Livro excluído com sucesso!' });
  } catch (error) {
    res.status(500).json({ message: 'Erro ao excluir o livro.' });
  }
});

module.exports = router;
