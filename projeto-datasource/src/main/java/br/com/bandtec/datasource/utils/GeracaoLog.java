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
        String pastaLinux1 = "/home/aluno/Documents";
        String pastaLinux2 = "/home/fernando.oliveira/Documents";
        String pastaLinux3 = "/home/joao_vinicius/Documentos";

        if (PlatformEnum.LINUX.equals(nomeSistema)) {
            if (pastaLinux1.equals("/home/aluno/Documents")) {
                File diretorio = new File(pastaLinux1);
                diretorio.mkdir();
                File arquivo = new File(pastaLinux1 + "/LogsDataSource.txt");
                if (!arquivo.exists()) {
                    arquivo.createNewFile();
                }
                List<String> lista = new ArrayList<>();
                lista.add("[" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "] " + mensagem);
                Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
            } else if (pastaLinux2.equals("/home/fernando.oliveira/Documents")) {
                File diretorio = new File(pastaLinux2);
                diretorio.mkdir();
                File arquivo2 = new File(pastaLinux2 + "/LogsDataSource.txt");
                if (!arquivo2.exists()) {
                    arquivo2.createNewFile();
                }
                List<String> lista = new ArrayList<>();
                lista.add("[" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "] " + mensagem);
                Files.write(Paths.get(arquivo2.getPath()), lista, StandardOpenOption.APPEND);
            } else if (pastaLinux3.equals("/home/joao_vinicius/Documentos")) {
                File diretorio = new File(pastaLinux3);
                diretorio.mkdir();
                File arquivo3 = new File(pastaLinux3 + "/LogsDataSource.txt");
                if (!arquivo3.exists()) {
                    arquivo3.createNewFile();
                }
                List<String> lista = new ArrayList<>();
                lista.add("[" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "] " + mensagem);
                Files.write(Paths.get(arquivo3.getPath()), lista, StandardOpenOption.APPEND);
            }

        } else if (PlatformEnum.WINDOWS.equals(nomeSistema)) {

            String caminhoWin1 = "C:\\Users\\Guide\\Documents";
            String caminhoWin2 = "C:\\Users\\kessi.santana\\Documents";

            if (caminhoWin1.equals("C:\\Users\\Guide\\Documents")) {
                File diretorio = new File(caminhoWin1);
                diretorio.mkdir();

                File arquivo = new File(caminhoWin1 + "/LogsDataSource.txt");

                if (!arquivo.exists()) {
                    arquivo.createNewFile();
                }
                List<String> lista = new ArrayList<>();
                lista.add("[" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "] " + mensagem);
                Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
            } else if (caminhoWin2.equals("C:\\Users\\kessi.santana\\Documents")) {
                File diretorio = new File(caminhoWin1);
                diretorio.mkdir();

                File arquivo = new File(caminhoWin1 + "/LogsDataSource.txt");

                if (!arquivo.exists()) {
                    arquivo.createNewFile();
                }
                List<String> lista = new ArrayList<>();
                lista.add("[" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "] " + mensagem);
                Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
            }
        }
    }
}
