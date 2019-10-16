package br.com.bandtec.datasource.utils;

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

public class GeracaoLog {

    public static void GravarLog(String mensagem) throws IOException {
        SystemInfo sistema = new SystemInfo();
//        //Coletando o tipo de SO que esta sendo executado.
        PlatformEnum nomeSistema = SystemInfo.getCurrentPlatformEnum();
        if (PlatformEnum.LINUX.equals(nomeSistema)) {           
//            String pastaLinux = "/home/Bandtec/Documentos";
             String pastaLinux = "/home/fernando.oliveira/Documents";

            File diretorio = new File(pastaLinux);
            diretorio.mkdir();
            File arquivo = new File(pastaLinux + "/LogsDataSource.txt");

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            List<String> lista = new ArrayList<>();
            lista.add("[" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "] " + mensagem);
            Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);

        } else if (PlatformEnum.WINDOWS.equals(nomeSistema)) {

            String caminhoWin = "C:\\Users\\Guide\\Documentos";
//          String caminhoWin = "C:\\Users\\KessyJonny\\Documents";
            File diretorio = new File(caminhoWin);
            diretorio.mkdir();
            File arquivo = new File(caminhoWin + "/LogsDataSource.txt");

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            List<String> lista = new ArrayList<>();
            lista.add("[" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "] " + mensagem);
            Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
        }
    }
}
