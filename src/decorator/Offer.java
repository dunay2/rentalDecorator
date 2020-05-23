package decorator;

public class Offer
{
    private String tipo;
    private int valor;

    public Offer(String tipo, int valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

}
