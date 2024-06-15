package org.example;

import org.example.house.Apartment;
import org.example.house.House;
import org.example.house.Room;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Используйте Stream API для решения заданий:
        //1.1 Создайте класс Дом, содержащий список Квартир. Каждая квартира содержит список
        //комнат. Каждая комната содержит площадь. Посчитайте суммарную жилую площадь
        //дома.
        //1.2 Среди всех квартир найдите квартиру, площадь которой больше 100 кв. м. Если такая
        //квартира найдена, то выведите её площадь. В противном случае выведите сообщение, что
        //такой квартиры нет.
        //1.3 Старый дом расселяют. В новом доме жильцы должны получить квартиры большей
        //площади. Создайте новый список квартир дома, увеличив площадь каждой комнаты на
        //30%.

        Room room = new Room(15);
        Room room1 = new Room(20);
        Room room2= new Room(22);
        Room room3 = new Room(30);
        Room room4 = new Room(35);
        Apartment appt = new Apartment(List.of(room, room3, room1));
        Apartment appt1 = new Apartment(List.of( room3, room2));
        Apartment appt2 = new Apartment(List.of(room1, room3, room, room3, room3));
        Apartment appt3 = new Apartment(List.of(room4, room3, room2));
        Apartment appt4 = new Apartment(List.of(room, room3, room1,room4,room3));
        House house = new House(List.of(appt, appt1, appt3,appt2,appt4 ));

        appt.rooms().stream().mapToDouble(Room::square).sum(); // находим площадь квартиры

        System.out.println("Площадь дома: " + house.appartments().stream().mapToDouble(a -> a.rooms().stream().mapToDouble(Room::square).sum()).sum());
        System.out.println("\nКвартиры более 100 м2:");

        house.appartments().stream().mapToDouble(appartment -> appartment.rooms().stream().mapToDouble(Room::square).sum()).filter(s -> s > 100).forEach(System.out::println);
        //System.out.println("Такой квартиры нет"); // не поняла как написать альтернативную команду на случай отсутствия квартиры

       //List <Appartment> newHouse = house.appartments().forEach(appartment -> appartment.rooms().forEach(

        System.out.println();
        appt.rooms().stream().mapToDouble(r -> r.square() * 1.3);
        house.appartments().stream().map(appartment -> appartment.rooms().stream().map(r -> r.square() * 1.3));
        // не осилила сбор в список =( List <Appartment> newHouse = new ArrayList<>(house.appartments().stream().map(appartment -> appartment.rooms().stream().map(r -> r.square() * 1.3)));

        // Task4:
        //1.4 Дан список, каждый элемент которого – это мапа площадей комнат (комната -
        //площадь). Создайте новые квартиры с комнатами заданных площадей
        Map < Room, Integer> map = Map.of(room,33, room2,12);
        Map < Room, Integer> map1 = Map.of(room1,21, room2,9);
        Map < Room, Integer> map2 = Map.of(room2,13, room1,10);
        Map < Room, Integer> map3 = Map.of(room3,18, room2,12);

        List < Map <Room, Integer>> task4 = List.of(map,map2,map3,map1 );

        // Apartment apartment = new Apartment(); - все мозг отрубился.
        // List <Room> roomList = map.forEach((r, i) -> new Room(i));


    }





    }