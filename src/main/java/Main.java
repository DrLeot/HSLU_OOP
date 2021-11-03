public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle(1,1,5);
        Circle circl1 = new Circle(1,2,10);

        Shape shape2 = new Rectangle(1,1,5,5);

        System.out.println(((Circle) shape1).getDiameter());
    }
}
