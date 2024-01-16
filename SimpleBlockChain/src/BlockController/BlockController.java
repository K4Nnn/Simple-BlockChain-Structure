package BlockController;

import BlockChain.BlockChain;
import BlockChainService.BlockChainService;
import MainBlock.MainBlock;

public class BlockController {

	BlockChain blockChain;
	BlockChainService blockService;
	
	public String createFirstBlock() {
		return	"Genesis Block: "+blockService.createGenesisBlock().toString();
	}
	
	public String readBlock(MainBlock aBlock) {
		return	aBlock.toString();
	}
	
	public static void main(String[] args) {
		
	}

}
