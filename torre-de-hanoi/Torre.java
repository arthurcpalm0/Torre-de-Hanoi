public class Torre{
    private Pilha<Disco> p;

    public Torre(){
        p = new Pilha<Disco>();
    }

    public void empilhar(Disco disco) throws Exception{
        if (p.isEmpty())
        {
            p.push(disco);
        }
        else {
            int tamanhoTopo = p.topo().getTamanho();
            if (tamanhoTopo>disco.getTamanho()){
                p.push(disco);
            }
            else {
                throw new Exception("Erro - Tentando colocar um disco maior sobre um disco menor");
            }
        }
    }

    public Disco desempilhar() throws Exception{
        if (!p.isEmpty()){
            return p.pop(disco);
        }
        else {
            throw new Exception("Erro - Tentando tirar um disco de uma torre vazia");
        }
    }
    public Disco get() throws Exception{
        return p.topo();
    }

    public int qtdDiscos(){
        return p.tamanho();
    }

    public Disco getDisco(int index){
        return p.get(index);
    }
}