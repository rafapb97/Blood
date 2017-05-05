package Blood.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Symptoms implements Serializable {

	private static final long serialVersionUID = 6952444966932416547L;
    
	private Integer id;
    private String type;
    private String severity;
    private List<Patient> patients;
    private List<Illnes> illnes;
    
    public Symptoms() {
    	super();
    	this.patients = new ArrayList<>();
    	this.illnes = new ArrayList<>();
    	// TODO Auto-generated constructor stub
    }
    
    public Symptoms(Integer id, String type, String severity){
    	super();
    	this.id = id;
    	this.type = type;
    	this.severity = severity;
    	this.patients = new ArrayList<Patient>();
    	this.illnes = new ArrayList<Illnes>();
    }
    
    public Symptoms(String type, String severity){
    	super();
    	this.type = type;
    	this.severity = severity;
    }
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Symptoms other = (Symptoms) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getSeverity (){
	return severity;
}
public void setSeverity (String severity){
	this.severity = severity;
}
public List<Patient> getPatients() {
	return patients;
}
public void setPatients(List<Patient> patients) {
	this.patients = patients;
}
public List<Illnes> getIllnes() {
	return illnes;
}
public void setIllnes(List<Illnes> illnes) {
	this.illnes = illnes;
}


}
