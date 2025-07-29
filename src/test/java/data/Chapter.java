package data;

public enum Chapter {
    Новинки ("Новинки книг"),
    Популярное ("Лучшие книги");
    public final String description;
    Chapter(String description){
        this.description = description;
    }
}
