package leetCode.Extra.Medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem_1396 {
    class UndergroundSystem {
        private final Map<Integer, Pair<String, Double>> checkInMap;
        private final Map<String, Pair<Double, Integer>> avgMap;

        public UndergroundSystem() {
            checkInMap = new HashMap<>();
            avgMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair<>(stationName, (double) t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Double> checkInEntry =  checkInMap.remove(id);
            String currKey = checkInEntry.getKey() + "->" + stationName;
            double currDur = t - checkInEntry.getValue();
            Pair<Double, Integer> avgEntry = avgMap.getOrDefault(currKey, new Pair<>((double) 0, 0));
            Double avg = avgEntry.getKey();
            int trips = avgEntry.getValue() + 1;
            avgMap.put(currKey, new Pair<>((avg * (trips - 1) + currDur)/trips, trips));
        }

        public double getAverageTime(String startStation, String endStation) {
            return avgMap.get(startStation + "->" + endStation).getKey();
        }
    }
}
