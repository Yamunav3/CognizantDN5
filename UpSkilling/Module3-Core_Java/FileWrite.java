import java.io.*;

public class FileWrite {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("file.txt");
        fw.write("hello yamuna");
        fw.close();
    }
}