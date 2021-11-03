public class Circle extends Shape{
    private int diameter;

    public Circle(int x, int y, int diameter){
        super(x, y);
        this.diameter = diameter;
    }

    @Override
    public int getPerimeter() {
        return (int) (diameter*Math.PI);
    }

    @Override
    public int getArea() {
        return (int) ((Math.pow(diameter/2,2)*Math.PI));
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString(){
        return "Durchmesser: "+diameter;
    }
}
