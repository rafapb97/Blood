package Blood.db.jdbc;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


import Blood.db.pojos.Hospital;



public class DB_Hospital extends GeneralMethods{

public void SQLCreate()  {
try {

// Create tables: begin
Statement stmt1 = super.c.createStatement();
String sql1 = "CREATE TABLE Hospital "
+ "(id INTEGER PRIMARY KEY AUTOINCREMENT ,"
+ "name TEXT NOT NULL, "
+ "location  TEXT, "
+ "range  INTEGER)";
stmt1.executeUpdate(sql1);
stmt1.close();
System.out.println("Tables created.");




}
catch (Exception e) {
e.printStackTrace();
}	
}

public ArrayList<Hospital> SQLSelect(){
ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
try {
Statement stmt = super.c.createStatement();

String sql = "SELECT * FROM Hospital";
ResultSet rs = stmt.executeQuery(sql);
while (rs.next()) {
int id = rs.getInt("id");
String name = rs.getString("name");
String location = rs.getString("location");
int range= rs.getInt("range");
Hospital hospital = new Hospital (id,name,location,range);
hospitals.add(hospital);
}
rs.close();
stmt.close();
System.out.println("Search finished.");
}
catch(Exception ex){
ex.printStackTrace();
}
return hospitals;
}
public void SQLDrop(){
try {

// Drop tables: begin
Statement stmt1 = super.c.createStatement();
String sql1 = "DROP TABLE hospital";
stmt1.executeUpdate(sql1);
stmt1.close();

} catch (Exception e) {
e.printStackTrace();
}
}
public void SQLInsert(Hospital hospital){
try {
Statement stmt = c.createStatement();
String sql = "INSERT INTO hospital (name, location, range) "

+ "VALUES ('" + hospital.getName() + "', '" + hospital.getLocation()	+ "','"+ hospital.getRange() + "');";

stmt.executeUpdate(sql);
stmt.close();



} catch (Exception e) {
e.printStackTrace();
}
}

public List<Hospital> SQLSearch(String hospName) {
	List<Hospital> hospitales = new LinkedList<>();
try {
	String sql = "SELECT * FROM hospital WHERE name LIKE ?";
PreparedStatement prep = super.c.prepareStatement(sql);
prep.setString(1, hospName);
ResultSet rs = prep.executeQuery();
while (rs.next()) {
int id = rs.getInt("id");
String name = rs.getString("name");
String location = rs.getString("location");
int range = rs.getInt("range");
Hospital hospital = new Hospital (id, name, location, range);
hospitales.add(hospital);
}

rs.close();
prep.close();

} catch (Exception e) {
e.printStackTrace();
}
return hospitales;
}

public void SQLDelete(Hospital hospital) {
	try{
	String sql = "DELETE FROM Hospital WHERE name=?";
	PreparedStatement prep = super.c.prepareStatement(sql);
	prep.setInt(1, hospital.getId());
	prep.executeUpdate();
	prep.close();
	}
	catch(SQLException ex){
		ex.printStackTrace();
		System.err.println("Fallo en la conexion, volviendo a intentar");
		
	}
    
}
public void SQLUpdate(Hospital hospUpdate) throws IOException , SQLException {
	String sql = "UPDATE Hospital SET name=? ,location=? ,range=?  WHERE id=?";
PreparedStatement prep = super.c.prepareStatement(sql);
prep.setString(1, hospUpdate.getName());
prep.setString(2, hospUpdate.getLocation());
prep.setInt(3, hospUpdate.getRange());
prep.setInt(4, hospUpdate.getId());
System.out.println("Update is finished");
prep.executeUpdate();
prep.close();

	
		}

	

}


