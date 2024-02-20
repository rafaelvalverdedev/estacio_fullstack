# DESCRIÇÃO DA MISSÃO
## Implementar um algoritmo de conversão de um número da base decimal para a base binária

# OBJETIVOS
## 1º Objetivo
### Utilizar recursos lógicos de linguagem de programação Python, com comandos iterativos.

## 2º Objetivo
### Entrar com qualquer número inteiro positivo na base decimal e o programa deve produzir o número correspondente ba base binária

numero_base_decimal = 23
numero_base_binaria = "{0:b}".format(numero_base_decimal)
print(f'Número na base demical:{numero_base_decimal}')
print(f'Conversão para a base binária:{numero_base_binaria}')
print('-----------------------------------')

n = int(input("Digite um numero: ")) # Entrada de dados do usuário
base = 2
binario = ""

while (n > 0):
  resto = n%base
  n = n//2
  binario += str(resto)
print(binario[-1::-1]) #[-1::-1] Condição Python para inverter o resultado
print('-----------------------------------')