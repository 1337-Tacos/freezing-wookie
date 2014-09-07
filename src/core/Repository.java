package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

public class Repository extends PackageList {

	public String listURL;

	Repository (String name, String url) {
		super(name);
		this.listURL = url;
	}

	//Since this is a repository, we fetch the repo, and update everything
	public boolean updateList() {
		try {
			String html = downloadRepo();	//Fetch URL
			Vector<MCPackage> list = parseUpdate(html);				//Parse into separate objects
			
			//TODO:  if parsing was successful, replace all old objects
			this.packageList = list;
			//update lastUpdated
			return true;
		//TODO:  better exception handling & error reporting
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}

	/**
	 * Downloads the document for the repository, and then re-assembles the document, re-writing the line endings.
	 * This should prevent issues from different architectures line endings being different.
	 * @return a string that should include the entire document
	 * @throws IOException
	 */
	private String downloadRepo() throws IOException {
		URL page = new URL(this.listURL + "/lol.txt");  //TODO:  proper URL
		URLConnection connection = page.openConnection();
		BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream()));
		StringBuilder response = new StringBuilder(5000);
		String inputLine;
		//Read each line of repository list into a big String
		while ((inputLine = in.readLine()) != null)
			response.append(inputLine + "\n");
		in.close();
		return response.toString();
	}

	private Vector<MCPackage> parseUpdate(String page) throws IOException {
		BufferedReader br = new BufferedReader(new StringReader(page));
		String line;

		MCPackage curPack = new MCPackage();
		Vector<MCPackage> packs = new Vector<MCPackage>();

		while ((line = br.readLine()) != null) {
			switch (line) {
			//Blank Line.  End of this package.  Load next.
			case "":
				System.out.println("Blank Line.  Loading next package");
				packs.add(curPack);
				curPack = new MCPackage();
				break;
			//Non-blank Line
			default:
				String[] parts = line.split("\\:\\ ");
				dealLine(parts, curPack);
				break;
			}
		}
		//Save the last pack
		packs.add(curPack);

		return packs;
	}

	private void dealLine(String[] line, MCPackage pack) {
		switch (line[0]) {
		case "Package":
			pack.packageID = line[1];
			break;
		case "Version":
			pack.version = line[1];
			break;
		case "Name":
			pack.name = line[1];
			break;
		case "ShortDesc":
			pack.shortDesc = line[1];
			break;
		case "Size":
			pack.size = Integer.parseInt(line[1]);
			break;
		case "Tags":
			//TODO:  add tag parsing
			break;
		case "Depends":
			//TODO:  add depends parsing
			break;
		case "Suggests":
			//TODO:  add suggests parsing
			break;
		case "Conflicts":
			//TODO:  add conflicts parsing
			break;
		case "Replaces":
			//TODO:  add replaces parsing
			break;
		case "md5Sum":
			pack.md5Sum = line[1];
			break;
		case "Filename":
			pack.fileName = line[1];
			break;
		case "Author":
			pack.author = line[1];
			break;
		case "Maintainer":
			pack.maintainer = line[1];
			break;
		case "Homepage":
			pack.homePage = line[1];
			break;
		case "Description":
			//TODO:  Implement Description handling
			break;
		default:
			System.out.println("Unrecognized type:" + line[0]);
		}
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
		//TODO:  Implement saveList for repository
		return false;
	}

	/**
	 * Loads the local DB (cache) into the repository
	 * 
	 * @param file
	 * @return if it was successful
	 */
	public boolean loadList(String name) {
		//TODO:  Implement loadList for repository
		return false;
	}

}