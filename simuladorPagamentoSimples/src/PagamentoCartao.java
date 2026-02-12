public class PagamentoCartao implements Pagamento{
    private final float taxa = 0.029f; // 2.9% de taxa

    @Override
    public boolean realizar(float valor, Cliente origem, Lojista destino){
        if (!origem.isAtivo() || valor <= 0 || origem.getSaldo() < valor){
            return false;
        }
        origem.alterarSaldo(-valor);
        destino.alterarSaldo(valor-(0.0029f*valor));
        return true;
    }
}
