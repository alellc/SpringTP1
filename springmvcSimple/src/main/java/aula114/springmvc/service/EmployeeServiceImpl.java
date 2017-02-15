package aula114.springmvc.service;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.*;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aula114.springmvc.domain.Contact;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List <Contact> listIdEmployee() {
		
		List contactos = new ArrayList();
		String sql = "select * from contact;";

 		List results = jdbcTemplate.queryForList(sql);
        for (Object result : results) {
        	Contact contacto = new Contact();
            HashMap map = (HashMap) result;
            for (Object key : map.keySet()) {}
            	//contacto.setId(Integer.valueOf(map.get("contact_id").toString()));
	        	contacto.setId(map.get("contact_id").toString());
	        	contacto.setName(map.get("name").toString());
	        	contacto.setAddress(map.get("address").toString());
	        	contacto.setEmail(map.get("email").toString());
	        	contacto.setTelephone(map.get("telephone").toString());
	        	contactos.add(contacto);
        }

		return contactos;
	}



	@Override
	public Contact show(String contact_id) {
		String sql ="select * from contact where contact_id = ?";
		Contact contact = new Contact();  		
		contact = jdbcTemplate.queryForObject(sql, new Object[]{contact_id}, new BeanPropertyRowMapper<Contact>(Contact.class));
        return contact;
	}

	@Override
	public int deleteContact(String contact_id){
		String sql ="delete from contact where contact_id = "+contact_id;
		int result = jdbcTemplate.update(sql);
		return result;
	}

	@Override
	public int updateContact(Contact c){
		String sql = "update contact set name=?,email=?,address=?,telephone=? where contact_id=?";
    	int result = jdbcTemplate.update(sql,c.getName(),c.getEmail(),c.getAddress(),c.getTelephone(),c.getId());
		return result;
	}

	@Override
	public int addContact(Contact c){
		String sql = "insert into contact(name,email,address,telephone) values(?,?,?,?)";
    	int result = jdbcTemplate.update(sql,c.getName(),c.getEmail(),c.getAddress(),c.getTelephone());
		return result;
	}
}
