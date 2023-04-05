import org.json.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class PhoneNumber {

    public static String getPhoneNumbers(String country, String phoneNumber) {

        try {
            // Construct the URL for the API request
            String apiUrl = "https://jsonmock.hackerrank.com/api/countries?name=" + URLEncoder.encode(country,
                    StandardCharsets.UTF_8);
            URL url = new URL(apiUrl);

            // Send the request and read the response
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            rd.close();

            // Parse the response as JSON and extract the calling code(s)
            JSONObject json = new JSONObject(response.toString());
            JSONArray data = json.getJSONArray("data");

            if (data.length() == 0) {
                return "-1";
            }

            JSONArray callingCodes = data.getJSONObject(0).getJSONArray("callingCodes");
            String callingCode = callingCodes.getString(callingCodes.length() - 1);

            // Prepend the calling code to the phone number and return the result
            return "+" + callingCode + " " + phoneNumber;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public static void main(String[] args) {
        System.out.println(getPhoneNumbers("Nigeria", "8012345678"));
    }
}
