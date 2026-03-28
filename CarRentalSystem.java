import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


    public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;
public CarRentalSystem() {
    cars = new ArrayList<>();
    customers = new ArrayList<>();
    rentals = new ArrayList<>();
}
public void addCar(Car car) {
    cars.add(car);
}
public void addCustomer(Customer customer) {
    customers.add(customer);
}
    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.setAvailable(false);
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not available for rent.");
        }
    }
    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for(Rental rental : rentals ){
            if(rental.getCar()== car){
                rentalToRemove = rental;
                break;
            }
        }
        if(rentalToRemove != null){
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Car not rented");
        }

    }
    public void menu(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Car Rental System Menu:");
            System.out.println("1. Rent Car");
            System.out.println("2. Return Car");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            if(choice == 1){
                System.out.println("\n Rent a Car \n");
                System.out.println("Enter your name:");
                String name = input.nextLine();

                System.out.println("\n Available Cars: \n");
                for(Car car : cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCarId() + " " + car.getBrand()+ " " + car.getModel());
                    }
                }
                System.out.println("Enter the Car ID you want to rent:");
                String carId = input.nextLine();
                System.out.println("Enter number of days: ");
                int days = input.nextInt();
                input.nextLine(); // Consume newline
                Customer customer = new Customer("CUS" + (customers.size() + 1), name);
                addCustomer(customer);
                Car selectedCar = null;
                for(Car car : cars){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }
                if(selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(days);
                    System.out.println("\n Rental Information: \n");
                    System.out.println("Customer ID: " + customer.getCustomerId());
                    System.out.println("Customer Name: " + customer.getName());
                    System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental Days " + days);
                    System.out.printf("Price: $%.2f\n", totalPrice);
                    rentCar(selectedCar, customer, days);
                } else {
                    System.out.println("Invalid car ID or car not available.");
                }
            } else if(choice == 2){
                System.out.println("\n Return a Car \n");
                System.out.println("Enter the Car ID you want to return:");
                String carId = input.nextLine();
                Car carToReturn = null;
                for(Car car : cars){
                    if(car.getCarId().equals(carId) && !car.isAvailable()){
                        carToReturn = car;
                        break;
                    }
                }
                if(carToReturn != null){
                    returnCar(carToReturn);
                } else {
                    System.out.println("Invalid car ID or car not rented.");
                }
            } else if(choice == 3){
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        input.close();
        System.out.println("Thank you for using the Car Rental System. Goodbye!");
    }
}
   



