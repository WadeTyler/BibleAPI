package net.guidedgospel.BibleAPI.repositories;

import net.guidedgospel.BibleAPI.models.Chapter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChapterRepository extends CrudRepository<Chapter, Integer> {
    @Query(value = "SELECT * FROM chapters WHERE bookid = ?", nativeQuery = true)
    public List<Chapter> getChaptersWithBookId(Integer bookid);

    @Query(value = "SELECT * FROM chapters WHERE chapterNum = ? AND bookid = ?", nativeQuery = true)
    public Chapter findByChapterNumAndBookId(Integer chapterNum, Integer bookid);
}
