package com.race.fastlap.vo;

public class RaceResultVO {
    private int posicao;
    private String piloto;
    private int qtdVoltas;
    private Long tempoTotal;
    private String tempoTotalFormated;
    private Long melhorVolta;
    private String melhorVoltaFormated;
    private Float velocMediaCorrida;
    private String diferencaTempo;

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) { this.posicao = posicao;}

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public int getQtdVoltas() {
        return qtdVoltas;
    }

    public void setQtdVoltas(int qtdVoltas) { this.qtdVoltas = qtdVoltas; }

    public Long getTempoTotal() { return tempoTotal; }

    public void setTempoTotal(Long tempoTotal) { this.tempoTotal = tempoTotal; }

    public String getTempoTotalFormated() { return tempoTotalFormated; }

    public void setTempoTotalFormated(String tempoTotalFormated) { this.tempoTotalFormated = tempoTotalFormated; }

    public Long getMelhorVolta() { return melhorVolta; }

    public void setMelhorVolta(Long melhorVolta) { this.melhorVolta = melhorVolta; }

    public String getMelhorVoltaFormated() { return melhorVoltaFormated; }

    public void setMelhorVoltaFormated(String melhorVoltaFormated) { this.melhorVoltaFormated = melhorVoltaFormated; }

    public Float getVelocMediaCorrida() {
        return velocMediaCorrida;
    }

    public void setVelocMediaCorrida(Float velocMediaCorrida) {
        this.velocMediaCorrida = velocMediaCorrida;
    }

    public String getDiferencaTempo() { return diferencaTempo; }

    public void setDiferencaTempo(String diferencaTempo) { this.diferencaTempo = diferencaTempo; }

}
