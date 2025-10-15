public class KernelFilter {
    public static double[][] identity() {
        return new double[][] {
            { 0, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 0 }
        };
    }

    public static double[][] gaussian() {
        return new double[][] {
            { 1, 2, 1 },
            { 2, 4, 2 },
            { 1, 2, 1 }
        };
    }

    public static double[][] sharpen() {
        return new double[][] {
            { 0, -1,  0 },
            { -1, 5, -1 },
            { 0, -1,  0 }
        };
    }

    public static double[][] laplacian() {
        return new double[][] {
            { -1, -1, -1 },
            { -1,  8, -1 },
            { -1, -1, -1 }
        };
    }

    public static double[][] emboss() {
        return new double[][] {
            { -2, -1, 0 },
            { -1,  1, 1 },
            {  0,  1, 2 }
        };
    }

    public static double[][] motionBlur() {
        return new double[][] {
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 1 }
        };
    }

    public static int[][] applyFilter(int[][] image, double[][] kernel) {
        int height = image.length;
        int width = image[0].length;
        int[][] result = new int[height][width];

        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                double sum = 0.0;
                for (int ki = -1; ki <= 1; ki++) {
                    for (int kj = -1; kj <= 1; kj++) {
                        sum += image[i + ki][j + kj] * kernel[ki + 1][kj + 1];
                    }
                }
                result[i][j] = Math.min(255, Math.max(0, (int) Math.round(sum)));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] image = StdArrayIO.readInt2D();
        double[][] kernel = gaussian(); // You can switch to other filters
        int[][] filtered = applyFilter(image, kernel);
        StdArrayIO.print(filtered);
    }
}
