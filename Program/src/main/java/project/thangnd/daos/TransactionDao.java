package project.thangnd.daos;

import java.math.BigInteger;
import java.util.List;

import project.thangnd.dtos.TransactionDetailDto;
import project.thangnd.models.Trans;
import project.thangnd.models.Transaction_detail;

public interface TransactionDao {

	public int inserTransaction(Trans trans);
	public List<Trans> listTransByIdRest(int id_rest);
	public Trans getTransById(int id_trans);
	public List<Trans> listTransByIdUser(int id_user, String tran_stat);
	public int updateTrans(int id_trans, String trans_stat);
	public Double sumPriceTrans(int rest);
	public BigInteger countTransactionByDate(String date, int rest);
	public BigInteger countTransaction(int rest);
	public Double sumPriceTransByDate(String date, int rest);
	public List<Transaction_detail> listTrans(String start_date, String end_date, int rest);
}
