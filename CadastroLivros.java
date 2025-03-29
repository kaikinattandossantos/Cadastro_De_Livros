import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroLivros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Livro> estante = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\nBem vindo a biblioteca! Digite a funcionalidade que quer explorar");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Marcar como lido");
            System.out.println("4 - Sair do sistema");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();

                    Livro novoLivro = new Livro(titulo, autor);
                    estante.add(novoLivro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    if (estante.isEmpty()) {
                        System.out.println("A estante está vazia :(");
                    } else {
                        System.out.println("\n--- LIVROS NA ESTANTE ---");
                        for (int i = 0; i < estante.size(); i++) {
                            Livro livro = estante.get(i);
                            System.out.println((i + 1) + ". " + livro.getTitulo() + 
                                             " - " + livro.getAutor() + 
                                             " (" + (livro.isLido() ? "Lido" : "Não lido") + ")");
                        }
                    }
                    break;

                case 3:
                    if (estante.isEmpty()) {
                        System.out.println("Não há livros para marcar como lido!");
                    } else {
                        System.out.println("\nSelecione o livro para marcar como lido:");
                        for (int i = 0; i < estante.size(); i++) {
                            System.out.println((i + 1) + ". " + estante.get(i).getTitulo());
                        }
                        System.out.print("Digite o número do livro: ");
                        int numeroLivro = scanner.nextInt();
                        if (numeroLivro > 0 && numeroLivro <= estante.size()) {
                            estante.get(numeroLivro - 1).setLido(true);
                            System.out.println("Livro marcado como lido!");
                        } else {
                            System.out.println("Número inválido!");
                        }
                    }
                    break;

                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}