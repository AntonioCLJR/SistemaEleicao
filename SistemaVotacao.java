import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaVotacao {
    private List<Partido> partidos;
    private List<Prefeito> prefeitos;
    private List<Vereador> vereadores;
    private Map<Integer, Integer> votosPrefeitos;
    private Map<Integer, Integer> votosVereadores;

    public SistemaVotacao() {
        this.partidos = new ArrayList<>();
        this.prefeitos = new ArrayList<>();
        this.vereadores = new ArrayList<>();
        this.votosPrefeitos = new HashMap<>();
        this.votosVereadores = new HashMap<>();
    }

    public void adicionarPartido(Partido partido) {
        this.partidos.add(partido);
    }

    public void adicionarPrefeito(Prefeito prefeito) {
        this.prefeitos.add(prefeito);
        this.votosPrefeitos.put(prefeito.getNumero(), 0);  // Inicializa os votos do prefeito
    }

    public void adicionarVereador(Vereador vereador) {
        this.vereadores.add(vereador);
        this.votosVereadores.put(vereador.getNumero(), 0);  // Inicializa os votos do vereador
    }

    public Partido buscarPartidoPorNumero(int numeroCandidato) {
        String numeroBase = String.valueOf(numeroCandidato).substring(0, 2);
        for (Partido partido : this.partidos) {
            if (String.valueOf(partido.getNumeroBase()).equals(numeroBase)) {
                return partido;
            }
        }
        return null;
    }

    public void votarPrefeito(int numeroCandidato) {
        if (this.votosPrefeitos.containsKey(numeroCandidato)) {
            this.votosPrefeitos.put(numeroCandidato, this.votosPrefeitos.get(numeroCandidato) + 1);
        }
    }

    public void votarVereador(int numeroCandidato) {
        if (this.votosVereadores.containsKey(numeroCandidato)) {
            this.votosVereadores.put(numeroCandidato, this.votosVereadores.get(numeroCandidato) + 1);
        }
    }

    public void exibirResultados() {
        Prefeito vencedorPrefeito = null;
        Vereador vencedorVereador = null;
        Partido partidoMaisVotos = null;
        int maxVotosPrefeito = 0;
        int maxVotosVereador = 0;
        int maxVotosPartido = 0;

        // Determina o vencedor para prefeito
        for (Prefeito prefeito : this.prefeitos) {
            int votos = this.votosPrefeitos.get(prefeito.getNumero());
            if (votos > maxVotosPrefeito) {
                maxVotosPrefeito = votos;
                vencedorPrefeito = prefeito;
            }
        }

        // Determina o vencedor para vereador
        for (Vereador vereador : this.vereadores) {
            int votos = this.votosVereadores.get(vereador.getNumero());
            if (votos > maxVotosVereador) {
                maxVotosVereador = votos;
                vencedorVereador = vereador;
            }
        }

        // Determina o partido com mais votos
        for (Partido partido : this.partidos) {
            int votosPartido = 0;
            for (Prefeito prefeito : this.prefeitos) {
                if (prefeito.getPartido().equals(partido)) {
                    votosPartido += this.votosPrefeitos.get(prefeito.getNumero());
                }
            }
            for (Vereador vereador : this.vereadores) {
                if (vereador.getPartido().equals(partido)) {
                    votosPartido += this.votosVereadores.get(vereador.getNumero());
                }
            }
            if (votosPartido > maxVotosPartido) {
                maxVotosPartido = votosPartido;
                partidoMaisVotos = partido;
            }
        }

        System.out.println("Vencedor da eleição para prefeito: " + vencedorPrefeito.getNome() + " do partido " + vencedorPrefeito.getPartido().getNome());
        System.out.println("Vencedor da eleição para vereador: " + vencedorVereador.getNome() + " do partido " + vencedorVereador.getPartido().getNome());
        System.out.println("Partido que recebeu mais votos: " + partidoMaisVotos.getNome() + " com " + maxVotosPartido + " votos");
    }
}
