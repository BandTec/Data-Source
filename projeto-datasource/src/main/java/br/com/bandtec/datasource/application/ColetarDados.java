/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.application;

import br.com.bandtec.datasource.model.CpuUser;


/**
 *
 * @author Bandtec
 */
public class ColetarDados {
    
     public static void main(String[] args) throws Exception {
        
         CpuUser cpu = new CpuUser();
   
        cpu.coletaCPU();
 

    }
    
}