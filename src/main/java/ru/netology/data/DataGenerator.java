package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас", "Нальчик",
                "Элиста", "Черкесск", "Петрозаводск", "Сыктывкар", "Симферополь", "Йошкар-Ола", "Саранск",
                "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан", "Грозный", "Чебоксары",
                "Барнаул", "Чита", "Петропавловск-камчатский", "Краснодар", "Красноярск", "Пермь",
                "Влапивосток", "Ставрополь", "Хабаровск", "Благовененск", "Архангельск", "Астрахань",
                "Белгород", "Брянск", "Владинир", "Волгоград", "Вологда", "Воронеж", "Иваново", "Орёл",
                "Иркутск", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Курган", "курск",
                "Санкт-Петербург", "Липешк", "Магадан", "Москва", "Мурманск", "Нижний Новгород",
                "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Пенза", "Псков", "Салехард",
                "Ростов-на-Дону", "Рязань", "Самара", "Саратов", "Окно-Сахалинск", "Екатеринбург",
                "Смоленск", "Тамбов", "Тверь", "Томск", "Тула", "Темень", "Ульяновск", "Челябинск", "Ярославль",
                "Севастополь", "Биробиджан", "Нарьян-Мар", "Ханты-Мансийск", "Анадырь" };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registrarion {
        private Registrarion() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
