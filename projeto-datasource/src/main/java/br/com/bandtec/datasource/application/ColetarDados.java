/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.application;

import br.com.bandtec.datasource.model.CpuUser;
import br.com.bandtec.datasource.view.TelaLogin1;

public class ColetarDados {
    
     public static void main(String[] args) throws Exception {
        
         CpuUser cpu = new CpuUser();
         
         TelaLogin1 tela = new TelaLogin1();
         
         tela.setVisible(true);
   
        cpu.coletaCPU();
                      

    }
    
}
