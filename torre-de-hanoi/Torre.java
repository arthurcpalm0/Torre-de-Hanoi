public class Torre{
    private Pilha<Disco> p;

    public Torre(int tamanho){
        p = new Pilha<Disco>(tamanho);
    }

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
    
    public void empilhar(Disco disco) throws Exception{
        if (podeEmpilhar(disco))
        {
            p.push(disco);
        }
    }

    public Disco desempilhar() throws Exception{
        if (!p.isEmpty()){
            return p.pop();
        }
        else {
            throw new Exception("Tentando tirar um disco de uma torre vazia");
        }
    }
    public Disco topoTorre() throws Exception{
        if (!p.isEmpty()){
            return p.topo();
        }
        else{
            throw new Exception("Torre vazia.");
        }
    }

    public int qtdDiscos(){
        return p.tamanho();
    }

    public Disco getDisco(int index) throws Exception{
        if (!p.isEmpty()){
            return p.get(index);
        }
        else{
            throw new Exception("Pilha vazia.");
        }
    }

    public boolean estaVazia(){
        return p.isEmpty();
    }
}