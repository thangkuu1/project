package project.thangnd.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.TransactionDetailDao;
import project.thangnd.models.Trans;
import project.thangnd.models.Transaction_detail;
import project.thangnd.services.TransactionDetailService;
import project.thangnd.services.TransactionService;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService{

	@Autowired
	private TransactionDetailDao transDetDao;
	
	
	@Override
	public int insertTransactionDetail(Transaction_detail trans_detail) {
		// TODO Auto-generated method stub
		return transDetDao.insertTransactionDetail(trans_detail);
	}


	@Override
	public List<Transaction_detail> listTransactionDetail(int transaction_id) {
		// TODO Auto-generated method stub
		return transDetDao.listTransactionDetail(transaction_id);
	}


	@Override
	public int updateTransactionByTransStat(int transaction_id, int id_food) {
		// TODO Auto-generated method stub
		return transDetDao.updateTransactionByTransStat(transaction_id, id_food);
	}

}
