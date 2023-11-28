import lombok.AllArgsConstructor;

public class Room {

    private int roomNumber;
    private double price;
    private String status;

    public Room(int roomNumber, double price, String status) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.status = status;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
