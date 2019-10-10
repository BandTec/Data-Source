
package br.com.bandtec.datasource.model;

import oshi.PlatformEnum;
import oshi.SystemInfo;


public class MemoriaUser {
    
    SystemInfo sistema = new SystemInfo();
    
     private PlatformEnum nomeSistema;
    
     private double memoria;
     
     private int porcentagemRam;
     
     private String nomeRam;

    public MemoriaUser() {
    }

    public MemoriaUser(PlatformEnum nomeSistema, double memoria, int porcentagemRam, String nomeRam) {
        this.nomeSistema = nomeSistema;
        this.memoria = memoria;
        this.porcentagemRam = porcentagemRam;
        this.nomeRam = nomeRam;
    }
      
    public String getNomeRam() {
        return nomeRam;
    }

    public void setNomeRam(String nomeRam) {
        this.nomeRam = nomeRam;
    }

    public int getPorcentagemRam() {
        return porcentagemRam;
    }

    public void setPorcentagemRam(int porcentagemRam) {
        this.porcentagemRam = porcentagemRam;
    }
     
     
    public SystemInfo getSistema() {
        return sistema;
    }

    public void setSistema(SystemInfo sistema) {
        this.sistema = sistema;
    }

    public double getMemoria() {
        return memoria;
    }

    public void setMemoria(double memoria) {
        this.memoria = memoria;
    }       
}
