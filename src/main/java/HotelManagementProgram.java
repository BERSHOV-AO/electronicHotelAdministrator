import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HotelManagementProgram {
    public static void main(String[] args) {

        HotelAdministrator administrator = new HotelAdministrator();

        administrator.addRoom(1, 5, 1000.0, 2);
        administrator.addRoom(2, 3, 1500.0, 1);
        administrator.addRoom(3, 1, 1130.0, 2);
        administrator.addRoom(4, 6, 1000.0, 1);
        administrator.addRoom(5, 10, 2000.0, 4);
        administrator.addRoom(6, 4, 800.0, 2);

        administrator.addRoom(10, 5, 2200, 2);


        List<HotelRoom> sortedByPrise = administrator.getSortedRoomsByPrice();
        for (HotelRoom room : sortedByPrise) {
            System.out.println(room);
        }

        administrator.addGuest(new Guest("Alex", 1, new Date(), setFutureDate(10)));
        administrator.addGuest(new Guest("Max", 2, new Date(), setFutureDate(5)));
        administrator.addGuest(new Guest("Victor", 3, new Date(), setFutureDate(8)));
        administrator.addGuest(new Guest("Anton", 4, new Date(), setFutureDate(8)));
        administrator.addGuest(new Guest("Sveta", 5, new Date(), setFutureDate(2)));
        administrator.addGuest(new Guest("Roman", 6, new Date(), setFutureDate(3)));
        administrator.addGuest(new Guest("Sergey", 10, getPastDate(10), setFutureDate(1)));

        List<Guest> sortedGuest = administrator.getSortedGuestsByAlphabet();
        for (Guest guest : sortedGuest) {
            System.out.println(guest);
        }

        System.out.println(administrator.getTotalFreeRooms());


        List<HotelRoom> freeRoomsByDate = administrator.getFreeRoomsByDate(setFutureDate(5));
        for (HotelRoom room : freeRoomsByDate) {
            System.out.println(room);
        }

        System.out.println(administrator.getPayAmount(10));


        administrator.printRoomDetails(10);

    }

    public static Date setFutureDate(int amount) {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, amount);
        return calendar.getTime();
    }

    public static Date getPastDate(int days) {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTime();
    }
}