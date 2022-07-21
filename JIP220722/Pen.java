public class Pen {
    private Shape shape;

    Pen() {

    }

    Pen(Shape shape) {
        this.shape = shape;
    }

    public void draw() {
        shape.draw();
    }

    public void changeColor(String color) {
        shape.changeColor(color);
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
