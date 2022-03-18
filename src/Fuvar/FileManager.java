package Fuvar;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public String header = "";
    List<Entity> ride = new ArrayList<Entity>();

    public List<Entity> fileRead(String fileName){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            header = br.readLine();
            while (br.ready()){
                String row = br.readLine();
                String[] rowData = row.split(";");
                Entity entity = new Entity(
                        Integer.parseInt(rowData[0]),
                        LocalDateTime.parse(rowData[1].replace(' ', 'T')),
                        Integer.parseInt(rowData[2]),
                        Double.parseDouble(rowData[3].replace(',', '.')),
                        Double.parseDouble(rowData[4].replace(',','.')),
                        Double.parseDouble(rowData[5].replace(',', '.')),
                        rowData[6]);
                ride.add(entity);
            }
            br.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ride;
    }


}
