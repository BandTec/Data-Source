/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.model;

import java.io.File;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.util.FormatUtil;

/**
 *
 * @author Bandtec
 */
public class DiscoRigidoUser {
    
    SystemInfo sistema = new SystemInfo();

    File[] disk = File.listRoots();
    
    private HWDiskStore[] hwDisks;
    private HWDiskStore disk1;
    private long tamanhoDisk;
    private String DiskC;
    private String DiskD;
    private long convercao;

    public DiscoRigidoUser() {
    }

    public DiscoRigidoUser(HWDiskStore[] hwDisks, HWDiskStore disk1, long tamanhoDisk, String DiskC, String DiskD, long convercao) {
        this.hwDisks = hwDisks;
        this.disk1 = disk1;
        this.tamanhoDisk = tamanhoDisk;
        this.DiskC = DiskC;
        this.DiskD = DiskD;
        this.convercao = convercao;
    }

    //Getters and Setters
    public long getTamanhoDisk() {
        return tamanhoDisk = disk1.getSize();
    }

    public void setTamanhoDisk(long tamanhoDisk) {
        this.tamanhoDisk = tamanhoDisk;
    }

    public String getDiskC() {
        return DiskC;
    }

    public void setDiskC(String DiskC) {
        this.DiskC = DiskC;
    }

    public long getconvercao() {
        return convercao;
    }

    public void setusando1(long convercao) {
        this.convercao = convercao;
    }

    public String getDiskD() {
        for (File partition : disk) {
            partition.getAbsolutePath();

            //pega o caminho absoluto do disco, mostrando se é o disco D ou outro
            System.out.println();
            //verifica se o disco é o disco D. Sem essa condição, ele mostra todos as unidades de armazenamento que achar
            DiskD = FormatUtil.formatBytes(partition.getUsableSpace());

        }
        return DiskD;
    }

    public void setDiskD(String DiskD) {
        this.DiskD = DiskD;
    }
    
    //Método para fazer a coleta de disco
    public void coletaDisco() throws Exception {
        
        try {
        /*Acessando o histórico de discos do computador: HD/SSD/PENDRIVE/etc...
      e colocando em um Array.
         */
        hwDisks = sistema.getHardware().getDiskStores();

        //Loop para acessar todos os campos do array.
        for (HWDiskStore hwDisk : hwDisks) {
            //Váriavel para acessar os campos do array conforme a váriavel i se incrementa.
            disk1 = hwDisk;
            //Convertendo os valores bugados do oshi em bytes.
            tamanhoDisk = disk1.getSize();
            /*soust para exibir o valor e o FormatUtil é uma converção padrão do oshi para
            converter bytes em gigabytes etc...
             */
            System.out.println("Você possui " + FormatUtil.formatBytesDecimal(tamanhoDisk) + " de espaço em seu HD");
        }
        } catch (Exception ex){
            GeracaoLog.GravarLog("Erro na classe Disco " + ex);
        }
        
        try {
        for (File partition : disk) {
            DiskC = partition.getAbsolutePath();
            DiskD = partition.getAbsolutePath();

            //pega o caminho absoluto do disco, mostrando se é o disco C ou outro
            if (DiskC.charAt(0) == 'C') {
                convercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
                //verifica se o disco é o disco C. Sem essa condição, ele mostra todos as unidades de armazenamento que achar
                System.out.println("Espaço total do disco: " + FormatUtil.formatBytes(partition.getTotalSpace()));
                System.out.println("Quantidade de espaço sobrando do HD: " + FormatUtil.formatBytes(partition.getUsableSpace()));
                System.out.println("Quantidade de espaço sendo usada no HD " + FormatUtil.formatBytes(partition.getTotalSpace() - partition.getUsableSpace()));
               
              
            }
            if (DiskD.charAt(0) == 'D') {
                convercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
//                usando1 = Integer.parseInt(usando);
                //verifica se o disco é o disco D. Sem essa condição, ele mostra todos as unidades de armazenamento que achar
                System.out.println("Espaço total do disco: " + FormatUtil.formatBytes(partition.getTotalSpace()));
//                                System.out.println("Espaço total do disco: " + i.getTotalSpace());
                System.out.println("Quantidade de espaço sobrando do HD: " + FormatUtil.formatBytes(partition.getUsableSpace()));
                System.out.println("Quantidade de espaço sendo usada no HD " + FormatUtil.formatBytes(partition.getTotalSpace() - partition.getUsableSpace()));
                
               
            }
        }
    } catch (Exception ex){
        GeracaoLog.GravarLog("Erro nos discos C e D: " + ex);
    }
    }

    
    
}
