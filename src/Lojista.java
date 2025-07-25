/*
    * O Lojista não faz transferências — ele apenas recebe.
    * O metodo receberPagamento(...) será chamado de dentro de Cliente.transferir(), passando o valor e a forma de pagamento.
    * O saldoBloqueado pode ser usado como ideia para simular pagamento via cartão (crédito demora a cair).
    * O Lojista pode também validar se está apto a receber, baseado em alguma regra de negócio (ex: conta ativa).
*/



public class Lojista extends Usuario{
    private static String cnpj; //tamanho de 14 digitos
    private static String razaoSocial;
    private static float saldoCartao;
    private static boolean lojaAtiva;

    //construtor
    public Lojista(String nome, String email, String senha, float saldoInicial, String cnpj, String razaoSocial) {
        super(nome, email, senha, saldoInicial);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.saldoCartao = 0.0f;
    }
    //Dados do lojista
    public void dadosLojista(){
        System.out.println("\n----------------------------------------------------------------"+
                            "\nSaldo Logista "+"\nNome: "+ this.getRazaoSocial()+" | CNPJ: " + this.getCnpj() +" | Saldo Final: R$"+  String.format("%.2f", this.getSaldo()) +
                            "\n----------------------------------------------------------------");
    }

    //metodos espeficos da classe
    public  boolean receberPagamento(float valor, String cnpjDestinado, String tpPagamento) {
        if (valor <= 0) return false;
        this.alterarSaldo(valor);
        return true;
    }

    public void liberarSaldoBloqueado(){
        /* O que faz: move o valor do saldoBloqueado para o saldo disponível.
           Motivação: simula o tempo de processamento de cartão (como acontece na vida real).
        */
       setSaldo(+saldoCartao);
    }



    //getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public boolean isLojaAtiva() {
        return lojaAtiva;
    }

    public void setLojaAtiva(boolean lojaAtiva) {
        this.lojaAtiva = lojaAtiva;
    }
    public static float getSaldoCartao() {
        return saldoCartao;
    }

    public static void setSaldoCartao(float saldoCartao) {
        Lojista.saldoCartao = saldoCartao;
    }


}
