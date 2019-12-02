/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
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
    private Integer usoCpuProcesso;
    private String usoRamProcesso;
    private LocalDateTime dataHoraProcesso;
    SystemInfo sistema = new SystemInfo();

    public ProcessosMaquina() {
    }

    public ProcessosMaquina(int idProcesso, int pidProcesso, List<OSProcess> procs, String nomeProcesso, Integer usoCpuProcesso, String usoRamProcesso, LocalDateTime dataHoraProcesso) {
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

    public List<String> getPidProcesso() {
        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(10, OperatingSystem.ProcessSort.CPU));
        List<String> listaPID = new ArrayList<>();
        for (final OSProcess process : procs) {
            pidProcesso = process.getProcessID();
            listaPID.add(String.valueOf(pidProcesso));
        }
        return listaPID;
    }

    public void setPidProcesso(int pidProcesso) {
        this.pidProcesso = pidProcesso;
    }

    public List<String> getNomeProcesso() {
        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(10, OperatingSystem.ProcessSort.CPU));
        List<String> listaNomeProc = new ArrayList<>();
        for (final OSProcess process : procs) {
            nomeProcesso = process.getName();
            listaNomeProc.add(nomeProcesso);
        }
        return listaNomeProc;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    public List<Integer> getUsoCpuProcesso() {
        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(10, OperatingSystem.ProcessSort.CPU));
        List<Integer> listaUsoCpu = new ArrayList<>();
        for (final OSProcess process : procs) {
            usoCpuProcesso = (int) process.calculateCpuPercent();
            listaUsoCpu.add(usoCpuProcesso);
        }
        return listaUsoCpu;
    }

    public void setUsoCpuProcesso(Integer usoCpuProcesso) {
        this.usoCpuProcesso = usoCpuProcesso;
    }

    public List<String> getUsoRamProcesso() {
        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(10, OperatingSystem.ProcessSort.CPU));
        List<String> listaUsoRam = new ArrayList<>();
        for (final OSProcess process : procs) {
            usoRamProcesso = FormatUtil.formatBytes(process.getResidentSetSize());
            listaUsoRam.add(usoRamProcesso);
        }
        return listaUsoRam;
    }

    public void setUsoRamProcesso(String usoRamProcesso) {
        this.usoRamProcesso = usoRamProcesso;
    }

    public LocalDateTime getDataHoraProcesso() {
        dataHoraProcesso = LocalDateTime.now(ZoneId.of("America/Buenos_Aires"));
        return dataHoraProcesso;
    }

    public void setDataHoraProcesso(LocalDateTime dataHoraProcesso) {
        this.dataHoraProcesso = dataHoraProcesso;
    }
}
