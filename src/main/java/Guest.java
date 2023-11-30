import java.util.Date;

/**
 * подумать над датой выезда
 */
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

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", roomNumber=" + roomNumber +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}
