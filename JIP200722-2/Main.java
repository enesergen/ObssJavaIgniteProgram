public class Main {
    public static void main(String[] args) {
        Bus bus1=new Bus(5,Destination.MALATYA);
        Passenger passenger1=new Passenger("Ahmet",Destination.MALATYA);
        Passenger passenger2=new Passenger("Ali",Destination.MALATYA);
        Passenger passenger3=new Passenger("Cansu",Destination.MALATYA);
        Passenger passenger4=new Passenger("Murat",Destination.MALATYA);
        Passenger passenger5=new Passenger("Beyza",Destination.MALATYA);
        Passenger passenger6=new Passenger("Kuzey",Destination.MALATYA);
        System.out.println("-------------------------------------------------");
        bus1.insertPassenger(passenger1);
        bus1.insertPassenger(passenger2);
        bus1.insertPassenger(passenger3);
        bus1.insertPassenger(passenger4);
        bus1.insertPassenger(passenger5);
        bus1.insertPassenger(passenger6);

        Bus bus2=new Bus(4,Destination.ANKARA);
        Passenger p1=new Passenger("Asim",Destination.ISTANBUL);
        Passenger p2=new Passenger("Hakan",Destination.ANKARA);
        Passenger p3=new Passenger("Kerim",Destination.MALATYA);
        Passenger p4=new Passenger("Ercan",Destination.ANKARA);
        Passenger p5=new Passenger("Emre",Destination.ISTANBUL);
        Passenger p6=new Passenger("Gizem",Destination.ANKARA);
        Passenger p7=new Passenger("Aycan",Destination.ANKARA);
        Passenger p8=new Passenger("Kutay",Destination.ANKARA);
        Passenger p9=new Passenger("Kutay",Destination.ANKARA);


        bus2.insertPassenger(p1);
        bus2.insertPassenger(p2);
        bus2.insertPassenger(p3);
        bus2.insertPassenger(p4);
        bus2.insertPassenger(p5);
        bus2.insertPassenger(p6);
        bus2.insertPassenger(p7);
        bus2.insertPassenger(p8);
        bus2.insertPassenger(p9);

    }
}
