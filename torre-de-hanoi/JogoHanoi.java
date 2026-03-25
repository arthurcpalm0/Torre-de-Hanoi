public class JogoHanoi{
    private Torre torre1;
    private Torre torre2;
    private Torre torre3;

    public JogoHanoi(int tamanho) throws Exception{
        torre1 = new Torre();
        torre2 = new Torre();
        torre3 = new Torre();
        for (int i=tamanho;i>0;i--){
            Disco disco = new Disco(i);
            torre1.empilhar(disco);
        }
    }

    public void mover(Disco disco, Torre torreIn, Torre torreFim) throws Exception{
        torreFim.empilhar(torreIn.desempilhar());
    }

    public void mostrar(Torre torre, int num){
        System.out.printf("Torre_%d:", num);
        for (int i = torre.qtdDiscos()-1; i>=0; i--){
            System.out.printf("\n");
            for (int j = 0; j<torre.getDisco(i).getTamanho(); j++){
                System.out.print("*");
            }
        }
    }
}