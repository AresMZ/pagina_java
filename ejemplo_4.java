import java.io.*;

public class FileUploadServlet {
    public void uploadFile(String fileName, InputStream fileContent) {
        try {
            OutputStream outputStream = new FileOutputStream(new File("/uploads/" + fileName));
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            fileContent.close();
            System.out.println("File uploaded successfully");
        } catch (IOException e) {
            System.out.println("Error uploading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FileUploadServlet servlet = new FileUploadServlet();
        try {
            // Simulación de subida de archivo
            InputStream fileContent = new FileInputStream(new File("archivo_malicioso.txt"));
            servlet.uploadFile("archivo_malicioso.txt", fileContent);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}