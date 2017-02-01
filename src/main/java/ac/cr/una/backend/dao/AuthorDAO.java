
package ac.cr.una.backend.dao;


import ac.cr.una.backend.model.Author;
import java.util.List;

/**
 *
 * @author mguzmana
 */
public interface AuthorDAO {

    public Author findByName(String  name);
     
}
