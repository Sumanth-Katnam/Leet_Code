package leetCode.Stack.Hard;

import java.util.*;
import java.util.stream.Collectors;

public class NumberOfAtoms_726 {
    public static String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stk = new Stack<>();
        stk.add(new HashMap<>());
        int i = 0;
        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                stk.add(new HashMap<>());
            } else if (formula.charAt(i) == ')') {
                var currMap = stk.pop();

                var sb = new StringBuilder();
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    sb.append(formula.charAt(i + 1));
                    i++;
                }
                int count = sb.toString().isEmpty() ? 1 : Integer.parseInt(sb.toString());

                var prevMap = stk.peek();
                for (String elem : currMap.keySet()) {
                    prevMap.put(elem, prevMap.getOrDefault(elem, 0) + (currMap.get(elem) * count));
                }
            } else {
                var sb = new StringBuilder();
                sb.append(formula.charAt(i));

                while (i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))) {
                    sb.append(formula.charAt(i + 1));
                    i++;
                }
                String elem = sb.toString();

                sb.setLength(0);
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    sb.append(formula.charAt(i + 1));
                    i++;
                }
                int count = sb.toString().isEmpty() ? 1 : Integer.parseInt(sb.toString());

                var currMap = stk.peek();
                currMap.put(elem, currMap.getOrDefault(elem, 0) + count);
            }
            i++;
        }
        var res = new StringBuilder();
        var resMap = stk.pop();
        List<String> sortedElems = resMap.keySet().stream().sorted().toList();
        for (String elem : sortedElems) {
            String count = resMap.get(elem) == 1 ? "" : new String(String.valueOf(resMap.get(elem)));
            res.append(elem).append(count);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(countOfAtoms("H2O")); //"H2O"
    }
}
