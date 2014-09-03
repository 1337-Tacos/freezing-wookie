package core;

public class MCPackage {

	protected String mcpackage;
	protected int version;
	protected String name;
	protected String shortDesc;
	protected int size;
	protected String[] tag;

	//TODO: Discuss.  Does a string list cover it?  What about version Numbers?
	protected String[] depends;
	protected String[] suggests;
	protected String[] conflicts;
	protected String[] replaces;

	//type?
	//architecture?

	protected String md5Sum;
	protected String author;
	protected String maintainer;
	protected String homePage;
	protected String Description;

	//TODO: constructor
	MCPackage() {
		
	}

}