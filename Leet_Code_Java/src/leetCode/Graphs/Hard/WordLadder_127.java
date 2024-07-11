package leetCode.Graphs.Hard;

import java.util.*;

public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);

        Map<String, ArrayList<String>> neighbors = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                var pattern = word.substring(0, i) + "." + word.substring(i + 1);
                if (!neighbors.containsKey(pattern)) {
                    neighbors.put(pattern, new ArrayList<>());
                }
                neighbors.get(pattern).add(word);
            }
        }

        Set<String> visit = new HashSet<>();
        visit.add(beginWord);

        Deque<String> dq = new ArrayDeque<>();
        dq.add(beginWord);
        int dist = 1;
        while (!dq.isEmpty()) {
            int length = dq.size();
            for (int i = 0; i < length; i++) {
                String word = dq.pollFirst();
                if (endWord.equals(word))
                    return dist;

                for (int j = 0; j < word.length(); j++) {
                    var pattern = word.substring(0, j) + "." + word.substring(j + 1);
                    for (String neighbor : neighbors.get(pattern)) {
                        if (!visit.contains(neighbor)) {
                            visit.add(neighbor);
                            dq.add(neighbor);
                        }
                    }
                }
            }
            dist++;
        }
        return 0;
    }
}
