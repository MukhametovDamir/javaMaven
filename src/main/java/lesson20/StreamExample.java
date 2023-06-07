package lesson20;

import lesson16.PersonApi;
import lesson16.Peson;
import lesson18.TestEmploe;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Peson> personFromApi = PersonApi.getPersonFromApi(10);
        for (Peson peson : personFromApi) {
            System.out.println(peson);
        }
        System.out.println("______________________________");


        List<Peson> iran = personFromApi.stream()
                .filter(peson -> peson.getCountry().equals("Iran"))
                .collect(Collectors.toList());

//        есть спиок personFromApi
//                нужно с помошью stream:
//        1)вывести женжин старше 20 лет;
//        2)найти мужчин младше 18 лет и вывести значение в виде ФИО дата рождения (пример Мухаметов дамир шокирович 01.01.2222)
//        3)найти всех кто старше 50 и сохранить этих людей в отдельный лист
//        4)вывести всех у кого Длина фио меньше 30 символов.

    }
}
