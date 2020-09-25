package ru.javatest;

/*
    Ввести с клавиатуры строку s и число k.
    Найти такую последовательность длиной k в строке s,
    в которой будет наибольшее количество гласных букв.
    Вернуть искомую последовательность в виде строки.
    Гласные буквы: a, e, i, o, u
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int k = Integer.parseInt(reader.readLine().trim());
        reader.close();

        System.out.println(compute(s,k)); // В этой функции находим последовательность длины k из строки s, в которой встречается больше всего гласных букв
    }

    public static String compute(String s, int k) {
        if(k > s.length()) // Если длина строки меньше, чем длина искомой последовательности, выбрасываем исключение
            throw new IllegalArgumentException("Некорректный ввод параметров!");
        String result=s; // Инициализируем переменную, в которую записываем найденную последовательность из k символов
        int overallCounter = 0; // Инициализируем счетчик, в который будем записывать общий максимум встреченных гласных в последовательности длины k
        char[] vowels = new char[] {'a','e','i','o','u'}; // Английский вариант
        //char[] vowels = new char[] {'а','е','ё','и','о','у','ы','э','ю','я'}; // Русский вариант
        List<String> sequenceList = new LinkedList<>(); // Создаем список, в который будем заносить все возможные последовательности из k символов
        for(int i = 0; i < s.length()-k; i++)
            sequenceList.add(s.substring(i , i+k )); // Добавляем все возможные последовательности из k букв в наш список
        for(String str: sequenceList) // Цикл для всех последовательностей длины k
            {int sequenceCounter=0; // Счетчик встреченных гласных для каждой отдельной записи в списке
                for(int j=0; j<str.length(); j++) { // Вложенный цикл для прохода по каждой отдельной букве в строке
                    for (int i = 0; i < vowels.length; i++) { // Второй вложенный цикл для прохода по массиву гласных букв
                        if (str.toLowerCase().charAt(j)==vowels[i]) // Проверяем, является ли текущая буква в строке гласной или нет
                            sequenceCounter++; // Если является, увеличиваем счетчик на единицу
                    }
                }
                if(sequenceCounter>overallCounter) { // После всех циклов сравниваем текущее количество гласных в последовательности с максимальным
                    overallCounter = sequenceCounter; // Если количество гласных больше встреченного максимума, увеличиваем наш счетчик максимума гласных
                    result = str; // Записываем в результат строку с текущим максимальным количеством гласных
                }
            }
        return result; // Возвращаем строку - последовательность длины k с максимальным числом гласных в ней
    }
}
