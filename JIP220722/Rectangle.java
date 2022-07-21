public class Rectangle extends Shape{
    private int height;
    private int width;
    Rectangle(int height,int width,String color){
        this.height=height;
        this.width=width;
        this.setColor(color);
    }

    @Override
    void draw() {
        System.out.println("Rectangle Area:"+height*width);
    }
    @Override
    void changeColor(String color) {
        String old=this.getColor();
        this.setColor(color);;
        System.out.println("Rectangle,Old Color:"+old+" New Color:"+this.getColor());
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
