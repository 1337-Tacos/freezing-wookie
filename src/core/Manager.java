package core;

import java.util.Arrays;
import java.util.List;

//TODO:  re-factor class to have a more useful name.
public class Manager {

	private List<Repository> repoList;

	//TODO:  Manager Constructor

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
	 * Adds a new repository to track.  
	 * @param name
	 * @param url
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

	//

	//public find package

}