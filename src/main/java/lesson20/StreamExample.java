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

//        ���� ����� personFromApi
//                ����� � ������� stream:
//        1)������� ������ ������ 20 ���;
//        2)����� ������ ������ 18 ��� � ������� �������� � ���� ��� ���� �������� (������ ��������� ����� ��������� 01.01.2222)
//        3)����� ���� ��� ������ 50 � ��������� ���� ����� � ��������� ����
//        4)������� ���� � ���� ����� ��� ������ 30 ��������.

    }
}
