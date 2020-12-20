import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileReader {
    public static List<Integer> readDataFromFile(String path) throws IOException {
        List<Integer> list = new ArrayList<>();
        FileInputStream readSteam = new FileInputStream(path);
        int number =  readSteam.read();
        
        while (number != -1) {
            number =  readSteam.read();
            list.add(number);
        }
        
        return list;
    }
}