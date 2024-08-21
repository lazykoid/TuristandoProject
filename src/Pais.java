import java.util.ArrayList;

public class Pais extends Localidade{
    private ArrayList<Estado> estados;

    public Pais(String nome) {
        super(nome);
        this.estados = new ArrayList<>();
    }

    public void adicionarEstado(Estado estado) {
        estados.add(estado);
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    @Override
    public String obterInformacoes() {
        return "País: " + nome + ", Número de Estados: " + estados.size();
    }
}
