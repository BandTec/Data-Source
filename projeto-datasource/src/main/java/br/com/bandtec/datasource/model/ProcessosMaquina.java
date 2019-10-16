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
public class ProcessosMaquina {
    
    private int idProcesso;
    private int pidProcesso;
    private String nomeProcesso;
    private String usoCpuProcesso;
    private String usoRamProcesso;
    private LocalDateTime dataHoraProcesso;

    public ProcessosMaquina() {
    }

    public ProcessosMaquina(int idProcesso, int pidProcesso, String nomeProcesso, String usoCpuProcesso, String usoRamProcesso, LocalDateTime dataHoraProcesso) {
        this.idProcesso = idProcesso;
        this.pidProcesso = pidProcesso;
        this.nomeProcesso = nomeProcesso;
        this.usoCpuProcesso = usoCpuProcesso;
        this.usoRamProcesso = usoRamProcesso;
        this.dataHoraProcesso = dataHoraProcesso;
    }
    
    
    

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public int getPidProcesso() {
        return pidProcesso;
    }

    public void setPidProcesso(int pidProcesso) {
        this.pidProcesso = pidProcesso;
    }

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    public String getUsoCpuProcesso() {
        return usoCpuProcesso;
    }

    public void setUsoCpuProcesso(String usoCpuProcesso) {
        this.usoCpuProcesso = usoCpuProcesso;
    }

    public String getUsoRamProcesso() {
        return usoRamProcesso;
    }

    public void setUsoRamProcesso(String usoRamProcesso) {
        this.usoRamProcesso = usoRamProcesso;
    }

    public LocalDateTime getDataHoraProcesso() {
        return dataHoraProcesso;
    }

    public void setDataHoraProcesso(LocalDateTime dataHoraProcesso) {
        this.dataHoraProcesso = dataHoraProcesso;
    }
    
    
    
}
