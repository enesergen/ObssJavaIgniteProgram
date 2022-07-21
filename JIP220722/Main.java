public class Main {
    public static void main(String[] args) {
    Pen p1=new Pen(new Circle(2,"Blue"));
    Pen p2=new Pen(new Rectangle(3,4,"Yellow"));
    p1.draw();
    p2.draw();
    p1.changeColor("Pink");
    p2.changeColor("Green");
    }
}
