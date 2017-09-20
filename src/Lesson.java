import java.io.Serializable;

public class Lesson implements Serializable {
    int id;
    String name;
    String path;
    String chapter;


    public Lesson(int id, String name, String path, String chapter) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.chapter = chapter;
    }

    public Lesson() {
    }

    public Lesson(String name,String chapter, String path) {
        this.name = name;
        this.path = path;
        this.chapter = chapter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}
