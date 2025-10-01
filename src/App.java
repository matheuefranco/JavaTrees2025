import java.util.Scanner;

public class App {

    static int menu(){
        Scanner leia = new Scanner(System.in);
        System.out.println("*** Arvore de Busca Binaria ***");
        System.out.println("1-Inserir");
        System.out.println("2-Percursos");
        System.out.println("3-Buscar");
        System.out.println("4-Carregar");
        System.out.println("5-Remover");
        System.out.println("6-Altura da arvore");
        System.out.println("0-Sair");
        int op = leia.nextInt();
        return op;
    }
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        Pessoa novoDado;
        BinarySearchTree<Integer> arvore = new BinarySearchTree<>(); 
        int op;
        do{
            op = menu();
            switch(op){
                case 1: System.out.println("Dado para inserir:");
                        //novoDado = leia.nextInt(); alterar
                        arvore.add(novoDado);
                break;
                case 2: System.out.println("PreOrdem:");
                        arvore.preOrder();
                        System.out.println("\nInOrdem:");
                        arvore.inOrder();
                        System.out.println("\nPostOrdem:");
                        arvore.postOrder();
                break;
                case 0: System.out.println("Saindo");
                break;
            }// fim switch
            System.out.println("Pressione uma tecla para continuar");
            leia.nextLine();// pausa
        }while(op!=0);
    }
}