public abstract class Shape {
    private int x;
    private int y;

    Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(int newX, int newY){
        this.x = newX;
        this.y = newY;
    }

    public abstract int getPerimeter();

    public abstract int getArea();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
