import java.util.ArrayList;
import java.util.List;

public class Numbers {
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
