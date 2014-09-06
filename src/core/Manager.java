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

	public MCPackage[] getAllPackages() {
		ArrayList<MCPackage> finalList = new ArrayList<MCPackage>();
		HashMap<String,MCPackage> finalMap = new HashMap<String,MCPackage>();
		//For each Repo...
		for (Repository repo : this.repoList) {
			//And each package in each repo....
			for (MCPackage pack : repo.getPackageList()) {
				//If it's already in it....
				if (finalMap.containsKey(pack.packageID)) {
					//Is this new one newer?
					if (pack.version > finalMap.get(pack.packageID).version) {
						//Then we update the one in the list.
						finalMap.put(pack.packageID, pack);
					}
					//Already in list, and newer version.
					//do nothing
				}
				//Package not in HashMap, so add it.
				finalMap.put(pack.packageID, pack);
			}
		}

		//Ok, all done generating list, now return it -_-
		Set<String> keys = finalMap.keySet();
		for (String key : keys) {
			finalList.add(finalMap.get(key));
		}
		return finalList.toArray(new MCPackage[finalList.size()]);
	}

	//public MCPackage[] getPackageCatagory(String);
	//Special case:  Installed Packages

	//public MCPackage[] getPackageOptions(String);

	//public setInstalled(String, boolean);

}