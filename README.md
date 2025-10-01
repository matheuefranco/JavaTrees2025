# Binary Search Tree (BST) com Padrão Observer

Este projeto implementa uma **Árvore Binária de Busca (Binary Search Tree)** em Java com o padrão **Observer** para monitoramento de operações e análise de desempenho.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Implementação](#implementação)
- [Padrão Observer](#padrão-observer)
- [Como Usar](#como-usar)
- [Exemplos de Uso](#exemplos-de-uso)
- [Análise de Complexidade](#análise-de-complexidade)
- [Compilação e Execução](#compilação-e-execução)

## 🎯 Sobre o Projeto

Este projeto foi desenvolvido como parte da disciplina de **Estruturas de Dados II** e implementa:

- **Binary Search Tree (BST)** genérica com tipo `T extends Comparable<T>`
- **Padrão Observer** para monitoramento de operações
- Contadores de comparações e percursos
- Arquitetura extensível e reutilizável

## 📁 Estrutura do Projeto

```
Trees/
├── src/
│   ├── App.java                    # Classe principal com método main
│   ├── BinarySearchTree.java       # Implementação da BST
│   ├── Node.java                   # Classe do nó da árvore
│   ├── Observable.java             # Classe abstrata para padrão Observer
│   └── TreeObserver.java           # Interface do Observer
├── bin/                           # Arquivos compilados (.class)
├── lib/                           # Bibliotecas externas (se houver)
└── README.md                      # Este arquivo
```

## 🏗️ Implementação

### Árvore Binária de Busca (BST)

A **Binary Search Tree** é uma estrutura de dados hierárquica onde:

- Cada nó tem no máximo dois filhos (esquerdo e direito)
- Para qualquer nó, todos os valores à esquerda são menores
- Todos os valores à direita são maiores ou iguais
- Permite busca, inserção e remoção eficientes

#### Características da Implementação:

```java
public class BinarySearchTree<T extends Comparable<T>> extends Observable {
    private Node<T> raiz;
    
    // Operações principais:
    // - add(T novoDado): Inserção de elementos
    // - preOrder(): Percurso pré-ordem
    // - search(T valor): Busca de elementos (a ser implementada)
}
```

### Classe Node

```java
public class Node<T> {
    T dado;
    Node<T> esquerda;
    Node<T> direita;
    
    // Representa um nó da árvore com valor e referências para filhos
}
```

## 👁️ Padrão Observer

O padrão Observer foi implementado para monitorar e analisar o desempenho da árvore:

### Componentes:

1. **Observable** (Classe Abstrata)
   - Gerencia lista de observers
   - Fornece métodos para adicionar/remover observers
   - Implementa notificações
   - Mantém contadores de operações

2. **TreeObserver** (Interface)
   ```java
   public interface TreeObserver {
       void onComparison(String operation, int totalComparisons);
       void onTraversal(String operation, int nodesVisited);
   }
   ```

3. **TreeStatisticsObserver** (Implementação Concreta)
   - Exibe estatísticas das operações
   - Monitora comparações e percursos
   - Fornece feedback em tempo real

### Vantagens do Padrão Observer:

- ✅ **Desacoplamento**: Separação entre lógica da árvore e monitoramento
- ✅ **Extensibilidade**: Fácil adição de novos tipos de observers
- ✅ **Reutilização**: A classe Observable pode ser usada por outras estruturas
- ✅ **Flexibilidade**: Múltiplos observers podem ser registrados simultaneamente

## 🚀 Como Usar

### 1. Criação da Árvore

```java
BinarySearchTree<Integer> bst = new BinarySearchTree<>();
```

### 2. Adição de Observer

```java
TreeStatisticsObserver observer = new TreeStatisticsObserver();
bst.addObserver(observer);
```

### 3. Operações na Árvore

```java
// Inserção de elementos
bst.add(50);
bst.add(30);
bst.add(70);

// Percurso da árvore
bst.preOrder(); // Saída: 50 - 30 - 70 -
```

## 📊 Exemplos de Uso

### Exemplo Básico

```java
public class Main {
    public static void main(String[] args) {
        // Cria BST e observer
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        TreeStatisticsObserver observer = new TreeStatisticsObserver();
        bst.addObserver(observer);
        
        // Adiciona elementos (com monitoramento)
        bst.add(50);  // Output: Operação: ADD - Total de comparações: 0
        bst.add(30);  // Output: Operação: ADD - Total de comparações: 1
        bst.add(70);  // Output: Operação: ADD - Total de comparações: 1
        
        // Percorre a árvore
        bst.preOrder(); // Output: 50 - 30 - 70 - 
                        // Output: Operação: PRE_ORDER - Nós visitados: 3
    }
}
```

### Exemplo com Strings

```java
BinarySearchTree<String> bstString = new BinarySearchTree<>();
bstString.addObserver(observer);

bstString.add("Maria");
bstString.add("João");
bstString.add("Pedro");

bstString.preOrder(); // Output: Maria - João - Pedro -
```

### Múltiplos Observers

```java
TreeStatisticsObserver observer1 = new TreeStatisticsObserver();
TreeStatisticsObserver observer2 = new TreeStatisticsObserver();

bst.addObserver(observer1);
bst.addObserver(observer2);

bst.add(25); // Ambos observers serão notificados
```

## ⚡ Análise de Complexidade

### Operações da BST:

| Operação | Melhor Caso | Caso Médio | Pior Caso |
|----------|-------------|------------|-----------|
| Inserção | O(log n)    | O(log n)   | O(n)      |
| Busca    | O(log n)    | O(log n)   | O(n)      |
| Percurso | O(n)        | O(n)       | O(n)      |

### Padrão Observer:

| Operação              | Complexidade |
|-----------------------|--------------|
| Adicionar Observer    | O(1)         |
| Remover Observer      | O(n)         |
| Notificar Observers   | O(m)         |

*Onde n = número de nós na árvore, m = número de observers*

## 🔧 Compilação e Execução

### Usando linha de comando:

```bash
# Navegar para o diretório src
cd src

# Compilar todos os arquivos Java
javac *.java -d ../bin

# Executar o programa
cd ../bin
java App
```

### Usando VS Code:

1. Abra o projeto no VS Code
2. Certifique-se de ter a extensão Java instalada
3. Pressione `F5` ou clique em "Run" → "Run Without Debugging"

## 🔮 Possíveis Extensões

### Funcionalidades a serem implementadas:

- ✅ **Busca** com contagem de comparações
- ✅ **Percursos** (In-Order, Post-Order)
- ✅ **Remoção** de elementos
- ✅ **Balanceamento** automático (AVL)
- ✅ **Serialização** da árvore
- ✅ **Interface gráfica** para visualização

### Novos Observers:

- **PerformanceObserver**: Mede tempo de execução
- **MemoryObserver**: Monitor uso de memória
- **LogObserver**: Salva operações em arquivo
- **GraphicalObserver**: Visualização gráfica em tempo real

## 📚 Conceitos Aplicados

- **Programação Orientada a Objetos**
- **Generics em Java**
- **Padrões de Projeto (Observer)**
- **Estruturas de Dados (Árvores)**
- **Recursão**
- **Análise de Algoritmos**

## 👥 Contribuição

Este projeto foi desenvolvido para fins educacionais. Sugestões e melhorias são bem-vindas!

---

**Disciplina**: Estruturas de Dados II  
**Semestre**: 2025  
**Tema**: Árvores Binárias de Busca com Padrão Observer
