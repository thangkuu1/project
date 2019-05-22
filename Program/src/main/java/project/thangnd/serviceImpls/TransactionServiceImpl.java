package project.thangnd.serviceImpls;



import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.TransactionDao;
import project.thangnd.dtos.TransactionDetailDto;
import project.thangnd.models.Trans;
import project.thangnd.models.Transaction_detail;
import project.thangnd.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired 
	private TransactionDao transDao;

	@Override
	public int inserTransaction(Trans trans) {
		// TODO Auto-generated method stub
		return transDao.inserTransaction(trans);
	}

	@Override
	public List<Trans> listTransByIdRest(int id_rest) {
		// TODO Auto-generated method stub
		return transDao.listTransByIdRest(id_rest);
	}

	@Override
	public Trans getTransById(int id_trans) {
		// TODO Auto-generated method stub
		return transDao.getTransById(id_trans);
	}

	@Override
	public List<Trans> listTransByIdUser(int id_user, String tran_stat) {
		// TODO Auto-generated method stub
		return transDao.listTransByIdUser(id_user, tran_stat);
	}

	@Override
	public int updateTrans(int id_trans, String trans_stat) {
		// TODO Auto-generated method stub
		return transDao.updateTrans(id_trans, trans_stat);
	}

	@Override
	public Double sumPriceTrans(int rest) {
		// TODO Auto-generated method stub
		return transDao.sumPriceTrans(rest);
	}

	@Override
	public BigInteger countTransactionByDate(String date, int rest) {
		// TODO Auto-generated method stub
		return transDao.countTransactionByDate(date, rest);
	}

	@Override
	public BigInteger countTransaction(int rest) {
		// TODO Auto-generated method stub
		return transDao.countTransaction(rest);
	}

	@Override
	public Double sumPriceTransByDate(String date, int rest) {
		// TODO Auto-generated method stub
		return transDao.sumPriceTransByDate(date, rest);
	}

	@Override
	public List<Transaction_detail> listTrans(String start_date, String end_date, int rest) {
		// TODO Auto-generated method stub
		return transDao.listTrans(start_date, end_date, rest);
	}
	
	
}
