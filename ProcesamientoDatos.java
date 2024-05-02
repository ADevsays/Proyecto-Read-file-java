import java.io.*;
// import java.net.Socket;
// import java.nio.charset.StandardCharsets;

public class ProcesamientoDatos {
    public static void main(String[] args) {
        String carpetaOrigen = "./archivos";
        String carpetaDestino = "./archivosGenerados";
        File carpeta = new File(carpetaOrigen);
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                System.out.println("Leyendo archivos");
                procesarArchivo(archivo, carpetaDestino);
            }
        } else {
            System.out.println("La carpeta ya no tiene mas archivos");
        }
    }

    private static void procesarArchivo(File archivoOrigen, String carpetaDestino) {
        // Integer puerto_servidor = 3000;
        // String host = "http://localhost";
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoOrigen))) {
            String nombreArchivo = archivoOrigen.getName();
            File archivoDestino = new File(carpetaDestino, "copia_" + nombreArchivo);

            if (!archivoDestino.getParentFile().exists()) {
                archivoDestino.getParentFile().mkdir();
            }

            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoDestino))) {
                // Socket socket = new Socket(host, puerto_servidor);
                // BufferedWriter escritor = new BufferedWriter(new
                // OutputStreamWriter(socket.getOutputStream()))) {

                String linea;
                while ((linea = lector.readLine()) != null) {
                    String folio = extraerFolio(linea);
                    escritor.write(folio);
                    escritor.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extraerFolio(String linea) {
        return linea.split(",")[0];
    }
}
