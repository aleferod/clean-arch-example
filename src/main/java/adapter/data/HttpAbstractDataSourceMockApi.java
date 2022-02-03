package adapter.data;

import adapter.data.dto.EmpresaMockApiDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class HttpAbstractDataSourceMockApi implements AbstractDataSource {

    @Override
    public String obterRazaoSocialPeloCnpj(String cnpj) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://61fad8a487801d0017a2c2ec.mockapi.io/razaosocial/" + cnpj))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==200) {
                EmpresaMockApiDto empresaMockApiDto = jsonParaPojo(response.body());
                return empresaMockApiDto.getRazaoSocial();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static EmpresaMockApiDto jsonParaPojo(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.readValue(json, EmpresaMockApiDto.class);
    }
}
