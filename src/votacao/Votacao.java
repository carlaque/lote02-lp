package votacao;

import java.io.IOException;
import java.util.Scanner;

public class Votacao {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        Voto[] voto = new Voto[100];
        int [][] eleitoresSecao = new int[20][2];
        
        boolean menu = true;
        do{
            System.out.println("Escolha uma das opcoes do menu: \n"
                    + "1 - Carregar Seção/Numero Eleitor \n"
                    + "2 - Classificar por Seção \n"
                    + "3 - Gravar Registro \n"
                    + "4 - Mostrar Indicadores \n"
                    + "9 - Finalizar");
            
            int opc = s.nextInt();
            
            switch (opc){
                case 1:
                    //carregar
                    voto = Metodos.carregar(voto);
                break;
                case 2:
                    //classificar
                    Metodos.classificar(voto);
                    
                break;
                case 3:
                    //gravar
                    Metodos.gravar(voto);
                break;
                case 4:
                    //indicadores
                    boolean menu2 = true;
                    do{
                        System.out.println("Mostrar Indicadores\n"
                                + "Estatísticas de Votação\n"
                                + "1 – Quantidade Eleitores por Seção\n"
                                + "2 – Seção com Maior e Menor número de Eleitores  \n"
                                + "3 – Quantidade de votos por candidato \n"
                                + "4 – 10 primeiros colocadas (nro  cand. e qtd votos \n"
                                + "9 – Finaliza consulta");
                        
                        int opc2 = s.nextInt();
                        
                        switch(opc2){
                            case 1:
                                //eleitores por seção
                                eleitoresSecao = Metodos.porSecao(voto);
                            break;
                            case 2:
                                //maior e menor numero de eleitores
                                Metodos.maiorMenor(eleitoresSecao);
                            break;
                            case 3:
                                //quantidade de votos por candidato
                            break;
                            case 4:
                                //10 primeiros colocados (nCan e qtd de votos)
                            break;
                            case 9:
                                menu2 = false;
                            break;
                        }
                        
                    }while(menu2);
                    
                break;
                case 9:
                    menu = false;
                    
                break;
                
                default: System.out.println("Opcao invalida tente outro");
                
            }
                            
            
        }while(menu);
        
    }
    
}
