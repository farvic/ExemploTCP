/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 * Modified by: Victor Fonseca
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.awt.Event;

public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            Scanner sc = new Scanner(System.in);
            
            while(true){
                String msg = sc.nextLine();
                byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem

                os.write(buf);

                byte[] bufR = new byte[20];
            
                is.read(bufR);
                
                String msgResp = new String(bufR);

                System.out.println(msgResp); 
            }

            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}