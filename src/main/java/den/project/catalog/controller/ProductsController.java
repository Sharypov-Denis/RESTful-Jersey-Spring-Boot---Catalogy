package den.project.catalog.controller;

import den.project.catalog.model.Products;
import den.project.catalog.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController///можно без этой аннотации
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "products")
@Path("/")
public class ProductsController {

    @Autowired
    private ProductsRepository repository;

    @GET
    @Produces("application/json")//сериализация, для формата XML - "application/xml"
    public List<Products> getAllUsers() {
        List<Products> productsList = new ArrayList<>();
        productsList = repository.getAll();
        return productsList;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")//сериализация, для формата XML - "application/xml"
    public Response getById(@PathParam("id") int id) throws URISyntaxException {
        Products products = repository.get(id);
        if (products == null) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(products)
                .contentLocation(new URI("/user-management/" + id)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Response deleteUser(@PathParam("id") int id) throws URISyntaxException {
        Products products = repository.get(id);
        if (products != null) {
            repository.delete(id);
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }

    @POST
    @Consumes("application/json")//ДЕсериализация, для формата XML - "application/xml"
    public Response create(Products products) throws URISyntaxException {
        if (products.getName() == null || products.getDescription() == null) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
        repository.save(products);
        return Response.status(201).entity(products).build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")//ДЕсериализация, для формата XML - "application/xml"
    @Produces("application/json")//сериализация, для формата XML - "application/xml"
    public Response update(@PathParam("id") int id, Products products) throws URISyntaxException {
        Products newProducts = repository.get(id);
        if (newProducts == null) {
            return Response.status(404).build();
        }
        newProducts.setName(products.getName());
        newProducts.setDescription(products.getDescription());
        repository.update(newProducts);
        return Response.status(200).entity(newProducts).build();
    }
}
