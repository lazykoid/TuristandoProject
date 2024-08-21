import java.util.ArrayList;

public class Estado extends Localidade{
    private ArrayList<Cidade> cidades;

    public Estado(String nome) {
        super(nome);
        this.cidades = new ArrayList<>();
    }

    public void adicionarCidade(Cidade cidade) {
        cidades.add(cidade);
    }

    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    @Override
    public String obterInformacoes() {
        return "Estado: " + nome;
    }
}
