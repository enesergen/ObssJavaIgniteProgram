public class Main {
    public static void main(String[] args) {
        Pen pen = new Pen();
        pen.drawRectangle(new Rectangle(3,4,"Red"));
        pen.drawCircle(new Circle(3,"Green"));
        pen.changeColorCircle(new Circle(5,"Green"),"Blue");
        pen.changeColorRectangle(new Rectangle(8,6,"Green"),"Yellow");
    }

}
