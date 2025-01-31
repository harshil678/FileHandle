import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ReadJson {
    static void readJson() {
        String[] kys = {"Name","Region","Country","Latitude","Longitude","Localtime","Temperature","Weather","Wind " +
                "Speed","Wind Degree","Wind Dir","Pressure(in)","Humidity","UV","Heatindex"};
        try {
            Object jsonFile = new JSONParser().parse(new FileReader("D:\\New folder\\Rest-Api\\src\\weather.json"));
            JSONObject j0 = (JSONObject) jsonFile;
            Map m = (Map) j0.get("location");
            {
                System.out.printf("%1$-13s:  %2$s%n",kys[0], m.get("name"));
                System.out.printf("%1$-13s:  %2$s%n",kys[1], m.get("region"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[2], m.get("country"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[3], m.get("lat"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[4], m.get("lon"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[5], m.get("localtime"));
            }
            m = (Map) j0.get("current");
             var text =((JSONObject) m.get("condition")).get("text");
            {
                System.out.printf("%1$-13s:  %2$s%n" ,kys[6], m.get("temp_c"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[7], text);
                System.out.printf("%1$-13s:  %2$s%n" ,kys[8], m.get("wind_kph"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[9], m.get("wind_degree"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[10], m.get("wind_dir"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[11], m.get("pressure_in"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[12], m.get("humidity"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[13], m.get("uv"));
                System.out.printf("%1$-13s:  %2$s%n" ,kys[14], m.get("heatindex_c"));
            }
        } catch (ParseException e) {
            System.out.println("Error parsing json file.");
//            throw new RuntimeException(e);
        }catch (IOException e) {
            System.out.println("Error reading json file.");
        }

    }
}
