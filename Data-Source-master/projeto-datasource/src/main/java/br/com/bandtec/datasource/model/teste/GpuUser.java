/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.model.teste;

/**
 *
 * @author Bandtec
 */
public class GpuUser {
    
    private int idGPU;
    private String nomeGPU;
    private String tempGPU;

    public GpuUser() {
    }

    public GpuUser(int idGPU, String nomeGPU, String tempGPU) {
        this.idGPU = idGPU;
        this.nomeGPU = nomeGPU;
        this.tempGPU = tempGPU;
    }

    public int getIdGPU() {
        return idGPU;
    }

    public void setIdGPU(int idGPU) {
        this.idGPU = idGPU;
    }

    public String getNomeGPU() {
        return nomeGPU;
    }

    public void setNomeGPU(String nomeGPU) {
        this.nomeGPU = nomeGPU;
    }

    public String getTempGPU() {
        return tempGPU;
    }

    public void setTempGPU(String tempGPU) {
        this.tempGPU = tempGPU;
    }
    
    
    
    
}
