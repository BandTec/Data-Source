/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.model;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.hardware.HWPartition;

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
    private String nomeDisk;

    public DiscoRigidoUser() {
    }

    public DiscoRigidoUser(HWDiskStore[] hwDisks, HWDiskStore disk1, long tamanhoDisk, String DiskC, String DiskD, long convercao, String nomeDisk) {
        this.hwDisks = hwDisks;
        this.disk1 = disk1;
        this.tamanhoDisk = tamanhoDisk;
        this.DiskC = DiskC;
        this.DiskD = DiskD;
        this.convercao = convercao;
        this.nomeDisk = nomeDisk;
    }

    public String getNomeDisk() {
        return nomeDisk = disk1.getName();
    }

    public void setNomeDisk(String nomeDisk) {
        this.nomeDisk = nomeDisk;
    }

    // Getters and Setters
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

    public void printDisks(HWDiskStore[] diskStores) {
        System.out.println("Disks:");
        for (HWDiskStore disk : diskStores) {
            boolean readwrite = disk.getReads() > 0 || disk.getWrites() > 0;
            System.out.format(" %s: Marca do HD: %s \n Tamanho do HD: %s",
                    disk.getName(),
                    disk.getModel(),
                    disk.getSize() > 0 ? FormatUtil.formatBytesDecimal(disk.getSize()) : "?");
            HWPartition[] partitions = disk.getPartitions();
            if (partitions == null) {
                // TODO Remove when all OS's implemented
                continue;
            }
            for (HWPartition part : partitions) {
                System.out.format(" |-- %s: %s (%s) size: %s%s%n", part.getIdentification(),
                        part.getName(),
                        part.getType(),
                        FormatUtil.formatBytesDecimal(part.getSize()),
                        part.getMountPoint().isEmpty() ? "" : " @ " + part.getMountPoint());
                System.out.println("");
            }
        }
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
                nomeDisk = disk1.getName();
                System.out.println("A marca do seu HD é " + disk1.getModel());
                System.out.println("Você possui " + FormatUtil.formatBytesDecimal(tamanhoDisk) + " de espaço em seu HD");

            }
        } catch (Exception ex) {
            GeracaoLog.GravarLog("Erro na classe Disco " + ex);
        }

        try {
            for (File partition : disk) {
                DiskC = partition.getAbsolutePath();
                DiskD = partition.getAbsolutePath();

                PlatformEnum nomeSistema = SystemInfo.getCurrentPlatformEnum();
                if (PlatformEnum.LINUX.equals(nomeSistema)) {
                    //pega o caminho absoluto do disco, mostrando se é o disco C ou outro
                    if (DiskC.charAt(0) == '/') {
                        convercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
                        //verifica se o disco é o disco C. Sem essa condição, ele mostra todos as unidades de armazenamento que achar
                        System.out.println("Espaço total do disco: " + FormatUtil.formatBytes(partition.getTotalSpace()));
                        System.out.println("Quantidade de espaço sobrando do HD: " + FormatUtil.formatBytes(partition.getUsableSpace()));
                        System.out.println("Quantidade de espaço sendo usada no HD " + FormatUtil.formatBytes(partition.getTotalSpace() - partition.getUsableSpace()));

                    }
                    // Sistema Windows
                } else {
                    if (DiskC.charAt(0) == 'C') {
                        convercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
                        //verifica se o disco é o disco C. Sem essa condição, ele mostra todos as unidades de armazenamento que achar
                        System.out.println("Espaço total do disco: " + FormatUtil.formatBytes(partition.getTotalSpace()));
                        System.out.println("Quantidade de espaço sobrando do HD: " + FormatUtil.formatBytes(partition.getUsableSpace()));
                        System.out.println("Quantidade de espaço sendo usada no HD " + FormatUtil.formatBytes(partition.getTotalSpace() - partition.getUsableSpace()));

                    } else if (DiskD.equals("D")) {
                        convercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
                        //                usando1 = Integer.parseInt(usando);
                        //verifica se o disco é o disco D. Sem essa condição, ele mostra todos as unidades de armazenamento que achar
                        System.out.println("Espaço total do disco: " + FormatUtil.formatBytes(partition.getTotalSpace()));
                        //                                System.out.println("Espaço total do disco: " + i.getTotalSpace());
                        System.out.println("Quantidade de espaço sobrando do HD: " + FormatUtil.formatBytes(partition.getUsableSpace()));
                        System.out.println("Quantidade de espaço sendo usada no HD " + FormatUtil.formatBytes(partition.getTotalSpace() - partition.getUsableSpace()));

                    }

                }
            }
        } catch (Exception ex) {
            GeracaoLog.GravarLog("Erro nos discos C e D: " + ex);
        }
    }
}
