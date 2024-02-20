# DESCRIÇÃO DA MISSÃO
## Implementar um programa orientado a objetos para visualizar e aplicar regressão linear em séries temporais.

# OBJETIVOS
## 1º Objetivo
### Aplicar as técnicas de: programação orientada a objetos, manipulação de dicionários e comandos iterativos para produção
### de gráficos no Python e para obter a regressão linear de uma série temporal. 

## 2º Objetivo
### Entrar com uma lsita de despesas por dia e o programa deve produzir: gráficos com visualização das séries temporais
### de despesas; gráfico de regressão linear da série temporal.

# Importação de Bibliotecas Utilizadas
import matplotlib.pyplot as plt
import numpy as np
from sklearn.linear_model import LinearRegression

# (1) Entrada de Dados
def entrada_dados():
    dicionario_alimentacao = {}
    for x in range(1, 6):
        alimentacao = input(f'Digite as despesas com alimentação para o dia {x} : ')
        dicionario_alimentacao[x] = alimentacao

    dicionario_vestuario = {}
    for x in range(1, 6):
        vestuario = input(f'Digite as despesas com vestuário para o dia {x} : ')
        dicionario_vestuario[x] = vestuario

    dicionario_transporte = {}
    for x in range(1, 6):
        transporte = input(f'Digite as despesas com transporte: para o dia {x} ')
        dicionario_transporte[x] = transporte

    return dicionario_alimentacao, dicionario_vestuario , dicionario_transporte

dados_despesas = entrada_dados()

print(f'Despesas com alimentação: {dados_despesas[0]}')
print(f'Despesas com vestuário: {dados_despesas[1]}')
print(f'Despesas com transporte: {dados_despesas[2]}')

# 2 Classe para tratar das séries temporais relacionadas a despesas
class SeriesDespesas:
    def __init__(self, dados1, dados2, dados3):
        self.dados1 = dados1
        self.dados2 = dados2
        self.dados3 = dados3

    def get_dates(self):
        return list(self.dados1.keys()), list(self.dados2.keys()), list(self.dados3.keys())

    def get_expenses(self):
        return list(self.dados1.values()), list(self.dados2.values()), list(self.dados3.values())

# Exemplo de uso
series_despesas = SeriesDespesas(dados_despesas[0], dados_despesas[1], dados_despesas[2])
print("Datas:", series_despesas.get_dates())
print("Despesas:", series_despesas.get_expenses())

# 3 Classe para gerar os graficos de linha e de regressão linear

class GeraGrafico:
    def __init__(self, datas, despesas):
        self.datas = datas
        self.despesas = despesas

    # Gráfico de linha
    def geracao_grafico(self):
        lista1 = self.despesas[0]
        lista_inteiros1 = [int(elemento) for elemento in lista1]

        lista2 = self.despesas[1]
        lista_inteiros2 = [int(elemento) for elemento in lista2]

        lista3 = self.despesas[2]
        lista_inteiros3 = [int(elemento) for elemento in lista3]

        x = np.linspace(1, 5, 5)
        plt.plot(self.datas[0], lista_inteiros1, 'bo-', label='Alimentação')
        plt.plot(self.datas[1], lista_inteiros2, 'ro-', label='Vestuário')
        plt.plot(self.datas[2], lista_inteiros3, 'yo-', label='Transporte')
        plt.xlabel('Dias')
        plt.ylabel('Despesas em R$')
        plt.title('Gráfico de Despesas')
        plt.legend()
        plt.grid()
        plt.show()

    # Gráfico de progressão linear
    def geracao_progressao(self):
        lista1 = self.despesas[0]
        lista_inteiros1 = [int(elemento) for elemento in lista1]

        x = np.array([1, 2, 3, 4, 5]).reshape((-1,1))
        y = np.array(lista_inteiros1)

        model = LinearRegression().fit(x, y)
        y_pred = model.predict(x)
        plt.plot(x, y_pred, 'r-', label='Regressão Linear')
        plt.plot(x, y, 'bo-', label='Alimentação - original')
        plt.title('Gráfico de Regressão Linear')
        plt.legend()
        plt.grid()
        plt.show()

# Exemplo de uso
gerar_graficos = GeraGrafico(series_despesas.get_dates(), series_despesas.get_expenses())
gerar_graficos.geracao_grafico()
gerar_graficos.geracao_progressao()