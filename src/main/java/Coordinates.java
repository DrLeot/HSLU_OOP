public class Coordinates {

    public String getQuadrant(int x, int y){
        if(x == 0 || y == 0){
            return "Achse";
        }
        if(x > 0 && y > 0){
            return "Quadrant I";
        }
        if(x < 0 && y > 0){
            return "Quadrant II";
        }
        if(x < 0 && y < 0){
            return "Quadrant III";
        }
        if(x > 0 && y < 0){
            return "Quadrant IV";
        }

        // if x and y are zero
        return "Ursprung";
    }
}
