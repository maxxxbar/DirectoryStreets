package utils;

import entities.Item;
import org.jetbrains.annotations.NotNull;
import statistics.Statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HousesStatistics implements Statistics {
    private static final int MAX_FLOOR = 5;
    private static final int MIN_FLOOR = 1;

    private final Set<Item> itemSet;
    private Map<String, Map<Integer, Integer>> numberOfStoreys;

    public HousesStatistics(Set<Item> itemSet) {
        this.itemSet = itemSet;
    }

    @Override
    public Map<String, Map<Integer, Integer>> getStatistics() {
        return createStatistics(itemSet);
    }

    private boolean maxFloorCheck(Integer floor) {
        return floor >= MIN_FLOOR && floor <= MAX_FLOOR;
    }

    private void createFirstValue(@NotNull String city, @NotNull Integer floor) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        tempMap.put(floor, 1);
        numberOfStoreys.put(city, tempMap);
    }

    private void createValue(@NotNull String city, @NotNull Integer floor) {
        Map<Integer, Integer> keyValueMap = numberOfStoreys.get(city);
        boolean containsFloor = keyValueMap.containsKey(floor);
        if (!containsFloor) {
            keyValueMap.put(floor, 1);
        } else {
            int value = keyValueMap.get(floor);
            keyValueMap.put(floor, ++value);
        }
        numberOfStoreys.put(city, keyValueMap);
    }

    private Map<String, Map<Integer, Integer>> createStatistics(@NotNull Set<Item> items) {
        numberOfStoreys = new TreeMap<>();
        items.forEach(item ->
                {
                    Integer mFloorKey = Integer.parseInt(item.getFloor());
                    String mCityKey = item.getCity();
                    if (maxFloorCheck(mFloorKey)) {
                        boolean containsCity = numberOfStoreys.containsKey(mCityKey);
                        if (!containsCity) {
                            createFirstValue(mCityKey, mFloorKey);
                        } else {
                            createValue(mCityKey, mFloorKey);
                        }
                    }
                }
        );
        return numberOfStoreys;
    }

}
