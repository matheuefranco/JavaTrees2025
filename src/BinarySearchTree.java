
public class BinarySearchTree<T extends Comparable<T>>  {
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

        public boolean  add(T novoDado){
            Node<T> novoNo = new Node(novoDado);
            if(novoNo == null)
                return false;
            this.raiz = add(this.raiz, novoNo);
            return true;
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

        private void inOrder(Node<T> raiz){
            if(raiz!=null){
                inOrder(raiz.esquerda);
                System.out.print(raiz.dado+" - ");
                inOrder(raiz.direita);
            }
        }

        public void inOrder(){
            inOrder(this.raiz);
        }

        private void postOrder(Node<T> raiz){
            if(raiz!=null){
                postOrder(raiz.esquerda);
                postOrder(raiz.direita);
               System.out.print(raiz.dado+" - ");
            }
        }

        public void postOrder(){
            postOrder(this.raiz);
        }

    
}