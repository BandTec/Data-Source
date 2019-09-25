package br.com.bandtec.datasource.model;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

public class CpuUser {

    SystemInfo sistema = new SystemInfo();

    //Atributos
    private int idUser;
    private int qtdProcesso;
    private PlatformEnum nomeSistema;
    private String processadorNome;
    private List<OSProcess> procs;
    private double cpu;
    private double cpuConvert;

    public CpuUser() {
    }

    public CpuUser(int idUser, int qtdProcesso, PlatformEnum nomeSistema, String processadorNome,
            List<OSProcess> procs, double cpu, double cpuCovert) {
        this.idUser = idUser;
        this.qtdProcesso = qtdProcesso;
        this.nomeSistema = nomeSistema;
        this.processadorNome = processadorNome;
        this.procs = procs;
        this.cpu = cpu;
        this.cpuConvert = cpuCovert;
    }

    ///método para coleta de CPU
    public void coletaCPU() throws Exception {

        //Pegando a quantidade de processos
        qtdProcesso = sistema.getOperatingSystem().getProcesses(0, OperatingSystem.ProcessSort.CPU).length;

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(CpuUser.class.getName()).log(Level.SEVERE, null, ex);
            GeracaoLog.GravarLog("Erro na classe CPU: " + ex);
        }

        try {
            //Coletando o tipo de SO que esta sendo executado.
            nomeSistema = SystemInfo.getCurrentPlatformEnum();

            //Coletando o modelo do processador que esta na máquina.
            processadorNome = sistema.getHardware().getProcessor().getName();

            //Pegando a quantidade de Cpu que esta sendo usada.
            cpu = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();

            
            //Convertendo bytes em gigabytes porque a converção padrão buga em alguns comandos.
            cpuConvert = cpu * 100;
            
            //Transformando em quantos porcento esta sendo utilizado.
            DecimalFormat df = new DecimalFormat();
            df.applyPattern("##,00");

            System.out.println("O sistema operacional que esta sendo utilizado é: " + nomeSistema);
            System.out.println("O processador da máquina é: " + processadorNome);
            System.out.println("Você está utilizando " + df.format(cpuConvert) + "% de sua CPU");
            System.out.println("Processos: " + qtdProcesso);
        } catch (NumberFormatException ex) {
            GeracaoLog.GravarLog("Erro na classe CPU: " + ex);
        }

    }

    public double getCpuConvert() {
        return cpuConvert;
    }

    public void setCpuConvert(double cpuConvert) {
        this.cpuConvert = cpuConvert;
    }

    
    public SystemInfo getSistema() {
        return sistema;
    }

    public void setSistema(SystemInfo sistema) {
        this.sistema = sistema;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getQtdProcesso() {
        return qtdProcesso = sistema.getOperatingSystem().getProcesses(0, OperatingSystem.ProcessSort.CPU).length;
    }

    public void setQtdProcesso(int qtdProcesso) {
        this.qtdProcesso = qtdProcesso;
    }

    public String getNomeSistema() {
        PlatformEnum nomeSis = SystemInfo.getCurrentPlatformEnum();
        return nomeSis.toString();
    }

    public void setNomeSistema(PlatformEnum nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public String getProcessadorNome() {
        return processadorNome = sistema.getHardware().getProcessor().getName();
    }

    public void setProcessadorNome(String processadorNome) {
        this.processadorNome = processadorNome;
    }

    public double getCpu() {
        return cpu = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks() * 100;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public String getProcs() {
        String nameProcs = null;
        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(3, OperatingSystem.ProcessSort.CPU));
        for (int i = 0; i < procs.size(); i++) {
            OSProcess p = procs.get(i);
            nameProcs = p.getName();
        }
        return nameProcs;
    }

    public void setProcs(List<OSProcess> procs) {
        this.procs = procs;
    }

}
