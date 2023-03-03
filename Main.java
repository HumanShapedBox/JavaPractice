/*
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
Пункты реализовать в методе main
Пункты реализовать в разных методах
 */
package HW;

import java.util.Random;

public class Main {

    public static void main(String[] arg){
        int i = new Random().nextInt(2000);
        int n = msBit(i);
        int size = getSize(i, n);
        int[] m1 = multNums(i, n, size);
        int[] m2 = aliqNums(i, n, size);

    //     System.out.println(i);
    //     System.out.println(n);
    //     System.out.println();

    //     for (int j : m1) {
    //         System.out.println(j);
    //     }

    //     System.out.println();
        
    //     for (int j : m2) {
    //         System.out.println(j);
    //     }
    // }

    static int msBit(Integer i){
        int msb = Integer.highestOneBit(i);
        return msb;
    }

    static int getSize(Integer i, Integer n){
        int size = 0;
        for (int j = i; j < Short.MAX_VALUE; j++){
            if (j % n == 0){
                size++;
            }
        }
        return size;
    }
    
    static int[] multNums(Integer i, Integer n, Integer size){
        int[] multNums = new int[size];
        int k = 0;
        for (int j = i; j < Short.MAX_VALUE; j++){
            if (j % n == 0){
                multNums[k] = j;
                k++;
            }
        }
        return multNums;
    }

    static int[] aliqNums(Integer i, Integer n, Integer size){
        int[] aliqNums = new int[size];
        int k = 0;
        for (int j = i; j < Short.MAX_VALUE; j++){
            if (j % n != 0){
                aliqNums[k] = j;
                k++;
            }
        }
        return aliqNums;
    }

}
