import java.util.ArrayList;
import java.util.List;

public class Numbers {

    public String Converttoroman(int number){
        StringBuilder ret = new StringBuilder();
        // add thousanders
        while(number >= 1000){
            ret.append("M");
            number -= 1000;
        }
        if(number >= 500){
            ret.append("D");
            number -= 500;
        }
        if(number >= 400){
            ret.append("CD"); // romans write CD instead of CCCC
            number -= 400;
        }
        while (number >= 100){
            ret.append("C");
            number -= 100;
        }

        return ret.toString();
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
