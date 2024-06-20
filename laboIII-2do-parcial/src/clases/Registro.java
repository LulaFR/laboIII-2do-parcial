package clases;

public class Registro {
    private String id;
    private Double temperature;

    //CONSTRUCTORS
    public Registro() {
    }

    public Registro(String id, Double temperature) {
        this.id = id;
        this.temperature = temperature;
    }

    //G&S
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id='" + id + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
