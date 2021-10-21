public class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle(int x, int y, int height, int width){
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public void changeDimension(int newHeight, int newWidth){
        this.width = newWidth;
        this.height = newHeight;
    }

    @Override
    public int getPerimeter() {
        return 2*(width+height);
    }

    @Override
    public int getArea() {
        return height*width;
    }
}
