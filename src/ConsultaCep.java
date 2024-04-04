import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep) {
        // Aqui concatenamos o trecho do endereço com o CEP que colocamos na busca:

        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        // Fizemos a requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        // Resposta através do Http Response - Usamos um Try & Catch para tratar exceções:
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Lembre-se sempre de na estrutura de projeto adicionar o GSON JAR que baixamos do site Maven
            return new Gson().fromJson(response.body(), Endereco.class);

            // Se der qualquer erro, vamos lançar a exceção genérica, pois não conhecemos a API:

        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }

    }
}