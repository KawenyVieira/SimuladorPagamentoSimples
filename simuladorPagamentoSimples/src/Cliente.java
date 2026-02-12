/*
 ** O Cliente deve verificar se:
 * está ativo
 * está autenticado
 * tem saldo suficiente
 ** A verificação de saldo e autenticação devem ser feitas dentro de transferir()
 */

public class Cliente extends Usuario{
    private String cpf; //tamanho de 11 digitos
    private String telefone; //tamanho de 9 digitos
    private boolean ativo;


    //construtor da mae
    public Cliente(String nome, String email, String senha, float saldoInicial, String cpf, String telefone) {
        super(nome, email, senha, saldoInicial);
        this.getCpf();
        this.getTelefone();
    }

    //metodos espeficos da classe
    public boolean transferir(Lojista destino, float valorTransacao, Pagamento formaPagamento, float saldoInicial){
        if (ativo){
            if (autenticar(this.getSenha())){// reavaliar a logica
                System.out.println("[Login realizado com sucesso]");
                if (getSaldo() > valorTransacao && formaPagamento.realizar(valorTransacao, this,destino)){
                    System.out.println("Usuario: "+ this.getNome()+" | Saldo: R$"+String.format("%.2f",saldoInicial)+
                            "\nDestino: "+destino.getRazaoSocial()+" | Valor: R$"+String.format("%.2f",valorTransacao)+" | Tipo de Pagamento: "+formaPagamento.getClass().getSimpleName() +
                            "\n[Transferência realizada com sucesso!] "+
                            "\nNovo saldo: R$"+ String.format("%.2f",this.getSaldo()) );
                }else if (getSaldo() < valorTransacao) {
                    System.out.println("Saldo indisponivel para transacao");
                }
            }else {
                System.out.println("ALERTA: Senha invalida");
            }
        }else {
            System.out.println("ALERTA: Usuario Inativo");
        }

        return ativo;
    }

    public void bloquearConta(){
        this.ativo =false;
    }

    //getters e setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
