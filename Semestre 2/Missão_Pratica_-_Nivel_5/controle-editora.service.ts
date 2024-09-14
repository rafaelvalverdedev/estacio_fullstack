import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ControleEditoraService {
  // Vetor de editoras
  private editoras = [
    { codEditora: 1, nome: 'Editora A' },
    { codEditora: 2, nome: 'Editora B' },
    { codEditora: 3, nome: 'Editora C' },
  ];

  // Retorna o vetor de editoras
  getEditoras() {
    return this.editoras;
  }

  // Retorna o nome da editora a partir do código
  getNomeEditora(codEditora: number) {
    const editora = this.editoras.filter(e => e.codEditora === codEditora);
    return editora.length > 0 ? editora[0].nome : 'Editora não encontrada';
  }
}
