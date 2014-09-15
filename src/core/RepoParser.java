package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public abstract class RepoParser {

	/**
	 * Downloads the document for the repository, and then re-assembles the document, re-writing the line endings.
	 * This should prevent issues from different architectures line endings being different.
	 * @return a string that should include the entire document
	 * @throws IOException
	 */
	protected static String downloadRepo(Repository repo) throws IOException {
		URL page = new URL(repo.listURL + "packages");
		URLConnection connection = page.openConnection();
		BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream()));
		StringBuilder response = new StringBuilder(10000);
		String inputLine;
		//Read each line of repository list into a big String
		while ((inputLine = in.readLine()) != null)
			response.append(inputLine + "\n");
		in.close();
		return response.toString();
	}

	/**
	 * Parses the response string from downloading a repository.
	 * This splits each line out, and handles each one, splitting them each out into MCPackages 
	 * @param page the raw repository which as downloaded
	 * @param repo the repository object for which this pertains
	 * @return the Vector which contains all the packages parsed from the html string
	 * @throws IOException
	 */
	protected static ArrayList<MCPackage> parseUpdate(String page, Repository repo) throws IOException {
		BufferedReader br = new BufferedReader(new StringReader(page));
		String line;

		MCPackage curPack = new MCPackage(repo);
		ArrayList<MCPackage> packs = new ArrayList<MCPackage>();

		while ((line = br.readLine()) != null) {
			switch (line) {
			//Blank Line.  End of this package.  Load next.
			case "":
				System.out.println("Blank Line.  Loading next package");
				if (curPack.checkValidity())
					packs.add(curPack);
				else
					System.out.println("a Package in " + repo.listName + " did not supply sufficient information.");
				curPack = new MCPackage(repo);
				break;
			//Non-blank Line
			default:
				//Split all other lines into the tag (before the colon)
				//and the content (after the colon and space)
				String[] parts = line.split("\\:\\ ");
				if (parts.length == 2)
					dealLine(parts, curPack);
				else
					System.out.println("Most likely malformed repository:" + repo.listURL);
				break;
			}
		}
		//Save the last pack
		if (curPack.checkValidity())
			packs.add(curPack);
		else
			System.out.println("a Package in " + repo.listName + " did not supply sufficient information.2");

		return packs;
	}

	/**
	 * Deals with a specific *normal* line in the repository
	 * This is already confirmed to be a normal line, or this would not have been called 
	 * @param line the string array which has been read. [0] should be the tag, [1] should be the data
	 * @param pack the object which the resulting parsed data should be loaded into
	 */
	private static void dealLine(String[] line, MCPackage pack) {
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
		case "Shortdesc":
			pack.shortDesc = line[1];
			break;
		case "Size":
			pack.size = Integer.parseInt(line[1]);
			break;
		case "Tags":
			dealTags(line[1], pack);
			break;
		case "Depends":
			//TODO:  add depends parsing
			break;
		case "Suggests":
			dealSuggest(line[1], pack);
			break;
		case "Conflicts":
			//TODO:  add conflicts parsing
			break;
		case "Replaces":
			dealReplace(line[1], pack);
			break;
		case "MD5sum":
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
			dealDescription(line[1], pack);
			break;
		default:
			System.out.println("Unrecognized type:" + line[0]);
		}
	}

	/**
	 * Handles a request to parse a comma separated list of tags
	 * @param tags the content string containing only a comma and space separated list of tags
	 * @param pack the MCPackage which to add the tags to
	 */
	private static void dealTags(String tags, MCPackage pack) {
		String[] parts = tags.split("\\,\\ ");
		for (int i = 0; i < parts.length; i++) {
			pack.tags.add(parts[i]);
		}
	}

	//TODO:  dealDescription
	private static void dealDescription(String line, MCPackage pack) {
		pack.Description = "lol lol lol this is a long paragraph or something.  at least long enough to test word-wrapping.  lol. \n hello.  And then poop was launched out of bob's taco-cannon, which caused mary to jump off the eifel tower.  This line is waaaaaay too long to follow proper coding conventions, but it would be way too annoying for me to use like 5 lines to contain it all.";
	}

	private static void dealSuggest(String suggests, MCPackage pack) {
		String[] parts = suggests.split("\\,\\ ");
		for (int i = 0; i < parts.length; i++) {
			pack.suggests.add(parts[i]);
		}
	}
	
	private static void dealReplace(String replaces, MCPackage pack) {
		String[] parts = replaces.split("\\,\\ ");
		for (int i = 0; i < parts.length; i++) {
			pack.replaces.add(parts[i]);
		}
	}
}