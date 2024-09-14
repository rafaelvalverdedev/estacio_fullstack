import { useState, useEffect } from 'react';
import { ControleLivro } from './controle/ControleLivros';
import { ControleEditora } from './controle/ControleEditora';


const controleLivro = new ControleLivro();
const controleEditora = new ControleEditora();

const LinhaLivro = (props) => {
    const { livro, excluir } = props;
    const nomeEditora = controleEditora.getNomeEditora(livro.codEditora);

    return (
        <tr>
            <td>
                {livro.titulo}
                <br />
                <button onClick={() => excluir(livro.codigo)} className="btn btn-danger">Excluir</button>
            </td>
            <td>{livro.resumo}</td>
            <td>{livro.autores.join(', ')}</td>
            <td>{nomeEditora}</td>
        </tr>
    );
};

const LivroLista = () => {
    const [livros, setLivros] = useState([]);
    const [carregado, setCarregado] = useState(false);

    useEffect(() => {
        controleLivro.obterLivros().then(livros => setLivros(livros));
    }, []);


    const excluir = (codigo) => {
        controleLivro.excluir(codigo).then(() => setCarregado(false));
    };

    return (
        <main>
            <h1>Lista de Livros</h1>
            <table className="table table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">Título</th>
                        <th scope="col">Resumo</th>
                        <th scope="col">Autores</th>
                        <th scope="col">Editora</th>
                    </tr>
                </thead>
                <tbody>
                    {livros.map((livro, index) => (
                        <LinhaLivro key={index} livro={livro} />
                    ))}
                </tbody>
            </table>
        </main>
    );
};

export default LivroLista;
