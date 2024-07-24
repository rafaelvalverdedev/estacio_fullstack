import 'bootstrap/dist/css/bootstrap.css'
import styles from "./page.module.css";
import Menu from "../../componentes/Menu";
import Head from 'next/head';

export default function Home() {
  return (
    <>
    <div className={styles.container}>
      <Head>
        <title>Loja Next</title>
      </Head>
      <Menu />
      <main className={styles.main}>
        <h1 className={styles.title}>Página Inicial</h1>
      </main>
    </div>
    </>
  );
}