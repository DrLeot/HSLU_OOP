import java.util.*;

public class Numbers {

    public int romandtointeger(String romannumber){
        int ret = 0;
        LinkedHashMap<Integer, String> romanlist = new LinkedHashMap<>();
        romanlist.put(900,"CM");
        romanlist.put(1000,"M");
        romanlist.put(400,"CD");
        romanlist.put(500,"D");
        romanlist.put(90,"XC");
        romanlist.put(100,"C");
        romanlist.put(40,"XL");
        romanlist.put(50,"L");
        romanlist.put(9,"IX");
        romanlist.put(10,"X");
        romanlist.put(4,"IV");
        romanlist.put(5,"V");
        romanlist.put(1,"I");


        for(Map.Entry<Integer, String> roman : romanlist.entrySet()){
            while(romannumber.contains(roman.getValue())){
                ret += roman.getKey();
                romannumber = romannumber.substring(roman.getValue().length());
            }
        }
        return ret;

    }

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
