import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner in = new Scanner(System.in);

        System.out.print("Digite o nome do Livro: ");
        var tituloLivro = in.nextLine();

        String tituloFormatado = tituloLivro.replace(" ", "+");

        String chave = "AIzaSyDcPlfRImsfR7r7JGu5JDAJu2-S4LIuX5E";
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + tituloFormatado + "&key=" + chave;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        try {
            GoogleBooksResponse googleBooksResponse = gson.fromJson(response.body(),GoogleBooksResponse.class);
            List<Item> items = googleBooksResponse.items();

            if(items == null || items.isEmpty()) {
                System.out.println("Livro nao encontrado");
            }else {
                //For
                for(Item item : items) {
                    VolumeInfo volumeInfo = item.volumeInfo();

                    System.out.println(volumeInfo);
                    System.out.println("--------------"); // Separador entre os livros
                }
            }
        }catch (JsonSyntaxException e) {
            System.out.println("Erro ao processar o livro");
        }

    }
}
