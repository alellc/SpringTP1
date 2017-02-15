package aula114.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import aula114.springmvc.service.EmployeeService;
import aula114.springmvc.domain.Contact;

import java.util.*;
import java.sql.SQLException;
import java.io.IOException;
import aula114.springmvc.domain.Contact;

@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;
  
  @RequestMapping("/show/{id}")
  public String show (Model model,@PathVariable("id") String id){
    /*System.out.println("Prueba"+id);*/
    Contact c = employeeService.show(id);
    model.addAttribute("aContact",c);
    return "show";
  }
  
  @RequestMapping("/employee")
  public String consulta(Model model){
    List<Contact> list = employeeService.listIdEmployee();
    model.addAttribute("list",list);
    return "consulta";
  }

  @RequestMapping("/eliminar/{id}")
  public String eliminar(Model model,@PathVariable("id") String id){
    int res = employeeService.deleteContact(id);
    return "eliminado";
  }

  @RequestMapping("/add")
  public String add (Model model){
    return "add";
  }

  @RequestMapping(value= "/add", method = RequestMethod.POST)
  public String eliminar(Model model,@RequestParam(value="name") String name, 
                                     @RequestParam(value="address") String address,
                                     @RequestParam(value="email") String email,@RequestParam(value="telephone") String telephone){
    Contact c = new Contact(name,email,address,telephone);
    int res = employeeService.addContact(c);
    return "addExito";
  }

  @RequestMapping("/edit/{id}/{name}/{email}/{address}/{telephone}")
  public String edit(Model model,@PathVariable("id") String id,@PathVariable("name") String name,@PathVariable("email") String email,
    @PathVariable("address") String address,@PathVariable("telephone") String telephone){
  	Contact c = new Contact(id,name,email,address,telephone);
    model.addAttribute("contact",c);
    return "edit";
  }

  @RequestMapping(value= "/edit", method = RequestMethod.POST)
  public String edicion(Model model,@RequestParam(value="id") String id,
                                    @RequestParam(value="name") String name, 
                                    @RequestParam(value="address") String address,
                                    @RequestParam(value="email") String email,@RequestParam(value="telephone") String telephone){
    Contact c = new Contact(id,name,email,address,telephone);
  	int res = employeeService.updateContact(c);
  	return "editExito";
  }
}
