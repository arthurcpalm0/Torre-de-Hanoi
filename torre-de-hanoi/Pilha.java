public class Pilha <T>{
    // Atributos
    private static final int TAM_DEFAULT = 100;
    private int topoPilha;
    private T elementos[];

    // Construtores
    public Pilha(int tamanho){
        this.elementos = (T[]) new Object[tamanho];
        this.topoPilha = -1;
    }
    public Pilha(){
        this(TAM_DEFAULT);
    }

    //Método que devolve um elemento especifico da pilha.
    public T get(int index) throws Exception{
    if (index>=0 && index<=topoPilha){
        return elementos[index];
    }
    else{
        throw new Exception ("Erro - Indice inválido");
    }
    }

    //Método que indica se a pilha está vazia.
    public boolean isEmpty(){
        return this.topoPilha == -1;
    }

    //Método que indica se a pilha está cheia.
    public boolean isFull(){
        return topoPilha == elementos.length - 1;
    }

    //Método que adiciona um elemento na pilha.
    public void push(T e) throws Exception{
        if (!this.isFull()){
            topoPilha++;
            this.elementos[topoPilha] = e;
        }
        else {
            throw new Exception("Overflow - Estouro de pilha.");
        }
    }

    // Método que remove um elemento da pilha.
    public T pop() throws Exception{
        if (!this.isEmpty()){
            T temp = this.elementos[topoPilha];
            topoPilha--;
            return temp;
        }
        else {
            throw new Exception("Underflow - Esvaziamento de Pilha.");
        }
    }

    // Método que devolve o elemento no topo da pilha.
    public T topo() throws Exception{
        if (!this.isEmpty()){
            return this.elementos[this.topoPilha];
        }
        else{
            throw new Exception ("Underflow - Esvaziamento de Pilha.");
        }
    }

    // Método que devolve o tamanho da pilha.
    public int tamanho(){
        return topoPilha+1;
    }
}