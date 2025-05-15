public class RouteTransposition {
    public static String encrypt(String plaintext) {
        plaintext = plaintext.trim().toUpperCase().replaceAll("\\s+", "");

        int length = plaintext.length();
        int rows = (int) Math.ceil(Math.sqrt(length));
        int cols = (int) Math.ceil((double) length / rows);

        char[][] grid = new char[rows][cols];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = (index < length) ? plaintext.charAt(index++) : 'X';
            }
        }

        StringBuilder ciphertext = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                ciphertext.append(grid[i][j]);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext) {
        ciphertext = ciphertext.trim().toUpperCase();
        int length = ciphertext.length();
        int rows = (int) Math.ceil(Math.sqrt(length));
        int cols = (int) Math.ceil((double) length / rows);

        char[][] grid = new char[rows][cols];
        int index = 0;


        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                grid[i][j] = (index < length) ? ciphertext.charAt(index++) : 'X';
            }
        }

        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 'X') {
                    plaintext.append(grid[i][j]);
                }
            }
        }

        return plaintext.toString();
    }
}

