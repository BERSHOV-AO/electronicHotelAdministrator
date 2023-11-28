import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Room> rooms;
    private List<Service> services;

    public Hotel() {
        rooms = new ArrayList<>();
        services = new ArrayList<>();
    }

    // Создает новый объект класса Room с заданными параметрами (номер комнаты, цена, статус)
    // и добавляет его в список rooms.
    public void addRoom(int roomNumber, double price, String status) {
        Room room = new Room(roomNumber, price, status);
        rooms.add(room);
        System.out.println("Добавлена комната с номером: " + roomNumber);
    }

    // Создает новый объект класса Service с заданными параметрами (название услуги, цена)
    // и добавляет его в список services.
    public void addService(String serviceName, double price) {
        Service service = new Service(serviceName, price);
        services.add(service);
        System.out.println("Добавлена услуга: " + serviceName);
    }

    // Поселить в номер
    public void checkIn(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (room.getStatus().equals("free")) {
                    room.setStatus("occupied");
                    System.out.println("Заселение в номер " + roomNumber);
                } else {
                    System.out.println("Гостиничный номер " + roomNumber + " занят");
                }
                return;
            }
        }
        System.out.println("В гостинице номера " + roomNumber + " не существует");
    }

    // Выселить из номера
    public void checkOut(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (room.getStatus().equals("occupied")) {
                    room.setStatus("free");
                    System.out.println("Выселение из номера " + roomNumber);
                } else {
                    System.out.println("Гостиничный номер " + roomNumber + " не занят");
                }
                return;
            }
        }
        System.out.println("В гостинице номера " + roomNumber + " не существует");
    }

    // Изменить статус номера
    public void changeStatus(int roomNumber, String newStatus) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.setStatus(newStatus);
                System.out.println("Статус номера " + roomNumber + "изменен на " + newStatus);
            }
        }
    }

    // Изменить цену номера или услуги



}
