public class Pen {


    public void drawRectangle(Rectangle rectangle) {
        System.out.println(rectangle.calculateArea());

    }

    public void drawCircle(Circle circle) {
        System.out.println(circle.calculateArea());

    }

    public void changeColorCircle(Circle circle, String color) {
        circle.setColor(color);
        printColor(color, circle);
    }

    public void changeColorRectangle(Rectangle rectangle, String color) {
        rectangle.setColor(color);
        printColor(color, rectangle);
    }

    public void printColor(String color, Object obj) {
        if (obj instanceof Rectangle) {
            System.out.println("Rectangle current color:" + color);
        } else {
            System.out.println("Circle current color:" + color);

        }
    }

}
