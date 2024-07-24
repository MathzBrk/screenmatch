package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.*;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();


        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um titulo para busca: ");
            busca = leitura.nextLine();
            BuscarTitulo buscador = new BuscarTitulo();

            Titulo titulo = buscador.buscarTitulo(busca);
            titulos.add(titulo);

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

        }
        System.out.println(titulos);

        GeradorDeArquivo gerador = new GeradorDeArquivo();
        gerador.gerarArquivoApartirDeLista(titulos);
        gerador.gerarArquivoDeTitulo(titulos.get(0));
        System.out.println("O programa finalizou corretamente");
    }
}
