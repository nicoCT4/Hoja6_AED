package uvg.edu.gt;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implementación de la interfaz {@code MapFactory} que permite la creación de diferentes tipos de mapas.
 * Esta clase soporta la creación de {@code HashMap}, {@code TreeMap} y {@code LinkedHashMap},
 * devolviendo la instancia correspondiente basada en un tipo de mapa especificado por el usuario.
 */
public class MapFactoryImpl implements MapFactory {
    
    /**
     * Devuelve una instancia de un mapa basada en el tipo especificado.
     * Los tipos de mapas soportados incluyen "HashMap", "TreeMap" y "LinkedHashMap".
     * 
     * @param mapType El tipo de mapa que se desea crear. El tipo de mapa es sensible a mayúsculas
     *                y debe coincidir exactamente con uno de los tipos soportados.
     * @return Un nuevo mapa del tipo especificado que asocia cadenas con objetos de tipo Card.
     * @throws IllegalArgumentException Si el tipo de mapa proporcionado no es válido o no está soportado.
     */
    @Override
    public Map<String, Card> getMap(String mapType) {
        switch (mapType) {
            case "HashMap":
                return new HashMap<>();
            case "TreeMap":
                return new TreeMap<>();
            case "LinkedHashMap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Invalid map type: " + mapType);
        }
    }
}

