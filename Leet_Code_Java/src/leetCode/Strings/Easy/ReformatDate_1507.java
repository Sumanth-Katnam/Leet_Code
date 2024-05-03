package leetCode.Strings.Easy;

import java.util.Arrays;
import java.util.Collections;

public class ReformatDate_1507 {
    public String reformatDate(String date){
        String[] monthArr = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] splitDate = date.split(" ");

//        Day
        splitDate[0] = splitDate[0].substring(0, splitDate[0].length() - 2);
        splitDate[0] = Integer.parseInt(splitDate[0]) < 10 ? "0" + splitDate[0] : splitDate[0];

//        Month
        for(int idx = 0; idx < 12; idx++){
            if(monthArr[idx].equals(splitDate[1]))
                splitDate[1] = idx + 1 < 10? "0" + (idx + 1): "" + (idx + 1);
        }
        Collections.reverse(Arrays.asList(splitDate));
        return String.join("-", splitDate);
    }
}
