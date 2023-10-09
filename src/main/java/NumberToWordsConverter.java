
public class NumberToWordsConverter {

    private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };

    private static final String[] teens = {
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] thousands = {"", "Thousand", "Million", "Billion", "Trillion"};

    public static String convertToWords(long number) {
        if (number == 0) {
            return "Zero";
        }

        String words = "";
        int index = 0;

        while (number > 0) {
            if (number % 1000 != 0) {
                words = convertChunkToWords((int)(number % 1000)) + thousands[index] + " " + words;
            }

            number /= 1000;
            index++;
        }

        return words.trim();
    }

    private static String convertChunkToWords(int number) {
        if (number == 0) {
            return "";
        } else if (number < 10) {
            return units[number] + " ";
        } else if (number < 20) {
            return teens[number - 10] + " ";
        } else if (number < 100) {
            return tens[number / 10] + " " + convertChunkToWords(number % 10);
        } else {
            return units[number / 100] + " Hundred " + convertChunkToWords(number % 100);
        }
    }

    public static void main(String[] args) {
//        long number = 1234567890112L;
        float floatValue = 1234.5678f;
        long longValue = (long) floatValue;
        long number = 1230;
        String words = convertToWords(longValue);
        System.out.println(number + " in words: " + words);
    }
}
