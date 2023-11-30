import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class HotelAdministrator {
    private List<HotelRoom> rooms;
    private List<Service> services;

    private List<Guest> guests;

    public HotelAdministrator() {
        rooms = new ArrayList<>();
        services = new ArrayList<>();
        guests = new ArrayList<>();
    }

    public void addRoom(HotelRoom room) {
        rooms.add(room);
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    // зарегистрировать гостя
    public void checkInGuest(String guestName, int roomNumber, Date checkInDate, Date checkOutDate) {
        Guest guest = new Guest(guestName, roomNumber, checkInDate, checkOutDate);
        guests.add(guest);

        HotelRoom room = findRoomByNumber(roomNumber);
        if(room != null) {
            room.setStatus(RoomStatus.OCCUPIED);
        }
    }

    // выезд гостя
    public void checkOutGuest(int roomNumber) {
        Guest guest = findGuestByRoomNumber(roomNumber);
        if (guest != null) {
            guests.remove(guest);

            HotelRoom room = findRoomByNumber(roomNumber);
            if (room != null) {
                room.setStatus(RoomStatus.FREE);
            }
        }

    }


    // Поселить в номер
//    public void checkIn(int roomNumber) {
//        Room room = findRoom(roomNumber);
//        if (room != null && room.getStatus() == RoomStatus.FREE) {
//            room.setStatus(RoomStatus.OCCUPIED);
//            System.out.println("Гость успешно заселился в комнату " + roomNumber);
//        } else {
//            System.out.println("Комната " + roomNumber + " недоступна для регистрации");
//        }
//    }

    // Выселить из номера
//    public void checkOut(int roomNumber) {
//        Room room = findRoom(roomNumber);
//        if (room != null && room.getStatus() == RoomStatus.OCCUPIED) {
//            room.setStatus(RoomStatus.FREE);
//            System.out.println("Гость успешно выписался из комнаты " + roomNumber);
//        } else {
//            System.out.println("Комната " + roomNumber + " не занята");
//        }
//    }

    // Изменить статус комнаты
    public void changeRoomStatus(int roomNumber, RoomStatus status) {
        HotelRoom room = findRoomByNumber(roomNumber);
        if (room != null) {
            room.setStatus(status);
            System.out.println("У комнаты " + roomNumber + " статус изменен на " + status);
        } else {
            System.out.println("Комната " + roomNumber + " не существует");
        }
    }

    // Изменить цену номера
    public void changeRoomPrice(int roomNumber, double price) {
        HotelRoom room = findRoomByNumber(roomNumber);
        if (room != null) {
            room.setPrice(price);
            System.out.println("У комнаты " + roomNumber + " цена изменена на " + price);
        } else {
            System.out.println("Комната " + roomNumber + " не существует");
        }
    }

    // Изменить цену услуги
    public void changeServicePrice(String serviceName, double price) {
        Service service = findService(serviceName);
        if (service != null) {
            service.setPrice(price);
            System.out.println("Услуга " + serviceName + " цена изменена на " + price);
        } else {
            System.out.println("Услуга " + serviceName + " не существует");
        }
    }

    public void addRoom(int roomNumber, int stars, double price, int capacity) {
        HotelRoom room = new HotelRoom(roomNumber, stars, price, capacity);
        rooms.add(room);

    }

    // Поиск комнаты
    private HotelRoom findRoomByNumber(int roomNumber) {
        for (HotelRoom room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    // Поиск гостя по номеру комнаты
    private Guest findGuestByRoomNumber(int roomNumber) {
        for (Guest guest : guests) {
            if (guest.getRoomNumber() == roomNumber) {
                return guest;
            }
        }
        return null;
    }

    // Поиск услуги
    private Service findService(String serviceName) {
        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                return service;
            }
        }
        return null;
    }
}