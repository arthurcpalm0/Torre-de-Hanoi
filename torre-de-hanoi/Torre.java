// Arthur Candido Palma
// RA: 10743580

public class Torre{
    // Atributos
    private Pilha<Disco> p;

    // Construtor
    public Torre(int tamanho){
        p = new Pilha<Disco>(tamanho);
    }

    // Método que verifica se o disco sendo colocado é menor que o disco abaixo.
    public boolean podeEmpilhar(Disco disco) throws Exception{
        if (p.isEmpty()){
            return true;
        }
        int tamanhoTopo = p.topo().getTamanho();
        if (tamanhoTopo>disco.getTamanho()){
            return true;
        }
        else {
            return false;
        }
    }
    
    // Método que empilha o disco na torre.
    public void empilhar(Disco disco) throws Exception{
        if (podeEmpilhar(disco))
        {
            p.push(disco);
        }
    }

    // Método que desempilha o disco da torre.
    public Disco desempilhar() throws Exception{
        if (!p.isEmpty()){
            return p.pop();
        }
        else {
            throw new Exception("Tentando tirar um disco de uma torre vazia");
        }
    }

    // Método que retorna o disco no topo da torre.
    public Disco topoTorre() throws Exception{
        if (!p.isEmpty()){
            return p.topo();
        }
        else{
            throw new Exception("Torre vazia.");
        }
    }

    // Método que retorna a quantidade de discos.
    public int qtdDiscos(){
        return p.tamanho();
    }

    // Método que retorna um disco especifico na torre.
    public Disco getDisco(int index) throws Exception{
        if (!p.isEmpty()){
            return p.get(index);
        }
        else{
            throw new Exception("Pilha vazia.");
        }
    }

    //  Método que verifica se a torre está vazia.
    public boolean estaVazia(){
        return p.isEmpty();
    }
}