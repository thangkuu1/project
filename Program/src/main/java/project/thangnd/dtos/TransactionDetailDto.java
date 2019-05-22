package project.thangnd.dtos;

public class TransactionDetailDto {
	
	private int transaction_id;
	private int id_food;
	private String name_food;
	private String quantum;
	private String price_food;
	private String trans_stat;
	
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getId_food() {
		return id_food;
	}
	public void setId_food(int id_food) {
		this.id_food = id_food;
	}
	public String getName_food() {
		return name_food;
	}
	public void setName_food(String name_food) {
		this.name_food = name_food;
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
		return "TransactionDetailDto [transaction_id=" + transaction_id + ", id_food=" + id_food + ", name_food="
				+ name_food + ", quantum=" + quantum + ", price_food=" + price_food + ", trans_stat=" + trans_stat
				+ "]";
	}
	
	
	
	

}
