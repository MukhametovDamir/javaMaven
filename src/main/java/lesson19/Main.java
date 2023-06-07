package lesson19;

import lesson16.PersonApi;
import lesson16.Peson;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Peson> persons = PersonApi.getPersons(10);
        for (Peson person : persons) {
            System.out.println(person);
        }
        System.out.println("_____________________________________");
//        LamdaExample.sortLamda(persons, new Predicato<Peson>() {
//            @Override
//            public boolean test(Peson peson) {
//                return peson.getCountry().equals("Spain");
//            }
//        });
        //Слева от стрелки то что мы передаем (Peson peson)
        //  -> - магическая страелка
        // справа Результат
//        System.out.println("__________________________________");
//        LamdaExample.sortLamda(persons,
//                (Peson peson) -> {
//            return peson.getCountry().equals("Spain");} );
//        System.out.println("__________________________________");
//        LamdaExample.sortLamda(persons,
//                p -> {return p.getCountry().equals("Spain");});
//        System.out.println("_____________________________");
        //Слева 1 тип можно без скобок
        //больше 1 типа, обязательно Круглые скопки
        // затем идет магическая стрелочка ->
        // Если ставим фигурные скобки обязательно должен быть return
        // Фигурные скоюки ставятся если нужно выполнить несколько действий
        // либо без фигуррных скобок сраз то что передаешь в return
        //persons.stream().filter(p->p.getCountry().equals("Spain")).forEach(System.out::println);
        LamdaExample.sortLamda(persons,
                p -> p.getCountry().equals("Iran"),
                pp -> {
                    pp.setCountry("QWE");
                    System.out.println(pp);
                },
                p-> p.length()
        );
    }
}


@FunctionalInterface// функциональный интефейс
interface Predicato<T> {
    boolean test(T t);
}

interface Consumerito<T> {
    void accept(T t);
}

class LamdaExample {
    public static void sortLamda(List<Peson> list,
                                 Predicato<Peson> p,
                                 Consumerito<Peson> c,
                                 Function<String, Integer> f
    ) {
        for (Peson peson : list) {
            if (p.test(peson)) c.accept(peson);
            f.apply(peson.getCountry());
        }
    }
}


