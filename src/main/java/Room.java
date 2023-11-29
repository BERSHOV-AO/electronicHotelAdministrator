class Room {
    private int number;
    private RoomStatus status;
    private double price;

    public Room(int number, RoomStatus status, double price) {
        this.number = number;
        this.status = status;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}