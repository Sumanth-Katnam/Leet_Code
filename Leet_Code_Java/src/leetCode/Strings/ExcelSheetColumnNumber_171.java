package leetCode.Strings;

public class ExcelSheetColumnNumber_171 {
    public static int titleToNumber(String columnTitle) {
        StringBuilder title = new StringBuilder(columnTitle).reverse();
        int result = 0;
        for(int i = 0; i < title.length(); i++){
            result = (int) (result + Math.pow(26, i) * ((int) title.charAt(i) - (int) 'A' + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }
}

