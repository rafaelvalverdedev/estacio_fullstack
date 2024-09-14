import { Editora } from "../modelo/Editora";

const editoras: Array<Editora> = [
    { codEditora: 1, nome: "Editora A" },
    { codEditora: 2, nome: "Editora B" },
    { codEditora: 3, nome: "Editora C" },
];

export class ControleEditora {
    getEditoras() {
        return editoras;
    }

    getNomeEditora(codEditora: number) {
        const editora = editoras.find(e => e.codEditora === codEditora);
        return editora ? editora.nome : "Editora não encontrada";
    }
}