package com.pluralsight.bookstore.repository;

import com.pluralsight.bookstore.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(Transactional.TxType.SUPPORTS)
public class BookRepository {

    @PersistenceContext(unitName = "bookStorePU")
    private EntityManager em;


    public Book find(Long id){
        return em.find(Book.class, id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Book create(Book book){
        em.persist(book);
        return book;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(Long id){
        em.remove(em.getReference(Book.class, id));
    }

    public List<Book> findAll(){
        TypedQuery<Book> query = (TypedQuery<Book>) em.createQuery("SELECT b FROM Book b order by b.title");
        return query.getResultList();
    }

    public Long countAll(){
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(B) FROM Book b", Long.class);
        return query.getSingleResult();
    }

}