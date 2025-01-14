package pedido;

import ingredientes.Ingrediente;

import java.util.TreeMap;

public class Cardapio {
    private TreeMap<Ingrediente,Double> precos;

    public Cardapio(){
        this.precos= new TreeMap<>();
    }

    public TreeMap<Ingrediente, Double> getPrecos(){
        return this.precos;
    }

    public void adicionarIngrediente(Ingrediente ingrediente,Double preco){
        if(preco > 0){
            precos.put(ingrediente, preco);
        }
        else{
            throw new IllegalArgumentException("Preco invalido.");
        }
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){
        if(precos.get(ingrediente) == null){
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }

        if(preco > 0){
            precos.put(ingrediente, preco);

            return true;
        }
        else {
            throw new IllegalArgumentException("Preco invalido.");
        }
    }

    public boolean removerIngrediente(Ingrediente ingrediente){
        if(precos.get(ingrediente) == null){
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
       precos.remove(ingrediente);
        return true;
    }

    public Double buscarPreco(Ingrediente ingrediente){
        if(precos.get(ingrediente) == null){
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
        return precos.get(ingrediente);
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

}
