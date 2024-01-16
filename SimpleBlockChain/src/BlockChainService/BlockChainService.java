package BlockChainService;

import BlockChain.*;
import MainBlock.*;
import Transaction.*;
import java.util.*;
import Hashlib.Hashlib;

public class BlockChainService {

	private BlockChain blockchain;
	
	public BlockChainService() {
		blockchain = new BlockChain();
	}
	
	public MainBlock createNewBlock(String localHash, String preHash, List<Transaction> tList, int nonce) {
		MainBlock newBlock = new MainBlock();
		long timestamp = System.currentTimeMillis();
		newBlock.setHash(localHash);
		newBlock.setPreHash(preHash);
		newBlock.setTimestamp(timestamp);
		newBlock.setNonce(nonce);
		newBlock.setIndex(blockchain.getBlockChain().size() - 1);
		for( Transaction tsa : tList )
			newBlock.addTransaction(tsa);
		if( addBlock(newBlock))
			return newBlock;
		return null;
	}
	
	public MainBlock createGenesisBlock() {
		MainBlock genesisBlock = new MainBlock();
		long timestamp = System.currentTimeMillis();
		List<Transaction> tList = new ArrayList<Transaction>();
		Transaction tsa_1 = new Transaction("K4n", 114514, "这是创世区块创始人");
		Transaction tsa_2 = new Transaction("Niko", 1919810, "这是世一步！");
		tList.add(tsa_1);
		tList.add(tsa_2);
		
		genesisBlock.setHash(calculateHash("", tList, 1));
		genesisBlock.setPreHash("");
		genesisBlock.setTimestamp(timestamp);
		genesisBlock.setNonce(1);
		genesisBlock.setIndex(1);
		
		blockchain.getBlockChain().add(genesisBlock);
		return genesisBlock;
	}
	
	public boolean addBlock(MainBlock newBlock) {
		if( isValidBlock(newBlock, blockchain.getLatestBlock()) ) {
			blockchain.getBlockChain().add(newBlock);
			return true;
		}
		else	
			return false;
	}
	
	public boolean isValidBlock(MainBlock newBlock, MainBlock previousBlock) {
		if( !newBlock.getHash().equals(previousBlock.getHash()) ) {
			System.out.println("Error: Block Invalid!");
			System.out.println("Failed in \"previousHash verification\".");
			System.out.println();
			return false;
		}
		else {
			String Hash = calculateHash(newBlock.getPreHash(), 
					newBlock.getTransactions(),newBlock.getNonce());
			if( !Hash.equals(newBlock.getHash()) ) {
				System.out.println("Error: Block Invalid!");
				System.out.println("Failed in \"LocalHash verification\".");
				System.out.println("New  Block's hash: "+newBlock.getHash());
				System.out.println("Verification hash: "+Hash);
				System.out.println();
				return false;
			}
			else {
				if( !isValidHash(newBlock.getHash()) )
					return false;
				return true;
			}
		}
	}
	
	public String calculateHash(String preHash, List<Transaction> tList, int nonce) {
		StringBuilder builder = new StringBuilder();
		builder.append(preHash);
		for ( Transaction tsa : tList ) {
			String str = tsa.toString();
			builder.append(str);
		}
		builder.append(nonce);
		String hash = Hashlib.sha256(builder.toString());
		return hash;
	}
	
	public boolean isValidHash(String hash) {
		//暂未实现
		return true;
	}
}
