package com.sao.hibernate;

import com.sao.hibernate.data.Author;
import com.sao.hibernate.data.Book;
import com.sao.hibernate.database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author saozd
 * @project com.sao.hibernate courseexample
 * 11.05.2023 May 2023
 */
public class TestMTMApp {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("Hibernate");

        Author author = new Author();
        author.setName("SAO");

        book.getAuthors().add(author);
        author.getBooks().add(book);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        book = (Book) session.merge(book);
        transaction.commit();
    }
}
