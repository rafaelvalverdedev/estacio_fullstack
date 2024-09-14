import {Livro} from "../modelo/Livro";

const baseURL = "http://localhost:3030/livros";

interface LivroMongo {
    _id: string;
    codEditora: number;
    titulo: string;
    resumo: string;
    autores: string[];
}


export class ControleLivro {
    async obterLivros(): Promise<Livro[]> {
        const resposta = await fetch(baseURL);
        const livrosMongo: LivroMongo[] = await resposta.json();
        return livrosMongo.map(livro => new Livro(livro._id, livro.codEditora, livro.titulo, livro.resumo, livro.autores));
    }

    async incluir(livro: Livro): Promise<boolean> {
        const livroMongo = { ...livro, _id: livro.codigo };
        const resposta = await fetch(baseURL, {
            method: 'POST',
            headers: {'Access-Control-Allow-Origin': '*', 'content-type': 'aplication/json'},
            body: JSON.stringify(livroMongo),
        });
        return resposta.ok;
    }

    async excluir(codigo: string): Promise<boolean> {
        const resposta = await fetch(`${baseURL}/${codigo}`, { method: 'DELETE' });
        return resposta.ok;
    }

}