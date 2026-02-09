package tcGenerator.ai;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class OllamaClient {

    private static final String OLLAMA_URL =
            "http://localhost:11434/api/generate";

    public static String generate(String prompt) {

        try {
            URL url = new URL(OLLAMA_URL);
            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Build request safely
            Map<String, Object> body = new HashMap<>();
            body.put("model", "llama3");
            body.put("prompt", prompt);
            body.put("stream", false);
            body.put("format", "json");

            Map<String, Object> options = new HashMap<>();
            options.put("temperature", 0);
            options.put("num_predict", 4096);
            
            body.put("options", options);

            ObjectMapper mapper = new ObjectMapper();
            byte[] json = mapper.writeValueAsBytes(body);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json);
            }

            InputStream is =
                    conn.getResponseCode() >= 400
                            ? conn.getErrorStream()
                            : conn.getInputStream();

            return new String(is.readAllBytes());

        } catch (Exception e) {
            throw new RuntimeException("Failed to call Ollama", e);
        }
    }
}
