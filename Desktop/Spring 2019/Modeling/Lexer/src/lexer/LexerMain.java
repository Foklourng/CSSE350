package lexer;

import java.util.Scanner;

public class LexerMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Lexer lex = new Lexer();
        
        while(true) {
            String input = in.nextLine();
            String[] tokens = lex.parse(input);
            
            if(tokens != null) {
                for(String t : tokens) 
                    System.out.print("\"" + t + "\", ");
                System.out.println();
            }
            else
                System.out.println("*** Lexer.parse returned null ***");
            
        }
    }
    
}
