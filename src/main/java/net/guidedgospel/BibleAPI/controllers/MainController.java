package net.guidedgospel.BibleAPI.controllers;

import net.guidedgospel.BibleAPI.models.Book;
import net.guidedgospel.BibleAPI.models.Chapter;
import net.guidedgospel.BibleAPI.models.Verse;
import net.guidedgospel.BibleAPI.repositories.BookRepository;
import net.guidedgospel.BibleAPI.repositories.ChapterRepository;
import net.guidedgospel.BibleAPI.repositories.VerseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bible")
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private VerseRepository verseRepository;

    // Get All Books
    @GetMapping({"", "/", "/books", "/books/"})
    private Iterable<Book> getAllBooks() {
        try {
            Iterable<Book> books = bookRepository.findAll();
            return books;
        } catch (Exception e) {
            System.out.println("Error in getAllBooks controller: " + e.getMessage());
            throw e;
        }
    }

    // Get all Chapters in Books using Book Name
    @GetMapping({"/{bookIdentifier}", "/{bookIdentifier}/"})
    private List<Chapter> getAllChaptersInBook(@PathVariable String bookIdentifier) {
        try {
            if (bookIdentifier.isEmpty() || bookIdentifier == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

            Integer bookid;

            // If is an integer (bookid)
            if (bookIdentifier.matches("\\d+")) {
                bookid = Integer.parseInt(bookIdentifier);
            }
            // If is a string (bookName)
            else {
                bookid = bookRepository.getBookId(bookIdentifier);
            }

            List<Chapter> chapters = chapterRepository.getChaptersWithBookId(bookid);

            if (chapters.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }

            return chapters;
        } catch (Exception e) {
            throw e;
        }

    }

    // Get all Verses in Chapter using book/chapterNum
    @GetMapping({"/{bookIdentifier}/{chapterNum}", "/{bookIdentifier}/{chapterNum}/"})
    private List<Verse> getVersesInChapter(@PathVariable String bookIdentifier, @PathVariable Integer chapterNum) {
        // Get bookid
        if (bookIdentifier.isEmpty() || bookIdentifier == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        Integer bookid;

        // If is an integer (bookid)
        if (bookIdentifier.matches("\\d+")) {
            bookid = Integer.parseInt(bookIdentifier);
        }
        // If is a string (bookName)
        else {
            bookid = bookRepository.getBookId(bookIdentifier);
        }

        Chapter chapter = chapterRepository.findByChapterNumAndBookId(chapterNum, bookid);

        List<Verse> verses = verseRepository.findAllByChapterId(chapter.getChapterid());

        return verses;

    }


    // Get specific verse
    @GetMapping({"/{bookIdentifier}/{chapterNum}/{verseNum}", "/{bookIdentifier}/{chapterNum}/{verseNum}/"})
    private Verse getVersesInChapter(@PathVariable String bookIdentifier, @PathVariable Integer chapterNum, @PathVariable Integer verseNum) {
        // Get bookid
        if (bookIdentifier.isEmpty() || bookIdentifier == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        Integer bookid;

        // If is an integer (bookid)
        if (bookIdentifier.matches("\\d+")) {
            bookid = Integer.parseInt(bookIdentifier);
        }
        // If is a string (bookName)
        else {
            bookid = bookRepository.getBookId(bookIdentifier);
        }

        Chapter chapter = chapterRepository.findByChapterNumAndBookId(chapterNum, bookid);

        Verse verse = verseRepository.findByChapterIdAndVerseNum(chapter.getChapterid(), verseNum);

        return verse;
    }


}
