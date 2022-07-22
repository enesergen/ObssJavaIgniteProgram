public class Main {
    public static void main(String[] args) {
    Pen p1=new Pen();
    Pen p2=new Pen();
    p1.draw(new Circle(2,"Blue"));
    p2.draw(new Rectangle(3,4,"Yellow"));
    p1.changeColor(new Circle(2,"Blue"),"Pink");
    p2.changeColor(new Rectangle(3,4,"Yellow"),"Green");
    }
}
