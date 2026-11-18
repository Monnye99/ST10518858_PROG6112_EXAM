public class Product implements IProduct {
    private String[] products;
    private int[][] sales;

    public Product(String[] products, int[][] sales) {
        this.products = products;
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total; // 153
    }

    @Override
    public double GetAverageProductSold() {
        return (double) GetTotalProductsSold() / 9; // 17.0
    }

    @Override
    public String GetMostPopularProduct() {
        // Find product with highest TOTAL sales
        int bestIndex = 0;
        int bestTotal = 0;
        for (int i = 0; i < sales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < sales[i].length; j++) {
                productTotal += sales[i][j];
            }
            if (i == 0 || productTotal > bestTotal) {
                bestTotal = productTotal;
                bestIndex = i;
            }
        }
        // Find that product's highest single month 
        int maxSingle = sales[bestIndex][0];
        for (int j = 0; j < sales[bestIndex].length; j++) {
            if (sales[bestIndex][j] > maxSingle) {
                maxSingle = sales[bestIndex][j];
            }
        }
        return products[bestIndex] + " (" + maxSingle + ")";
        // Returns: Cozy Nights Monarch (25)
    }
}