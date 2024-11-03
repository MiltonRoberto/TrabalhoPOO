import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<CarroEletrico> frota;
    private List<Eletroposto> eletropostos;

    public Main() {
        frota = new ArrayList<>();
        eletropostos = new ArrayList<>();
    }

    public void adicionarCarro(CarroEletrico carro) {
        frota.add(carro);
        System.out.println("Carro adicionado com sucesso!");
    }

    public void removerCarro(String id) {
        CarroEletrico carroParaRemover = null;
        for (CarroEletrico carro : frota) {
            if (carro.getId().equals(id)) {
                carroParaRemover = carro;
                break;
            }
        }

        if (carroParaRemover != null) {
            frota.remove(carroParaRemover);
            System.out.println("Carro removido com sucesso!");
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    public void exibirCarrosDisponiveis() {
        System.out.println("Carros Disponíveis:");
        for (CarroEletrico carro : frota) {
            System.out.println("ID: " + carro.getId() + ", Marca: " + carro.getMarca() + ", Modelo: " + carro.getModelo() +
                    ", Ano: " + carro.getAno() + ", Autonomia de: " + carro.getAutonomiaAtual() + " km, " +
                    "Capacidade: " + carro.getBateria() + " kWh");
        }
    }

    public void adicionarCarroDoUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de carro:");
        System.out.println("1. Compacto");
        System.out.println("2. Sedan");
        System.out.println("3. SUV");
        int tipoCarro = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        System.out.print("Informe o ID do carro: ");
        String id = scanner.nextLine();

        System.out.print("Informe a marca do carro: ");
        String marca = scanner.nextLine();

        System.out.print("Informe o modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("Informe o ano do carro: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Informe a capacidade da bateria em kWh: ");
        double bateria = Double.parseDouble(scanner.nextLine());

        CarroEletrico carro;
        switch (tipoCarro) {
            case 1:
                carro = new CarroCompacto(id, marca, modelo, ano, bateria);
                break;
            case 2:
                carro = new CarroSedan(id, marca, modelo, ano, bateria);
                break;
            case 3:
                carro = new CarroSuv(id, marca, modelo, ano, bateria);
                break;
            default:
                System.out.println("Tipo de carro inválido!");
                return;
        }

        adicionarCarro(carro);
    }

    public void exibirEletropostos() {
        System.out.println("Eletropostos Disponíveis:");
        for (Eletroposto eletroposto : eletropostos) {
            System.out.println("ID: " + eletroposto.getId() + ", Local: " + eletroposto.getLocal() +
                    ", Vagas: " + eletroposto.getVagasDisponiveis() + ", Tempo Médio de Carga: " + eletroposto.getTempoMedioCarga() + " horas");
        }
    }

    public void exibirDistanciaEletropostos() {
        System.out.println("Distância até Eletropostos:");
        for (Eletroposto eletroposto : eletropostos) {
            double distancia = calcularDistancia(eletroposto); // Método fictício para calcular distância
            System.out.println("Eletroposto ID: " + eletroposto.getId() + ", Distância: " + distancia + " km");
        }
    }

    private double calcularDistancia(Eletroposto eletroposto) {
        return 0; // Placeholder, substitua pela lógica real
    }

    public void adicionarEletropostoDoUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID do eletroposto: ");
        String id = scanner.nextLine();

        System.out.print("Informe o local do eletroposto: ");
        String local = scanner.nextLine();

        System.out.print("Informe o número de vagas disponíveis: ");
        int vagas = Integer.parseInt(scanner.nextLine());

        System.out.print("Informe o tempo médio de carga em horas: ");
        double tempoCarga = Double.parseDouble(scanner.nextLine());

        Eletroposto eletroposto = new Eletroposto(id, local, vagas, tempoCarga);
        eletropostos.add(eletroposto);
        System.out.println("Eletroposto adicionado com sucesso!");
    }

    public void realizarViagem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID do carro que deseja utilizar: ");
        String idCarro = scanner.nextLine();

        CarroEletrico carro = null;
        for (CarroEletrico c : frota) {
            if (c.getId().equals(idCarro)) {
                carro = c;
                break;
            }
        }

        if (carro == null) {
            System.out.println("Carro não encontrado.");
            return;
        }

        System.out.print("Informe a distância da viagem em km: ");
        try {
            double distancia = Double.parseDouble(scanner.nextLine());

            if (carro.getAutonomiaAtual() >= distancia) {
                carro.setAutonomiaAtual(carro.getAutonomiaAtual() - distancia);
                System.out.println("Viagem realizada com sucesso! Autonomia atual do carro: " + carro.getAutonomiaAtual() + " km.");
            } else {
                System.out.println("Erro: Autonomia insuficiente para realizar a viagem.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: entrada inválida. Por favor, insira uma distância válida.");
        }
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Ver Carros Disponíveis");
            System.out.println("2. Adicionar Carro");
            System.out.println("3. Remover Carro");
            System.out.println("4. Ver Eletropostos");
            System.out.println("5. Adicionar Eletroposto");
            System.out.println("6. Ver Distância dos Eletropostos");
            System.out.println("7. Realizar Viagem");
            System.out.println("8. Cadastrar Motorista");
            System.out.println("9. Listar Motoristas");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    sistema.exibirCarrosDisponiveis();
                    break;
                case 2:
                    sistema.adicionarCarroDoUsuario();
                    break;
                case 3:
                    System.out.print("Informe o ID do carro a ser removido: ");
                    String id = scanner.nextLine();
                    sistema.removerCarro(id);
                    break;
                case 4:
                    sistema.exibirEletropostos();
                    break;
                case 5:
                    sistema.adicionarEletropostoDoUsuario();
                    break;
                case 6:
                    sistema.exibirDistanciaEletropostos();
                    break;
                case 7:
                    sistema.realizarViagem();
                    break;
                case 8:
                    Motorista.cadastrarMotorista();
                    break;
                case 9:
                    Motorista.listarMotoristas();
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 10);

        scanner.close();
    }
}
