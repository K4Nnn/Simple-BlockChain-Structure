package BlockChain;

import MainBlock.MainBlock;
import java.util.*;

public class BlockChain {

	private List<MainBlock> blockChain;
	
	public BlockChain() {
		blockChain = new ArrayList<MainBlock>();
	}
	
	public List<MainBlock> getBlockChain(){
		return blockChain;
	}
	
	public void setBlockChain(List<MainBlock> newBlockChain) {
		this.blockChain = newBlockChain;
	}
	
	public MainBlock getLatestBlock() {
		return blockChain.get(blockChain.size() - 1);
	}
	
}
