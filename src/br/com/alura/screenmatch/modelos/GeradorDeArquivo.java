package br.com.alura.screenmatch.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void gerarArquivoApartirDeLista(List<Titulo> titulos) throws IOException {
        FileWriter escrita = new FileWriter( "titulos.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
    }

    public void gerarArquivoDeTitulo(Titulo titulo) throws IOException {
        FileWriter escrita = new FileWriter( titulo.getNome() + ".json");
        escrita.write(gson.toJson(titulo));
        escrita.close();
    }
}
