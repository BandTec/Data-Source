/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.conexao;

import br.com.bandtec.datasource.model.ColetaDadosMaquina;
import br.com.bandtec.datasource.model.ProcessosMaquina;
import br.com.bandtec.datasource.model.teste.CpuUser;
import br.com.bandtec.datasource.utils.GeracaoLog;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 * @author aluno
 */
public class DataSourceBot extends TelegramLongPollingBot {

    ColetaDadosMaquina coletaDadosMaquina = new ColetaDadosMaquina();
    ProcessosMaquina pm = new ProcessosMaquina();
    CpuUser cpuUser = new CpuUser();

    @Override
    public String getBotToken() {
        return "1054038373:AAE9Gg2eL1h8zOhhM2sIS_R1PFLaK6qKlBQ";
    }

    @Override
    public void onUpdateReceived(Update update) {

        String command = update.getMessage().getText();
        
        SendMessage message = new SendMessage();

        if (command.equalsIgnoreCase("dadosmaquina")) {
            try {
                GeracaoLog.GravarLog("Iniciando a resposta do DataSourcebot");
                GeracaoLog.GravarLog(update.getMessage().getText());
                message.setText(
                        "O seu Sistema operacional é " + cpuUser.getNomeSistema() + "\n"
                        + "O seu processador é " + cpuUser.getProcessadorNome() + "\n"
                        + "Seu CPU esta em " + coletaDadosMaquina.getUsoCPU() + "% \n"
                        + "Sua Memoria Ram esta em " + coletaDadosMaquina.getUsoRam() + "% \n"
                        + "Seu HD esta em " + coletaDadosMaquina.getUsoDisco() + "% ");

                GeracaoLog.GravarLog(
                        "O seu Sistema operacional é " + cpuUser.getNomeSistema() + "\n"
                        + "O seu processador é " + cpuUser.getProcessadorNome() + "\n"
                        + "Seu CPU esta em " + coletaDadosMaquina.getUsoCPU() + "% \n"
                        + "Sua Memoria Ram esta em " + coletaDadosMaquina.getUsoRam() + "% \n"
                        + "Seu HD esta em " + coletaDadosMaquina.getUsoDisco() + "% ");
            } catch (IOException ex) {
                message.setText("Desculpe não consegui encontrar os dados da maquina");
                Logger.getLogger(DataSourceBot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (command.equalsIgnoreCase("processosmaquina")) {
            try {
                GeracaoLog.GravarLog("Iniciando a resposta do DataSourcebot");
                GeracaoLog.GravarLog(update.getMessage().getText());
                
                List<String> lista = new ArrayList<>();
                List<String> lista1 = new ArrayList<>();
                lista.add("Sera exibido uma lista dos processos do Sistema Opercional.");
                for (int i = 0; i < 10; i++) {              
                            lista1.add(" "+i+ " PID: " +pm.getPidProcesso().get(i) 
                                    + "   Nome: "+ pm.getNomeProcesso().get(i) + "\n");
                }
                message.setText(lista.toString()+"\n"+ lista1.toString());
                GeracaoLog.GravarLog(lista.toString()+"\n"+ lista1.toString());
            } catch (IOException ex) {
                message.setText("Desculpe não consegui encontrar a lista");
                Logger.getLogger(DataSourceBot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (command.equalsIgnoreCase("Que dia e hoje?")) {
            System.out.println(update.getMessage().getText());
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy ")));

            message.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy ")));
        }

        if (command.equalsIgnoreCase("Qual o meu nome?")) {
            System.out.println(update.getMessage().getText());
            System.out.println(update.getMessage().getFrom().getFirstName());

            message.setText(update.getMessage().getFrom().getFirstName());
        }

        if (command.equalsIgnoreCase("Qual meu sobre nome?")) {
            System.out.println(update.getMessage().getText());
            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        }

        if (command.equalsIgnoreCase("Qual meu nome completo?")) {
            System.out.println(update.getMessage().getText());
            System.out.println(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
        }

        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        } catch (TelegramApiException ex) {
            Logger.getLogger(DataSourceBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getBotUsername() {
        return "data_source_bot";
    }

}
