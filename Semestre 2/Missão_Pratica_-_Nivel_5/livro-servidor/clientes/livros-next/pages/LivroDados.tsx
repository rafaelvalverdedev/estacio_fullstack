import { useState } from 'react';
import { useRouter } from 'next/router';
import { ControleEditora } from '../classes/controle/ControleEditora';
import { Livro } from '../classes/modelo/Livro';
import 'bootstrap/dist/css/bootstrap.css'
import styles from '../src/app/page.module.css';
import Head from 'next/head';
import Menu from '../componentes/Menu';

const controleEditora = new ControleEditora();
const baseURL = "http://localhost:3000/api/livros";

const LivroDados: React.FC = () => {
    const [titulo, setTitulo] = useState('');
    const [resumo, setResumo] = useState('');
    const [autores, setAutores] = useState('');
    const [codEditora, setCodEditora] = useState(0);
    const opcoes = controleEditora.getEditoras().map(editora => ({ value: editora.codEditora, text: editora.nome }));

    const router = useRouter();

    const tratarCombo = (e: React.ChangeEvent<HTMLSelectElement>) => {
        setCodEditora(Number(e.target.value));
    };

    const incluir = async (e: React.FormEvent<HTMLFormElement>) => {

        e.preventDefault();
        if (codEditora == "") {
            alert("Escolha a editora.")
        } else {
            const novoLivro = new Livro(0, codEditora, titulo, resumo, autores.split('\n'));
            const response = await fetch(baseURL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(novoLivro)
            });
            if (response.ok) {
                router.push('/LivroLista');
            }
        }
    };

    return (
        <div className={styles.container}>
            <Head>
                <title>Dados do Livro</title>
            </Head>
            <Menu />
            <main className={styles.main}>
                <h1 className={styles.title}>Dados do Livro</h1>
                <form onSubmit={incluir}>
                    <div className="form-group">
                        <label>Título</label>
                        <input type="text" className="form-control" value={titulo} onChange={(e) => setTitulo(e.target.value)} required />
                    </div>
                    <div className="form-group">
                        <label>Resumo</label>
                        <textarea className="form-control" value={resumo} onChange={(e) => setResumo(e.target.value)} required />
                    </div>
                    <div className="form-group">
                        <label>Autores</label>
                        <textarea className="form-control" value={autores} onChange={(e) => setAutores(e.target.value)} required />
                    </div>
                    <div className="form-group">
                        <label>Editora</label>
                        <select className="form-control" value={codEditora} onChange={tratarCombo}>
                            <option value=""> -- </option>
                            {opcoes.map((editora) => (
                                <option key={editora.value} value={editora.value}>{editora.text}</option>
                            ))}
                        </select>
                    </div>
                    <button type="submit" className="btn btn-primary">Incluir</button>
                </form>
            </main>
        </div>
    );
};

export default LivroDados;
