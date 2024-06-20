import clases.Person;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Contenedora c = new Contenedora(0);

        //CARGO DATOS
        c.addPerson(new Person("Luciana AFR", 20, "Un barrio", "12345678", "Ocupación"));
        c.addPerson(new Person("Lula AFR", 20, "Un barrio", "12345678", "Ocupación"));
        c.addPerson(new Person("Agostina AFR", 25, "Mismo barrio", "12345670", "Misma ocupación"));
        c.addPerson(new Person("Delfina AFR", 18, "Otra Vez Mismo barrio", "12345600", "Otra Vez Misma ocupación", 152));

        System.out.println("\n\n");
        //MUESTRO DATOS
        c.showPeopleList();

        System.out.println("\n\n");
        //MÉTODO TEST
        c.test();

        //MÉTODO ISOLATE (ARCHIVOS Y JSON)
        try {
            c.isolate();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}