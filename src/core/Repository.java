package core;

public class Repository extends PackageList {

	public String listURL;

	//Since this is a repository, we fetch the repo, and update everything
	public boolean updateList() {
		return false;
		//TODO: implement updateList for Repositories
	}
	
}