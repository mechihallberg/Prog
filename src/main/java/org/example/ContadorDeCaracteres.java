package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class ContadorDeCaracteres {

    public static void main(String[] args) {
        // Texto fijo
        String texto = "Queridos amigos y compatriotas, Hoy nos reunimos en un momento crucial de nuestra historia. Nos enfrentamos a desafíos que ponen a prueba no solo nuestra resistencia, sino también nuestra unidad. En tiempos de división, debemos recordar lo que nos une: nuestros valores compartidos, nuestra esperanza en un futuro mejor y nuestra determinación para lograrlo. No podemos ignorar las dificultades que enfrentamos. Desde la desigualdad económica hasta el cambio climático, nuestras comunidades sienten el peso de la incertidumbre. Pero en cada desafío hay una oportunidad. Una oportunidad para innovar, para unirnos y para construir un mundo en el que todos tengamos la oportunidad de prosperar. Les pido que trabajemos juntos. No como partidos ni como grupos, sino como una sola comunidad. Debemos escuchar a aquellos que son diferentes a nosotros, aprender de sus experiencias y encontrar soluciones que beneficien a todos. La educación es la clave para el cambio. Necesitamos invertir en nuestras escuelas, asegurándonos de que cada niño, sin importar su origen, tenga acceso a una educación de calidad. Porque cuando educamos a nuestros jóvenes, les damos las herramientas para cambiar el mundo. También debemos cuidar de nuestro planeta. Las generaciones futuras dependen de nuestras acciones hoy. Implementemos políticas que promuevan energías limpias y sostenibles, protegiendo así el hogar que todos compartimos. Y, sobre todo, nunca debemos perder de vista la importancia de la empatía. En un mundo que a menudo parece frío y dividido, el amor y la compasión deben ser nuestras guías. Hoy, les invito a soñar juntos. A soñar con un futuro en el que la igualdad, la justicia y la paz sean realidades, no solo palabras. Juntos, podemos hacer de este sueño una realidad. Gracias.";;

        // Llamar a la función que cuenta los caracteres en todas las palabras
        Map<Integer, ArrayList<String>> resultado = contarPalabrasPorLongitud(texto);

        // Encontrar la longitud máxima
        int maxLength = 0;
        for (int length : resultado.keySet()) {
            if (length > maxLength) {
                maxLength = length;
            }
        }

        // Mostrar el conteo de palabras y las palabras de la longitud máxima
        System.out.println("Conteo de palabras por longitud:");
        for (Map.Entry<Integer, ArrayList<String>> entry : resultado.entrySet()) {
            System.out.println("Cantidad de palabras con " + entry.getKey() + " caracteres: " + entry.getValue().size());
        }

        // Mostrar palabras de la longitud máxima
        System.out.println("\nPalabras con " + maxLength + " caracteres:");
        System.out.println(resultado.get(maxLength));
    }

    private static Map<Integer, ArrayList<String>> contarPalabrasPorLongitud(String texto) {
        // Crear una expresión regular para encontrar todas las palabras
        String regex = "\\b\\w+\\b"; // Busca todas las palabras
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        Map<Integer, ArrayList<String>> contador = new HashMap<>();

        while (matcher.find()) {
            String palabra = matcher.group();
            int length = palabra.length();

            // Agregar la palabra a la lista correspondiente a su longitud
            contador.putIfAbsent(length, new ArrayList<>());
            contador.get(length).add(palabra);
        }

        return contador;
    }
}