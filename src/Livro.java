public record Livro (String titulo, String autores, String dataPublicacao){
    @Override
    public String toString() {
        return "Título: " + titulo + "\n" +
                "Autor(es): " + autores + "\n" +
                "Data de Publicação: " + dataPublicacao;
    }
}
