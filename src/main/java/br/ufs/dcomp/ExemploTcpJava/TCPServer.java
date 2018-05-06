/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 * Modified by: Victor Fonseca
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.awt.Event;

public class TCPServer{
    public static void main(String[] args){
        
        try {
            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1"));
            System.out.println("[OK] ]");
            
            System.out.print("[ Aquardando pedidos de conexão    ..................  ");
            Socket sock = ss.accept(); // Operação bloqueante (aguardando pedido de conexão)
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); //Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); //Canal de saída de dados
            
            System.out.println("[ Aguardando recebimento de mensagem   ..............  ");
            
            Scanner sc = new Scanner(System.in);
            
            while(true){
                byte[] buf = new byte[20]; // buffer de recepção
                
                is.read(buf); // Operação bloqueante (aguardando chegada de dados)
                
                String msg = new String(buf); // Mapeando vetor de bytes recebido para String
                
                System.out.println(msg);
                
                String msgResp = sc.nextLine();
                
                byte[] bufR = msgResp.getBytes();
                
                os.write(bufR);
            }
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}