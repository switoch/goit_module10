import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileWriter {
    public static void jsonWriter() throws IOException {
        FileReader reader = new FileReader("C:\\Users\\HP\\IdeaProjects\\goit_module10\\src\\main\\java\\file1.txt");
        int c;
        String line = "";
        while ((c = reader.read()) != -1) {
            if (c != 13 && c != 10) {
                line += (char) c;
            } else if (c == 10) {
                line += " ";
            }
        }
        String[] strarr = line.split(" ");
        String[] name = new String[strarr.length - strarr[0].length()];
        int[] age = new int[strarr.length - strarr[0].length()];
        int k = 0;
        int t = 0;
        for (int i = 2; i < strarr.length; i++) {
            if (i % 2 == 0) {
                name[k] = strarr[i];
                k++;
            } else {
                age[t] = Integer.valueOf(strarr[i]);
                t++;
            }
        }
        String json = "";
        FileWriter writer = new FileWriter("user.json");
        ArrayList<User> users = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            User user = new User(name[j], age[j]);
            users.add(user);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        json = gson.toJson(users.toArray());

        writer.write(json);
        writer.flush();
        writer.close();

    }
}
