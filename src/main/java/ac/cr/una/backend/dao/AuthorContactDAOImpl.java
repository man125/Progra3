/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.AuthorContact;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toshiba1
 */
public class AuthorContactDAOImpl implements AuthorContactDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    
    @Override
    public AuthorContact save(AuthorContact contact) {
        session.beginTransaction();
        session.save(contact);
        session.getTransaction().commit();

        return contact;
    }

    @Override
    public List<AuthorContact> findAll() {
        List<AuthorContact> aList = new ArrayList<>();

        aList = session.createCriteria(AuthorContact.class).list();

        return aList;
    }

    @Override
    public boolean deleteAll() {
        boolean isDeleted = false;
        AuthorContact autor = null;

        session.beginTransaction();
        autor = (AuthorContact) session.get(AuthorContact.class);//dao
        session.delete(autor);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }
    
}

