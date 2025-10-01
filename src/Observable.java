
public abstract class Observable<T> {
    protected TreeObserver observer;
    protected int comparisonCount;
    
    public void setObserver(TreeObserver newObserver) {
        this.observer = newObserver;
    }
    
    public void removeObserver() {
        this.observer=null;
    }
    
    protected void notificaCompacao() {
        if(this.observer!=null) {
            this.comparisonCount++;
        }
    }

    protected void nofiticaConclusao() {
        if(this.observer!=null) {
            this.observer.totalComparacao(comparisonCount);
        }
    }
    
    protected void notificaPercurso(String operation, T dado) {
        if(this.observer!=null) 
            observer.noPercurso(operation, dado);
        
    }
    
    // Métodos utilitários para reset dos contadores
    protected void resetComparisonCount() {
        this.comparisonCount = 0;
    }
    

}
