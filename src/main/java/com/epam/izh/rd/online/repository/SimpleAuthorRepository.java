package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository {

    private Author[] authors = new Author[] {};

    @Override
    public boolean save(Author author) {
        boolean exist = false;

        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getName().equals(author.getName()) && authors[i].getLastName().equals(author.getLastName())) {
                exist = true;
            }
        }

        if (!exist) {
            Author[] newAuthors = new Author[authors.length + 1];
            for (int i = 0; i < authors.length; i++) {
                newAuthors[i] = authors[i];
            }
            newAuthors[authors.length] = author;

            authors = newAuthors;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Author findByFullName(String name, String lastname) {
        Author fullName = null;

        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getName().equals(name) && authors[i].getLastName().equals(lastname)) {
                fullName = authors[i];
            }
        }

        return fullName;
    }

    @Override
    public boolean remove(Author author) {
        boolean exist = false;

        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getName() == author.getName() && authors[i].getLastName() == author.getLastName()) {
                exist = true;
            }
        }

        if (!exist) {
            return false;
        } else {
            Author[] newAuthors = new Author[authors.length - 1];
            int count = 0;
            for (int i = 0; i < authors.length; i++) {
                if (authors[i].getName() == author.getName() && authors[i].getLastName() == author.getLastName()) {
                    continue;
                }
                newAuthors[count] = authors[i];
                count++;
            }

            authors = newAuthors;
            return true;
        }
    }

    @Override
    public int count() {
        return authors.length;
    }
}
