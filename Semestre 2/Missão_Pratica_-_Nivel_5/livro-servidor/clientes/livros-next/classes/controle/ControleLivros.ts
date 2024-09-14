import { Livro } from "../modelo/Livro";

const livros: Array<Livro> = [
    { codigo: 1, codEditora: 1, titulo: "Livro 1", resumo: "Resumo do livro 1", autores: ["Autor 1", "Autor 2"] },
    { codigo: 2, codEditora: 2, titulo: "Livro 2", resumo: "Resumo do livro 2", autores: ["Autor 3"] },
    { codigo: 3, codEditora: 3, titulo: "Livro 3", resumo: "Resumo do livro 3", autores: ["Autor 4", "Autor 5"] },
];

export class ControleLivro {
    obterLivros() {
        return livros;
    }

    incluir(livro: Livro) {
        livro.codigo = livros.length ? Math.max(...livros.map(l => l.codigo)) + 1 : 1;
        livros.push(livro);
    }

    excluir(codigo: number) {
        const index = livros.findIndex(l => l.codigo === codigo);
        if (index >= 0) {
            livros.splice(index, 1);
        }
    }
}