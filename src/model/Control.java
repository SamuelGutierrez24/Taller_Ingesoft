package model;

import java.util.ArrayList;

public class Control {
     
    private Node root;
    private ArrayList<Node> printInOrder;
    private int count;
    private Node firts10 []; 

    public Control(){
        this.root = null;
        printInOrder = new ArrayList<Node>();
        firts10 = new Node [10];
        this.count = 9;
    }

    public String add(int score, String nickname){
        return add(score, nickname,root);
    }

    public String add(int score,String nickname, Node current){
        
        if(root==null){
            Node node = new Node(score, nickname);
            root = node;
            if(count>=0){
                firts10 [count] = node;
                count --;
            }
            return "The root has been added";
        }else{
            
            Node node = new Node(score,nickname);
            // SI es mayor
            if(node.getScore()> current.getScore()){
                if(current.getRight() == null){
                    current.setRight(node);
                }else{
                    add(score, nickname, current.getRight());
                }
            }
            // Si es menor
            if(node.getScore()<current.getScore()){
                
                if(current.getLeft() == null){
                    current.setLeft(node);
                }else{
                    add(score, nickname, current.getLeft());
                }
                
                    if(count>=0){
                        firts10 [count] = node;
                        count --;
                    }
            }

                return "Node was added."; 
        }
    }


    public String searchByScore(int score){
        if(root != null){
            return searchByScore(score,root);
        }else{
            return "No hay registro de scores aun";
        }

    }   
    private String searchByScore(int target, Node current){
       

        if(current.getScore() == target){
            return current.getNickname();
        }else{
            if(target> current.getScore()){
                return searchByScore(target, current.getRight());
            }else{
                return searchByScore(target, current.getLeft());
            }
        }
    }
    
    public ArrayList<Node> inOrder(){
         return inOrder(root);
    }

    public ArrayList<Node> inOrder(Node node){
        if(node == null){
            return printInOrder;
        }

        inOrder(node.getLeft());
        printInOrder.add(node);
        inOrder(node.getRight());
        return printInOrder;
    }

    public String inOrderString(){
        inOrder();

        int longit = printInOrder.size();
        String out = "Score:----------Nickname: \n \n";
        for(int i = 0;i<=longit-1;i++){
            out+= printInOrder.get(i).getScore() + "         " + printInOrder.get(i).getNickname() + "\n";
        }

            return out;
    }

    /*public String inOrder10(){
        String out = "";

        for(int i = 0; i<=9; i++){
            
            if(firts10[i].getScore() > order){
                order = firts10[i].getScore();
            }
        }

        return out;
    }*/

}
