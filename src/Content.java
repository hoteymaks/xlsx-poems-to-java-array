public class Content {
    private String name;
    private String author;
    private String content;

    public Content() {
    }

    public Content(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Content(String author, String name, String content) {
        this.name = name;
        this.author = author;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
