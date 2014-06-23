package md.chisinau.services;

import java.net.ResponseCache;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import md.chisinau.dao.CustomerDAOImpl;
import md.chisinau.dao.CustomersDAO;
import md.chisinau.pojo.Customers;

@Path("/customers")
public class CustomersService {

	   @GET 
	    @Produces("text/plain")
	    public String getIt() {
		   Locale.setDefault(Locale.US);
	    	
	    	
	        return "Hi there!";
	    }
	   @GET
	   @Path("/getCustomers")
	   @Produces(MediaType.APPLICATION_JSON)
	  public Response getCustomers(){
		   Locale.setDefault(Locale.US);
		   CustomersDAO dao = new CustomerDAOImpl();
		   List<Customers> result = dao.getAllCustomers();
		   if (result!=null) {
			 return Response.ok(new GenericEntity<List<Customers>>(result){}).build();
			
		}
		   return null;
		   
	   }
	   @GET
	   @Path("/getCustomer/{id}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getCustomer(@PathParam("id") int id ){
		   Locale.setDefault(Locale.US);
		   CustomersDAO dao = new CustomerDAOImpl();
		   Customers customer = dao.getCustomerById(id);
		   System.out.println(customer.toString());
		  return Response.ok(new GenericEntity<Customers>(customer){}).build();
	   }
	   @PUT
	   @Path("/update/{id}")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response updateCustomers(){
		   
		   
		   return Response.ok().build();
	   }
}
