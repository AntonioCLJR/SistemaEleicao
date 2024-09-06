public class Partido {
    private String nome;
    private int numeroBase;

    public Partido(String nome, int numeroBase) {
        this.nome = nome;
        this.numeroBase = numeroBase;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroBase() {
        return numeroBase;
    }
}