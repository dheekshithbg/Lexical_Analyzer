import java.io.*;
import java.util.*;

public class lexical {
    int operators(char w, char x, char y, char[] ope, int k){
        if(x=='+' || x=='-' || (x=='/' && y!='/' && w!='/') || x=='*' || x=='%'|| x=='='){
            ope[k]=x;
            k++;
        }
        return k;
    }
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       ArrayList<String> keywords = new ArrayList<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally",
            "float", "for", "if", "implements", "import", "instanceof", "int", "interface", "long",
            "native", "new", "package", "private", "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try",
            "void", "volatile", "while"
        ));
       String s,key="";
      try { 
            File Obj = new File("code.txt"); 
            Scanner Reader = new Scanner(Obj);
            char[] ope=new char[20];
            String[] var=new String[20]; 
            String digit1="", digit="", command="", spl="", pre="",str="",comm="";
            int k=0,d=0,t=0;
            lexical obj=new lexical();
            while (Reader.hasNextLine()) { 
                String data = Reader.nextLine();
                String[] words = data.split("\\s+");
                System.out.println(data+" ");
                char[] arr=data.toCharArray();
                for(int j=0;j<arr.length;j++){
                    if(j!=arr.length-1 && j!=0){
                        k=obj.operators(arr[j-1],arr[j],arr[j+1],ope,k);
                        if(arr[j]=='/' && arr[j+1]=='/'){
                        command=data.substring(j+2);
                        comm+=command+", ";
                    }
                    }
                    if(arr[j]=='.' || arr[j]==',' || arr[j]==';' || arr[j]=='(' || arr[j]==')' || arr[j]=='{' || arr[j]=='}'){
                        spl+=arr[j]+" ";
                    }
                    if(arr[j]=='"' && arr[j+1]!=')'){
                        for(int l2=j+1;l2<arr.length;l2++){
                            if(arr[l2]=='"'){
                                str+=",";
                                break;}
                            str+=arr[l2];
                        }
                    }
                    if(Character.isDigit(arr[j]) && (arr[j-1]=='=' || arr[j-1]==' ' || arr[j-1]=='/' ||arr[j-1]=='*' ||arr[j-1]=='+' ||arr[j-1]=='-' ||arr[j-1]=='%')){
                        digit1+=arr[j];
                        for(int i=j+1;i<arr.length;i++){
                            if(Character.isDigit(arr[i])||arr[i]=='.'){
                                digit1+=arr[i];
                                if(arr[i+1]==';'){digit1+=",";break;}
                            }
                            else if(arr[i]==' '){
                                digit1+=",";
                                break;
                            }
                        }
                    }
                    if(arr[j]=='@'){
                        
                        pre+=data.substring(j,arr.length)+", ";
                    }
                    if(arr[j]=='=' ||((arr[j]=='=') && (arr[j-1]==' '))){
                        int tem1=j-1;
                        do{
                            tem1--;
                        }while(arr[tem1]!=' ');
                        var[t]=data.substring(tem1+1, j);
                        t++;
                    }  
                    digit+=digit1;
                    str+=digit1;
                    digit1="";
                }
                for(String word: words){
                        for(String i: keywords){
                            if(word.equals(i)){
                                key+= word+ ", ";
                                //System.out.println(word);
                                break;
                            }
                        }
                }
            }
            System.out.println("Tokens :"); 
            System.out.print("Lexeme of Operators : ");
            for(int l=0;l<k;l++){
                if(l==k-1){
                    System.out.println(ope[l]);
                }else{
                    System.out.print(ope[l]+", ");
                }
           }
            System.out.println("Operators count : "+ k);
            System.out.print("Lexeme of Variables : ");
            for(int l1=0;l1<t;l1++){
                if(l1==t-1){
                    System.out.println(var[l1]);
                }else{
                    System.out.print(var[l1]+", ");
                }
                
            }
            System.out.print("Lexeme of Constants :");
            System.out.println(digit.substring(0,(digit.length()-1)));
            System.out.println("Lexeme of Keywords :"+ key.substring(0,(key.length()-2)));
            System.out.println("Lexeme of Literals :"+ str.substring(0,(str.length()-1)));
            System.out.println("Lexeme of Special Characters/ Delimiters : "+ spl);
            System.out.println("Non-Tokens :");
            System.out.println("Lexeme of Comments :"+ comm.substring(0,(comm.length()-2)));
            System.out.println("Lexeme of Preprocessors :"+ pre.substring(0,(pre.length()-2)));
            Reader.close(); 
        } 
        catch (FileNotFoundException e) { 
            System.out.println("An error has occurred."); 
            e.printStackTrace();
        }
}
}