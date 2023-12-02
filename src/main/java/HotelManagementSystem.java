public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        // Добавление номеров
        hotel.addRoom(new HotelRoom(1, 4, 2500.00, 2 ));
        hotel.addRoom(new HotelRoom(2, 3, 1500.00, 1 ));
        hotel.addRoom(new HotelRoom(3, 5, 4000.00, 4 ));
        hotel.addRoom(new HotelRoom(4, 3, 1500.00, 1 ));
        hotel.addRoom(new HotelRoom(5, 2, 1000.00, 1 ));

        // Добавление услуг
        hotel.addService(new Service("Breakfast", 500.0));
        hotel.addService(new Service("Laundry", 300.0));
        hotel.addService(new Service("Room service", 280.0));

        // Пример использования функций администратора
//        administrator.checkIn(10);
//        administrator.checkOut(11);
//        administrator.changeRoomStatus(14, RoomStatus.UNDER_REPAIR);
//        administrator.changeRoomPrice(11, 1700.0);
//        administrator.changeServicePrice("Breakfast", 550.0);

    }
}