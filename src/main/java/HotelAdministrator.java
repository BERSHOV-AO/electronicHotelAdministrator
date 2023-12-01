import java.util.*;

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
        if (room != null) {
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

    public void addService(String serviceName, double price) {
        Service service = new Service(serviceName, price);
        services.add(service);
    }

    // Сортировка номеров по цене
    public List<HotelRoom> getSortedRoomsByPrice() {
        List<HotelRoom> sortedRooms = new ArrayList<>(rooms);
        Collections.sort(sortedRooms, Comparator.comparingDouble(HotelRoom::getPrice));
        return sortedRooms;
    }

    // Сортировка номеров по вместимости
    public List<HotelRoom> getSortedRoomsByCapacity() {
        List<HotelRoom> sortedRooms = new ArrayList<>(rooms);
        Collections.sort(sortedRooms, Comparator.comparingInt(HotelRoom::getCapacity));
        return sortedRooms;
    }

    // Сортиовка номеров по количеству звезд
    public List<HotelRoom> getSortedRoomsByStars() {
        List<HotelRoom> sortedRooms = new ArrayList<>(rooms);
        Collections.sort(sortedRooms, Comparator.comparingInt(HotelRoom::getStars));
        return sortedRooms;
    }

    // Получить список доступных номеров (RoomStatus.FREE)
    public List<HotelRoom> getFreeRooms() {
        List<HotelRoom> freeRooms = new ArrayList<>();
        for (HotelRoom room : rooms) {
            if (room.getStatus() == RoomStatus.FREE) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    // Сортировка гостей по алфавиту
    public List<Guest> getSortedGuestsByAlphabet() {
        List<Guest> sortedGuest = new ArrayList<>(guests);
        Collections.sort(sortedGuest, Comparator.comparing(Guest::getName));
        return sortedGuest;
    }

    // Общее число свободных номеров
    public int getTotalFreeRooms() {
        int count = 0;
        for (HotelRoom room : rooms) {
            if (room.getStatus() == RoomStatus.FREE) {
                count++;
            }
        }
        return count;
    }

    // Общее число постояльцев
    public int getTotalGuests() {
        return guests.size();
    }

    // доступные номера по дате
    public List<HotelRoom> getFreeRoomsByDate(Date date) {
        List<HotelRoom> freeRoom = new ArrayList<>();
        for (HotelRoom room : rooms) {
            if (room.getStatus() == RoomStatus.FREE && isRoomFreeOnDate(room.getRoomNumber(), date)) {
                freeRoom.add(room);
            }

        }
        return freeRoom;
    }

    // Сумма оплаты за номер которую должен оплатить постоялец
    // При выселении с текущей даты, можно сделать при выселении с полной указанной датой!!!
    public double getPayAmount(int roomNumber) {
        double paymentAmount = 0.0;
        Guest guest = findGuestByRoomNumber(roomNumber);
        if (guest != null) {
            Date currentDate = new Date();
            long durationInMillis = currentDate.getTime() - guest.getCheckInDate().getTime();
            int durationInDays = (int) (durationInMillis / (24 * 60 * 60 * 1000));
            paymentAmount = durationInDays * findRoomByNumber(roomNumber).getPrice();
        }
        return paymentAmount;
    }

    // Посмотреть 3-х последних постояльцев номера и даты их пребывания
    // получить последних трех гостей

    //public List<Guest> getLastThreeGuests(int )


    // Получить отсортированные услуги по цене
    public List<Service> getSortedServicesByPrice() {
        List<Service> sortedServices = new ArrayList<>(services);
        Collections.sort(sortedServices, Comparator.comparingDouble(Service::getPrice));
        return sortedServices;
    }

    // получить отсортированные услуги по дате
    public List<Service> getSortedServicesByDate(int roomNumber) {
        List<Service> sortedServices = new ArrayList<>();
        Guest guest = findGuestByRoomNumber(roomNumber);
        if (guest != null) {
            for (Service service : services) {
                if (service.getDate().after(guest.getCheckInDate())) {
                    sortedServices.add(service);
                }
            }
            Collections.sort(sortedServices, Comparator.comparing(Service::getDate));
        }
        return sortedServices;
    }

    // осмотреть детали отдельного номера
    public void printRoomDetails(int roomNumber) {
        HotelRoom room = findRoomByNumber(roomNumber);
        if(room != null) {
            System.out.println("Room Number: " + room.getRoomNumber());
            System.out.println("Stars: " + room.getStars());
            System.out.println("Price: " + room.getPrice());
            System.out.println("Capacity: " + room.getCapacity());
            System.out.println("Status: " + room.getStatus());
        }
    }

    // ------------------------------------------------------------------
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

    // свободен ли номер по дате
    private boolean isRoomFreeOnDate(int roomNumber, Date date) {
        for (Guest guest : guests) {
            if (guest.getRoomNumber() == roomNumber && !date.before(guest.getCheckInDate()) && !date.after(guest.getCheckOutDate())) {
                return false;
            }
        }
        return true;
    }
}