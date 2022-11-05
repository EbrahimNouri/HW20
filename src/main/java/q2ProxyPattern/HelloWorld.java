package q2ProxyPattern;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloWorld {
    public static void main(String[] args)
    {
        String fileContent = "hello world file";
        FileOutputStream outputStream = null;

        try {

            outputStream = new FileOutputStream("file.txt");

            byte[] strToBytes = fileContent.getBytes();

            outputStream.write(strToBytes);

            System.out.print(
                    "File is created successfully.");
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }

        finally {

            if (outputStream != null) {

                try {

                    outputStream.close();
                }

                catch (IOException e) {
                    System.out.print(e.getMessage());
                }
            }
        }
    }

    public class ReadFile {
        public static void main(String[] args) {
            String pathFile = "/home/viroo/s.txt";
            try {
                File file = new File(pathFile);
                System.out.println(file.getName());
                System.out.println(file.getPath());
                System.out.println(file.exists());
                System.out.println(file.canWrite());
                System.out.println(file.canRead());
                System.out.println(file.isDirectory());
                Path path = Paths.get(pathFile);
                System.out.println(Files.size(path));
            } catch (IOException e) {
                System.err.println("Error! " + e.getMessage());
            }
        }
    }

}