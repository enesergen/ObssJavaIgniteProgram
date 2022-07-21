public class Main {
    public static void main(String[] args) {

        Pen pen = new Pen();
        pen.drawCircle(new Circle(3, "Blue"));
        pen.changeColorCircle("Green", new Circle(4, "Red"));

        pen.drawRectangle(new Rectangle(4, 5, "Pink"));
        pen.changeColorRectangle("Blue", new Rectangle(4, 5, "Pink"));


    }
}
