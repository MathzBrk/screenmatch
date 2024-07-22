package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        var filmeDoPaulo = new Movie("Dogville", 2003);
        filmeDoPaulo.avaliar(10);
        Movie outroFilme = new Movie("Avatar",2023);
        outroFilme.avaliar(8);
        Movie meuFilme = new Movie("O poderoso chefão", 1970);
        meuFilme.avaliar(9);
        Serie lost = new Serie("Lost", 2000);
        Movie f1 = filmeDoPaulo;

        List<Titulo> lista = new LinkedList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for(Titulo item : lista){
            System.out.println(item.getNome());
            if(item instanceof Movie filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }
        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jaqueline");
        System.out.println(buscaPorArtista);
        System.out.println("Depois da ordenação: ");
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getReleaseYear));
        System.out.println("Ordenando por ano: ");
        System.out.println(lista);
    }
}
