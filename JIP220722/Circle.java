public class Circle extends Shape {


    private int radius;

    Circle(int radius, String color) {
        this.setColor(color);
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("Circle Area:" + Math.PI * radius * radius);
    }

    @Override
    void changeColor(String color) {
        String old = this.getColor();
        this.setColor(color);
        ;
        System.out.println("Circle,Old Color:" + old + " New Color:" + this.getColor());
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

















