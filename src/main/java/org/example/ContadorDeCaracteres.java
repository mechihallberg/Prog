package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class ContadorDeCaracteres {

    public static void main(String[] args) {
        // Crear un objeto Scanner para recibir entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese el texto
        System.out.println("Por favor, ingresa el texto:");
        String texto = scanner.nextLine();

        // Contar las frases y las palabras en cada una
        contarFrasesYPalabras(texto);

        // Cerrar el scanner
        scanner.close();
    }

    private static void contarFrasesYPalabras(String texto) {
        // Crear una expresión regular para encontrar todas las frases
        String fraseRegex = "(?<=\\.\\s|^)([A-Z].*?)(?=\\.)"; // Busca frases que empiezan con mayúscula y terminan en punto
        Pattern frasePattern = Pattern.compile(fraseRegex);
        Matcher fraseMatcher = frasePattern.matcher(texto);

        int totalLetras = 0;
        Map<String, Integer> frasePalabrasMap = new HashMap<>(); // HashMap para almacenar frases y su conteo de palabras

        while (fraseMatcher.find()) {
            String frase = fraseMatcher.group();
            int palabrasCount = contarPalabras(frase);
            int letrasCount = contarLetras(frase);

            totalLetras += letrasCount;
            frasePalabrasMap.put(frase, palabrasCount); // Almacenar la frase y su conteo de palabras

            // Mostrar el resultado para cada frase
            System.out.printf("En la frase \"%s\" hay %d palabras de %d letras.%n", frase, palabrasCount, letrasCount);
        }

        // Mostrar el total de letras en todo el texto
        System.out.println("Total de letras en el texto: " + totalLetras);

        // Mostrar el contenido del HashMap (frases y conteo de palabras)
        System.out.println("\nConteo de palabras por frase:");
        for (Map.Entry<String, Integer> entry : frasePalabrasMap.entrySet()) {
            System.out.printf("Frase: \"%s\" - Palabras: %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static int contarPalabras(String frase) {
        // Crear una expresión regular para encontrar todas las palabras
        String regex = "\\b\\w+\\b"; // Busca todas las palabras
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(frase);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static int contarLetras(String frase) {
        return frase.replaceAll("\\s+", "").length(); // Cuenta las letras eliminando espacios
    }
}