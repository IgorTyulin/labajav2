import java.io.*;

public class Counter {
    public static void counter(String fileName) {
        int[] buf = new int[26];
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                line = line.toLowerCase();
                int size = line.length();
                for (int i = 0; i < size; i++) {
                    if ((int) line.charAt(i) >= 97 && (int) line.charAt(i) <= 122) {
                        buf[(int) line.charAt(i) - 97] += 1;
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter("output.txt", false)) {
            for (int i = 0; i < 26; i++) {
                String line = "" + (char) (i + 97) + " - " + buf[i] + "\n";
                writer.write(line);
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}