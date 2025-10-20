public class Node<T extends Comparable<T>>{
    T dado;
    int fb;
    Node<T> esquerda;
    Node<T> direita;
    public Node(T dado){
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
        this.fb=0;
    }
}