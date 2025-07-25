public class Usuario implements Autenticavel{
    private String nome;
    private String email;
    private String senha;
    private float saldo;

    //construtor
    public Usuario(String nome, String email, String senha, float saldoInicial) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.saldo = saldoInicial;
    }

    //Metodos exclusivos da classe
    protected void alterarSaldo(float valor){
        this.saldo += valor;
    }


    //implementacao da interface
    @Override
    public boolean autenticar(String senhaInformada){
        return this.senha.equals(senhaInformada);
    }


    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
