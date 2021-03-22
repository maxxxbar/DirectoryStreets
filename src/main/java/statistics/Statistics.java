package statistics;

import entities.Item;

import java.util.Map;

public interface Statistics {
    Map<String, Map<Integer, Integer>> getStatistics();
}
