/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.model;

/**
 *
 * @author fernando.oliveira
 */
public class Maquina {
    
    private int idMaquina;
    private String nomeSO;
    private String nomeCPU;
    private String usoCPU;
    private String memRamTotal;
    private String memRamUsada;
    private String memRamDisponivel;
    private String discoTotal;
    private String discoUsado;
    private String discoDisponivel;
    private String nomeGPU;
    private String descricaoTipoMaquina;

    public Maquina() {
    }

    public Maquina(int idMaquina, String nomeSO, String nomeCPU, String usoCPU, String memRamTotal, String memRamUsada, String memRamDisponivel, String discoTotal, String discoUsado, String discoDisponivel, String nomeGPU, String descricaoTipoMaquina) {
        this.idMaquina = idMaquina;
        this.nomeSO = nomeSO;
        this.nomeCPU = nomeCPU;
        this.usoCPU = usoCPU;
        this.memRamTotal = memRamTotal;
        this.memRamUsada = memRamUsada;
        this.memRamDisponivel = memRamDisponivel;
        this.discoTotal = discoTotal;
        this.discoUsado = discoUsado;
        this.discoDisponivel = discoDisponivel;
        this.nomeGPU = nomeGPU;
        this.descricaoTipoMaquina = descricaoTipoMaquina;
    }
    
    
    
    

    public long getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNomeSO() {
        return nomeSO;
    }

    public void setNomeSO(String nomeSO) {
        this.nomeSO = nomeSO;
    }

    public String getNomeCPU() {
        return nomeCPU;
    }

    public void setNomeCPU(String nomeCPU) {
        this.nomeCPU = nomeCPU;
    }

    public String getUsoCPU() {
        return usoCPU;
    }

    public void setUsoCPU(String usoCPU) {
        this.usoCPU = usoCPU;
    }

    public String getMemRamTotal() {
        return memRamTotal;
    }

    public void setMemRamTotal(String memRamTotal) {
        this.memRamTotal = memRamTotal;
    }

    public String getMemRamUsada() {
        return memRamUsada;
    }

    public void setMemRamUsada(String memRamUsada) {
        this.memRamUsada = memRamUsada;
    }

    public String getMemRamDisponivel() {
        return memRamDisponivel;
    }

    public void setMemRamDisponivel(String memRamDisponivel) {
        this.memRamDisponivel = memRamDisponivel;
    }

    public String getDiscoTotal() {
        return discoTotal;
    }

    public void setDiscoTotal(String discoTotal) {
        this.discoTotal = discoTotal;
    }

    public String getDiscoUsado() {
        return discoUsado;
    }

    public void setDiscoUsado(String discoUsado) {
        this.discoUsado = discoUsado;
    }

    public String getDiscoDisponivel() {
        return discoDisponivel;
    }

    public void setDiscoDisponivel(String discoDisponivel) {
        this.discoDisponivel = discoDisponivel;
    }

    public String getNomeGPU() {
        return nomeGPU;
    }

    public void setNomeGPU(String nomeGPU) {
        this.nomeGPU = nomeGPU;
    }

    public String getDescricaoTipoMaquina() {
        return descricaoTipoMaquina;
    }

    public void setDescricaoTipoMaquina(String descricaoTipoMaquina) {
        this.descricaoTipoMaquina = descricaoTipoMaquina;
    }
    
    
   
}
