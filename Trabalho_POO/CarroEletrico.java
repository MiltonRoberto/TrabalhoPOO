public class CarroEletrico {
    protected String id;
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double bateria; // Capacidade da bateria em kWh
    protected double autonomiaAtual; // Autonomia atual em km

    public CarroEletrico(String id, String marca, String modelo, int ano, double bateria, double autonomiaAtual) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.bateria = bateria;
        this.autonomiaAtual = autonomiaAtual;
    }

    public String getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getBateria() {
        return bateria;
    }

    public double getAutonomiaAtual() {
        return autonomiaAtual;
    }

    // Método para definir a autonomia atual
    public void setAutonomiaAtual(double autonomiaAtual) {
        this.autonomiaAtual = autonomiaAtual;
    }
}
