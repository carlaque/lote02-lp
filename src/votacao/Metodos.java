package votacao;

import java.io.*;
import javax.swing.*;
import java.util.Random;

public class Metodos {
    //ACÇÕES
    public static Voto[] carregar(Voto[] voto) throws IOException{
        
        Random gerador = new Random();
        
        for(int i = 0; i<100; i++){
            voto[i] = new Voto();
            
            voto[i].nCandidato = gerador.nextInt(300);
            voto[i].nSecao = gerador.nextInt(20);
        }        
        return voto;
    }
    
    public static void classificar(Voto[] voto) throws IOException{
        
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 99; j++){
                if(voto[j].nSecao > voto[j + 1].nSecao){
                    int aux = voto[j].nSecao ;
                    voto[j].nSecao = voto[j+1].nSecao;
                    voto[j+1].nSecao = aux;
                }
            }
        }
        
        System.out.println("DADOS CLASSIFICADOS");
    }
 
    public static void gravar(Voto[] voto) throws IOException{
        String fileName = "Votacao-Gravada.txt";
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write("Seção||||Candidato\n");
        for(int i=0;i<100;i++){
            writer.append(voto[i].nSecao + "    ;    ");
            writer.append(voto[i].nCandidato +"\n");
        }
        writer.close();
        System.out.println("Gravação feita com sucesso!");
    }
    
    //ESTATISTICAS
    public static int[][] porSecao(Voto[] voto) throws IOException{
        int eleitoresSecao[][] = new int[20][2];
        
        int eleitores = 1;
        int qtd = 0 ;
        for(int i=1;i<100;i++){
            
            if(voto[i].nSecao == voto[i-1].nSecao){
                eleitores++;          
            }else{
                eleitoresSecao[qtd][0] = voto[i-1].nSecao ;
                eleitoresSecao[qtd][1] = eleitores;
                qtd++;
                eleitores = 1;
            }
            
        }
        
        System.out.println("secao |||||| qtd eleitorees");
        
        for(int j = 0;j<(qtd);j++){
            System.out.println(eleitoresSecao[j][0] + "|||||" + eleitoresSecao[j][1]);
        }
        
        return eleitoresSecao;
    }
    
    public static void maiorMenor(int[][] eleitoresSecao) throws IOException{
        int eleitoresMM[][] = new int [2][2];
        //eleitoresMM[0][1] = eleitoresSecao[0][0];
        eleitoresMM[1][1] = 100;
        for (int[] eleitoresSecao1 : eleitoresSecao) {
            if (eleitoresSecao1[1] > eleitoresMM[0][1]) {
                eleitoresMM[0][0] = eleitoresSecao1[0];
                eleitoresMM[0][1] = eleitoresSecao1[1];
            }
            if (eleitoresSecao1[1] < eleitoresMM[1][1]) {
                eleitoresMM[1][0] = eleitoresSecao1[0];
                eleitoresMM[1][1] = eleitoresSecao1[1];
            }
        }
        
        
        for(int j = 0;j<2;j++){
            System.out.println(eleitoresMM[j][0] + "|||||" + eleitoresMM[j][1]);
        }
        
        
    }
    
    
}
