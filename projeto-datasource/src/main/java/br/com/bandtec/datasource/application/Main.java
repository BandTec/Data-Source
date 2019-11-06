package br.com.bandtec.datasource.application;

import br.com.bandtec.datasource.dao.ProcessosMaquinaDAO;
import br.com.bandtec.datasource.model.teste.CpuUser;
import br.com.bandtec.datasource.view.TelaLogin;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class Main {

    public static void main(String[] args) throws Exception {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
          SystemInfo si = new SystemInfo();

        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();
      
        CpuUser cpu = new CpuUser();
//        cpu.coletaCPU(os.getFileSystem());
   
    }
}
