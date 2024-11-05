package net.guidedgospel.BibleAPI.repositories;

import net.guidedgospel.BibleAPI.models.Verse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VerseRepository extends CrudRepository<Verse, Integer> {

    @Query(value = "SELECT * FROM verses WHERE chapterid = ?", nativeQuery = true)
    public List<Verse> findAllByChapterId (Integer chapterid);

    @Query(value = "SELECT * FROM verses WHERE chapterid = ? AND verseNum = ?", nativeQuery = true)
    public Verse findByChapterIdAndVerseNum(Integer chapterid, Integer verseNum);

}
