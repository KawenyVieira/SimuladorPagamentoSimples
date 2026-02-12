public interface Pagamento {
    public boolean realizar(float valor, Cliente origem, Lojista destino);
}
