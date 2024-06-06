package br.com.alura.screenmatch.modelos;

public class Titulo {
    private String nome;
    private int releaseYear;
    private boolean inclcudedPlan;
    private double somaAvaliacoes;
    private int totalAssessment;
    private int duracaoEmMinutos;

    public String getNome() {
        return nome;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isInclcudedPlan() {
        return inclcudedPlan;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalAssessment(){
        return totalAssessment;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setInclcudedPlan(boolean inclcudedPlan) {
        this.inclcudedPlan = inclcudedPlan;
    }

    public void exibeFichaTencnica(){
        System.out.println("Name of the movie: " +nome);
        System.out.println("Release year: " +releaseYear);
    }

    public void avaliar(double nota){
        somaAvaliacoes += nota;
        totalAssessment++;
    }

    public double obterMediaAvaliacoes(){

        return somaAvaliacoes / totalAssessment;
    }
}
