# Bible API
This is an Open Source public Bible API project for use by Developers to use in their own Christian applications. The Bible version is the KJV. There aren't many Bible API resources out there


The original use case for this api is to be used Guide Gospel's Bible section. Check out at the Guided Gospel Website: https://guidedgospel.net/

This project is made using Java, SpringBoot, and MySQL Database.

## Routes
All Data is returned in JSON format. The format includes going deeper per page. Put simply all routes follow this format: ``/bookName/chapterNum/verseNum``. 
`/` returns all books, `/bookName` returns chapters in that book. `/bookName/chapterNum` returns the verses in that chapter. `/bookName/chapterNum/verseNum` returns the specific verse.

### Books

> /api/bible or /api/bible/books

This Route returns all books in the bible. The Data Structure returned is as follows:
```
[
    {
      "bookid": number,
      "abbrev": string,
      "bookName": string
    },
  ]
```

### Chapters

> /api/bible/{bookName or bookid}

This route returns all chapters in the specified book. The parameter provided can be either the bookName or bookid. The Data Structure returned is as follows:
```
[
    {
        "chapterid": number,
        "bookid": number,
        "chapterNum": number
    },
]
```

### Verses

> /api/bible/{bookName or bookid}/{chapterNum}

This route returns all verses in the specified chapter, in the specified book. Replace {bookName or bookid} with the bookName or bookid. Replace {chapterNum} with the chapter number. The Data Structure returned is as follows:
```
[
    {
        "verseid": number,
        "chapterid": number,
        "verseNum": number,
        "text": string
    },
]
```

### Specific Verse

> /api/bible/{bookName or bookid}/{chapterNum}/{verseNum}

This route returns all verses in the specified chapter, in the specified book. Replace {bookName or bookid} with the bookName or bookid. Replace {chapterNum} with the chapter number. Replace {verseNum} with the verse number. The Data Structure returned is as follows:
```
{
    "verseid": number,
    "chapterid": number,
    "verseNum": number,
    "text": string
}
```

