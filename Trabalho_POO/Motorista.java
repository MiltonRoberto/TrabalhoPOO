import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Motorista {
    private String nome;
    private String id;
    private String CNH;
    private String nivelExperiencia;

    private static List<Motorista> motoristas = new ArrayList<>();

    public Motorista(String nome, String id, String CNH, String nivelExperiencia) {
        this.nome = nome;
        this.id = id;
        this.CNH = CNH;
        this.nivelExperiencia = nivelExperiencia;
    }

    // Getters e Setters

    @Override
    public String toString() {
        return "Motorista{" +
                "Nome='" + nome + '\'' +
                ", ID='" + id + '\'' +
                ", CNH='" + CNH + '\'' +
                ", Nível de Experiência='" + nivelExperiencia + '\'' +
                '}';
    }

    // Método para cadastrar motorista
    public static void cadastrarMotorista() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do motorista: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o ID do motorista: ");
        String id = scanner.nextLine();

        System.out.print("Informe o número da CNH do motorista: ");
        String CNH = scanner.nextLine();

        System.out.print("Informe o nível de experiência (iniciante, intermediário, avançado): ");
        String nivelExperiencia = scanner.nextLine();

        Motorista motorista = new Motorista(nome, id, CNH, nivelExperiencia);
        motoristas.add(motorista);
        System.out.println("Motorista cadastrado com sucesso!");
    }

    // Método para listar motoristas
    public static void listarMotoristas() {
        if (motoristas.isEmpty()) {
            System.out.println("Nenhum motorista cadastrado.");
        } else {
            System.out.println("Lista de Motoristas:");
            for (Motorista motorista : motoristas) {
                System.out.println(motorista);
            }
        }
    }
}
