package clases;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    private List<Person> healthy = new ArrayList<>();
    private List<Registro> isolated = new ArrayList<>();

    public TestResult() {
    }

    public List<Person> getHealthy() {
        return healthy;
    }

    public void setHealthy(List<Person> healthy) {
        this.healthy = healthy;
    }

    public List<Registro> getIsolated() {
        return isolated;
    }

    public void setIsolated(List<Registro> isolated) {
        this.isolated = isolated;
    }
}
