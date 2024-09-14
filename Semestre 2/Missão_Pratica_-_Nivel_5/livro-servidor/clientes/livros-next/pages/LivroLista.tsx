import { useEffect, useState } from 'react';
import { LinhaLivro } from '../componentes/LinhaLivro';
import 'bootstrap/dist/css/bootstrap.css'
import styles from '../src/app/page.module.css';
import Menu from '../componentes/Menu';
import Head from 'next/head';

const baseURL = "http://localhost:3000/api/livros";

export const LivroLista: React.FC = () => {
    const [livros, setLivros] = useState([]);
    const [carregado, setCarregado] = useState(false);

    const obter = async () => {
        const response = await fetch(baseURL);
        const data = await response.json();
        setLivros(data);
    };
    const excluirLivro = async (codigo: number) => {
        const response = await fetch(`${baseURL}/${codigo}`, {
            method: 'DELETE'
        });
        return response.ok;

    };

    useEffect(() => {
        if (!carregado) {
            obter().then(() => setCarregado(true));
        }
    }, [carregado]);

    const excluir = async (codigo: number) => {
        await excluirLivro(codigo);
        setCarregado(false);
    };

    return (
        <>
            <div className={styles.container}>
                <Head>
                    <title>Lista de Livros</title>
                </Head>
                <Menu />
                <main className={styles.main}>
                    <h1 className={styles.title}>Lista de Livros</h1>
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Título</th>
                                <th>Editora</th>
                                <th>Autores</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            {livros.map((livro) => (
                                <LinhaLivro
                                    key={livro.codigo}
                                    livro={livro}
                                    excluir={() => excluir(livro.codigo)}
                                />
                            ))}
                        </tbody>
                    </table>
                </main>
            </div>
        </>
    );
};

export default LivroLista;
