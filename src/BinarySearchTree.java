
public class BinarySearchTree<T extends Comparable<T>> extends Observable<T>  {
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

        public T search(T dadodeBusca){
            T dado =  search(this.raiz, dadodeBusca);
            notificarConclusao();
            return  dado;
        }

        private T search(Node<T> raiz, T dadodeBusca){
            notificarCompacao();// comparador do observable
            if(raiz==null)
                return null; // objeto nao existe na arvore
            if(dadodeBusca.equals(raiz.dado))
                return raiz.dado;                
            if(dadodeBusca.compareTo(raiz.dado)<0)
                return search(raiz.esquerda, dadodeBusca);
            else
                return search(raiz.direita, dadodeBusca);    
        }

    public Node<T> removeNode(Node<T> raiz) {
        Node<T> nova, pai;
        if(raiz.direita==null){
            nova = raiz.esquerda;
            return nova;
        }
        // percorrer até achar o menor da direita
        pai = raiz; nova= raiz.direita;
        while(nova.esquerda!=null){
            pai=nova;
            nova = nova.esquerda;
	    }// fim while
        
        // reorganizar os ponteiros
        if(pai!=raiz){
            pai.esquerda = nova.direita;
            nova.direita = raiz.direita;
        }
        nova.esquerda = raiz.esquerda;
        System.out.println("Retornando nova raiz:"+nova.dado);
	    return nova;
    }

    public void remove(T dadoRemover) {
        raiz = remove(this.raiz, dadoRemover);
    }

    private Node<T> remove(Node<T> raiz, T dadoRemover) {
        if(raiz==null){
            System.out.println("Não encontrado - :(");
            return null;       
         }
        if(raiz.dado.equals(dadoRemover)){
            System.out.println("Encontrado - removendo");
            return removeNode(raiz);        }
        if(dadoRemover.compareTo(raiz.dado)<0)
            raiz.esquerda = remove(raiz.esquerda,dadoRemover);
        else
            raiz.direita = remove(raiz.direita,dadoRemover);
        return raiz;
    }// fim buscaRemove


    
}