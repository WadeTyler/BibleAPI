package net.guidedgospel.BibleAPI.models;

import jakarta.persistence.*;

@Entity(name = "verses")
public class Verse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verseid")
    private Integer verseid;

    @Column(name = "chapterid")
    private Integer chapterid;

    @Column(name = "verseNum")
    private Integer verseNum;

    @Column(name = "text")
    private String text;


    // Getters and Setters
    public Integer getVerseid() {
        return verseid;
    }

    public void setVerseid(Integer verseid) {
        this.verseid = verseid;
    }

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    public Integer getVerseNum() {
        return verseNum;
    }

    public void setVerseNum(Integer verseNum) {
        this.verseNum = verseNum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
