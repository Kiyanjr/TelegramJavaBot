import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GetPrice {
    public static String CryptoLivePrice() {
        OkHttpClient client = new OkHttpClient();
        List<String> Arzha = Arrays.asList("bitcoin", "ethereum", "tether", "bnb", "solana", "xrp", "usd-coin",
                "cardano", "avalanche-2", "dogecoin");
        String coinIds = String.join(",", Arzha);
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=" + coinIds + "&vs_currencies=usd";
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return "❌Request Failed: " + response.code();
            }
            String jsonData = response.body() != null ? response.body().string() : null;
            if (jsonData == null || jsonData.isEmpty()) {
                return "❌No Data here!";
            }
            System.out.println("✅ JSON Response: " + jsonData);
            JSONObject jsonObject = new JSONObject(jsonData);
            StringBuilder message = new StringBuilder("\n📌 Prices of top 10 coins :\n");
            for (String coin : Arzha) {
                JSONObject coinData = jsonObject.optJSONObject(coin);
                if (coinData != null && coinData.has("usd")) {
                    double price = coinData.getDouble("usd");
                    message.append("\n✅ ").append(coin.toUpperCase()).append(": $").append(price).append("\n");
                } else {
                    message.append("⚠️ ").append(coin.toUpperCase()).append("\nNo info was found about price");
                }
            }
            return message.toString();
        } catch (IOException e) {
            System.out.println("❌ NO data found: " + e.getMessage());
        }
        return coinIds;
    }
}

