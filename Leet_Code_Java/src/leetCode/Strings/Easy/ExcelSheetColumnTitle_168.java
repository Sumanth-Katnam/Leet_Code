package leetCode.Strings.Easy;

public class ExcelSheetColumnTitle_168 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        int temp = columnNumber;
        while(--temp >= 0){
            result.append((char) ('A' + temp % 26));
            temp = temp/26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
