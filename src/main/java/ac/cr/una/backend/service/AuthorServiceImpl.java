
package ac.cr.una.backend.service;


import ac.cr.una.backend.dao.AuthorContactDAO;
import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import java.util.List;

/**
 *
 * @author mguzmana
 */
public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO aDAO;
    private AuthorContactDAO aDAO2;

    public AuthorServiceImpl() {
    }

    public AuthorServiceImpl(AuthorDAO aDAO,AuthorContactDAO aDAO2) {
        this.aDAO = aDAO;
        this.aDAO2 = aDAO2;
    }

    @Override
    public Author findByName(String  name) {
        return aDAO.findByName(name);
    }

    @Override
    public List<AuthorContact> findAll() {
        return aDAO2.findAll();
    }

    @Override
    public AuthorContact save(AuthorContact a) {
        return aDAO2.save(a);
    }

    @Override
    public boolean deleteAll() {
        return aDAO2.deleteAll();
    }

    //get--set
    public AuthorDAO getaDAO() {
        return aDAO;
    }

    public void setaDAO(AuthorDAO aDAO) {
        this.aDAO = aDAO;
    }

    public AuthorContactDAO getaDAO2() {
        return aDAO2;
    }

    public void setaDAO2(AuthorContactDAO aDAO2) {
        this.aDAO2 = aDAO2;
    }


   

}
