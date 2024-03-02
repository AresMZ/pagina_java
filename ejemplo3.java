import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExample {
    private static List<String> leakedData = new ArrayList<>();

    public static void main(String[] args) {
        // Simulación de agregar datos a la lista (¡esto es solo un ejemplo!)
        for (int i = 0; i < 1000000; i++) {
            String data = "Some sensitive data " + i;
            leakedData.add(data);
        }

        // No liberamos la memoria correctamente (¡esto es un error!)
        // En una aplicación real, debes liberar recursos adecuadamente.
    }
}
