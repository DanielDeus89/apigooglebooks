public record VolumeInfo(String title, String[] authors, String publishedDate) {
    @Override
    public String toString() {
        String autores = (authors != null) ? String.join(", ", authors) : "Autor(es) não disponível(is)";
        String data = (publishedDate != null) ? publishedDate : "Data de publicação não disponível";
        return "Título: " + title + "\n" + "Autor(es): " + autores + "\n" + "Data de Publicação: " + data;
    }
}
