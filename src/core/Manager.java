package core;

import java.util.Arrays;
import java.util.List;

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

	//public MCPackage[] getAllPackages();
	//{
	//	loop through repos, adding to LIST, keeping highest version.
	//	Convert to array when done.
	//}

	//public MCPackage[] getPackageCatagory(String);

	//public MCPackage[] getPackageOptions(String);

	//public setInstalled(String, boolean);

	

}