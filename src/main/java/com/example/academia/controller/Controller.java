package com.example.academia.controller;

import com.example.academia.JSON.*;
import com.example.academia.bean.Bills;
import com.example.academia.bean.Domain;
import com.example.academia.bean.Employee;
import com.example.academia.service.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Path("academia")
public class Controller {
    Service service = new Service();
    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginFunc(Employee emp) throws URISyntaxException
    {
        Employee e = service.login(emp);
        if(e==null)
            return Response.status(203).build();
        else if(e.getPassword().equals(emp.getPassword()) && e.getDepartment().equals("Accounts"))
            return Response.ok().entity(e.getEmployee_id()).build();
        else
            return Response.status(203).build();
    }

    @POST
    @Path("/createbill")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBill(CreateBill bill) throws URISyntaxException{
        int id = service.createBill(bill);
        /*  0 for domian success
            +v number bill id
            -1 student not found
            -2 domain not found
            -3 server error
            */
        if(id>=0)
            return Response.ok().entity(id).build();
        else
            return Response.status(404).entity(id).build();
    }

    @GET
    @Path("/viewBill")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewBill() throws URISyntaxException
    {

        return Response.ok().entity(service.viewBill()).build();
    }

    @POST
    @Path("/studentBill")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response studentBill(String roll_number)
    {
        List<Bills> bills = service.studentBill(roll_number);
        return Response.ok().entity(bills).build();
    }

    @POST
    @Path("/deleteBill")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteBill(List<BillId> ids)
    {

        boolean stat =service.deleteBill(ids);
        if(stat)
            return Response.ok().build();
        else
            return Response.status(403).build();
    }

    @POST
    @Path("/updateAmount")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAmount(UpdateAmount amt)
    {

        if(service.updateAmount( amt))
            return Response.ok().build();
        else
            return Response.status(403).build();
    }

    @POST
    @Path("/updateDeadline")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDeadline(UpdateDeadline cal)
    {
        if(service.updateDeadline(cal))
            return Response.ok().build();
        else
            return Response.status(403).build();
    }

    @POST
    @Path("/updateDescription")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDescription(UpdateDescription des)
    {
        if(service.updateDescription(des))
            return Response.ok().build();
        else
            return Response.status(403).build();
    }

    @GET
    @Path("/getDomain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomain()
    {
        return Response.ok().entity(service.getDomain()).build();
    }




}
