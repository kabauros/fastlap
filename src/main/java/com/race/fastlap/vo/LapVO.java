package com.race.fastlap.vo;

public class LapVO {
    private Long id;
    private String hora;
    private String piloto;
    private int numeroVolta;
    private Long tempoVolta;
    private Float velocMediaVolta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public int getNumeroVolta() {
        return numeroVolta;
    }

    public void setNumeroVolta(int numeroVolta) {
        this.numeroVolta = numeroVolta;
    }

    public Long getTempoVolta() { return tempoVolta; }

    public void setTempoVolta(Long tempoVolta) { this.tempoVolta = tempoVolta; }

    public Float getVelocMediaVolta() {
        return velocMediaVolta;
    }

    public void setVelocMediaVolta(Float velocMediaVolta) {
        this.velocMediaVolta = velocMediaVolta;
    }

}
