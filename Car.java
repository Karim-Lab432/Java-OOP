
public class Car {

    private String carID;
    private String brandName;
    private String model;
    private double pricePerday;
    private boolean isAvailable;

    public Car(String carID, String brandName, String model, double pricePerday, boolean isAvailable) {
        this.carID = carID;
        this.brandName = brandName;
        this.model = model;
        this.pricePerday = pricePerday;
        this.isAvailable = isAvailable;
    }

    public String getCarId() {
        return carID;
    }

    public String getBrand() {
        return brandName;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int rentalDays) {
        return pricePerday * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void returnCar() {
        isAvailable = true;
    }
}



