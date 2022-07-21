public class Bus {
    private Destination destination;
    private Passenger[] passengers;
    private int passengerCounter = 0;

    public Bus(int capacity, Destination destination) {
        if (capacity < 0 || capacity > 70) {
            System.out.println("Invalid capacity value.");
            return;
        }
        this.destination = destination;
        this.passengers = new Passenger[capacity];
    }

    public void insertPassenger(Passenger passenger) {
        if (isCorrectDestination(passenger)) {
            destinationStatusWrite(passenger);
            if (hasEmptySeat()) {
                passengers[passengerCounter] = passenger;
                insertionStatusWrite(passenger);
                passengerCounter++;

            } else {
                insertionStatusWrite(passenger);
            }
        } else {
            destinationStatusWrite(passenger);
        }
    }

    private boolean hasEmptySeat() {
        return passengerCounter < passengers.length;
    }

    private boolean isCorrectDestination(Passenger passenger) {
        return (passenger.getDestination() == this.destination);
    }

    private void insertionStatusWrite(Passenger passenger) {
        if (hasEmptySeat())
            System.out.println("Insertion is Succesfull, Passanger Name:" + passenger.getName() + "\n-------------------------------------------------");
        else
            System.out.println("Bus is full.Insertion is not succesfull." + "\n-------------------------------------------------");
    }

    private void destinationStatusWrite(Passenger passenger) {
        if (isCorrectDestination(passenger))
            System.out.println("Bus destination and passenger destination are same.");
        else
            System.out.println("Bus destination and passenger destination are not same." + "\nBus destination:" + this.destination + " passanger destination:" + passenger.getDestination() + "\n-------------------------------------------------");
    }




    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }
}
