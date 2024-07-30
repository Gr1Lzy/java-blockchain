package org.example.entity;

import org.example.util.StringUtil;

import java.util.List;
import java.util.logging.Logger;

public class Block {
    public final String hash;
    public final String previousHash;
    private final String data;
    private final long timeStamp;

    private static final Logger logger = Logger.getLogger(Block.class.getName());

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash +
                        timeStamp +
                        data
        );
    }

    public static Boolean isValidHash(List<Block> blockchain) {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                logger.info("Current Hashes not equal");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                logger.info("Previous Hashes not equal");
                return false;
            }
        }

        return true;
    }
}
