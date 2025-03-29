public class Livro {
    private String titulo;
    private String autor;
    private boolean lido;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.lido = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }
}