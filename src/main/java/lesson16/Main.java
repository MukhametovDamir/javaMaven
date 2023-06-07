package lesson16;


import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Peson personFromApi = PersonApi.getPersonFromApi();
//        System.out.println(personFromApi);


        List<Peson> personFromApi = PersonApi.getPersons(100);

        for (Peson peson : personFromApi) {
            System.out.println(peson);
        }
    }
}
