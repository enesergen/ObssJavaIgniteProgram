public class Circle extends Shape{
    int radius;

    public Circle(int radius,String color) {
        this.color=color;
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI*radius*radius;
    }

    @Override
    void setColor(String color) {
    this.color=color;
    }

    @Override
    String getColor() {
        return color;
    }
}
