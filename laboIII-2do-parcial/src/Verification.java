public class Verification {
    public static void areThereTests(Integer test) {
        if (test == 0) {
            throw new RuntimeException("No quedan tests");
        }
    }

    public static void numberExceeds (Double x) {
        if (x >= 38) {
            throw new RuntimeException("Valor superado");
        }
    }
}
