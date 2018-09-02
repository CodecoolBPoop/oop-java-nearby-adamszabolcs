import java.util.Scanner;
import java.util.Arrays;

class Nearby {

    private static int[][] multi = new int[][]{
            {2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323},
            {1, 3, 5, 7},
            {321, 320, 32, 3, 41241, -11, -12, -13, -66, -688}
    };

    public int getNumber() {
        Scanner scanInput = new Scanner(System.in);
        System.out.println("Enter number: ");
        int x = scanInput.nextInt();
        return x;
    }


    public int[] nearby(int x, int y, int range) {
        int[] result;
        if (multi[x].length < y + range) {
            if (multi[x].length < range) {
                result = new int[multi[x].length - 1];
            } else {
                result = new int[range + ((multi[x].length - 1) - y)];
            }
        } else if (y < range) {
            result = new int[range + y];
        } else {
            result = new int[range * 2];
        }
        int indexNumber = 0;
        for (int i = range; i >= 1; i--) {
            if (y - i < 0) {
                continue;
            } else {
                result[indexNumber] = multi[x][y - i];
                indexNumber++;
            }
        }
        for (int j = 1; j <= range; j++) {
            if (y + j > multi[x].length - 1) {
                break;
            } else {
                result[indexNumber] = multi[x][y + j];
                indexNumber++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Nearby array = new Nearby();
        int x = array.getNumber();
        int y = array.getNumber();
        int range = array.getNumber();
        int[] result = array.nearby(x, y, range);
        System.out.println(Arrays.toString(result));
    }
}