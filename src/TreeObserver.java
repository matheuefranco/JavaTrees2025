
public class TreeObserver<T>  {
    public void totalComparacao( int totalComparisons) {
        System.out.println(" Total de comparações: " + totalComparisons);
    }
    
    
    public void noPercurso(String operation, T dataNodeVisited) {
        System.out.println("Operação: " + operation + " - Nó visitado: " + dataNodeVisited);
    }
}
