import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFileReader {
    public static void fileReader() throws IOException {
        File file = new File("C:\\Users\\HP\\IdeaProjects\\goit_module10\\src\\main\\java\\file.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        String line = new String(buffer);
        String[] line1 = line.split("\n");
        Pattern p = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{4}|\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}");
        for (String s : line1) {
            Matcher m = p.matcher(s);
            if (m.find()) {
                System.out.println(s);
            }
        }
    }
}
