public class PontoTuristico{
    private String nome;
    private String tipo;
    private String review;
    private int rating;

    public PontoTuristico(String nome, String tipo, String review) {
        this.nome = nome;
        this.tipo = tipo;
        this.review = review;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getReview(){
        return review;
    }

    public void setReview(String review) {
            this.review = review;
    }
    
    public void setReview(String review, int rating) {
            this.review = review;
            this.rating = rating;
    }
    
    public int getRating() {
            return rating;
    }

}