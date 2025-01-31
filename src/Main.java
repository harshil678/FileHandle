
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int status = FetchApi.fetchApi();
        if (status == 200) {
            System.out.println("\nApi response fetched successfully.\nThe following API responses are available:\n");
            ReadJson.readJson();
        }
        else{
            System.out.println("\nError fetching api response.");
        }
    }
}