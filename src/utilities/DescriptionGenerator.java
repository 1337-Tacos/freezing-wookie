package utilities;

import core.MCPackage;

public abstract class DescriptionGenerator {

	public static String generateDescription(MCPackage pack) {
		String html = "";
		html += "<html><head>";
		//head stuff goes here
		html += "</head><body bgcolor='#777779'>";
		html += "<hr/><font size=50>";
		html += "<img src=" + pack.getParent().listURL + "images/" + pack.getID() + " />";
		html += pack.getName();
		html += "</font><hr/>";
		html += pack.getDescription();
		//html += other details and stuff
		html += "</body></html>";
		
		return html;
	}
}

/* 
 * We will definitely want to make this html much, much more advanced in the future.
 * First, this will involve making a vertical bar, with the main details in that bar
 * While the description will stay basically how it is.
 */