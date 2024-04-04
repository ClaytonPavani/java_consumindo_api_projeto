import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    // Usamos um método void aqui, porque ela não tem nenhum retorno
    public void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Vamos pegar o endereço e fazer o ToJson para salvarmos o arquivo no formato JSON
        // Usando o FileWriter para escrever - A cada consulta de cep irá gerar um novo arquivo:
        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();
    }


}
