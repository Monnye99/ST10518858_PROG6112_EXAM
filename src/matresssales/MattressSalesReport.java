import java.util.Scanner;

public class MattressSalesReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1D array  product names as required by question
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

        // 2D array product amd month = 3 x 3
        int[][] sales = new int[3][3];

        // INPUT 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + " mattress: ");
                sales[i][j] = sc.nextInt();
            }
            System.out.println();
        }

        // TOTAL
        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                total += sales[i][j];
            }
        }

        // AVERAGE - total / 9 values
        int average = total / 9;

        // MOST POPULAR - highest single sale and product that had it
        int maxSale = sales[0][0];
        String popularProduct = products[0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sales[i][j] > maxSale) {
                    maxSale = sales[i][j];
                    popularProduct = products[i];
                }
            }
        }

        // OUTPUT
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("*******");
        System.out.println("TOTAL PRODUCT SALES: "+ total);
        System.out.println("AVERAGE PRODUCT SALES:" + average);
        System.out.println("MOST POPULAR PRODUCT: " + popularProduct +"(" + maxSale + ")");
    }
}