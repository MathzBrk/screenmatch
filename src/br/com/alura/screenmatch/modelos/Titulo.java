package br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    private String nome;

    private int releaseYear;
    private boolean inclcudedPlan;
    private double somaAvaliacoes;
    private int totalAssessment;
    private int duracaoEmMinutos;

    public Titulo(String nome, int releaseYear) {
        this.nome = nome;
        this.releaseYear = releaseYear;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if(meuTituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não consegui inverter o ano" +
                    " porque tem mais de 04 caracteres");
        }
        this.releaseYear = Integer.valueOf(meuTituloOmdb.year());
        String runtime = meuTituloOmdb.runtime().replaceAll("[^0-9]", "");
        this.duracaoEmMinutos = Integer.valueOf(runtime);
    }

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

    @Override
    public String toString() {
        return "(nome = " + nome +
                ", releaseYear = " + releaseYear + ", duração = " +
                duracaoEmMinutos   + ")"         ;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}
