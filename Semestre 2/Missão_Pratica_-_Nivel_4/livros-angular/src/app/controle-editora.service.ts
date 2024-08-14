import { Injectable } from '@angular/core';
import { Editora } from './editora';

@Injectable({
  providedIn: 'root',
})

export class ControleEditoraService {
  private editoras: Array<Editora> = [
    { codEditora: 1, nome: 'Editora A' },
    { codEditora: 2, nome: 'Editora B' },
    { codEditora: 3, nome: 'Editora C' },
  ];

  getNomeEditora(codEditora: number): string | undefined {
    return this.editoras.find(editora => editora.codEditora === codEditora)?.nome;
  }

  getEditoras(): Array<Editora> {
    return this.editoras;
  }

}
