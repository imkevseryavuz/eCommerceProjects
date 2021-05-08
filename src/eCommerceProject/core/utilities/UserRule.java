package eCommerceProject.core.utilities;

public class UserRule {
	public static boolean Run(boolean... logics) {
		for(boolean logic:logics) {
			if (!logic) {
				return false;
			}
		}
		return true;
	}
}
