public class CarroSedan extends CarroEletrico {
    public CarroSedan(String id, String marca, String modelo, int anoFabrica, double Bateria) {
        super(id, marca, modelo, anoFabrica, Bateria, 400);
    }

    public double tempoCarga() {
        return 6.0; // horas
    }
}
