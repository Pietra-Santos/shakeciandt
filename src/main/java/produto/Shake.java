package produto;

import ingredientes.*;

import java.util.ArrayList;
import java.util.List;

public class Shake {
    private Base base;
    private Fruta fruta;
    private Topping topping;
    private List<Adicional> adicionais;
    private TipoTamanho  tipoTamanho;

    public Base getBase() {
        return base;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public Topping getTopping() {
        return topping;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public TipoTamanho getTipoTamanho() {
        return tipoTamanho;
    }

    public Shake(Base base, Fruta fruta, Topping topping, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.tipoTamanho = tipoTamanho;

        this.adicionais = new ArrayList<>();
    }
    public Shake(Base base, Fruta fruta, Topping topping,List<Adicional> adicionais, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.tipoTamanho = tipoTamanho;

        this.adicionais = adicionais;
    }

    @Override
    public String toString() {
        return this.base.getTipoBase().toString() + " / " + this.fruta.getTipoFruta().toString() + " / " + this.topping.getTipoTopping().toString() + " / " + this.adicionais + " / " + this.tipoTamanho.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shake)) return false;

        Shake shake = (Shake) o;
        boolean ehIgual = base.equals(shake.getBase()) && fruta.equals(shake.getFruta()) && topping.equals(shake.getTopping());
        boolean adicionaisIguais = adicionais.size() == shake.getAdicionais().size();

        for(Adicional adicional: adicionais) {
            if(!shake.getAdicionais().contains(adicional)) {

                adicionaisIguais = false;
                break;
            }
        }

        return ehIgual && adicionaisIguais;
    }
}
