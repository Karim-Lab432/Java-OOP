public class CarRentalSystemApp {
    public static void main(String[] args)  {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        Car c1 = new Car("CAR1","Toyota","Camry",32.0, true);
        Car c2 = new Car("CAR2","Nissan","Patrol",45.0, true);
        rentalSystem.addCar(c1);
        rentalSystem.addCar(c2);
        rentalSystem.menu();
    }
}
