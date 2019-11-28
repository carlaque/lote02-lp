package votacao;

public class Voto {
    int nSecao;
    int nCandidato;
    
    Voto(){
        this(0,0);
    }
    
    Voto(int nS, int nC){
        nSecao = nS;
        nCandidato =  nC;
    }
}

