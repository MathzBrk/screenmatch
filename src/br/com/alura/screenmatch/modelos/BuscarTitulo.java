package br.com.alura.screenmatch.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class BuscarTitulo {
    Gson gson = new GsonBuilder().
            setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public Titulo buscarTitulo(String titulo) {
        String encodedBusca = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        String endereco = "https://www.omdbapi.com/?t=" + encodedBusca + "&apikey=256f3114";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            System.out.println("JSON recebido: " + json);

            TituloOmdb meuTituloOmdm = gson.fromJson(json, TituloOmdb.class);

            Titulo meuTitulo = new Titulo(meuTituloOmdm);
            return meuTitulo;

        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Verifique o endereço do uri, erro encontrado");
        } catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMensagem());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
