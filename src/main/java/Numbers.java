import java.util.ArrayList;
import java.util.List;

public class Numbers {

    public String Converttoroman(int number){
        String ret = "";
        final int[] conversionListNumbers = {
                1000,
                900,
                500,
                400,
                100,
                90,
                50,
                40,
                10,
                9,
                5,
                4,
                1
        };
        final String[] conversionListletters = {
                "M",
                "CM",
                "D",
                "CD",
                "C",
                "XC",
                "L",
                "XL",
                "X",
                "IX",
                "V",
                "IV",
                "I"
        };

        int index = 0;
        while(number > 0){
            while(number >= conversionListNumbers[index]){
                ret += conversionListletters[index];
                number -= conversionListNumbers[index];
            }
            index += 1;
        }

        return ret;
    }

    public int max(int a, int b){
        if(a >= b){
            return a;
        }else{
            return b;
        }
    }
    public int min(int a, int b){
        if(a <= b){
            return a;
        }else{
            return b;
        }
    }
    public int max(int a, int b, int c){
        int ab = max(a, b);
        return max(ab, c);
    }
    public int min(int a, int b, int c){
        int ab = min(a, b);
        return min(ab, c);
    }

    public int maxnth(ArrayList<Integer> numbers){
        if(numbers.size() == 1){
            return numbers.get(0);
        }
        if(numbers.size() == 0){
            return 0;
        }

        int tmp = max(numbers.get(0), numbers.get(1));
        for(int i = 2; i < numbers.size();i++){
            tmp = max(tmp, numbers.get(i));
        }
        return tmp;
    }
}
