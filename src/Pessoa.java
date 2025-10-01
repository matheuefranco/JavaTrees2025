public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private Integer matricula;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public int compareTo(Pessoa outraPessoa){
        return this.matricula.compareTo(outraPessoa.getMatricula());
    }

    @Override
    public String toString(){
        return this.nome +" - " +this.matricula;
    }
    



}
