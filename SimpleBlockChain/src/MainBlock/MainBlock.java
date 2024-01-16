/*
 * This is a simple implementation for BlockChain
 * Start from 2024/1/14
 */
package MainBlock;

import java.io.*;
import java.util.*;
import Transaction.*;

public class MainBlock implements Serializable{
	private static final long serialVersionUID = 1L;
	/*
	 * 在类或对象序列化、反序列化时 用该UID确认类是否兼容，是否可以进行序列化、反序列化
	 */
	
	private String localHash;
	/*
	 * 本块的哈希值
	 */
	
	private String previousHash;
	/*
	 * 上一个块的哈希值
	 */
	
	private long timestamp;
	/*
	 * 本块的时间戳
	 * 若为-1则表示无效
	 */
	
	private int nonce;
	/*
	 * 即number once，随机数
	 * 在实际应用中，起随机选择的作用
	 * 若为-1则表示无效
	 */
	
	private int index;
	
	private List<Transaction> transactions;
	
	public MainBlock() {
		this.localHash = null;
		this.previousHash = null;
		this.timestamp = -1;
		this.nonce = -1;
		this.index = -1;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public MainBlock(String localHash, String preHash, long timestamp, int nonce) {
		this.localHash = new String(localHash);
		this.previousHash = new String(preHash);
		this.timestamp = timestamp;
		this.nonce = nonce;
//		增加随机数算法
		this.index = 0;
		this.transactions = new ArrayList<Transaction>();
	}
	
	/*
	 * 返回本块的哈希值
	 */
	public String getHash() {
		return this.localHash;
	}
	
	/*
	 * 返回上一个块的哈希值
	 */
	public String getPreHash() {
		return this.previousHash;
	}
	
	/*
	 * 返回本块的时间戳
	 */
	public long getTimestamp() {
		return this.timestamp;
	}
	
	/*
	 * 返回本块的随机数
	 */
	public int getNonce() {
		return this.nonce;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public List<Transaction> getTransactions(){
		return this.transactions;
	}
	
	/*
	 * 设定本块的哈希值
	 */
	public void setHash(String lhash) {
		this.localHash = lhash;
	}
	
	/*
	 * 设定其中前一块的哈希值
	 */
	public void setPreHash(String phash) {
		this.previousHash = phash;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setTransactions(List<Transaction> tList) {
		this.transactions = tList;
	}
	
	public boolean addTransaction(Transaction aTransacion) {
		if(this.transactions.add(aTransacion))	
			return true;
		else {
			System.out.println("Block's addTransaction error!");
			return false;
		}
	}

	@Override
	public String toString() {
		return "LocalHash: "+localHash+", PreviousHash: "+previousHash+", Timestamp: "+
				this.timestamp+", Nonce: "+nonce+", Index: "+index+". ";
	}
	
	
	
}