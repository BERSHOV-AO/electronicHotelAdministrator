class HotelRoom {
    private int roomNumber;
    private int stars;
    private double price;
    private int capacity;
    private RoomStatus status;

    public HotelRoom(int roomNumber, int stars, double price, int capacity) {
        this.roomNumber = roomNumber;
        this.stars = stars;
        this.price = price;
        this.capacity = capacity;
        this.status = RoomStatus.FREE;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getStars() {
        return stars;
    }

    public double getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "roomNumber=" + roomNumber +
                ", stars=" + stars +
                ", price=" + price +
                ", capacity=" + capacity +
                ", status=" + status +
                '}';
    }
}