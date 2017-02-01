
package ac.cr.una.backend.service;


import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import java.util.List;


public interface AuthorService {

    public Author findByName(String name);
    public List<AuthorContact> findAll();
    public AuthorContact save(AuthorContact autor);
    public boolean deleteAll();
}
