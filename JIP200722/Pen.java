public class Pen {
    public void drawRectangle(Rectangle rectangle) {
        System.out.println("Area:" + rectangle.height * rectangle.width);
    }

    public void drawCircle(Circle circle) {
        System.out.println("Area:" + Math.PI * Math.pow(circle.radius, 2));
    }

    public void changeColorRectangle(String color, Rectangle rectangle) {
        rectangle.color = color;
        System.out.println("Current Color:" + color);

    }

    public void changeColorCircle(String color, Circle circle) {
        circle.color = color;
        System.out.println("Current Color:" + color);
    }
}
