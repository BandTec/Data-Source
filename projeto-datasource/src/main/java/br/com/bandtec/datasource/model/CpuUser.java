package br.com.bandtec.datasource.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

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
            //Pegando o total de memória RAM do computador.
            long totalRAM = sistema.getHardware().getMemory().getTotal();
            //Pegando a memória RAM que esta sendo usada.
            long RAMUsada = sistema.getHardware().getMemory().getAvailable();
            //Cálculo para dar a porcentagem de memória RAM que esta sendo utilizada.
            long RAM = ((RAMUsada * 100) / totalRAM);

            System.out.println("O sistema operacional que esta sendo utilizado é: " + nomeSistema);
            System.out.println("O processador da máquina é: " + processadorNome);
            System.out.println("Você está utilizando " + df.format(cpuConvert) + "% de sua CPU");
            System.out.println("Você esta utilizando " + RAM + "% de sua memória RAM");
            System.out.println("Total Memória RAM: " + FormatUtil.formatBytes(totalRAM));
            System.out.println("Memória RAM usada: " + FormatUtil.formatBytes(RAMUsada));
            System.out.println("Ipv4 : " + sistema.getOperatingSystem().getNetworkParams().getIpv4DefaultGateway());
            System.out.println("Nome da Maquina : " + sistema.getOperatingSystem().getNetworkParams().getDomainName());
            System.out.println("Processos: " + qtdProcesso);

            this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(qtdProcesso, OperatingSystem.ProcessSort.CPU));
            for (int i = 0; i < procs.size(); i++) {
                OSProcess processos = procs.get(i);
                System.out.println("\nLista de Processos: " + processos.getName());
                System.out.println("PID do processo  " + processos.getProcessID());
            }
           

            GeracaoLog.GravarLog("Sistema Operacional : " + nomeSistema);
            GeracaoLog.GravarLog("Processador: " + processadorNome);
            GeracaoLog.GravarLog("Você está utilizando " + df.format(cpuConvert) + "% de sua CPU");
            GeracaoLog.GravarLog("Você esta utilizando " + RAM + "% de sua memória RAM");
            GeracaoLog.GravarLog("Memória RAM Total: " + FormatUtil.formatBytes(totalRAM));
            GeracaoLog.GravarLog("Memória RAM Usada: " + FormatUtil.formatBytes(RAMUsada)+"\n");

//            GeracaoLog.GravarLog("RAM Total: " +sistema.getHardware().getMemory().getTotal());
//            GeracaoLog.GravarLog("Ram Usada: " +sistema.getHardware().getMemory().getAvailable()+"\n"); 
//            GeracaoLog.GravarLog("HD: " + Arrays.asList(sistema.getHardware().getDiskStores()));
//            GeracaoLog.GravarLog("GPU: " +processadorNome);
//            System.out.println("" +   Arrays.toString(sistema.getOperatingSystem().getChildProcesses(2, 2, OperatingSystem.ProcessSort.CPU)));
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
        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(5, OperatingSystem.ProcessSort.CPU));
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
