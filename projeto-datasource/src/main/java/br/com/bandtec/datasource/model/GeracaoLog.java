
package br.com.bandtec.datasource.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;


public class GeracaoLog {
    
    
        public static void GravarLog(String mensagem) throws IOException {
            
            
//         SystemInfo sistema = new SystemInfo();     
//         sistema.getOperatingSystem();
//        //Coletando o tipo de SO que esta sendo executado.
//        PlatformEnum nomeSistema = SystemInfo.getCurrentPlatformEnum();   
        String pastaLinux = "/home/LogsDataSource";
//        String pastaWindows = "C:\\LogsDataSource";
        
        File diretorio = new File(pastaLinux);
            diretorio.mkdir();
        File arquivo = new File(pastaLinux + "/LogsdeExecução.txt");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        List<String> lista = new ArrayList<>();
        lista.add("[" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "] " + mensagem);
        Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
    }
    
}
