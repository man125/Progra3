
package ac.cr.una.backend.webservice;


import ac.cr.una.backend.dao.AuthorContactDAO;
import ac.cr.una.backend.dao.AuthorContactDAOImpl;
import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.dao.AuthorDaoImpl;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.service.AuthorService;
import ac.cr.una.backend.service.AuthorServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("authors")
public class AuthorWebservice {

    private AuthorDAO authorDAO;
    private AuthorContactDAO authorcontactDAO;
    private AuthorService authorService;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    
    public AuthorWebservice() {
    }

    /**
     * Retrieves All the Students
     *
     * @return Student
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuthorContact> getAllAuthors() {
         List<AuthorContact> contactList = null;
        authorcontactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO,authorcontactDAO);

        contactList = authorService.findAll();

        return contactList;
    }

 
   @GET
    @Path("/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAuthorByName(@PathParam("nombre") String name) {
        Author a = null;
        authorDAO = new AuthorDaoImpl();
        authorService = new AuthorServiceImpl(authorDAO,authorcontactDAO);

        a = authorService.findByName(name);

        return a;
    }
    
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuthorContact createAuthor(AuthorContact autor) {

        authorcontactDAO = new AuthorContactDAOImpl();
         authorService = new AuthorServiceImpl(authorDAO, authorcontactDAO);

       autor = authorService.save(autor);

        return autor;
    }

    /**
     * Delete a new Student
     *
     * @param id
     * @return student
     */
    @DELETE
   // @Path("/{id}")
    public boolean deleteAll() {
        boolean result;
        authorcontactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl( authorDAO, authorcontactDAO);

        result = authorService.deleteAll();

        return result;
    }


}
