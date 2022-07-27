import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<String> lines() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("C:\\Staj\\JIP220722\\Deneme.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            String line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        }
        return lines;
    }

    public static ArrayList<String> splitWord(ArrayList<String> lines) {
        ArrayList<String> allWords = new ArrayList<>();
        StringBuffer sb=null;
        for (String line : lines) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].contains(".")) {
                    sb = new StringBuffer(words[i]);//string substring kullan
                    words[i] = sb.deleteCharAt(sb.length() - 1).toString();
                } else if (words[i].contains(",")) {
                     sb = new StringBuffer(words[i]);
                    words[i] = sb.deleteCharAt(sb.length() - 1).toString();
                }
                allWords.add(words[i]);
            }
        }

        return allWords;

    }

    public static ArrayList<String> toUpperCase(ArrayList<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String upperCase = words.get(i).toUpperCase(Locale.US);
            words.set(i, upperCase);
        }
        return words;
    }

    public static boolean isContain(String words, HashMap<String, Integer> hasMap) {
        return hasMap.containsKey(words);
    }

    public static HashMap<String, Integer> counter(ArrayList<String> words) {
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            if (!isContain(words.get(i).toString(), result)) {
                result.put(words.get(i), 1);
            } else {
                int count = result.get(words.get(i)) + 1;
                result.replace(words.get(i), count);
            }
        }
        return result;
    }

    public static void writeResult(TreeMap<String, Integer> result) {
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }

    public static TreeMap<String, Integer> sortHashMap(HashMap<String, Integer> result) {
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(result);
        return sortedMap;
    }

    public static void main(String[] args) throws IOException {
        /*
        ArrayList<String>lines=lines();
        ArrayList<String>words=splitWord(lines);
        ArrayList<String>upperCaseWord=toUpperCase(words);
        HashMap <String,Integer>result=counter(upperCaseWord);
        HashMap <String,Integer>result=;
        */
        writeResult(sortHashMap(counter(toUpperCase(splitWord(lines())))));


    }
}
