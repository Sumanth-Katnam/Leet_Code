package leetCode.ArrayAndHashing.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights_846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (int card: hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);

        for (int i : hand) {
            if (freq.get(i) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {
                int currCard = i + j;
                if (freq.getOrDefault(currCard, 0) == 0) {
                    return false;
                }

                freq.put(currCard, freq.get(currCard) - 1);
            }
        }

        return true;
    }
}
