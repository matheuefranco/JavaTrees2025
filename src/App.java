import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {

    static  void carregarArquivo(BinarySearchTree tree, String csvFile){
        String line = "";
        String[] leitura = null;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                Pessoa p = new Pessoa();
                leitura = line.split(",");
                System.out.println(leitura[0]+" " + leitura[1]);
                p.setMatricula(Integer.parseInt(leitura[0]));
                p.setNome(leitura[1]);
                tree.add(p); 
            }// fim percurso no arquivo
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
        BinarySearchTree<Pessoa> arvore = new BinarySearchTree<>(); 
        int op;
        do{
            op = menu();
            switch(op){
                case 1: System.out.println("Dado para inserir:");
                        novoDado = new Pessoa();
                        System.out.println("Matricula:");
                        novoDado.setMatricula(leia.nextInt());
                        System.out.println("Nome:");
                        novoDado.setNome(leia.next());
                        arvore.add(novoDado);
                break;
                case 2: System.out.println("PreOrdem:");
                        arvore.preOrder();
                        System.out.println("\nInOrdem:");
                        arvore.inOrder();
                        System.out.println("\nPostOrdem:");
                        arvore.postOrder();
                break;
                case 3: System.out.println("Matricula para busca:");
                        Pessoa dadoBusca = new Pessoa();
                        dadoBusca.setMatricula(leia.nextInt());
                        novoDado = arvore.search(dadoBusca);
                        if(novoDado == null)
                            System.out.println("Dado nao encontrado");
                        else
                            System.out.println("Dado encontrado:"+novoDado);
                        break;   
                case 4: System.out.println("Carregando arquivo:");
                        String csvFile = "dados.csv";
                        carregarArquivo(arvore, csvFile);
                break;

                case 0: System.out.println("Saindo");
                break;


            }// fim switch
            System.out.println("Pressione uma tecla para continuar");
            leia.nextLine();// pausa
        }while(op!=0);
    }
}