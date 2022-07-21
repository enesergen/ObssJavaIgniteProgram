import java.util.Random;


public class ReverseArray {
    public static Random rand;

    public static int[] fillTheArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }

    public static int[] reverseArray(int[] array) {
        int[] temp = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            temp[(array.length - 1) - i] = array[i];
        }
        return temp;
    }

    public static void printArray(int[] array) {
        for (int arrayItem : array) {
            System.out.println(arrayItem);
        }
    }

    public static int[] reverseArray2(int[] array) {
        for (int i = 0; i < (array.length / 2) - 1; i++) {// 0 1 2 3 4     size=5 i-max=1
            int temp = 0;
            temp = array[i];//temp=0
            array[i] = array[array.length - i - 1];//array[0]=array[5-0-1=4]=>array[4]
            array[array.length - i - 1] = temp;//array[4]=array[0]=temp
        }
        return array;
    }


    public static void sifirla(int [] array){
        for (int i=0; i<array.length;i++){
            array[i]=0;
        }
    }
    public static void main(String[] args) {
        rand = new Random();
        int[] array = new int[rand.nextInt(50) + 1];
        System.out.println("Array Size:" + array.length);
        array = fillTheArray(array);//First
        printArray(array);
        System.out.println("----------------------------------");
        array = reverseArray(array);//Reverse
        printArray(array);
        System.out.println("----------------------------------");
        array = reverseArray2(array);//Double Reverse
        printArray(array);
        sifirla(array);
        printArray(array);//call by reference

    }
}
