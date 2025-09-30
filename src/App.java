
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        BinarySearchTree<Integer> arvore = new BinarySearchTree<>(); 
        //TreeObserver observador = new TreeObserver<>();
        //arvore.setObserver(observador);
        for(int i=0;i<5;i++){
            System.out.println("Valor:");
            arvore.add(leia.nextInt());
        }
        // mostrar o preOrdem da arvore
        System.out.println("Preorder:");
        arvore.preOrder();
    }
}
