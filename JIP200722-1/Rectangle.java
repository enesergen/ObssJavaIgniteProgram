public class Rectangle extends Shape{
    int height;
    int width;

    public Rectangle(int height, int width,String color) {
        this.color=color;
        this.height = height;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return height*width;
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
