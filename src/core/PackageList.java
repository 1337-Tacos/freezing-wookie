package core;

import java.util.Date;
import core.MCPackage;

/**
 * This handles a specific list of packages
 * Normally, this is a specific repository.
 * Includes all methods to update list, get specific details, etc.
 * @author 1n5aN1aC
 */
public class PackageList {
	/**
	 * the actual list of packages this holds
	 */
	private MCPackage[] packageList = null;

	/**
	 * the User-friendly name of this list of packages
	 */
	public String listName;
	public Date lastUpdated;

	//TODO:  Constructor
	PackageList() {
		
	}

	/**
	 * Updates the List.
	 * This is PURPOSEFULLY not defined for the base PackageList.
	 * This is because normal PackageLists will actually be Repositories, which have their own implementation
	 * @return Always false for PackageList, as it is for non-repo packages, or abstract representations
	 */
	public boolean updateList() {
		return false;
	}

	/**
	 * Returns the MCPackage object for a specific mcpackage.
	 * @param mcPackage the string used as a short identifier for the requested package
	 * @return the MCPackage object for the requested short identifier
	 */
	public MCPackage getPackage(String mcPackage) {

		for(MCPackage pack : this.packageList){
			if(pack.mcpackage == mcPackage){
				return pack;
			}
		}
		return null;
	}

	//Returns the version of a specific mcpackage
	public int getPackageVersion(String mcPackage) {
		MCPackage pack = this.getPackage(mcPackage);

		if(pack != null){
			return pack.version;
		}
		return 0;
	}

	//Returns the full details of a specific mcpackage.
	//Used as more efficient method of generating the package listings
	public getPackageDetails(String mcPackage) {
		
		
		
	}

	//Returns a list of package Objects.
	//TODO: discuss.  objects?  names?  details?
	public MCPackage[] getPackageList() {
		return this.packageList;
	}

	//Saves the list to local DB
	public boolean saveList() {
		
	}

	//Loads the local DB into the list
	public boolean loadList() {
		
	}

}