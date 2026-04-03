import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int contador = 0;
        int opmenu = 0;
        try{
            do{
                    System.out.println("Ingresse a quantidade de discos:");
                    int tam = entrada.nextInt();
                    int nMin = (int) Math.pow(2,tam)-1;
                    JogoHanoi jogo = new JogoHanoi(tam);
                    do{
                        System.out.printf("1- Mover Disco\n2-Mostrar Torres\n3-Reiniciar jogo\n4- Sair\n");
                        int opcao = entrada.nextInt();
                        opmenu = Menu(jogo, opcao, entrada, tam);
                        if (opmenu==1){
                            contador++;
                        }
                        if (jogo.jogoTerminado()){
                            System.out.printf("Parabens, você conseguiu, jogo terminado em: %d passos (Minimo: %d passos).\n",contador, nMin);
                            System.out.println("Deseja jogar novamente? s/n");
                            char r = entrada.next().charAt(0);
                            if (r == 's' || r == 'S' ){
                                System.out.println("Jogo reiniciado.");
                                opmenu = 3;
                            }
                            else if (r == 'n' || r == 'N'){
                                System.out.println("Adeus.");
                                opmenu = 4;
                            }
                            else{
                                System.out.println("Entrada invalida.");
                            }
                        }
                    } while (opmenu!=4 && opmenu!=3 && !jogo.jogoTerminado());
            } while (opmenu!=4);
        }
        catch(Exception e){
            System.out.println("Erro detectado: " + e.getMessage());
        }
        entrada.close();
    }

    static int Menu(JogoHanoi jogo, int opcao, Scanner entrada, int tam) throws Exception{
        switch (opcao) {
            case 1:
                System.out.println("Selecione a torre de onde o disco sairá.");
                int index1 = entrada.nextInt();
                index1--;
                System.out.println("Selecione a torre onde o disco entrará.");
                int index2 = entrada.nextInt();
                index2--;
                try{
                    jogo.mover(index1,index2);
                }
                catch (Exception e){
                    System.out.println("Erro detectado: " + e.getMessage());
                    return 0;
                }
                return 1;
            case 2:
                jogo.mostrar();
                return 0;
            case 3:
                System.out.println("Tem certeza que deseja reiniciar? s/n");
                char r = entrada.next().charAt(0);
                if (r == 's' || r == 'S' ){
                    System.out.println("Jogo reiniciado.");
                }
                else if (r == 'n' || r == 'N'){
                    return 0;
                }
                else{
                    System.out.println("Entrada invalida.");
                    return 0;
                }
                return 3;
            case 4:
                System.out.println("Adeus.");
                return 4;
            default:
                System.out.println("Opcao invalida.");
                return 0;
        }
    }
}