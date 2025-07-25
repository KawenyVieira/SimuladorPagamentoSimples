public class PagamentoSaldo implements Pagamento{
    private float cashback; // futura melhoria
    @Override
    public boolean realizar(float valor, Cliente origem, Lojista destino){
        if (!origem.isAtivo() || valor <= 0 || origem.getSaldo() < valor){
            return false;
        }
        origem.alterarSaldo(-valor);
        destino.alterarSaldo(valor);
        return true;
    }
}
