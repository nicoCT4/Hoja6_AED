package uvg.edu.gt;

import java.io.*;
import java.util.*;

/**
 * Gestiona las cartas disponibles y la colección de cartas del usuario.
 * Permite cargar cartas desde un archivo, agregar cartas a la colección del usuario,
 * y mostrar las cartas disponibles y en la colección del usuario.
 */
public class CardManager {
    private Map<String, Card> availableCards = new HashMap<>();
    private Map<String, Integer> userCollection = new HashMap<>();

    /**
     * Carga cartas desde un archivo especificado.
     * El archivo debe tener el formato "nombre|tipo" en cada línea.
     *
     * @param filePath La ruta del archivo desde donde se cargarán las cartas.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public void loadCardsFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String type = parts[1].trim();
                    availableCards.put(name, new Card(name, type));
                }
            }
        }
    }

    /**
     * Establece el mapa de cartas disponibles.
     *
     * @param newAvailableCards El nuevo mapa de cartas disponibles.
     */
    public void setAvailableCards(Map<String, Card> newAvailableCards) {
        this.availableCards = newAvailableCards;
    }
    
    /**
     * Agrega una carta especificada por el nombre a la colección del usuario.
     * Muestra un mensaje indicando si la carta fue agregada o si no existe en las cartas disponibles.
     *
     * @param cardName El nombre de la carta a agregar.
     */
    public void addCardToUserCollection(String cardName) {
        if (availableCards.containsKey(cardName)) {
            userCollection.put(cardName, userCollection.getOrDefault(cardName, 0) + 1);
            System.out.println("Carta agregada a la colección.");
        } else {
            System.out.println("La carta no existe en las cartas disponibles.");
        }
    }

    /**
     * Muestra todas las cartas disponibles.
     */
    public void listAllAvailableCards() {
        if (availableCards.isEmpty()) {
            System.out.println("No hay cartas disponibles.");
            return;
        }
        availableCards.forEach((name, card) -> System.out.println(card));
    }

    /**
     * Muestra las cartas disponibles filtradas por el tipo especificado.
     *
     * @param type El tipo de cartas a mostrar.
     */
    public void listCardsByType(String type) {
        availableCards.values().stream()
                .filter(card -> card.getType().equalsIgnoreCase(type))
                .forEach(System.out::println);
    }

    /**
     * Guarda la colección de cartas del usuario en un archivo especificado.
     * El archivo tendrá el formato "nombre|cantidad" para cada carta en la colección.
     *
     * @param filePath La ruta del archivo donde se guardará la colección.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public void saveUserCollectionToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : userCollection.entrySet()) {
                writer.write(entry.getKey() + "|" + entry.getValue());
                writer.newLine();
            }
        }
    }

    /**
     * Muestra la colección de cartas del usuario.
     */
    public void showUserCollection() {
        if (userCollection.isEmpty()) {
            System.out.println("La colección del usuario está vacía.");
            return;
        }
        userCollection.forEach((name, count) -> System.out.println("Nombre: " + name + ", Cantidad: " + count));
    }

    /**
     * Muestra el tipo de una carta específica.
     *
     * @param cardName El nombre de la carta cuyo tipo se desea conocer.
     */
    public void showCardType(String cardName) {
        Card card = availableCards.get(cardName);
        if (card != null) {
            System.out.println("El tipo de '" + cardName + "' es: " + card.getType());
        } else {
            System.out.println("La carta '" + cardName + "' no existe en las cartas disponibles.");
        }
    }
    
    /**
     * Muestra la colección de cartas del usuario ordenadas por tipo.
     */
    public void showUserCollectionOrderedByType() {
        if (userCollection.isEmpty()) {
            System.out.println("La colección del usuario está vacía.");
            return;
        }
    
        userCollection.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    Card card = availableCards.get(entry.getKey());
                    if (card != null) {
                        System.out.println("Nombre: " + card.getName() + ", Tipo: " + card.getType() + ", Cantidad: " + entry.getValue());
                    }
                });
    }
    
    /**
     * Muestra todas las cartas existentes ordenadas por tipo.
     */
    public void listAllCardsOrderedByType() {
        availableCards.values().stream()
                .sorted(Comparator.comparing(Card::getType).thenComparing(Card::getName))
                .forEach(card -> System.out.println("Nombre: " + card.getName() + ", Tipo: " + card.getType()));
    }
    
}


