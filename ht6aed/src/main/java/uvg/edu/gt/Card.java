package uvg.edu.gt;

/**
 * Representa una carta con un nombre y un tipo específicos.
 * La clase {@code Card} modela cartas que pueden ser de diferentes tipos, como monstruo, trampa o hechizo,
 * cada una con su propio nombre único.
 */
public class Card {
    private String name; // Nombre de la carta
    private String type; // Tipo de la carta (monstruo, trampa, hechizo)

    /**
     * Construye una nueva carta con el nombre y tipo especificados.
     * 
     * @param name El nombre de la carta, que identifica a la carta de forma única.
     * @param type El tipo de la carta, que puede ser "monstruo", "trampa" o "hechizo".
     */
    public Card(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Devuelve el nombre de la carta.
     * 
     * @return El nombre de la carta.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece un nuevo nombre para la carta.
     * 
     * @param name El nuevo nombre de la carta.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el tipo de la carta.
     * 
     * @return El tipo de la carta.
     */
    public String getType() {
        return type;
    }

    /**
     * Establece un nuevo tipo para la carta.
     * 
     * @param type El nuevo tipo de la carta, que puede ser "monstruo", "trampa" o "hechizo".
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Devuelve una representación en cadena de la carta, incluyendo su nombre y tipo.
     * 
     * @return Una cadena que representa la carta, incluyendo su nombre y tipo.
     */
    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

