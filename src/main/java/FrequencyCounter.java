import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FrequencyCounter {

    public static void wordsCounter() throws IOException {
        FileReader reader = new FileReader("words.txt");
        int c;
        String line = "";
        while ((c = reader.read()) != -1) {
            if (c != 13 && c != 10) {
                line += (char) c;
            } else if (c == 10) {
                line += " ";
            }
        }


        String[] words = line.split(" ");

        ArrayList<String> wordslist = new ArrayList<>();
        for(int j = 0; j<words.length;j++){
            if(!(words[j].equals(""))) {
                wordslist.add(words[j]);
            }
        }

        HashSet<String> hset = new HashSet<String>(wordslist);
        wordslist.clear();
        wordslist.addAll(hset);

        Multimap<Integer, String> map = ArrayListMultimap.create();


        for(int i = 0; i<wordslist.size();i++){
            int count = 0;
             for (int j = 0; j < words.length; j++){
                if (wordslist.get(i).equals(words[j])) {
                    count++;
                }
            }
             map.put(count, wordslist.get(i));
        }

        String[] order = new String[map.size()];

        int t = 0;
        for (Map.Entry<Integer, String> entry : map.entries()) {
            order[t] = entry.getValue() + " " + entry.getKey();
            t++;
        }

        for(int i = order.length-1; i >= 0;i-- ){
            System.out.println(order[i]);
        }
    }
}
