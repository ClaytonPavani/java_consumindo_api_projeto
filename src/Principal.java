import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        // Criando um Scanner para o usuário inserir o endereco de CEP:
        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();

        System.out.println("Digite um número de CEP para consulta:");
        var cep = leitura.nextLine();

        // Criando um Try & Catch para fazermos o tratamento de exceção - Para obtermos o endereço:
        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);

            // Classe gerador de arquivo que irá gerar esse arquivo assim que ele foi pego
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);

        } catch (RuntimeException | IOException e) {
            // usando método e.getMessage() para exibir a mensagem:
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }

    }
}