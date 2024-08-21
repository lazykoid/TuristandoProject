import java.util.ArrayList;

public class Cidade extends Localidade {
    private String cep;
    private String area;
    ArrayList<PontoTuristico> pontosTuristicos;

    public Cidade(String nome, String cep, String area) {
        super(nome);
        this.area = area;
        this.cep = cep;
        this.pontosTuristicos = new ArrayList<>();
    }

    public String getArea(){ return area;}

    public String getCep(){return cep;}

    public void setCep(String cep){this.cep = cep;}

    public void setArea(String area){this.area = area;}

    public void adicionarPontoTuristico(PontoTuristico ponto) {
        pontosTuristicos.add(ponto);
    }

    @Override
    public String obterInformacoes() {
        return "Cidade: " + nome + ", Área: " + area;
    }
}
