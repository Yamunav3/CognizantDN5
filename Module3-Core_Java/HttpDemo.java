import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpDemo {

        public static void main(String[] args) {

                try {

                        // Step 1: Create Client
                        HttpClient client = HttpClient.newHttpClient();

                        // Step 2: Create Request
                        HttpRequest request = HttpRequest.newBuilder()
                                        .uri(URI.create(
                                                        "https://api.github.com/users/yamunav3"))
                                        .GET()
                                        .build();

                        // Step 3: Send Request
                        HttpResponse<String> response = client.send(
                                        request,
                                        HttpResponse.BodyHandlers.ofString());

                        // Step 4: Print Response
                        System.out.println(
                                        "Status Code: "
                                                        + response.statusCode());

                        System.out.println(
                                        "\nResponse:\n"
                                                        + response.body());

                } catch (Exception e) {

                        e.printStackTrace();
                }
        }
}