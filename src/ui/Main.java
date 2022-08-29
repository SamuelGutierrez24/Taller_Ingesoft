package ui;
import java.util.Scanner;

import model.Control;
public class Main {
    
    public static Scanner sc;
    private Control control;

    public Main(){
        this.control = new Control();
        sc = new Scanner(System.in);
    }

        public static void main(String [] args){
            
            Main ppal = new Main();
            int option = 0;
           do{
            option = ppal.showMenu();
            ppal.executeOperation(option);
           }while(option!=5);
        }

        public int showMenu() {
            int option=0;
    
            System.out.println(
                    "Main menu, please pick an option\n" +
                    "(1) Agregar registro \n" +
                    "(2) Buscar registro por puntaje \n"+
                    "(3) Ver puntajes de menor a mayor\n" +
                    "(4) Ver TOP 10, de mayor a menor \n" +
                    "(5) salir");
                
            option= sc.nextInt();
            sc.nextLine();
            return option;
        }
       
        public void executeOperation(int operation) {
		
            switch(operation) {
            
                case 1 :
                agregarRegistro();
                break;
                case 2 :
                buscarRegistro();
                break;
                case 3 :
                inOrder();
                break;
                case 4 :
                top10();
                break;
                case 5 :
                System.out.println("Todo bien, en la buena");
                break;
            default:
                System.out.println("Error, wrong option");
            
            }
        }

        public void agregarRegistro(){
            System.out.println("Ingrese el nickname:");
            String name = sc.nextLine();

            System.out.println("Ingrese su puntaje:");
            int score = sc.nextInt();

            System.out.println(control.add(score,name));
        }

        public void buscarRegistro(){
            System.out.println("Inserte puntaje a buscar:");
            int score = sc.nextInt();

            System.out.println(control.searchByScore(score));;
        }

        public void inOrder(){
            System.out.println(control.inOrderString());
        }

        public void top10(){

        }
}
