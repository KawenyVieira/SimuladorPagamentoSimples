public class PagamentoPix implements Pagamento{

    @Override
    public boolean realizar(float valor, Cliente origem, Lojista destino){ //aquie esta duplicando a verificação na melhoria sera analizado qual a melhor escolha
        if (!origem.isAtivo() || valor <= 0 || origem.getSaldo() < valor){
            return false;
        }
        origem.alterarSaldo(-valor);
        destino.alterarSaldo(valor);
        return true;
    }
}
