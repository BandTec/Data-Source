/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.application;

import br.com.bandtec.datasource.conexao.ConexaoBD;
import br.com.bandtec.datasource.model.CpuUser;
import br.com.bandtec.datasource.model.DiscoRigidoUser;
import br.com.bandtec.datasource.view.TelaLogin1;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class ColetarDados {
    
     public static void main(String[] args) throws Exception {
        
        ConexaoBD con = new ConexaoBD();
        CpuUser cpu = new CpuUser(); 
        DiscoRigidoUser hds = new DiscoRigidoUser();
        TelaLogin1 tela = new TelaLogin1(); 
        SystemInfo si = new SystemInfo();

        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();
        
        tela.setVisible(false);
//        cpu.coletaCPU();
//        hds.printDisks(hal.getDiskStores());
         hds.coletaDisco();
       
//        con.conectarBD();
//        con.incluirTeste();
             
    }
    
}
