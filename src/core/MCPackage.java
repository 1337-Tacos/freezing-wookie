package core;

public class MCPackage {

	protected String packageID;
	protected int version;
	protected String name;
	protected String shortDesc;
	protected int size;
	protected String[] tag;
	protected String imageLink;

	//TODO: Discuss.  Does a string list cover it?  What about version Numbers?
	protected String[] depends;
	protected String[] suggests;
	protected String[] conflicts;
	protected String[] replaces;

	//type?
	//architecture?

	protected String md5Sum;
	protected String downloadLink;

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

	

}