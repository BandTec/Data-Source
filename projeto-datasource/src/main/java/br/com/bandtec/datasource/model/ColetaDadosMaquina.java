/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.model;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import oshi.SystemInfo;

/**
 *
 * @author fernando.oliveira
 */
public class ColetaDadosMaquina {

    private int idColetaDados;
    private long usoCPU;
    private long usoRam;
    private long usoDisco;
    private LocalDateTime dataHoraColeta;
    SystemInfo sistema = new SystemInfo();

    long totalRAM = sistema.getHardware().getMemory().getTotal();
    long RamDisponivel = sistema.getHardware().getMemory().getAvailable();
    long RamUsada = totalRAM - RamDisponivel;
    long PorcentagemRam = ((RamUsada * 100) / totalRAM);
    double usoCPU1 = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
    double cpuConvert = usoCPU1 * 100;

    public ColetaDadosMaquina() {
    }

    public ColetaDadosMaquina(int idColetaDados, long usoCPU, long usoRam, long usoDisco, LocalDateTime dataHoraColeta) {
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

    public long getUsoCPU() {
        usoCPU = (long) cpuConvert;
        return usoCPU;
    }

    public void setUsoCPU(long usoCPU) {
        this.usoCPU = usoCPU;
    }

    public long getUsoRam() {
        usoRam = PorcentagemRam;
        return usoRam;
    }

    public void setUsoRam(long usoRam) {
        this.usoRam = usoRam;
    }

    public long getUsoDisco() {
        File[] disk = File.listRoots();
        for (File partition : disk) {
            String DiskC = partition.getAbsolutePath();
            if (DiskC.charAt(0) == 'C') {
                long discoConvercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
                usoDisco = discoConvercao;
            }
            if (DiskC.charAt(0) == '/') {
                long discoConvercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
                usoDisco = discoConvercao;
            }
        }
        return usoDisco;
    }

    public void setUsoDisco(long usoDisco) {
        this.usoDisco = usoDisco;
    }

    public LocalDateTime getDataHoraColeta() {
        dataHoraColeta = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        return dataHoraColeta;
    }

    public void setDataHoraColeta(LocalDateTime dataHoraColeta) {
        this.dataHoraColeta = dataHoraColeta;
    }
}
