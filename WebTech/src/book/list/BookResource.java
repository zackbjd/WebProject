package book.list;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;








@Path("/books")
public class BookResource {

	BookDAO dao = new BookDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Book> findAll() {
		System.out.println("findAll");
		return dao.findAll();
	}
	@GET 
	@Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Book findById(@PathParam("id") String id) {
		System.out.println("***"+ id);
        return dao.findById(Integer.parseInt(id));
    }
	
	@PUT @Path("{id}")
	@Consumes ({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces ({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Book upadate(Book book){
		dao.update(book);
		return book;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Book create(Book book) {
		System.out.println("Creating book");
		return dao.create(book);
	}
	
	@DELETE @Path("{id}")
	@Produces ({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("id") int id) {
		dao.remove(id);
	}
	
	@GET @Path("search/{query}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Book> findByName(@PathParam("query") String query){
		return dao.findByName(query);
	}

	
}
