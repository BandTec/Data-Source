/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.model;

import java.time.LocalDateTime;

/**
 *
 * @author fernando.oliveira
 */
public class ColetaDadosMaquina {
    
    
    private int idColetaDados;
    private String usoCPU;
    private String usoRam;
    private String usoDisco;
    private LocalDateTime dataHoraColeta;

    public ColetaDadosMaquina() {
    }

    public ColetaDadosMaquina(int idColetaDados, String usoCPU, String usoRam, String usoDisco, LocalDateTime dataHoraColeta) {
        this.idColetaDados = idColetaDados;
        this.usoCPU = usoCPU;
        this.usoRam = usoRam;
        this.usoDisco = usoDisco;
        this.dataHoraColeta = dataHoraColeta;
    }
    
    public long getIdColetaDados() {
        return idColetaDados;
    }

    public void setIdColetaDados(int idColetaDados) {
        this.idColetaDados = idColetaDados;
    }

    public String getUsoCPU() {
        return usoCPU;
    }

    public void setUsoCPU(String usoCPU) {
        this.usoCPU = usoCPU;
    }

    public String getUsoRam() {
        return usoRam;
    }

    public void setUsoRam(String usoRam) {
        this.usoRam = usoRam;
    }

    public String getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(String usoDisco) {
        this.usoDisco = usoDisco;
    }

    public LocalDateTime getDataHoraColeta() {
        return dataHoraColeta;
    }

    public void setDataHoraColeta(LocalDateTime dataHoraColeta) {
        this.dataHoraColeta = dataHoraColeta;
    }
}
