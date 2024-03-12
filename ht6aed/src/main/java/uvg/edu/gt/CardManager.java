package uvg.edu.gt;

import java.io.*;
import java.util.*;

public class CardManager {
    private Map<String, Card> availableCards = new HashMap<>();
    private Map<String, Integer> userCollection = new HashMap<>();

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

    public void setAvailableCards(Map<String, Card> newAvailableCards) {
        this.availableCards = newAvailableCards;
    }
    
    public void addCardToUserCollection(String cardName) {
        if (availableCards.containsKey(cardName)) {
            userCollection.put(cardName, userCollection.getOrDefault(cardName, 0) + 1);
            System.out.println("Carta agregada a la colección.");
        } else {
            System.out.println("La carta no existe en las cartas disponibles.");
        }
    }

    public void listAllAvailableCards() {
        if (availableCards.isEmpty()) {
            System.out.println("No hay cartas disponibles.");
            return;
        }
        availableCards.forEach((name, card) -> System.out.println(card));
    }

    public void listCardsByType(String type) {
        availableCards.values().stream()
                .filter(card -> card.getType().equalsIgnoreCase(type))
                .forEach(System.out::println);
    }

    public void saveUserCollectionToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : userCollection.entrySet()) {
                writer.write(entry.getKey() + "|" + entry.getValue());
                writer.newLine();
            }
        }
    }

    public void showUserCollection() {
        if (userCollection.isEmpty()) {
            System.out.println("La colección del usuario está vacía.");
            return;
        }
        userCollection.forEach((name, count) -> System.out.println("Nombre: " + name + ", Cantidad: " + count));
    }

    // Método para mostrar el nombre, tipo y cantidad de cada carta en la colección del usuario, ordenadas por tipo
    public void showCardType(String cardName) {
        Card card = availableCards.get(cardName);
        if (card != null) {
            System.out.println("El tipo de '" + cardName + "' es: " + card.getType());
        } else {
            System.out.println("La carta '" + cardName + "' no existe en las cartas disponibles.");
        }
    }
    
    // Método para mostrar el nombre, tipo y cantidad de cada carta en la colección del usuario, ordenadas por tipo
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
    
    // Método para mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo
    public void listAllCardsOrderedByType() {
        availableCards.values().stream()
                .sorted(Comparator.comparing(Card::getType).thenComparing(Card::getName))
                .forEach(card -> System.out.println("Nombre: " + card.getName() + ", Tipo: " + card.getType()));
    }
    
}

