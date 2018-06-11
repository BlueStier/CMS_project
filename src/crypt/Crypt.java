package crypt;

import org.mindrot.jbcrypt.BCrypt;

public final class Crypt {
	
	public static final String encrypted(String mdp) {
		return BCrypt.hashpw(mdp, BCrypt.gensalt());
	}
	
	public static final boolean decripted(String mdp, String mdp_crypt) {
		return BCrypt.checkpw( mdp, mdp_crypt);
	}
}
