import java.util.List;

public record VolumeInfo(
        String title,
        String subtitle,
        String[] authors,
        String publisher,
        String publishedDate,
        String description,
        List<IndustryIdentifier> industryIdentifiers,
        int pageCount,
        String printType,
        List<String> categories,
        Double averageRating,
        int ratingsCount,
        ImageLinks imageLinks,
        String language,
        String previewLink,
        String infoLink,
        String canonicalVolumeLink
) {
    @Override
    public String toString() {
        String authorsString = (authors != null) ? String.join(", ", authors) : "Author(s) not available";
        String date = (publishedDate != null) ? publishedDate : "Publication date not available";
        return "Title: " + title + "\n" +
                "Subtitle: " + (subtitle != null ? subtitle : "N/A") + "\n" +
                "Author(s): " + authorsString + "\n" +
                "Publisher: " + (publisher != null ? publisher : "N/A") + "\n" +
                "Publication Date: " + date + "\n" +
                "Description: " + (description != null ? description : "N/A") + "\n" +
                "Categories: " + (categories != null ? String.join(", ", categories) : "N/A") + "\n" +
                "Language: " + language + "\n" +
                "Preview Link: " + previewLink + "\n";
    }
}
