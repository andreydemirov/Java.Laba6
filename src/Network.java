import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class network {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://dog.ceo/api/breeds/image/random";
    private Msg responseData;

    public void sendRequest() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            this.responseData = JSON.parseObject(response.toString(),Msg.class);
        }
        else {
            System.out.println("Something goes wrong...");
        }
    }

    public String getImage() {
        return responseData.getMessage();
    }
}
