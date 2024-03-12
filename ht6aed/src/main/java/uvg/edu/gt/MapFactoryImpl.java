package uvg.edu.gt;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactoryImpl implements MapFactory {
    
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
