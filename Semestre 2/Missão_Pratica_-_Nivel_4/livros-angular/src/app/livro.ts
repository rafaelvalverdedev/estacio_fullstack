export class Livro {
    codigo: number;
    codEditora: number;
    titulo: string;
    resumo: string;
    autores: string[];

    constructor() {
        this.codigo = 0,
        this.codEditora = 0,
        this.titulo = '',
        this.resumo = '';
        this.autores = [];
    }
}
