/*      Amostra de saida esperada
    [Login realizado com sucesso]
    Usuário: Antonio | Saldo: R$ 100.00
    Destino: Loja da Ana | Valor: R$ 25.00 | Forma de pagamento: Pix
    [Transferência realizada com sucesso!]
    Novo saldo: R$ 75.00
*/

public class Main {
    public static void main(String[] args) {
        //Inserção de Lojista e Cliente, em outras situaçoes em sistemoas completo poderia ser um get do banco
        Lojista lojista = new Lojista("Zé do Bar", "zé@","senha",70f,"100000000000000","Bar do Zé");

        Cliente cliente = new Cliente("dede","test@","senha",75.5f,"00000000001","000000001");
        cliente.setAtivo(true);

        //Simulacao de Pagamento
        //simulacao Pix
            Pagamento pagamentoPix =new PagamentoPix();
            cliente.transferir(lojista,15f,pagamentoPix, cliente.getSaldo());
            lojista.dadosLojista();
        //simulacao Cartao
            Pagamento pagamentoCartao =new PagamentoCartao();
            cliente.transferir(lojista,15f,pagamentoCartao, cliente.getSaldo());
            lojista.dadosLojista();
        //simulacao Saldo
            Pagamento pagamentoSaldo =new PagamentoSaldo();
            cliente.transferir(lojista,15f,pagamentoSaldo, cliente.getSaldo());



        //Simulaçoes de erro
        //Cliente Bloqueado
//            cliente.bloquearConta();
//            cliente.transferir(lojista,15f,pagamentoPix, cliente.getSaldo());

        //Cliente com Saldo insuficiente
//            cliente.transferir(lojista,90f,pagamentoPix, cliente.getSaldo());





    }
}