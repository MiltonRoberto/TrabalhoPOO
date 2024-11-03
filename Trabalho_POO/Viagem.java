import java.util.List;

public class Viagem {
    private Motorista motorista;
    private CarroEletrico carro;
    private double quilometragemPercorrida;
    private String destino;
    private List<Eletroposto> paradasParaRecarga;

    public Viagem(Motorista motorista, CarroEletrico carro, double quilometragemPercorrida, String destino) {
        this.motorista = motorista;
        this.carro = carro;
        this.quilometragemPercorrida = quilometragemPercorrida;
        this.destino = destino;
    }

    public void planejarParadasParaRecarga(List<Eletroposto> eletropostos) {
        // Implementar lógica para selecionar as paradas de recarga com base na autonomia e disponibilidade
    }

    // Getters
    public Motorista getMotorista() {
        return motorista;
    }

    public CarroEletrico getCarro() {
        return carro;
    }

    public double getQuilometragemPercorrida() {
        return quilometragemPercorrida;
    }

    public String getDestino() {
        return destino;
    }

    public List<Eletroposto> getParadasParaRecarga() {
        return paradasParaRecarga;
    }

    // Setters
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setCarro(CarroEletrico carro) {
        this.carro = carro;
    }

    public void setQuilometragemPercorrida(double quilometragemPercorrida) {
        this.quilometragemPercorrida = quilometragemPercorrida;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setParadasParaRecarga(List<Eletroposto> paradasParaRecarga) {
        this.paradasParaRecarga = paradasParaRecarga;
    }
}
