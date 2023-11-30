import java.util.Date;

public class Guest {
    private String name;
    private int roomNumber;
    private Date checkInDate;
    private Date checkOutDate;

    public Guest(String name, int roomNumber, Date checkInDate, Date checkOutDate) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getName() {
        return name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

}
