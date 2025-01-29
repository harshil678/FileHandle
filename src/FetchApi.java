import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FetchApi {
    static int fetchApi() {
        System.out.println("This is a code to fetch api data and show received data in formatted pattern.");
        System.out.println("We will use weather api for fetching data.");
        System.out.print("\nEnter your key: ");
        var key = new Scanner(System.in).nextLine();
        var url = "https://api.weatherapi.com/v1/current.json?key=" + key + "&q=21" +
                ".340731,%2070.751900&aqi=no";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<Path> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("D:\\New folder\\Rest-Api\\src\\weather.json")));

        } catch (Exception e) {
            System.out.println("Something went wrong.");
//            throw new RuntimeException(e);
        }
        if( response == null){
            return 404;
        }else{
            return response.statusCode();
        }
    }
}
