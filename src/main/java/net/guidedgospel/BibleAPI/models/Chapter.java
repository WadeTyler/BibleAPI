package net.guidedgospel.BibleAPI.models;

import jakarta.persistence.*;

@Entity(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapterid")
    private Integer chapterid;

    @Column(name = "bookid")
    private Integer bookid;

    @Column(name = "chapterNum")
    private Integer chapterNum;

    // Getters and Setters


    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(Integer chapterNum) {
        this.chapterNum = chapterNum;
    }
}
