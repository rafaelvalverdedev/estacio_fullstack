# DESCRIÇÃO DA MISSÃO
## Implementar um algoritmo para obter o conjuntos das partes de um conjunto.

# OBJETIVOS
## 1º Objetivo
### Utilizar estruturas de dados como listas, comandos condicionais e iterativos.

## 2º Objetivo
### Entrar com uma lsita que representa um conjunto e o programa deve produzir o seu respectivo conjunto das partes.



# # (1) Entrada de dados
def entradaDados():
    entrada = input("Digite os números separados por espaço: (ex: 1 2 3)  ")
    return list(entrada.split(" ")) #Comando para criar a lista com os dados de entrada
listaDados = entradaDados()

# # (2) Cálculos Intermediários
def Calculo(conjunto):
    conjuntoPartes = [[]] #Lista vazia, representando o conjunto vazio

    for x in conjunto:
        novas_partes = [parte + [x] for parte in conjuntoPartes]
        conjuntoPartes.extend(novas_partes)
    return conjuntoPartes

# # (3) Apresentação dos Resultados
conjuntoPartes = Calculo(listaDados)
print('----------------------------------')
print("Conjunto original:", listaDados)
print(' ')
print("Conjunto de partes:", conjuntoPartes)
print('----------------------------------')