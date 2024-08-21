import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GerenciadorDeLocalidades {
    private ArrayList<Localidade> localidades;

    public GerenciadorDeLocalidades() {
        localidades = new ArrayList<>();
    }

    public void adicionarLocalidade(Localidade localidade) {
        localidades.add(localidade);
    }

    public ArrayList<Localidade> getLocalidades() {
        return localidades;
    }

    public void exportToCSV(String filePath) {
        File file = new File(filePath);
        boolean fileExists = file.exists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if (!fileExists) {
                writer.write("Pais,Estado,Cidade,PontoTuristico,Review,Nota");
                writer.newLine();
            }
            
            for (Localidade localidade : localidades) {
                if (localidade instanceof Pais) {
                    Pais pais = (Pais) localidade;
                    for (Estado estado : pais.getEstados()) {
                        for (Cidade cidade : estado.getCidades()) {
                            for (PontoTuristico ponto : cidade.pontosTuristicos) {
                                writer.write(String.format("%s,%s,%s,%s,%s,%s",
                                    pais.getNome(),
                                    estado.getNome(),
                                    cidade.getNome(),
                                    ponto.getNome(),
                                    ponto.getReview(),
                                    ponto.getRating()));
                                writer.newLine();
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayCSVContents(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}
        
}
