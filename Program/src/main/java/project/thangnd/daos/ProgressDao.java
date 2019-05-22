package project.thangnd.daos;

import java.math.BigInteger;
import java.util.List;

import project.thangnd.models.Progress;

public interface ProgressDao {
	
	List<Progress> listProgress(int id);
	public int insertProgress(Progress progress);
	public int updateNoteProgress(int transaction_id, String progress, String note);
	public String timeProgress(int id_progress);
	public BigInteger countTimeProgress(String time_start, String time_end );
	public List<BigInteger> listTimeSpaceById_rest(int id_rest);
}
