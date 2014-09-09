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
	protected String version;
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
	protected int size;
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

	protected String md5Sum;
	protected String fileName;

	protected String author = "";
	protected String maintainer;
	protected String homePage;
	protected String Description = "";

	MCPackage(Repository parent) {
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

	//Get standard package details

	public String getDownloadLink() {
		return "packages/" + fileName;
	}

	public Repository getParent() {
		return this.parent;
	}

	public String getID() {
		return this.packageID;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.Description;
	}

}