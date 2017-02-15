package aula114.springmvc.service;

import java.util.List;

import aula114.springmvc.domain.Contact;

public interface EmployeeService {

	public List<Contact> listIdEmployee();
	public Contact show(String id);
	public int deleteContact(String contact_id);
	public int updateContact(Contact c);
	public int addContact(Contact c);
}
