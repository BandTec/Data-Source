/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

/**
 *
 * @author fernando.oliveira
 */
public class ProcessosMaquina {

    private int idProcesso;
    private int pidProcesso;
    private List<OSProcess> procs;
    private String nomeProcesso;
    private String usoCpuProcesso;
    private String usoRamProcesso;
    private LocalDateTime dataHoraProcesso;
    SystemInfo sistema = new SystemInfo();

    public ProcessosMaquina() {
    }

    public ProcessosMaquina(int idProcesso, int pidProcesso, List<OSProcess> procs, String nomeProcesso, String usoCpuProcesso, String usoRamProcesso, LocalDateTime dataHoraProcesso) {
        this.idProcesso = idProcesso;
        this.pidProcesso = pidProcesso;
        this.procs = procs;
        this.nomeProcesso = nomeProcesso;
        this.usoCpuProcesso = usoCpuProcesso;
        this.usoRamProcesso = usoRamProcesso;
        this.dataHoraProcesso = dataHoraProcesso;
    }

    public String getProcs() {
        String nameProcs = null;
        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(10, OperatingSystem.ProcessSort.CPU));
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            nameProcs = p.getName();

        }
        return nameProcs;
    }

    public void setProcs(List<OSProcess> procs) {
        this.procs = procs;
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public int getPidProcesso() {
        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(1, OperatingSystem.ProcessSort.CPU));
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            pidProcesso = p.getProcessID();
        }
        return pidProcesso;
    }

    public void setPidProcesso(int pidProcesso) {
        this.pidProcesso = pidProcesso;
    }

    public String getNomeProcesso() {

        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(1, OperatingSystem.ProcessSort.CPU));
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            nomeProcesso = p.getName();
        }
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {

        this.nomeProcesso = nomeProcesso;
    }

    public String getUsoCpuProcesso() {

        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(1, OperatingSystem.ProcessSort.CPU));
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
           usoCpuProcesso = FormatUtil.formatBytes((long) p.calculateCpuPercent());
        }   
        return usoCpuProcesso;
    }
    public void setUsoCpuProcesso(String usoCpuProcesso) {
        this.usoCpuProcesso = usoCpuProcesso;
    }
    public String getUsoRamProcesso() {
        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(1, OperatingSystem.ProcessSort.CPU));
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            usoRamProcesso = FormatUtil.formatBytes(p.getResidentSetSize());
        }
        return usoRamProcesso;
    }
    public void setUsoRamProcesso(String usoRamProcesso) {
        this.usoRamProcesso = usoRamProcesso;
    }
    public LocalDateTime getDataHoraProcesso() {
        dataHoraProcesso = LocalDateTime.now();
        return dataHoraProcesso;
    }
    public void setDataHoraProcesso(LocalDateTime dataHoraProcesso) {
        this.dataHoraProcesso = dataHoraProcesso;
    }
}
