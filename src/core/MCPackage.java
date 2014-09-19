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
	/**
	 * The size (in bytes) of all related mod files
	 */
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

	/**
	 * A string witch represents the type of release.
	 * Valid options: Normal, Beta, Alpha, Dev
	 */
	private String releaseType = "normal";
	private String releaseDate;

	protected String sha256;
	protected String fileName;

	protected String author = "";
	protected String maintainer = "";
	protected String homePage;

	/**
	 * license is a name of the mod's license, followed by a link to the license's text on curseforge. 
	 */
	protected String license;
	protected String licenseLink;

	/******************************************
	 *                Constructors
	 *****************************************/

	/**
	 * Normal Constructor, minimum (to be full) parameters
	 * @param id the uniqueID (shortname) of the mod.  This is a string with no spaces, analogous to Linux package names.
	 * @param name the Human-Readable name of the mod.  This should be the actual mod name.
	 * @param version the version this package is on
	 * @param size the size (in bytes) which the mod will consume.
	 */
	MCPackage(Repository parent, String id, String name, String version, String file) {
		this(parent);
		this.packageID = id;
		this.name = name;
		this.version = version;
		this.fileName = file;
	}

	public MCPackage(Repository parent) {
		this.parent = parent;
	}

	MCPackage() {
		this(new Repository("err", "http://err.com") );
	}

	/******************************************
	 *                Methods
	 *****************************************/

	//TODO:  Get standard package details

	public String getDownloadLink() {
		return "packages/" + fileName;
	}

	public boolean checkValidity() {
		if (this.fileName == null || this.version == null)
			return false;
		if (this.name == null || this.packageID == null)
			return false;
		return true;
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

	public String getReleaseTpe() {
		return this.releaseType;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public String getSha256() {
		return this.sha256;
	}

	public String getFileName() {
		return this.fileName;
	}

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

	public void setParent(Repository repo) {
		this.parent = repo;
	}

	public void setID(String ID) {
		this.packageID = ID;
	}

	public void setVersion(String ver) {
		this.version = ver;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setShortDesc(String desc) {
		this.shortDesc = desc;
	}

	public void setDescription(String desc) {
		this.Description = desc;
	}

	public void setSize(int newSize) {
		this.size = newSize;
	}

	public void addTag(String tag) {
		this.tags.add(tag);
	}

	//add Depends

	//add suggests

	//add conflicts

	//add replaces

	public boolean setReleaseType(String type) {
		if (type == "normal" || type == "beta" || type == "alpha" || type == "dev") {
			this.releaseType = type;
			return true;
		} else
			return false;
	}

	public void setReleaseDate(String newDate) {
		this.releaseDate = newDate;
	}

	public void setReleaseDate() {
		//TODO: parse string dates 
	}

	public void setSha256(String sha) {
		this.sha256 = sha;
	}

	//filename?

	public void setAuthor(String auth) {
		this.author = auth;
	}

	public void setMaintainer(String main) {
		this.maintainer = main;
	}

	public void setHomePage(String home) {
		this.homePage = home;
	}

	public void setLicense(String lic, String link) {
		this.license = lic;
		this.licenseLink = link;
	}
}