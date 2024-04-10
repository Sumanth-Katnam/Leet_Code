package leetCode.HeapPriorityQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RevealCardsInIncreasingOrder_950 {
    public int[] deckRevealedIncreasing(int[] deck) {
//        Arrays.sort(deck);
//        int deck_len = deck.length;
//
//        Deque<Integer> dq = new ArrayDeque<>(IntStream.range(0, deck_len).boxed().toList());
//
//        int[] res = new int[deck_len];
//        Arrays.fill(res, 0);
//
//        int idx;
//        for(int num: deck){
//            idx = dq.poll();
//            res[idx] = num;
//
//            if(!dq.isEmpty())
//                dq.add(dq.poll());
//        }
//        return res;

        int N = deck.length;
        int[] result = new int[N];
        boolean skip = false;
        int indexInDeck = 0;
        int indexInResult = 0;

        Arrays.sort(deck);

        while (indexInDeck < N) {
            // There is an available gap in result
            if (result[indexInResult] == 0) {

                // Add a card to result
                if (!skip) {
                    result[indexInResult] = deck[indexInDeck];
                    indexInDeck++;
                }

                // Toggle skip to alternate between adding and skipping cards
                skip = !skip;
            }
            // Progress to next index of result array
            indexInResult = (indexInResult + 1) % N;
        }
        return result;
    }
}
