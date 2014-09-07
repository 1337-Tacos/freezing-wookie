package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

//TODO:  re-factor class to have a more useful name.
public class Manager {

	private List<Repository> repoList;

	//TODO:  Manager Constructor

	/**
	 * Adds a new repository to track.
	 * @param name the name of the repository
	 * @param url the raw url to the repository's home dir
	 */
	public void addRepo(String name, String url) {
		//TODO:  update this, along with Repository constructor
		Repository repo = new Repository(name, url);
		repoList.add(repo);
	}

	/**
	 * Removes the specified repository from the manager's repo list.
	 * This will generally cause all that repo's packages to cease to exist.
	 * @param removeRepo the repository which you wish to remove
	 */
	public void removeRepo(Repository removeRepo) {
		repoList.removeAll(Arrays.asList(removeRepo));
	}

	/**
	 * Request the package manager to update all it's repositories
	 * @return true if successful, or if there are no repositories to update
	 */
	public boolean updateRepos() {
		boolean anyFailed = false;
		for (Repository repo : this.repoList) {
			if (repo.updateList() == false)
				anyFailed = true;
		}
		if (anyFailed == true)
			return false;
		return true;
	}

	/**
	 * returns a list of all packages in all Repositories.
	 * @return an array of all packages
	 */
	public MCPackage[] getAllPackages() {
		return getPackageCatagory("all");
	}

	//TODO:  Special case:  Installed Packages
	/**
	 * Returns a list of all packages with the specified tag.
	 * This is.....  Perhaps a bit crazy on it's converting, but we can optimize it if we run into issues.
	 * @param cat the category which you want to return.  "all" returns all categories
	 * @return the array with the matching packages
	 */
	public MCPackage[] getPackageCatagory(String cat) {
		ArrayList<MCPackage> finalList = new ArrayList<MCPackage>();
		HashMap<String,MCPackage> finalMap = new HashMap<String,MCPackage>();
		//For each Repo...
		for (Repository repo : this.repoList) {
			//And each package in each repo....
			for (MCPackage pack : repo.getPackageList()) {
				//If we want all packages, don't bother checking categories
				if (cat != "all" && !pack.tags.contains(cat))
					continue;
				//If it's already in it....
				if (finalMap.containsKey(pack.packageID)) {
					//Is this new one newer?
					if (pack.version > finalMap.get(pack.packageID).version) {
						//Then we update the one in the list.
						finalMap.put(pack.packageID, pack);
					}
					//Already in list, and newer version.
					//do nothing
				} else {
					//Package not in HashMap, so add it.
					finalMap.put(pack.packageID, pack);
				}
			}
		}

		//OK, all done generating list, now return it -_-
		Set<String> keys = finalMap.keySet();
		for (String key : keys) {
			finalList.add(finalMap.get(key));
		}
		return finalList.toArray(new MCPackage[finalList.size()]);
	}

	/**
	 * Fetches all instances of a requested package
	 * @param id the unique ID of the mod you want to find
	 * @return an array of all instances of the mod
	 */
	public MCPackage[] getPackageOptions(String id) {
		ArrayList<MCPackage> finalList = new ArrayList<MCPackage>();
		for (Repository repo : this.repoList) {
			for (MCPackage pack : repo.getPackageList()) {
				if (pack.packageID.equalsIgnoreCase(id))
					finalList.add(pack);
			}
		}
		return finalList.toArray(new MCPackage[finalList.size()]);
	}

	public void setInstalled(MCPackage pack, boolean install) {
		//TODO:  create getInstalled()
	}

}