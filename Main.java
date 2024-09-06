import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaVotacao sistema = new SistemaVotacao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Partido");
            System.out.println("2. Criar Candidato");
            System.out.println("3. Votar");
            System.out.println("4. Exibir Resultados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do partido: ");
                    String nomePartido = scanner.nextLine();
                    System.out.println("Digite o número base do partido (Deve ter apenas 2 números): ");
                    int numeroPartido = scanner.nextInt();
                        if (String.valueOf(numeroPartido).length() == 2) {
                            Partido partido = new Partido(nomePartido, numeroPartido);
                            sistema.adicionarPartido(partido);
                            System.out.println("Partido " + nomePartido + " criado com sucesso!");
                            break;
                        } else {
                            System.out.println("Número Invalido.");
                            break;
                        }
                case 2:
                    System.out.println("Digite para qual modalidade o candidato irá concorrer:\n1 - PREFEITO\n2 - VEREADOR");
                    int modalidadeCandidato = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    System.out.print("Digite o nome do candidato: ");
                    String nomeCandidato = scanner.nextLine();

                    System.out.print("\nCaso seja candidato a prefeito, será aceito números de 10 até 99" + "\nCaso seja candidato a vereador, será aceito números de 10000 até 99999" + "\nDigite o número do candidato:" );
                    int numeroCandidato = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    Partido partidoDoCandidato = sistema.buscarPartidoPorNumero(numeroCandidato);
                    if (partidoDoCandidato != null) {
                        if (modalidadeCandidato == 1) {
                            if (String.valueOf(numeroCandidato).length() == 2) {
                            Prefeito prefeito = new Prefeito(nomeCandidato, partidoDoCandidato, numeroCandidato);
                            sistema.adicionarPrefeito(prefeito);
                            System.out.println("Candidato " + nomeCandidato + " do partido " + partidoDoCandidato.getNome() + " criado com sucesso!");
                            } else {
                                System.out.println("NUMERO INVALIDO.");
                            }
                        } else if (modalidadeCandidato == 2) {
                            if (String.valueOf(numeroCandidato).length() == 5) {
                            Vereador vereador = new Vereador(nomeCandidato, partidoDoCandidato, numeroCandidato);
                            sistema.adicionarVereador(vereador);
                            System.out.println("Candidato " + nomeCandidato + " do partido " + partidoDoCandidato.getNome() + " criado com sucesso!");
                            } else {
                                System.out.println("NUMERO INVALIDO.");
                            }
                        } else {
                            System.out.println("Modalidade inválida.");
                        }
                    } else {
                        System.out.println("Partido não encontrado. Crie o partido primeiro.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o número do candidato a prefeito em que deseja votar (2 DÍGITOS): ");
                    int numeroVotoPrefeito = scanner.nextInt();
                    scanner.nextLine();//
                    if (String.valueOf(numeroVotoPrefeito).length() == 2) {
                    System.out.println("VOCÊ ESTÁ VOTANDO EM: " + numeroVotoPrefeito);
                    System.out.print("APERTE 1 PARA CONFIRMAR SEU VOTO: ");
                    int confirmacaoPrefeito = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    if (confirmacaoPrefeito == 1) {
                        sistema.votarPrefeito(numeroVotoPrefeito);
                        System.out.println("Voto para prefeito registrado com sucesso!");

                    } else {
                        System.out.println("SEU VOTO NÃO FOI CONFIRMADO! TENTE NOVAMENTE.");
                    }
                    } else {
                        System.out.println("NUMERO INVALIDO.");
                        break;
                    }

                    System.out.print("Digite o número do candidato a vereador em que deseja votar: ");
                    int numeroVotoVereador = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    if (String.valueOf(numeroVotoVereador).length() == 5) {
                    System.out.println("VOCÊ ESTÁ VOTANDO EM: " + numeroVotoVereador);
                    System.out.print("APERTE 1 PARA CONFIRMAR SEU VOTO: ");
                    int confirmacaoVereador = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    if (confirmacaoVereador == 1) {
                        sistema.votarVereador(numeroVotoVereador);
                        System.out.println("Voto para vereador registrado com sucesso!");
                    } else {
                        System.out.println("SEU VOTO NÃO FOI CONFIRMADO! TENTE NOVAMENTE.");
                    }
                    break;
                    } else {
                        System.out.println("NUMERO INVALIDO.");
                        break;
                    }
                case 4:
                    sistema.exibirResultados();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

