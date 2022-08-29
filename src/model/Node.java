package model;

public class Node{


    private int score;
    private String nickname;
    private Node right;
    private Node left;

    public Node(int score, String nickname){
        this.score = score;
        this.nickname = nickname;
        this.right = null;
        this.left = null;
    }

    public Node setRight(Node right){
        return this.right = right;
    }

    public Node getRight(){
        return right;
    }

    public Node getLeft(){
        return left;
    }

    public Node setLeft(Node left){
        return this.left = left;
    }

    public int getScore(){
        return this.score;
    }

    public String getNickname(){
        return this.nickname;
    }

}