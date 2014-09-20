package utilities;

import java.util.ArrayList;

public final class VersionUtilities {
	public static final void verifyVersion(String ver) {
		
	}

	/**
	 * Converts, compares and returns which string is the latest (bigger) version string
	 * @param first the first version string to comapare
	 * @param second the second version string to compare
	 * @return true if the first string is larger, or equal to, the second string
	 */
	public static final boolean compareVersions(String first, String second) {
		//Clean any letters or other things that don't belong in a version string.
		String firstC = cleanString(first);
		String secondC = cleanString(second);

		//split the version strings along the .'s
		String[] firstS = firstC.split("\\.");
		String[] secondS = secondC.split("\\.");
		ArrayList<Integer> firstI = new ArrayList<Integer>();
		ArrayList<Integer> secondI = new ArrayList<Integer>();

		//convert that into array of Integers.
		for (String verPart : firstS)
			firstI.add(Integer.getInteger(verPart));
		for (String verPart : secondS)
			secondI.add(Integer.getInteger(verPart));

		//procedurally compare Integers, and return when done.
		for (int i = 0; i < 90; i++) {
			//TODO: research in .size() in relation to starting at 0
			if (secondI.size() < i+1)
				//If second string has less length than first (or both even so far, but both same)
				return true;
			if (firstI.size() < i+1)
				//if first string has less length than second
				return false;
			if (firstI.get(i) == secondI.get(i))
				//if both elements are same, skip to next element
				continue;
			else if (firstI.get(i) > secondI.get(i))
				//If the first element is larger, return true;  it's newer
				return true;
			else
				//Otherwise, the second element must be newer, return false.
				return false;
		}
		//Really, we shouldn't ever be able to get here, but the compiler thinks we can
		//so it'll complain if we don't add this.
		return false;
	}

	private static final String cleanString(String in) {
		//replace letters with numbers logic goes here.
		//That might become a bit messy
		//but I sure hope it doesn't :(
		return in;
	}
}