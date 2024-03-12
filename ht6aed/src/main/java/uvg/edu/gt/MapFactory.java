package uvg.edu.gt;

import java.util.Map;

public interface MapFactory {
    Map<String, Card> getMap(String mapType);
}
