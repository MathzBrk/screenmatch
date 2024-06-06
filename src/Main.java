import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Serie;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Movie meuFilme = new Movie();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setReleaseYear(1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTencnica();
        meuFilme.avaliar(8);
        meuFilme.avaliar(5);
        meuFilme.avaliar(10);
        System.out.println(meuFilme.getTotalAssessment());
        System.out.println(meuFilme.obterMediaAvaliacoes());

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setReleaseYear(2000);
        lost.exibeFichaTencnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar lost: " +lost.getDuracaoEmMinutos());

        Movie outroFilme = new Movie();
        outroFilme.setNome("Avatar");
        outroFilme.setReleaseYear(2023);
        outroFilme.setDuracaoEmMinutos(200);


        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio ep = new Episodio();
        ep.setNumero(1);
        ep.setSerie(lost);
        ep.setTotalVisualizacoes(300);
        filtro.filtra(ep);

    }
}