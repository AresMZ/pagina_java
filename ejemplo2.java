import java.util.logging.Logger;

public class SensitiveInfoLeak {
    private static final Logger logger = Logger.getLogger(SensitiveInfoLeak.class.getName());

    public static void main(String[] args) {
        String secretKey = "mySuperSecretKey123"; // Información sensible (¡no hagas esto en producción!)

        // Simulación de un error en la aplicación
        try {
            int result = 10 / 0; // División por cero (provoca una excepción)
        } catch (ArithmeticException e) {
            // Registra el error junto con la clave secreta (¡esto es un error de seguridad!)
            logger.severe("Error: " + e.getMessage() + ". Secret Key: " + secretKey);
        }
    }
}