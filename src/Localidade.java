public abstract class Localidade{
    protected String nome;

    public Localidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract String obterInformacoes();
}