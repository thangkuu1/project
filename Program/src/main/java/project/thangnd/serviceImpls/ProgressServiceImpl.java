package project.thangnd.serviceImpls;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.ProgressDao;
import project.thangnd.models.Progress;
import project.thangnd.services.ProgressService;
@Service
public class ProgressServiceImpl implements ProgressService{

	@Autowired
	private ProgressDao progressDao;
	
	@Override
	public List<Progress> listProgress(int id) {
		// TODO Auto-generated method stub
		return progressDao.listProgress(id);
	}

	@Override
	public int insertProgress(Progress progress) {
		// TODO Auto-generated method stub
		return progressDao.insertProgress(progress);
	}

	@Override
	public int updateNoteProgress(int transaction_id, String progress, String note) {
		// TODO Auto-generated method stub
		return progressDao.updateNoteProgress(transaction_id, progress, note);
	}

	@Override
	public String timeProgress(int id_progress) {
		// TODO Auto-generated method stub
		return progressDao.timeProgress(id_progress);
	}

	@Override
	public BigInteger countTimeProgress(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return progressDao.countTimeProgress(time_start, time_end);
	}

	@Override
	public List<BigInteger> listTimeSpaceById_rest(int id_rest) {
		// TODO Auto-generated method stub
		return progressDao.listTimeSpaceById_rest(id_rest);
	}

}
