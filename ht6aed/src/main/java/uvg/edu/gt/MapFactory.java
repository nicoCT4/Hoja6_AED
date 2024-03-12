package uvg.edu.gt;

import java.util.Map;

/**
 * Fábrica para la creación de instancias de diferentes tipos de mapas.
 * Esta interfaz define un método para obtener un mapa que asocia
 * cadenas con objetos de tipo Card, permitiendo especificar el tipo de mapa deseado.
 */
public interface MapFactory {

    /**
     * Crea y devuelve una instancia de mapa según el tipo especificado por el usuario.
     * 
     * @param mapType El tipo de mapa a ser creado. Esto puede ser, por ejemplo,
     *                "HashMap", "TreeMap", entre otros, dependiendo de las implementaciones
     *                disponibles y los requisitos especificados por el usuario.
     * @return Un mapa nuevo que asocia cadenas con objetos de tipo Card.
     */
    Map<String, Card> getMap(String mapType);
}

