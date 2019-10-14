
package br.com.bandtec.datasource.model;

import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.util.FormatUtil;


public class MemoriaUser {
    
     SystemInfo sistema = new SystemInfo();

    private PlatformEnum nomeSistema;
    private long totalRAM;
    private long RamDisponivel;
    private long RamUsada;
    private long PorcentagemRam;

    public MemoriaUser() {

    }

    public MemoriaUser(PlatformEnum nomeSistema, long totalRAM, long RamDisponivel, long RamUsada, long PorcentagemRam) {
        this.nomeSistema = nomeSistema;
        this.totalRAM = totalRAM;
        this.RamDisponivel = RamDisponivel;
        this.RamUsada = RamUsada;
        this.PorcentagemRam = PorcentagemRam;
    }

    public void coletaMemoria() {

        nomeSistema = SystemInfo.getCurrentPlatformEnum();

        totalRAM = sistema.getHardware().getMemory().getTotal();
        
        RamDisponivel = sistema.getHardware().getMemory().getAvailable();
        
        RamUsada = totalRAM - RamDisponivel;
       
        PorcentagemRam = ((RamUsada * 100) / totalRAM);

        String total = FormatUtil.formatBytes(totalRAM);

        System.out.println(" sistema operacional  utilizado é: " + nomeSistema);
        System.out.println("Você esta utilizando " + PorcentagemRam + "% de sua memória RAM");
        System.out.println("Total Memória RAM: " + total);
        System.out.println("Memória RAM usada: " + FormatUtil.formatBytes(RamUsada));
        System.out.println("Memória RAM disponivel: " + FormatUtil.formatBytes(RamDisponivel));
    }

    public String getNomeSistema() {
        PlatformEnum nome = SystemInfo.getCurrentPlatformEnum();
        return nome.toString();
    }

    public void setNomeSistema(PlatformEnum nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public SystemInfo getDados() {
        return sistema;
    }

    public void setDados(SystemInfo dados) {
        this.sistema = dados;
    }

    public String getTotalRAM() {
        totalRAM = sistema.getHardware().getMemory().getTotal();
        String total = FormatUtil.formatBytes(totalRAM);
        return total;

    }

    public void setTotalRAM(long totalRAM) {
        this.totalRAM = totalRAM;
    }

    public String getRamDisponivel() {
        RamDisponivel = sistema.getHardware().getMemory().getAvailable();
        String disponivel = FormatUtil.formatBytes(RamDisponivel);
        return disponivel;
    }

    public void setRamDisponivel(long RamDisponivel) {
        this.RamDisponivel = RamDisponivel;
    }

    public String getRamUsada() {
        totalRAM = sistema.getHardware().getMemory().getTotal();

        RamDisponivel = sistema.getHardware().getMemory().getAvailable();

        RamUsada = totalRAM - RamDisponivel;

        String usada = FormatUtil.formatBytes(RamUsada);

        return usada;
    }

    public void setRamUsada(long RamUsada) {
        this.RamUsada = RamUsada;
    }

    public String getPorcentagemRam() {
        totalRAM = sistema.getHardware().getMemory().getTotal();
        RamDisponivel = sistema.getHardware().getMemory().getAvailable();
        RamUsada = totalRAM - RamDisponivel;
         PorcentagemRam = ((RamUsada * 100) / totalRAM);
       String usada = Long.toString(PorcentagemRam);
        return usada;
    }

    public void setPorcentagemRam(long PorcentagemRam) {
        this.PorcentagemRam = PorcentagemRam;
    }  
}
