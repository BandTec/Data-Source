package br.com.bandtec.datasource.application;

import br.com.bandtec.datasource.conexao.DataSourceBot;
import br.com.bandtec.datasource.utils.GeracaoLog;
import br.com.bandtec.datasource.view.TelaLogin;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;   
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {

    public static void main(String[] args) throws Exception {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            System.out.println("Iniciado o bot do telegram Data-Source");
            GeracaoLog.GravarLog("Iniciado o bot do telegram Data-Source");
            telegramBotsApi.registerBot(new DataSourceBot());
            
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }
}
