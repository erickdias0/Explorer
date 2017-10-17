/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Erick
 */
public class FileExplorer {
void help(){
System.out.println("**************Bem Vindo!**************");
System.out.println("1 - Listar Todos : Exibe todos os arquivos do computador.");
System.out.println("2 - Pesquisar Arquivo : Exibe todos arquivos que contém o filtro recebido");
System.out.println("3 - Pesquisar em Diretório : Exibe todos arquivos que contém o filtro recebido,em um diretório específico");
System.out.println("4 - Listar Diretório : Lista todos arquivos e diretórios contidos no diretório informado");
System.out.println("5 - Deletar Arquivo : Deleta o arquivo localizado no caminho informado");
System.out.println("6 - Propriedades de Arquivo : Informa as propriedades do arquivo localizado no caminho informado");
System.out.println("7 - Copiar Arquivo : Copia o arquivo localizado no caminho origem para o caminho destino");
System.out.println("**************************************");
}

void listAll(File arq){
   try{
   if (arq.isFile()) {
        System.out.println("Arquivo " + arq.getName());
        return;
    }
    System.out.println("Diretório: " + arq.getPath());
    for (File pasta : arq.listFiles()) {
        listAll(pasta);
}
   }catch(Exception e){
       e.printStackTrace();
   }

}
void list(File arq,String filtro){
    
    try{
   
    
    if ((arq.isFile()) && (arq.getName().contains(filtro))) {
        
        System.out.println("Arquivo encontrado: "+arq.getAbsolutePath());
        return;
    }
    if(arq.isFile()){
        return;
    }
    for (File pasta : arq.listFiles()) {
        list(pasta,filtro);
        
    }
    }catch(Exception e){
       
    }
 
          
}
    void copy(File origem, File destino) throws FileNotFoundException, IOException{  
        InputStream in = new FileInputStream(origem);  
        OutputStream out = new FileOutputStream(destino);  
      
        
        byte[] buf = new byte[1024];  
        int tamanho;  
        while ((tamanho = in.read(buf)) > 0) {  
            out.write(buf, 0, tamanho);  
        }  
        in.close();  
        out.close();  
    }  


}