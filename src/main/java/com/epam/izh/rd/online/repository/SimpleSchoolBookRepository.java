package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {

    SchoolBook[] schoolBooks = new SchoolBook[] {};

    @Override
    public boolean save(SchoolBook book) {
        SchoolBook[] newSchoolBook = new SchoolBook[schoolBooks.length + 1];
        for (int i = 0; i < schoolBooks.length; i++) {
            newSchoolBook[i] = schoolBooks[i];
        }
        newSchoolBook[newSchoolBook.length - 1] = book;
        schoolBooks = newSchoolBook;
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        int countBooks = 0;
        for (int i = 0; i < schoolBooks.length; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                countBooks++;
            }
        }
        SchoolBook[] booksByName = new SchoolBook[countBooks];

        int countItem = 0;

        for (int i = 0; i < schoolBooks.length; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                booksByName[countItem] = schoolBooks[i];
                countItem++;
            }
        }

        return booksByName;
    }

    @Override
    public boolean removeByName(String name) {
        boolean removed = false;

        int countBooks = 0;
        for (int i = 0; i < schoolBooks.length; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                countBooks++;
                removed = true;
            }
        }
        SchoolBook[] booksRemoved = new SchoolBook[schoolBooks.length - countBooks];

        int countItem = 0;

        for (int i = 0; i < schoolBooks.length; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                continue;
            }
            booksRemoved[countItem] = schoolBooks[i];
            countItem++;
        }
        schoolBooks = booksRemoved;

        return removed;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
