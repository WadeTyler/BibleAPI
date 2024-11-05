# Bible API
This is an Open Source public Bible API project for use by Developers to use in their own Christian applications.
All routes return data in JSON format.

## Routes

#### Books

> /api/bible or /api/bible/books

This Route returns all books in the bible. The Data Strucutre returned is as follows:
```[
    {
      "bookid": number,
      "abbrev": string,
      "bookName": string
    }
  ]```

