package project.thangnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_detail")
public class Transaction_detail {
	
	@Column(name="transaction_id")
	private int transaction_id;
	@Id
	@Column(name="id_food")
	private int id_food;
	
	@Column(name="quantum")
	private String quantum;

	public int getTransaction_id() {
		return transaction_id;
	}
	
	@Column(name="price_food")
	private String price_food;
	
	@Column(name="trans_stat")
	private String trans_stat;

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getId_food() {
		return id_food;
	}

	public void setId_food(int id_food) {
		this.id_food = id_food;
	}

	public String getQuantum() {
		return quantum;
	}

	public void setQuantum(String quantum) {
		this.quantum = quantum;
	}
	public String getPrice_food() {
		return price_food;
	}

	public void setPrice_food(String price_food) {
		this.price_food = price_food;
	}

	public String getTrans_stat() {
		return trans_stat;
	}

	public void setTrans_stat(String trans_stat) {
		this.trans_stat = trans_stat;
	}

	@Override
	public String toString() {
		return "Transaction_detail [transaction_id=" + transaction_id + ", id_food=" + id_food + ", quantum=" + quantum
				+ ", price_food=" + price_food + ", trans_stat=" + trans_stat + "]";
	}

	
	
	
}
