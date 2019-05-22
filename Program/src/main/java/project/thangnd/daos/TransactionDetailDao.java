package project.thangnd.daos;

import java.util.List;

import project.thangnd.models.Transaction_detail;

public interface TransactionDetailDao {

	public int insertTransactionDetail(Transaction_detail trans_detail);
	public List<Transaction_detail> listTransactionDetail(int transaction_id);
	public int updateTransactionByTransStat(int transaction_id, int id_food);
}
