/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.application;

import br.com.bandtec.datasource.conexao.ConexaoBD;
import br.com.bandtec.datasource.model.CpuUser;
import br.com.bandtec.datasource.model.DiscoRigidoUser;
import br.com.bandtec.datasource.view.TelaLogin;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class ColetarDados {

    public static void main(String[] args) throws Exception {

        ConexaoBD con = new ConexaoBD();
        CpuUser cpu = new CpuUser();
        DiscoRigidoUser hds = new DiscoRigidoUser();
        SystemInfo si = new SystemInfo();
        TelaLogin tela = new TelaLogin();

        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();

//        cpu.coletaCPU();
//        hds.printDisks(hal.getDiskStores());
//        hds.coletaDisco();
        tela.setVisible(true);
//       tela.setVisible(false);

//        con.conectarBD();
        while (true) {
            Thread.sleep(10000);
            con.incluirTeste();
        }
    }
}
