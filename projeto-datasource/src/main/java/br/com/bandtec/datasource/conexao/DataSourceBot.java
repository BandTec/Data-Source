/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.conexao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Override
    public String getBotToken() {
        return "689180142:AAHBCk-T7PogVo1J7qzYAI1HLVeB78-15P4";
    }

    @Override
    public void onUpdateReceived(Update update) {
        
//            System.out.println(update.getMessage().getText());
//            System.out.println(update.getMessage().getFrom().getFirstName() );

            String command= update.getMessage().getText();

            SendMessage message = new SendMessage();
            
               if(command.equals("Que dia e hoje?")){

                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy ")));

                message.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy ")));
            }

            if(command.equals("Qual o meu nome?")){

                System.out.println(update.getMessage().getFrom().getFirstName());

                message.setText(update.getMessage().getFrom().getFirstName());
            }

            if (command.equals("Qual meu sobre nome?")){

                System.out.println(update.getMessage().getFrom().getLastName());
                message.setText(update.getMessage().getFrom().getLastName());
            }

            if (command.equals("Qual meu nome completo?")){
                System.out.println(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
           message.setText(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
            }

            message. setChatId(update.getMessage().getChatId());


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
