public class HotelManagementProgram {
    public static void main(String[] args) {
        HotelAdministrator administrator = new HotelAdministrator();

        // Добавление номеров
        administrator.addRoom(new Room(101, RoomStatus.FREE, 100.0));
        administrator.addRoom(new Room(102, RoomStatus.OCCUPIED, 150.0));
        administrator.addRoom(new Room(103, RoomStatus.FREE, 120.0));

        // Добавление услуг
        administrator.addService(new Service("Breakfast", 10.0));
        administrator.addService(new Service("Laundry", 20.0));
        administrator.addService(new Service("Room service", 15.0));

        // Пример использования функций администратора
        administrator.checkIn(101);
        administrator.checkOut(102);
        administrator.changeRoomStatus(103, RoomStatus.UNDER_REPAIR);
        administrator.changeRoomPrice(101, 110.0);
        administrator.changeServicePrice("Breakfast", 12.0);

    }
}