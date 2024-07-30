package org.example;

import org.example.entity.Block;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Block> blockchain = new ArrayList<>();

        blockchain.add(new Block("Hello World!", "0"));
        blockchain.add(new Block("Hello Java!", blockchain.getLast().hash));
        blockchain.add(new Block("Hello Blockchain!", blockchain.getLast().hash));

        System.out.println(Block.isValidHash(blockchain));
    }
}