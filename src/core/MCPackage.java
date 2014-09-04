package core;

public class MCPackage {

	/**
	 * The uniqueID (shortname) of the mod.  Analogous to Linux package names.
	 * Should not include any spaces, underscores, or special characters.
	 */
	protected String packageID;
	/**
	 * The version number the package is currently at.
	 */
	protected int version;
	/**
	 * The Human-Readable name of the mod.  This should be the actual mod name.
	 * Can contain spaces or any printable characters.
	 */
	protected String name;
	/**
	 * The short Description for the mod.
	 * Should be less than 50 characters long, or it may be cut off.
	 */
	protected String shortDesc;
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
	protected String[] tags;

	//TODO: Discuss.  Does a string list cover it?  What about version Numbers?
	protected String[] depends;
	protected String[] suggests;
	protected String[] conflicts;
	protected String[] replaces;

	//type?
	//architecture?

	protected String md5Sum;
	protected String fileName;

	protected String author;
	protected String maintainer;
	protected String homePage;
	protected String Description;

	
	/**
	 * Absolute minimum constructor.  These fields are required.
	 * Anything less than these will error out / not be recorded.
	 * @param id the uniqueID (shortname) of the mod.  This is a string with no spaces, analogous to linux package names.
	 * @param name the Human-Readable name of the mod.  This should be the actual mod name.
	 * @param version the version this package is on
	 * @param size the size (in bytes) which the mod will consume.
	 */
	MCPackage(String id, String name, int version, int size) {
		
	}

	//TODO: normal constructor (common fields)
	MCPackage(String id, int version, String name, String shortDesc, int size, String[] tags, String imageLink) {
		
	}

	//TODO: full constructor (all fields)
	MCPackage() {
		
	}


	//Get standard package details

	

}