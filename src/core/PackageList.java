package core;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 * This handles a specific list of packages.  
 * Normally, this is a specific repository.
 * Includes all methods to update list, get specific details, etc.
 * a PackageList is kept separate from Repository mainly because we can list local mods in one
 * While that is obviously not a repo, and those local mods may no longer exist in said repo.
 * @author 1n5aN1aC
 */
public class PackageList {
	/**
	 * the actual list of packages this holds
	 */
	protected Vector<MCPackage> packageList = new Vector<MCPackage>();

	/**
	 * the User-friendly name of this list of packages
	 */
	public String listName;
	public Date lastUpdated;

	PackageList(String name) {
		this.listName = name;
		//Set the last-used date to jan 1 1990 (never) just in case.
		Calendar cal = Calendar.getInstance();
		cal.set(1990, 1, 1);
		this.lastUpdated = cal.getTime();
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

		for(MCPackage pack : this.packageList) {
			if(pack.packageID == mcPackage) {
				return pack;
			}
		}
		return null;
	}

	//Returns the version of a specific mcpackage
	public String getPackageVersion(String mcPackage) {
		MCPackage pack = this.getPackage(mcPackage);

		if(pack != null) {
			return pack.version;
		}
		return "0";
	}

	//Returns the full details of a specific mcpackage.
	//Used as more efficient method of generating the package listings
	//Will need to discuss return type(s)
	public void getPackageDetails(String mcPackage) {
		
	}

	//Returns an array of package Objects.
	public Vector<MCPackage> getPackageList() {
		return this.packageList;
	}

}