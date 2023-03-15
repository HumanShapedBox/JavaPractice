// Сташкова К.С., группа 10|4992|25/01/2023

package HW;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Task3 {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> nums = fillArray(new ArrayList<>(), 10);
        System.out.println(nums);
        Collections.sort(nums);
        /*
         * Вычитала, что в коллекциях и так используется метод сортировки слиянием (как алгоритм устойчивой сортировки)
         * Для реализации метода "руками" взяла массив
         */
        System.out.println(nums);
        System.out.println("-".repeat(10));
        // Divide and conquer
        int[] numbers = new int[10];
        for (int j = 0; j < 10; j++){
            numbers[j] = new Random().nextInt(10);
        }
        printArray(numbers);
        mergeDivision(numbers, 0, numbers.length - 1);
        printArray(numbers);
        taskDone();
        // Удаляем чётные
        ArrayList <Integer> oddOnly = evenKiller(nums);
        System.out.println(oddOnly);
        taskDone();
        // min, max, mid
        System.out.println(nums);
        int max = findMax(nums);
        int min = findMin(nums);
        double mid = findMid(nums);
        System.out.println("Максимальное значение = " + max);
        System.out.println("Минимальное значение = " + min);
        System.out.println("Среднее значение = " + mid);
        taskDone();
        // Объединение двух списков (добавить только те элементы второго, которые не встречаются в первом)
        ArrayList <Integer> list1 = fillArray(new ArrayList<>(), 10);
        System.out.println("Первый список: " + list1);
        ArrayList <Integer> list2 = fillArray(new ArrayList<>(), 10);
        System.out.println("Второй список: " + list2);
        ArrayList <Integer> commonList = arrayUnion(list1, list2);
        System.out.println("Результат объединения: " + commonList);
        taskDone();
        // Ноль 10000 раз, подсчёт времени выполнения
        long begin = System.currentTimeMillis();
        ArrayList <Integer> zero = new ArrayList<>();
        for (int i = 0; i < 10000; i++){
            zero.add(0, 0);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

        long begin2 = System.currentTimeMillis();
        List<Integer> zeroList = new LinkedList<Integer>();
        for (int i = 0; i < 10000; i++){
            ((LinkedList<Integer>) zeroList).addFirst(0);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - begin2);
        taskDone();        
    }

    static ArrayList <Integer> fillArray(ArrayList <Integer> array, int size){
        for (int i = 0; i < size; i++){
            array.add(new Random().nextInt(10));
        }
        return array;
    }

    static void printArray(int[] array){
        for (int i : array) {
        System.out.print(i+" ");
    }
    System.out.println();
    }

    static void taskDone(){
        System.out.println("-".repeat(10));
    }
    
    static void mergeDivision(int[] array, int start, int end) {
        if (end <= start)
            return;
        int mid = start + (end - start) / 2;
        mergeDivision(array, start, mid);
        mergeDivision(array, mid + 1, end);
    
        int[] buffer = Arrays.copyOf(array, array.length);
        for (int k = start; k <= end; k++)
        buffer[k] = array[k];  
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                array[k] = buffer[j];
                j++;
            } 
            else if (j > end) {
                array[k] = buffer[i];
                i++;
            } 
            else if (buffer[j] < buffer[i]) {
                array[k] = buffer[j];
                j++;
            } 
            else {
                array[k] = buffer[i];
                i++;
            }
        }
    }

    static ArrayList<Integer> evenKiller(ArrayList<Integer> array){
        ArrayList<Integer> temp = new ArrayList<>(array.size());
        for (int i = 0; i < array.size(); i++){
            if (array.get(i)%2!=0){
                temp.add(array.get(i));
            }
        }
        return temp;
    }

    static int findMax(ArrayList<Integer> array){
        int max = array.get(0);
        for (int i = 1; i < array.size(); i++){
            if (array.get(i) > max){
                max = array.get(i);
            }
        }
        return max;
    }

    static int findMin(ArrayList<Integer> array){
        int min = array.get(0);
        for (int i = 1; i < array.size(); i++){
            if (array.get(i) < min){
                min = array.get(i);
            }
        }
        return min;
    }

    static double findMid(ArrayList<Integer> array){
        double sum = 0;
        double length = array.size();
        for (int i = 1; i < array.size(); i++){
            sum += array.get(i);
        }
        double mid = sum / length;
        return mid;
    }

    static ArrayList <Integer> arrayUnion(ArrayList <Integer> one, ArrayList <Integer> two){
        ArrayList <Integer> array = new ArrayList<>(one);
        for (int i = 0; i < two.size(); i++){
            if (array.contains(two.get(i)) == false){
                array.add(two.get(i));
            }
        }
        return array;
    }
}
