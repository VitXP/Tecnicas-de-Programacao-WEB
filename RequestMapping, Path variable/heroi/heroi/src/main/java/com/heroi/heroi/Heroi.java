package com.heroi.heroi;

public class Heroi {

    // Atributos
    private String nome;
    private String habilidade;
    private Integer idade;
    private Integer forca;
    private boolean vivo;

    //Construtor
    public Heroi(String nome, String habilidade, Integer idade, Integer forca, boolean vivo) {
        this.nome = nome;
        this.habilidade = habilidade;
        this.idade = idade;
        this.forca = forca;
        this.vivo = vivo;
    }

    //Get e setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    //ToString
    @Override
    public String toString() {
        return String.format("🦸️ Herói: Nome %s, Habilidade %s, Idade %d, Forca %d, Vivo %s",
                nome,habilidade,idade,forca,vivo);
    }
}
