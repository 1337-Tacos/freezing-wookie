package core;

public class ModRef {
	
	String name;
	String version;
	
	public ModRef(String name, String version){
		this.name = name;
		this.version = version;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getVersion(){
		return this.version;
	}

}
