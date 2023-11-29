import java.util.ArrayList;
import java.util.List;

class HotelAdministrator {
    private List<Room> rooms;
    private List<Service> services;

    public HotelAdministrator() {
        rooms = new ArrayList<>();
        services = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addService(Service service) {
        services.add(service);
    }

    // Поселить в номер
    public void checkIn(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room != null && room.getStatus() == RoomStatus.FREE) {
            room.setStatus(RoomStatus.OCCUPIED);
            System.out.println("Гость успешно заселился в номер " + roomNumber);
        } else {
            System.out.println("Комната " + roomNumber + " недоступна для регистрации");
        }
    }

    // Выселить из номера
    public void checkOut(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room != null && room.getStatus() == RoomStatus.OCCUPIED) {
            room.setStatus(RoomStatus.FREE);
            System.out.println("Гость успешно выписался из комнаты " + roomNumber);
        } else {
            System.out.println("Комната " + roomNumber + " не занята");
        }
    }

    // Изменить статус комнаты
    public void changeRoomStatus(int roomNumber, RoomStatus status) {
        Room room = findRoom(roomNumber);
        if (room != null) {
            room.setStatus(status);
            System.out.println("У комнаты " + roomNumber + " статус изменен на " + status);
        } else {
            System.out.println("Комната " + roomNumber + " не существует");
        }
    }

    // Изменить цену номера
    public void changeRoomPrice(int roomNumber, double price) {
        Room room = findRoom(roomNumber);
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

    // Поиск комнаты
    private Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                return room;
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