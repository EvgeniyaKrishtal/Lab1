import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        System.out.print("Введите количество элементов массива: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int value;
        for (int i = 0; i < n; i++) {
            System.out.print(">> ");
            value = in.nextInt();
            arr[i] = value;
        }
        System.out.print("Исходный массив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nВыберите, что нужно сделать с массивом:" +
                "\n1: Сортировка по возрастанию" +
                "\n2: Пузырьковая сортировка" +
                "\n3: Поиск числа в массиве" +
                "\n4: Бинарный поиск" +
                "\n5: Сортировка по алфавиту строки");
        int sw;
        sw = in.nextInt();
        switch (sw) {
            case 1:
                System.out.print("\nСортировка по возрастанию: ");
                selectionSort(arr);
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                break;
            case 2:
                System.out.print("\nСортировка пузырьком: ");
                bubbleSort(arr);
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                break;
            case 3:
                System.out.print("\nВведите число, которое нужно найти: ");
                int item = in.nextInt();
                searchInArray(arr, item);
                break;
            case 4:
                System.out.println("Введите элемент для бинарного поиска: ");
                item = in.nextInt();
                int first = 0;
                int last = arr.length - 1;
                binarySearch(arr, first, last, item);
                break;
            case 5:
                System.out.print("Введите количество строк:");
                int num = in.nextInt();
                System.out.println("\nВведите строки:");
                ArrayList<String> cha = new ArrayList<String>();
                for (int i = 0; i < num; i++){
                    String ch = in.next();
                    cha.add(ch);
                }
                Collections.sort(cha);
                System.out.println(cha);
                break;
        }

    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void searchInArray(int[] arr, int item) {
        int counter;
        for (counter = 0; counter < arr.length - 1; counter++) {
            if (arr[counter] == item) {
                System.out.println(item + " является " + (counter + 1) + " по счету в массиве");
                break;
            }
        }
        if (counter == arr.length - 1) {
            System.out.println("Число " + item + " не найдено в массиве");
        }
    }

    public static void binarySearch(int[] array, int first, int last, int item) {
        int position;
        int comparisonCount = 1;
        position = (first + last) / 2;

        while ((array[position] != item) && (first <= last)) {
            comparisonCount++;
            if (array[position] > item) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(item + " является " + ++position + " элементом в массиве");
            System.out.println("Метод бинарного поиска нашел число после " + comparisonCount +
                    " сравнений");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + comparisonCount + " сравнений");
        }
    }
}
