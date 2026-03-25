public class Pilha <T>{
    // atributos
    private static final int TAM_DEFAULT = 100;
    private int topoPilha;
    private T elementos[];
    @SuppressWarnings("unchecked")
    // construtores
    public Pilha(int tamanho){
        this.elementos = (T[]) new Object[tamanho];
        this.topoPilha = -1;
    }

    public T get(int index){
        if (index>=0 && index<=topoPilha){
            return elementos[index];
        }
        else{
            throw new Exception ("Erro - Indice inválido");
        }
    }

    public Pilha(){
        this(TAM_DEFAULT);
    }

    // métodos
    public boolean isEmpty(){
        return this.topoPilha == -1;
    }

    public boolean isFull(){
        return topoPilha == elementos.length - 1;
    }

    public void push(T e) throws Exception{
        if (!this.isFull()){
            topoPilha++;
            this.elementos[topoPilha] = e;
        }
        else {
            throw new Exception("Overflow - Estouro de pilha.");
        }
    }

    public T pop() throws Exception{
        if (!this.isEmpty()){
            T temp = this.elementos[topoPilha];
            topoPilha--;
            return temp;
            // Jeito mais simples: return this.elementos[this.topoPilha--];
        }
        else {
            throw new Exception("Underflow - Esvaziamento de Pilha.");
        }
    }

    public T topo() throws Exception{
        if (!this.isEmpty()){
            return this.elementos[this.topoPilha];
        }
        else{
            throw new Exception ("Underflow - Esvaziamento de Pilha.");
        }
    }

    public int tamanho(){
        return topoPilha+1;
    }
}