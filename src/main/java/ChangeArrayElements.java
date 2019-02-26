import java.util.Random;

public class ChangeArrayElements {
    public static void main(String args[]) {
        int mLength = 20;
        int m[] = new int[mLength];
        int i;
        Random random = new Random();
        Element elem = new Element();

        for (i = 0; i < mLength; i++) {
//            20 = 10 - (-10);
            m[i] = (int) (Math.random() * (20)) - 10;
        }

        System.out.print("Array:");
        for (i = 0; i < mLength; i++) {
            System.out.print(m[i] + "  ");
        }
        changeArrayElements(searchMaxNegative(m), searchMinPositive(m), m);

        System.out.println();
        System.out.print("Array: ");
        for (i = 0; i < mLength; i++) {
            System.out.print(m[i] + "  ");
        }
    }
    public static Element searchMaxNegative(int m[]) {
        int maxNegative = 0;
        int indexNegative = 0;
        int i;
        Element elem = new Element();

        for (i = 0; i < m.length; i++) {
            if (m[i] < 0) {
                maxNegative = m[i];
                indexNegative = i;
            }
        }

        if (maxNegative == 0) {
            System.out.println("Array doesn't contain any negative numbers! Try again.");
            System.exit(0);
        }

        for (i = 1; i < m.length; i++) {
            if (m[i] < 0) {
                if (m[i] > maxNegative) {
                    maxNegative = m[i];
                    indexNegative = i;
                }
            }
        }
        elem.value = m[indexNegative];
        elem.index = indexNegative;
        System.out.println();
        System.out.println("Maximum negative number: " + elem.value);
        return elem;
    }

    public static Element searchMinPositive (int m[]) {
        int minPositive = 0;
        int indexPositive = 0;
        int i;
        Element elem = new Element();

        for (i = 0; i < m.length; i++) {
            if (m[i] > 0) {
                minPositive = m[i];
                indexPositive = i;
            }
        }

        if (minPositive == 0) {
            System.out.println("Array doesn't contain any positive numbers! Try again.");
            System.exit(0);
        }

        for (i = 1; i < m.length; i++) {
            if (m[i] > 0) {
                if (m[i] < minPositive) {
                    minPositive = m[i];
                    indexPositive = i;
                }
            }
        }
        elem.value = m[indexPositive];
        elem.index = indexPositive;
        System.out.println("Minimum positive number: " + elem.value);
        return elem;
    }

    public static void changeArrayElements(Element element1, Element element2, int m[]) {
        m[element2.index] = element1.value;
        m[element1.index] = element2.value;
    }
}
