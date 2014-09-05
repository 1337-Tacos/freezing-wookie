package core;

public class Repository extends PackageList {

	public String listURL;
	
	//TODO: constructor (will be called from Manager (only I think) )
	Repository (String name, String url) {
		super(name);
		this.listURL = url;
	}

	//Since this is a repository, we fetch the repo, and update everything
	public boolean updateList() {
		return false;
		//TODO: implement updateList for Repositories
		
		//Fetch list
		//

		
	}

	/**
	 * Calculates the URL from which you can download the mod from.
	 * PLEASE use this function, rather than getting it directly, as future changes may break it if you do.
	 * @param thePackage an MCPackage object for which you want a download URL
	 * @return the URL where you should be able to download the actual mod package from
	 */
	public String getModDownloadURL(MCPackage thePackage) {
		return listURL + thePackage.getDownloadLink();
	}
	
	/**
	 * Gets the link to the URL where you can download the icon for mod.
	 * This function should always be used instead of directly computing it, to allow for package version changes in the future.
	 * @param thePackage an MCPackage object for which you want an image for
	 * @return the URL where you should be able to download the icon for the package.
	 */
	public String getModIconURL(MCPackage thePackage) {
		return listURL + "/images/" + thePackage.packageID;
	}

	/**
	 * Saves the repository to local DB (cache)
	 * @return if it was successful
	 */
	public boolean saveList() {
		
	}

	/**
	 * Loads the local DB (cache) into the repository
	 * 
	 * @param file
	 * @return
	 */
	public boolean loadList(String name) {
		
	}

}