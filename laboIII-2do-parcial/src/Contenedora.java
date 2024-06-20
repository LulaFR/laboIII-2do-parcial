import clases.Person;
import clases.Registro;
import clases.TestResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Contenedora {
    private Integer test;
    private Set<Person> people = new LinkedHashSet<>();
    private Map<Integer, Registro> chart = new HashMap<>();
    private TestResult testResult = new TestResult();

    public Contenedora(Integer test) {
        this.test = test;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public Map<Integer, Registro> getChart() {
        return chart;
    }

    public void setChart(Map<Integer, Registro> chart) {
        this.chart = chart;
    }

    public void addPerson(Person p) {
        if (personExists(p) == false) { //Si la persona no está en el set
            if (verifyKit(p) == true) { //Si la persona tiene kit
                people.add(p); //Se agrega a la persona al set
            }
        } else {
            System.out.println("Esta persona ya se encuentra registrada: " + p);
        }

    }

    private Boolean verifyKit(Person p) {
        Random random = new Random();
        Integer option;
        if (p.getKit() == null) { //Si la persona no tiene un kit asignado
            try {
                Verification.areThereTests(test); //Se verifica q queden tests
                assignKit(p);

            } catch (RuntimeException e) { //No quedan tests
                System.out.println(e.getMessage());
                System.out.println("Agregar tests"); //Se pregunta si se agregan más tests
                System.out.println("1. Sí");
                System.out.println("2. No");
                do {
                    System.out.print(">");
                    option = 1;
                    //option = random.nextInt(1, 2);
                } while (option != 1 && option != 2);

                if (option == 1) { //Se agregan tests
                    setTest(10);
                    System.out.println("Tests agregados");
                    verifyKit(p);
                } else {
                    return false; //No se agregan tests y no se puede agregar a la persona
                }
            }
        }
        return true;
    }

    public void assignKit(Person p) {
        Random random = new Random();
        p.setKit(random.nextInt(1, 1000)); //Se le asigna un kit a la persona
        setTest(getTest() - 1); //Se reduce el número de tests
    }

    private boolean personExists(Person newP) {
        for (Person p : people) {
            if (newP.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public void showPeopleList() {
        System.out.println("--Lista de personas--");
        for (Person p : people) {
            System.out.println(p);
        }
    }

    public void test() {
        Random random = new Random();
        for (Person p : people) {
            chart.put(p.getKit(), new Registro(p.getId(), random.nextDouble(36, 39)));
        }
    }

    public void isolate() throws IOException {
        for (Map.Entry<Integer, Registro> entry : chart.entrySet()) {
            Person p = search(entry.getValue().getId()); //Busco a la persona
            try {
                Verification.numberExceeds(entry.getValue().getTemperature()); //Chequeo la temperatura
                testResult.getHealthy().add(p);
            } catch (RuntimeException e) { //Excede la temperatura
                testResult.getIsolated().add(entry.getValue());
                String neighbourhood = p.getNeighbourhood(); //Obtengo el barrio de la persona
                System.out.println("Kit " + entry.getKey() + " | Barrio: " + neighbourhood); //Leyenda
                saveIsolatedInFile(entry.getKey(), entry.getValue().getTemperature(), neighbourhood); //Guardo en archivo
            }
        }
        //serialize(TestResult.getHealthy(), TestResult.getIsolated()); //Guardo con JSON
        serialize();
    }

    public Person search(String id) {
        for (Person p : people) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void saveIsolatedInFile(Integer kit, Double temperature, String neighbourhood) throws IOException {
        File file = new File("urgente.dat");

        if (!file.exists()) { //Corroboro que el archivo exista
            file.createNewFile(); //Si no existe, lo creo
        }

        BufferedWriter b = new BufferedWriter(new FileWriter(file));

        //Paso la información a un string
        String s = "Kit: " + kit + " | Temperatura: " + temperature + " grados | Barrio: " + neighbourhood;

        //Escribo y cierro el archivo
        b.write(s);
        b.close();
    }

    private void serialize() throws IOException {
        File file = new File("archivo.json");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, testResult);
    }
}
