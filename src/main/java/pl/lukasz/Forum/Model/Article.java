package pl.lukasz.Forum.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.time.LocalDate;
@Entity
@Table(name="article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String title;

    private Date date;
    @NotEmpty
    private String content;

    public Article(
    ){}

    public Article(String title,  String content,Date date) {

        this.title = title;

        this.content = content;
        this.date=date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
