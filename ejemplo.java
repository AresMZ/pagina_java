package ejemplo_java;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class InsecureCryptoExample {
    public static void main(String[] args) throws Exception {
        // Generamos una clave secreta (esto es solo para demostración, no es seguro)
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();

        // Creamos un cifrador
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Datos sensibles (por ejemplo, una contraseña)
        String sensitiveData = "MySecretPassword123";

        // Ciframos los datos
        byte[] encryptedData = cipher.doFinal(sensitiveData.getBytes());

        // Aquí deberíamos almacenar o transmitir los datos cifrados de manera segura
        // Pero en este ejemplo, simplemente los mostraremos
        System.out.println("Datos cifrados: " + new String(encryptedData));

        // Ahora, intentemos descifrar los datos (esto también es inseguro)
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(encryptedData);

        // Mostramos los datos descifrados
        System.out.println("Datos descifrados: " + new String(decryptedData));
    }
}


