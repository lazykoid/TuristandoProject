import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String top = "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
        String bottom = "-------------------------------------------------";
        int end = 0;
        GerenciadorDeLocalidades gerenciador = new GerenciadorDeLocalidades();

        while (end != 1) {
            try {
                System.out.println(top);
                System.out.println("Turistando - O lugar das reviews mais sinceras!");
                System.out.println("1) Adicionar Review");
                System.out.println("2) Ver Reviews");
                System.out.println("3) Sair");
                
                int inp = scan.nextInt();
                scan.nextLine();
                switch (inp) {
                    case 1:
                        System.out.println("Nome da cidade: ");
                        String tmpCidade = scan.nextLine();

                        String tmpCep;
                        while (true) {
                            String cepRegex = "\\d{5}-\\d{3}";
                            Pattern pattern;
                            Matcher matcher;

                            System.out.println("CEP (XXXXX-XXX): ");
                            tmpCep = scan.nextLine();
                            pattern = Pattern.compile(cepRegex);
                            matcher = pattern.matcher(tmpCep);
                            if (matcher.matches()) {
                                break;
                            } else {
                                System.out.println("Formato de CEP inválido. Certifique-se de que o CEP está no formato XXXXX-XXX.");
                            }
                        }
                        String tmpArea;
                        int tmpIO;
                        while (true) {
                            System.out.println("Selecione o tipo de Zona: ");
                            System.out.println("1) Urbana");
                            System.out.println("2) Rural");

                            try {
                                tmpIO = scan.nextInt();
                                scan.nextLine();
                                if (tmpIO == 1) {
                                    tmpArea = "Urbana";
                                    break; // Opção válida, saia do loop
                                } else if (tmpIO == 2) {
                                    tmpArea = "Rural";
                                    break; // Opção válida, saia do loop
                                } else {
                                    System.out.println("Escolha inválida. Selecione 1 para Urbana ou 2 para Rural.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Por favor, insira um número.");
                                scan.nextLine(); // Limpa o buffer do scanner
                            }
                        }

                        Cidade cidade1 = new Cidade(tmpCidade, tmpCep, tmpArea);

                        System.out.println("Ponto Turistico: ");
                        String tmpPonto = scan.nextLine();

                        System.out.println("Tipo de Ponto Turistico: ");
                        String tmpTipo = scan.nextLine();

                        System.out.println("Review: ");
                        String tmpReview = scan.nextLine();

                        int tmpRating;
                        while (true) {
                            System.out.println("Nota (1-5): ");
                            try {
                                tmpRating = scan.nextInt();
                                scan.nextLine();
                                if (tmpRating >= 1 && tmpRating <= 5) {
                                    break; // Nota válida, saia do loop
                                } else {
                                    System.out.println("Nota inválida. Insira um valor entre 1 e 5.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Por favor, insira um número entre 1 e 5.");
                                scan.nextLine(); // Limpa o buffer do scanner
                            }
                        }

                        PontoTuristico ponto1 = new PontoTuristico(tmpPonto, tmpTipo, tmpReview);
                        ponto1.setReview(tmpReview, tmpRating);

                        cidade1.adicionarPontoTuristico(ponto1);

                        System.out.println("Estado: ");
                        String tmpEstado = scan.nextLine();

                        Estado estado1 = new Estado(tmpEstado);

                        estado1.adicionarCidade(cidade1);

                        System.out.println("Pais: ");
                        String tmpPais = scan.nextLine();

                        Pais pais1 = new Pais(tmpPais);
                        pais1.adicionarEstado(estado1);

                        gerenciador.adicionarLocalidade(pais1);
                        gerenciador.exportToCSV("Turistando.csv");
                        System.out.println(bottom);
                        break;

                    case 2:
                        System.out.println(top);
                        gerenciador.displayCSVContents("Turistando.csv");
                        break;
                    case 3:
                        end = 1;
                        scan.close();
                        break;
                    default:
                        System.out.println("Digite um Número Válido!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scan.nextLine();
            }
        }
    }
}
