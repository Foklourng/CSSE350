package lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lexer {
    public StringBuilder temp = new StringBuilder("");
    public String str[];
    String[] parse(String input) {
        // YOUR IMPLEMENTATION HERE
        //use try catch to catch the unexpect error with the input;
        
        
        ArrayList<String> result = new ArrayList<String>();
      try{
        for(int i =0; i <input.length();++i){
            temp.setLength(0);
            
            switch(input.charAt(i)) {
                case '-':
                    if(i < input.length()-1){
                    if(Character.isDigit(input.charAt(i+1)) ){//// (a+-)
                        temp.append(input.charAt(i));
                        temp.append(input.charAt(i+1));
                        i++;
                        
                        for(int a = i; a <input.length()-1;++a){
                             if(Character.isDigit(input.charAt(i+1))){
                                    temp.append(input.charAt(i + 1));
                                    i++;    
                            }else if(input.charAt(i+1) == '.'){
                                temp.append(input.charAt(i+1));
                                    i++;
                            }
                         }
                    } 
                    }if(input.charAt(i) == '-'){
                        temp.append(input.charAt(i));
                    }
                    
                    
                    result.add(temp.toString());
                    break;
             
                case '(':
                    temp.append(input.charAt(i));
                    result.add(temp.toString());
                    break;
                case '.'://input contain .1
                    if(!Character.isDigit(input.charAt(i)))
                        return null;
                    break;
                case '_':
                    temp.append(input.charAt(i));
                    
                    result.add(temp.toString());
                    break;
                case '*':
                    temp.append(input.charAt(i));
                    result.add(temp.toString());
                    break;
                case '+':
                    temp.append(input.charAt(i));
                    result.add(temp.toString());
                    break;
                case '/':
                    temp.append(input.charAt(i));
                    result.add(temp.toString());
                    break;
                case ')':
                    //System.out.println("Char "+ i+ " "+input.charAt(i) );
                    temp.append(input.charAt(i));
                    result.add(temp.toString());
                    break;
                default:
                    if(Character.isDigit(input.charAt(i))){
                         temp.append(input.charAt(i)); 
                         if(i < input.length()-1){
                         if(input.charAt(i+1) == '_'){
                             temp.append(input.charAt(i+1)); 
                             i++;
                         }
                         }
                         for(int a = i; a <input.length()-1;++a){
                             if(i < input.length()-1){
                             if(Character.isDigit(input.charAt(i+1))){
                                    temp.append(input.charAt(i + 1));
                                    i++;    
                            }   
                             
                             if(i < input.length()-1){
                                if(input.charAt(i+1) == '.'){
                                    i++;
                                    temp.append(input.charAt(i));
                                    if(i == input.length() -1){//input contain 1.
                                        return null;
                                    }else{
                                        if(!Character.isDigit(input.charAt(i+1)))
                                            return null;
                                    }
                                }
                             }
                         }/*else{
                                 return null;
                             }*/
                             
                         }
                         for(int a = i; a <input.length()-1;++a){
                             if(Character.isDigit(input.charAt(i+1))){
                                    temp.append(input.charAt(i + 1));
                                    i++;    
                            }
                         }
                         
                        // if(Character.isDigit(input.charAt(i)) && input.charAt(i+1) == '.' )
                         
                         
                         
                         result.add(temp.toString());
                    }
                    
                    if(Character.isLetter(input.charAt(i))){
                        temp.append(input.charAt(i));
                        if(i < input.length()-1){
                        if(input.charAt(i+1) == '_'){
                             temp.append(input.charAt(i+1)); 
                             i++;
                         }
                        }
                        for(int a = i; a <input.length()-1;++a){
                           // System.out.println("In");
                            if(Character.isDigit(input.charAt(i+1))){
                             i++;
                           //  System.out.println("digit coming");
                             temp.append(input.charAt(i));
                            //System.out.println("temp is " + temp);
                            }else{
                                 a = input.length();
                              //   System.out.println("end");
                             }
                            }
                       // System.out.println("a1 is " + temp);
                        result.add(temp.toString());
                        }
                        
                    }
           // System.out.println("I is " + i);
                    //break;
            }
            
            str = new String[result.size()]; 
           // System.out.println("Result size " +result.size() );
            for(int j = 0; j < result.size() ; j++){
                str[j] = result.get(j);
                
            }
            
       
           
        return str;
    }catch(Exception e){
        return null;
    }
        
}
}
