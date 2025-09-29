
public class BinarySearchTree<T extends Comparable<T>>{
        private Node<T> raiz;

        public BinarySearchTree(){
            this.raiz=null;
        }


        private Node<T> add(Node<T> raiz, Node<T> novoNo){
            if(raiz==null)
                return novoNo;
            if(novoNo.dado.compareTo(raiz.dado)<0) 
                raiz.esquerda = add(raiz.esquerda, novoNo);
            else
                raiz.direita = add(raiz.direita, novoNo);

            return raiz;
        }

        public void add(T novoDado){
            Node<T> novoNo = new Node(novoDado);
            this.raiz = add(this.raiz, novoNo);
        }

        private void preOrder(Node<T> raiz){
            if(raiz!=null){
                System.out.print(raiz.dado+" - ");
                preOrder(raiz.esquerda);
                preOrder(raiz.direita);
            }
        }

        public void preOrder(){
            preOrder(this.raiz);
        }

    
}