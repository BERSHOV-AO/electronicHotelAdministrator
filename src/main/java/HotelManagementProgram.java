//public class HotelManagementProgram {
//    public static void main(String[] args) {
//        HotelAdministrator administrator = new HotelAdministrator();
//
//        // Добавление номеров
//        administrator.addRoom(new Room(10, RoomStatus.FREE, 1000.0));
//        administrator.addRoom(new Room(11, RoomStatus.OCCUPIED, 1500.0));
//        administrator.addRoom(new Room(14, RoomStatus.FREE, 1200.0));
//
//        // Добавление услуг
//        administrator.addService(new Service("Breakfast", 500.0));
//        administrator.addService(new Service("Laundry", 300.0));
//        administrator.addService(new Service("Room service", 280.0));
//
//        // Пример использования функций администратора
//        administrator.checkIn(10);
//        administrator.checkOut(11);
//        administrator.changeRoomStatus(14, RoomStatus.UNDER_REPAIR);
//        administrator.changeRoomPrice(11, 1700.0);
//        administrator.changeServicePrice("Breakfast", 550.0);
//
//    }
//}