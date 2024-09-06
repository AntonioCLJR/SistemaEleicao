public abstract class Candidato {
    private String nome;
    private Partido partido;
    private int numero;

    public Candidato(String nome, Partido partido, int numero) {
        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Partido getPartido() {
        return partido;
    }

    public int getNumero() {
        return numero;
    }
}