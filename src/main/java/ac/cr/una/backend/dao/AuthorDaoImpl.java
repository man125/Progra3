/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Author;

/**
 *
 * @author toshiba1
 */
public class AuthorDaoImpl implements AuthorDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public Author findByName(String name) {
        Author autor = null;
        Query query = session.createQuery("from Author where nombre = :nombre ");//name
        query.setParameter("nombre", name);

        if (query.list().size() > 0) {
           autor = (Author) query.list().get(0);
        }

        return autor;
    }
    
}
