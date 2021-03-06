package br.com.bandtec.datasource.model.teste;

import br.com.bandtec.datasource.utils.GeracaoLog;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class CpuUser {

    SystemInfo sistema = new SystemInfo();
    Components components = JSensors.get.components();

    //Atributos
    private int idUser;
    private int qtdProcesso;
    private PlatformEnum nomeSistema;
    private String processadorNome;
    private List<OSProcess> procs;
    private double cpu;
    private double cpuConvert;
    private transient double cpuPercent = -1d;
    private long usadoDisco;
    private long totalDisco;
    private long disponivelDisco;
    private float porcentagem;

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
    public void coletaCPU(FileSystem fileSystem) throws Exception {

        List<Gpu> gpus = components.gpus;

        //Pegando a quantidade de processos
        qtdProcesso = sistema.getOperatingSystem().getProcesses(0, OperatingSystem.ProcessSort.CPU).length;

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
            long RamDisponivel = sistema.getHardware().getMemory().getAvailable();
            // Calculo para pegar a memoria ram USADA no SISTEMA
            long RamUsada = totalRAM - RamDisponivel;
            //Cálculo para dar a porcentagem de memória RAM que esta sendo utilizada.
            long PorcentagemRam = ((RamUsada * 100) / totalRAM);

            OSFileStore[] fsArray = fileSystem.getFileStores();

            if (gpus != null) {
                for (final Gpu gpu : gpus) {
                    System.out.println("NOME GPU: " + gpu.name);
                    if (gpu.sensors != null) {
                        System.out.println("Sensors: ");

                        //Print temperatures
                        List<Temperature> temps = gpu.sensors.temperatures;
                        for (final Temperature temp : temps) {
                            System.out.println(temp.name + ": " + temp.value + " C");
                        }

                        //Print fan speed
                        List<Fan> fans = gpu.sensors.fans;
                        for (final Fan fan : fans) {
                            System.out.println(fan.name + ": " + fan.value + " RPM");
                        }
                    }
                }
            }

////          pegando o nome da placa de video
//            String nomeGPU = components.gpus.get(0).name;
////          pegando a temperatura da placa de video
//            String TEMPGPU = components.gpus.get(0).sensors.temperatures.get(0).value.toString();
//
//            String PlacaMae = components.mobos.get(0).name;
//            String NomeCPU = components.cpus.get(0).name;
//            String TempCPU = components.cpus.get(0).sensors.temperatures.get(0).value.toString();
            File[] disk = File.listRoots();

            for (File i : disk) {
                String DiskC = i.getAbsolutePath();
                if (DiskC.charAt(0) == 'C') {
                    for (OSFileStore fs : fsArray) {
                         usadoDisco = fs.getUsableSpace();
                         totalDisco = fs.getTotalSpace();
                         disponivelDisco = totalDisco - usadoDisco;
                         porcentagem = (float) (100d * usadoDisco / totalDisco);

                        System.out.println("O sistema operacional que esta sendo utilizado é: " + nomeSistema);
                        System.out.println("O processador da máquina é: " + processadorNome);
                        System.out.println("Você está utilizando " + df.format(cpuConvert) + "% de sua CPU");
                        System.out.println("Você esta utilizando " + PorcentagemRam + "% de sua memória RAM");
                        System.out.println("Total Memória RAM: " + FormatUtil.formatBytes(totalRAM));
                        System.out.println("Memória RAM usada: " + FormatUtil.formatBytes(RamUsada));
                        System.out.println("Memória RAM disponivel para uso: " + FormatUtil.formatBytes(RamDisponivel));
                        System.out.println("Disco total: " + FormatUtil.formatBytes(totalDisco));
                        System.out.println("Disco usado: " + FormatUtil.formatBytes(usadoDisco));
                        System.out.println("Disco disponivel para uso: " + FormatUtil.formatBytes(disponivelDisco));
                        System.out.println("Ipv4 : " + sistema.getOperatingSystem().getNetworkParams().getIpv4DefaultGateway());
                        System.out.println("Nome da Maquina : " + sistema.getOperatingSystem().getNetworkParams().getDomainName());
                        System.out.println("Processos: " + qtdProcesso);
                        if (gpus != null) {
                            gpus.forEach((gpu) -> {
                                System.out.println("NOME GPU: " + gpu.name + "\n");
                             });
                        }

                        this.procs = Arrays.asList(sistema.getOperatingSystem().getProcesses(5, OperatingSystem.ProcessSort.CPU));
                        for (final OSProcess process : procs) {

                            System.out.println("\nLista de Processos: " + process.getName());
                            System.out.println("PID do processo  " + process.getProcessID());
                            System.out.println("CPUPorceProcess " + process.calculateCpuPercent());
                            System.out.println("RAMPorcentProcess " + FormatUtil.formatBytes(process.getResidentSetSize()));

                        }

                        GeracaoLog.GravarLog("Sistema Operacional : " + nomeSistema);
                        GeracaoLog.GravarLog("Processador: " + processadorNome);
                        GeracaoLog.GravarLog("Você está utilizando " + df.format(cpuConvert) + "% de sua CPU");
                        GeracaoLog.GravarLog("Você esta utilizando " + PorcentagemRam + "% de sua memória RAM");
                        GeracaoLog.GravarLog("Memória RAM Total: " + FormatUtil.formatBytes(totalRAM));
                        GeracaoLog.GravarLog("Memória RAM Disponivel para uso: " + FormatUtil.formatBytes(RamDisponivel));
                        GeracaoLog.GravarLog("Memória RAM Usada: " + FormatUtil.formatBytes(RamUsada));

                        GeracaoLog.GravarLog("Disco TOTAL: " + FormatUtil.formatBytes(totalDisco));
                        GeracaoLog.GravarLog("Disco Usado: " + FormatUtil.formatBytes(usadoDisco));
                        GeracaoLog.GravarLog("Disco Disponivel: " + FormatUtil.formatBytes(disponivelDisco));

                        if (gpus != null) {
                            for (final Gpu gpu : gpus) {
                                GeracaoLog.GravarLog("NOME GPU: " + gpu.name + "\n");
                            }
                        }
                    }
                }
            }
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

    public long getUsadoDisco() {
        return usadoDisco;
    }

    public void setUsadoDisco(long usadoDisco) {
        this.usadoDisco = usadoDisco;
    }

    public String getTotalDisco() {
        String total = Long.toString(totalDisco);
        return total;
    }

    public void setTotalDisco(long totalDisco) {
        this.totalDisco = totalDisco;
    }

    public long getDisponivelDisco() {
        return disponivelDisco;
    }

    public void setDisponivelDisco(long disponivelDisco) {
        this.disponivelDisco = disponivelDisco;
    }

    public float getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(float porcentagem) {
        this.porcentagem = porcentagem;
    }
}
