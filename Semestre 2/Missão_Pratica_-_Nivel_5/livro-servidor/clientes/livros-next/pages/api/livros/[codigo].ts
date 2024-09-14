// pages/api/livros/[codigo].ts
import { NextApiRequest, NextApiResponse } from 'next';
import { controleLivro } from '.';

export default (req: NextApiRequest, res: NextApiResponse) => {
  try {
    if (req.method === 'DELETE') {
      const { codigo } = req.query;
      controleLivro.excluir(Number(codigo));
      res.status(200).json({ message: 'Livro excluído com sucesso' });
    } else {
      res.status(405).send('Método não permitido');
    }
  } catch (error) {
    res.status(500).send('Erro no servidor');
  }
};
