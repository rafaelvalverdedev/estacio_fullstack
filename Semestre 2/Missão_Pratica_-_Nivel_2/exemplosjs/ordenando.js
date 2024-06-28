// Objetivo de trocar os valores de duas posições de um vetor
// tendo como parametros de entrada o vetor e as posições
const swap = (arr, i, j) => {
  [arr[i], arr[j]] = [arr[j], arr[i]];
};
// Objetivo de embaralhar os elementos de um vetor
// tendo como parametros de entrada o vetor e a quentidade de trocas
const shuffle = (arr, swaps) => {
  for (let i = 0; i < swaps; i++) {
    let idx1 = Math.floor(Math.random() * arr.length);
    let idx2 = Math.floor(Math.random() * arr.length);
    swap(arr, idx1, idx2);
  }
};
// Objetivo de ordenar um vetor de inteiros com o algoritmo Buble Sort
// tendo como parametro de entrada o valor de inteiros
const bubble_sort = (arr) => {
  let n = arr.length;
  for (let i = 0; i < n - 1; i++) {
    let min_idx = i;
    for (let j = i + 1; j < n; j++) {
      if (arr[j] < arr[min_idx]) {
        min_idx = j;
      }
    }
    swap(arr, i, min_idx);
  }
  return arr;
};
// Objetivo de ordenar um vetor de inteiros utilizando o algoritmo Selection Sort
//tendo como parametro de entrada valores inteiros
const selection_sort = (arr) => {
  let n = arr.length;
  for (let i = 0; i < n - 1; i++) {
    let min_idx = i;
    for (let j = i + 1; j < n; j++) {
      if (arr[j] < arr[min_idx]) {
        min_idx = j;
      }
    }
    swap(arr, i, min_idx);
  }
  return arr;
};

// Objetivo de ordenar um vetor de inteiros com o algoritmo Quick Sort, recursivo
// tendo como parametros o vetor, posição inicial e posição final
const quick_sort = (arr, low, high) => {
  if (low < high) {
    let pi = particionamento(arr, low, high);
    quick_sort(arr, low, pi - 1);
    quick_sort(arr, pi + 1, high);
  }
  return arr;
};

// Objetivo de apoio a quick_sort
// tendo como parametros o vetor, posição inicial, posição final e vetor do pivot
const particionamento = (arr, low, high) => {
  let pivot = arr[high];
  let i = low - 1;
  for (let j = low; j < high; j++) {
    if (arr[j] < pivot) {
      i++;
      swap(arr, i, j);
    }
  }
  swap(arr, i + 1, high);
  return i + 1;
};
