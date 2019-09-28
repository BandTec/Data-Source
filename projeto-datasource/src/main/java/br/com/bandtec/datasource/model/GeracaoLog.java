
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
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;


public class GeracaoLog {
    
    
     private PlatformEnum nomeSistema;
    
        public static void GravarLog(String mensagem) throws IOException {
            
            
         SystemInfo sistema = new SystemInfo();     
      
//        //Coletando o tipo de SO que esta sendo executado.
//        nomeSistema = SystemInfo.getCurrentPlatformEnum();   
        String pastaLinux = "/home/Bandtec/Documents";
        String pastaWindows = "C:\\";
        
//        if(nomeSistema.LINUX){
//            
//        }
        
        File diretorio = new File(pastaLinux);
            diretorio.mkdir();
        File arquivo = new File(pastaLinux + "/LogsDataSource.txt");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        List<String> lista = new ArrayList<>();
        lista.add("[" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "] " + mensagem);
        Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
    }
    
}
