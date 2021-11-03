public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Point(Point point){
        this(point.x, point.y);
    }
    public void moveRelativePolar(double a, int r){
        // this.x =
        // this.y =
    }
    public void moveRelative(int x, int y){
        this.x += x;
        this.y = this.y + y;
    }
    public void moveRelative(Point point){
        this.x += point.x;
        this.y += point.y;
    }
    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}
