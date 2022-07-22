abstract class Shape {
    private String color;

    abstract void draw();

    abstract void changeColor(String color);

    protected String getColor() {
        return color;
    }

    protected void setColor(String color) {
        this.color = color;
    }
}
