public class Square extends Shape{
    private int size;

    public Square(int x, int y, int size){
        super(x,y);
        this.size = size;
    }

    @Override
    public int getPerimeter() {
        return 4*size;
    }

    @Override
    public int getArea() {
        return (int) Math.pow(size,2);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
