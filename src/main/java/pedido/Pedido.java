package pedido;

import ingredientes.Adicional;
import ingredientes.Ingrediente;
import produto.Shake;

import java.util.ArrayList;
import java.util.List;

public class Pedido{

    private int id;
    private  ArrayList<ItemPedido> itens;
    private Cliente cliente;

    public Pedido(int id, ArrayList<ItemPedido> itens,Cliente cliente){
        this.id = id;
        this.itens=itens;
        this.cliente=cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public int getId(){
        return this.id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio){
        double total= 0;

        for(int i = 0; i < itens.size(); i++){
            double precoItem = 0.0;
            Shake shake = itens.get(i).getShake();
            Ingrediente ingrediente = shake.getBase();
            precoItem = cardapio.buscarPreco(ingrediente) * shake.getTipoTamanho().multiplicador;

            List<Adicional> adicionais = shake.getAdicionais();

            for(int j = 0; j < adicionais.size(); j++){

                precoItem = precoItem + cardapio.buscarPreco(adicionais.get(j));
            }

            precoItem *= itens.get(i).getQuantidade();

            total += precoItem;
        }

        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        if(itens.contains(itemPedidoAdicionado)) {
            //procurar o item e salvar na variavel

            int indice = this.itens.indexOf(itemPedidoAdicionado);

            ItemPedido itemPedido = this.itens.get(indice);

            //atualizar quantidade
            itemPedido.setQuantidade(
                    itemPedido.getQuantidade() + itemPedidoAdicionado.getQuantidade()
            );

            //excluir o item do array e adicionar o item atualizado
            itens.remove(indice);
            itens.add(itemPedido);
        }
        else {
            this.itens.add(itemPedidoAdicionado);
        }
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {
        //substitua o true por uma condição
        if (itens.contains(itemPedidoRemovido)) {
            int indice = itens.indexOf(itemPedidoRemovido);

            ItemPedido itemPedido = itens.get(indice);

            if(itemPedido.getQuantidade() == 1){
                itens.remove(itemPedidoRemovido);
            }
            else{
                itemPedido.setQuantidade(itemPedido.getQuantidade() - 1);
                itens.set(indice, itemPedido);
            }
        } else {
            throw new IllegalArgumentException("Item nao existe no pedido.");
        }
        return false;
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
