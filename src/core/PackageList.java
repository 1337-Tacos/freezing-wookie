package core;

import java.util.Date;

//This handles a specific list of packages
//Normally, this is a specific repository.
//Includes all methods to update list, get specific details, etc.
public class PackageList {

	public String listName;
	public String listURL;
	public Date lastUpdated;
	
	//Updates the List.
	public boolean updateList() {
		/*
		 * This is PURPOSEFULLY not defined for the base PackageList.
		 * This is because normal PackageLists will actually be Repositories, which have their own implementation
		 */
		return false;
	}
	
	public 
	
}
