public class JogoHanoi{
    private Torre[] torre;
    private int numDiscos;

    public JogoHanoi(int tamanho) throws Exception{
        this.torre = new Torre[3];
        for(int i = 0; i < 3; i++){
            torre[i] = new Torre(tamanho);
        }
        numDiscos = tamanho;
        for (int i=tamanho;i>0;i--){
            Disco disco = new Disco(i);
            torre[0].empilhar(disco);
        }
    }

    public void mover(int index1, int index2) throws Exception{
        if (torre[index2].podeEmpilhar(torre[index1].topoTorre())){
            torre[index2].empilhar(torre[index1].desempilhar());
        }
        else{
            throw new Exception ("Tentando colocar um disco maior sobre um disco menor.");
        }
    }

    public void mostrar() throws Exception{
        System.out.println("Torre 1:    Torre 2:    Torre3:");
        for (int i = numDiscos-1; i>=0; i--){
            for (int j=0; j<3; j++){
                if (i<torre[j].qtdDiscos()){
                    int tamanho = torre[j].getDisco(i).getTamanho();
                    int espacos = numDiscos - tamanho;
                    System.out.print(" ".repeat(espacos));
                    System.out.print("*".repeat(tamanho * 2)); 
                    System.out.print(" ".repeat(espacos));
                }
                else{
                    System.out.print(" ".repeat(numDiscos * 2));
                }
                System.out.print("      ");
            }
            System.out.println();
        }
    }

    public boolean jogoTerminado(){
        if (torre[0].estaVazia() && (torre[1].estaVazia()||torre[2].estaVazia())){
            return true;
        }
        else{
            return false;
        }
    }
}