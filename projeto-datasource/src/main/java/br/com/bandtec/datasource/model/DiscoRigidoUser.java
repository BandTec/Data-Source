/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.model;

import oshi.SystemInfo;

/**
 *
 * @author Bandtec
 */
public class DiscoRigidoUser {
    
    SystemInfo sistema = new SystemInfo();

    private  Double capacidadeTotal;
    private  int porcentagemUso;
    private  String nomeHD;

    public DiscoRigidoUser() {
    }

    public DiscoRigidoUser(Double capacidadeTotal, int porcentagemUso, String nomeHD) {
        this.capacidadeTotal = capacidadeTotal;
        this.porcentagemUso = porcentagemUso;
        this.nomeHD = nomeHD;
    }

    public SystemInfo getSistema() {
        return sistema;
    }

    public void setSistema(SystemInfo sistema) {
        this.sistema = sistema;
    }

    public Double getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(Double capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public int getPorcentagemUso() {
        return porcentagemUso;
    }

    public void setPorcentagemUso(int porcentagemUso) {
        this.porcentagemUso = porcentagemUso;
    }

    public String getNomeHD() {
        return nomeHD;
    }

    public void setNomeHD(String nomeHD) {
        this.nomeHD = nomeHD;
    }



    
}
