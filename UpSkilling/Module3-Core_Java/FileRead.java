
import java.io.*;

public class FileRead {
    public static void main(String[] args) throws IOException {
        System.out.println("using  FileReader");
        FileReader fr = new FileReader("file.txt");
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
        fr.close();
        System.out.println("\nusing BufferedReader");
        BufferedReader br = new BufferedReader(
                new FileReader("file.txt"));

        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}