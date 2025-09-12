package Lab1;

public class Lab1_2 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%dx%d=%d\t", i, j, i * j);
            }
            System.out.println();
        }
        for (int i = 1; i < 10; i++)
            System.out.printf("\t%d", i);
        System.out.println();
        for (int i = 1; i < 10; i++) {
            System.out.print(i);
            for (int j = 1; j < 10; j++) {
                System.out.printf("\t%d", i * j);
            }
            System.out.println();

        }
    }
}
