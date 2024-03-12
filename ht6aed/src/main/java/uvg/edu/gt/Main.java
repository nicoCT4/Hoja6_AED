package uvg.edu.gt;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardManager cardManager = new CardManager();
        MapFactory mapFactory = new MapFactoryImpl();

        // Seleccionar la implementación de MAP mediante el patrón Factory
        System.out.println("Seleccione la implementación del MAP:\n1) HashMap\n2) TreeMap\n3) LinkedHashMap");
        String mapChoice = scanner.nextLine();
        switch (mapChoice) {
            case "1":
                cardManager.setAvailableCards(mapFactory.getMap("HashMap"));
                break;
            case "2":
                cardManager.setAvailableCards(mapFactory.getMap("TreeMap"));
                break;
            case "3":
                cardManager.setAvailableCards(mapFactory.getMap("LinkedHashMap"));
                break;
            default:
                System.out.println("Opción no válida. Usando HashMap por defecto.");
                cardManager.setAvailableCards(mapFactory.getMap("HashMap"));
        }

        // Cargar cartas desde el archivo
        try {
            cardManager.loadCardsFromFile("C:\\Users\\nicol\\OneDrive\\Documents\\UVG\\Tercer Semestre\\Algoritmos y Estructura de Datos\\HT6_AED\\cards_desc.txt");
        } catch (IOException e) {
            System.err.println("Error al cargar las cartas: " + e.getMessage());
            return;
        }

        String userChoice;
        do {
            System.out.println("\nOperaciones disponibles:");
            System.out.println("1. Agregar una carta a la colección del usuario.");
            System.out.println("2. Mostrar el tipo de una carta específica.");
            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta en su colección.");
            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta en su colección, ordenadas por tipo.");
            System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes.");
            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.");
            System.out.println("7. Salir.");
            System.out.print("Ingrese la operación que desea realizar: ");
            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.print("Ingrese el nombre de la carta a agregar: ");
                    String cardToAdd = scanner.nextLine();
                    cardManager.addCardToUserCollection(cardToAdd);
                break;
                case "2":
                    System.out.print("Ingrese el nombre de la carta para mostrar su tipo: ");
                    String cardToShowType = scanner.nextLine();
                    cardManager.showCardType(cardToShowType);
                    break;
                case "3":
                    System.out.println("Colección del usuario:");
                    cardManager.showUserCollection();
                    break;
                case "4":
                    System.out.println("Colección del usuario, ordenada por tipo:");
                    cardManager.showUserCollectionOrderedByType();
                    break;
                case "5":
                    System.out.println("Todas las cartas disponibles:");
                    cardManager.listAllAvailableCards();
                    break;
                case "6":
                    System.out.println("Todas las cartas disponibles, ordenadas por tipo:");
                    cardManager.listAllCardsOrderedByType();
                    break;
                case "7":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (!userChoice.equals("7"));
    }
}

