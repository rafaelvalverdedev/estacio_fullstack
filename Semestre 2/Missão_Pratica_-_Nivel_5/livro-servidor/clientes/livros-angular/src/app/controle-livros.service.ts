import { Injectable } from '@angular/core';
import { Livro } from './livro';

@Injectable({
  providedIn: 'root',
})

export class ControleLivrosService {
  private livros: Array<Livro> = [
    { codigo: 1, codEditora: 1, titulo: 'Livro 1', resumo: 'Resumo do Livro 1', autores: ['Autor A', 'Autor B'] },
    { codigo: 2, codEditora: 2, titulo: 'Livro 2', resumo: 'Resumo do Livro 2', autores: ['Autor C'] },
    { codigo: 3, codEditora: 3, titulo: 'Livro 3', resumo: 'Resumo do Livro 3', autores: ['Autor D', 'Autor E'] },
  ];

  obterLivros(): Array<Livro> {
    return this.livros;
  }

  incluir(livro: Livro): void {
    const novoCodigo = this.livros.length > 0 ? Math.max(...this.livros.map(l => l.codigo)) + 1 : 1;
    livro.codigo = novoCodigo;
    this.livros.push(livro);
  }

  excluir(codigo: number): void {
    const indice = this.livros.findIndex(l => l.codigo === codigo);
    if (indice !== -1) {
      this.livros.splice(indice, 1);
    }
  }
}
