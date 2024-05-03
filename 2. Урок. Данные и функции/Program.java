public class Program {

    public static void main(String[] args) {

        int[] array = {2, 1, 2, 3, 4};
        System.out.println(getCountEvens(array));

        array = new int[]{2, 2, 0};
        System.out.println(getCountEvens(array));

        array = new int[]{1, 3, 5};
        System.out.println(getCountEvens(array));

        array = new int[]{2, 1, 2, 3, 4};
        System.out.println(getDifferenceBetweenMinMax(array));

        array = new int[]{0, 0, 2, 3, 4};
        System.out.println(presenceAdjacentZeros(array));

        array = new int[]{1, 0, 0, 3, 4};
        System.out.println(presenceAdjacentZeros(array));

        array = new int[]{0, 0, 0, 3, 4};
        System.out.println(presenceAdjacentZeros(array));
    }

    /**
     * Метод возвращающий количество четных элементов массива
     * @param array
     * @return
     */
    private static int getCountEvens(int[] array){
        if (array == null || array.length <= 0) {
            return 0;
        }

        int count = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Метод возвращающий разницу между максимальным и минимальным элементом массива
     * @param array
     * @return
     */
    private static int getDifferenceBetweenMinMax(int[] array){
        if (array == null || array.length <= 0) {
            return 0;
        }

        int max = array[array.length - 1];
        int min = array[0];
        int result = 0;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
            else if (i < min) {
                min = i;
            }
        }
        result = max - min;
        return result;
    }


    /**
     * Метод возвращающий истину, в случае, нахождения соседних элементов равных нулю
     * @param array
     * @return
     */
    private static boolean presenceAdjacentZeros(int[] array){
        if (array == null || array.length <= 0) {
            return false;
        }

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] == 0 && array[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }
}
