package uvg.edu.gt;

public class Card {
    private String name; // Nombre de la carta
    private String type; // Tipo de la carta (monstruo, trampa, hechizo)

    // Constructor que acepta el nombre y tipo de la carta
    public Card(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Getter para el nombre de la carta
    public String getName() {
        return name;
    }

    // Setter para el nombre de la carta
    public void setName(String name) {
        this.name = name;
    }

    // Getter para el tipo de la carta
    public String getType() {
        return type;
    }

    // Setter para el tipo de la carta
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
