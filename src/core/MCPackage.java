package core;

import java.io.Serializable;
import java.util.ArrayList;

public class MCPackage implements Serializable {

	private static final long serialVersionUID = 6390833776759776304L;
	private Repository parent;

	/**
	 * The uniqueID (shortname) of the mod.  Analogous to Linux package names.
	 * Should not include any spaces, underscores, or special characters.
	 */
	protected String packageID;
	/**
	 * The version number the package is currently at.
	 */
	protected String version = "0";
	/**
	 * The Human-Readable name of the mod.  This should be the actual mod name.
	 * Can contain spaces or any printable characters.
	 */
	protected String name;
	/**
	 * The short Description for the mod.
	 * Should be less than 50 characters long, or it may be cut off.
	 */
	protected String shortDesc = "";
	/**
	 * The size (in bytes) which the mod will consume.
	 * Technically should include the config file, and anything else the mod will download
	 */
	protected String Description = "";
	protected int size = 0;
	/**
	 * a list of tags (generally categories) which the mod falls into.
	 * There are a number of supported recommended categories you should use, listed elsewhere.
	 * There are also some special tags which may invoke special behavior.
	 * TODO:  Document special cases for tags here
	 */
	protected ArrayList<String> tags = new ArrayList<String>();

	//Only one thread is building the list and after its built its static, so getting a lock is just a useless performance hit.
	//If we absolutely have to change it there is a built in wrapper for synchronizing arrayLists.
	protected ArrayList<ModRef> depends = new ArrayList<ModRef>();
	protected ArrayList<String> suggests = new ArrayList<String>();
	protected ArrayList<ModRef> conflicts = new ArrayList<ModRef>();
	protected ArrayList<String> replaces = new ArrayList<String>();
	
	
	//type?
	//architecture?

	protected String md5Sum = "";
	protected String fileName;

	protected String author = "";
	protected String maintainer = "";
	protected String homePage;

	/**
	 * license is a name of the mod's license, followed by a link to the license's text on curseforge. 
	 */
	protected String license;
	protected String licenseLink;

	public MCPackage(Repository parent) {
		this.parent = parent;
	}

	/**
	 * Normal Constructor, minimum (to be full) parameters
	 * @param id the uniqueID (shortname) of the mod.  This is a string with no spaces, analogous to linux package names.
	 * @param name the Human-Readable name of the mod.  This should be the actual mod name.
	 * @param version the version this package is on
	 * @param size the size (in bytes) which the mod will consume.
	 */
	MCPackage(Repository parent, String id, String name, String version, String file) {
		this.parent = parent;

		this.packageID = id;
		this.name = name;
		this.version = version;
		this.fileName = file;
	}
	
	MCPackage() {
		this.name = "Error- No package Matches";
		this.fileName = "error.jar";
		this.packageID = "error";
		this.parent = new Repository("error", "http://error.com/");
	}

	//TODO:  Get standard package details

	public String getDownloadLink() {
		return "packages/" + fileName;
	}

	/******************************************
	 *                Getters
	 *****************************************/

	public Repository getParent() {
		return this.parent;
	}

	public String getID() {
		return this.packageID;
	}

	public String getVersion() {
		return this.version;
	}

	public String getName() {
		return this.name;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public String getDescription() {
		return this.Description;
	}

	public int getsize() {
		return this.size;
	}

	public ArrayList<String> getTags() {
		return this.tags;
	}

	//Get Depends

	//Get Suggests

	//Get Conflicts

	//Get Replaces

	public String getMD5Sum() {
		return this.md5Sum;
	}

	//File name????

	public String getauthor() {
		return this.author;
	}

	public String getMaintainer() {
		return this.maintainer;
	}

	public String getHomePage() {
		return this.homePage;
	}

	public String getLicense() {
		return this.license;
	}

	public String getLiceseLink() {
		return this.licenseLink;
	}

	/******************************************
	 *               Setters
	 *****************************************/

	public void setID(String ID) {
		this.packageID = ID;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setDescription(String desc) {
		this.Description = desc;
	}

	public void setShortDesc(String desc) {
		this.shortDesc = desc;
	}

	public void setAuthor(String auth) {
		this.author = auth;
	}

	public void setLicense(String lic, String link) {
		this.license = lic;
		this.licenseLink = link;
	}

	public void addTag(String tag) {
		this.tags.add(tag);
	}

	public boolean checkValidity() {
		if (this.fileName == null || this.version == null)
			return false;
		if (this.name == null || this.packageID == null)
			return false;
		return true;
	}
}