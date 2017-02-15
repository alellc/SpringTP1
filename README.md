# SpringTP1
Esto es un proyecto por requerimento de la asignatura DWS
Partiendo del proyecto <https://github.com/alellc/springMVCexaple>
Hace falta crear una base de datos llamada contactdb y una tabla llamada contactdb con el script que tenemos alojado en la carpeta sql <https://github.com/alellc/SpringTP1/blob/master/springmvcSimple/sql/MySQL_script.sql>
Una vez creada la tabla podemos desplegar el proyecto utilizando el comando mvn jetty:run ya que tiene el servidor jetty embebido. Una vez ejecutado el para probar la aplicación deberemos poner en la URL: localhost:9999/employee
##Añadido
Le he añadido al proyecto existente una CRUD completa usando Spring JdbcTemplate como podemos ver
Con este metodo consigo borrar un contacto 

	public int deleteContact(String contact_id){
		String sql ="delete from contact where contact_id = "+contact_id;
		int result = jdbcTemplate.update(sql);
		return result;
	}
Con este método condigo acer un update con los simbolos de ? le estoy diciendo al framework que les voy a pasar como parametros luego esos datos

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
  Tambien le he añadido bootstrap a las vistas JSP para que el resultado visual de la aplicación fuese un poco mas vistosa
  
  
