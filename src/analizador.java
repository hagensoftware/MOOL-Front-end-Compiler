   import java.io.*;
   import java.util.*;

   public class analizador {
      static public String[] lines= new String[100]; //lineas
      static public String[] listaTokens= new String[400]; //num max de tokens
      static public String[] listaTipos= new String[400];
      static public int[] listLines= new int[400];
      static public int[] listPos= new int[400];
      String linea;
      private int linnum;
   
      public analizador(String[] args){ 
         boolean bReservada;        
         boolean ok;
         String[] Reservada = {"protected","true","false","null",
            "object","integer","float","boolean",
            "module","interface","implements","import","init",
            "const","void","class","function","extends",
            "fields","shadow","constructors","methods","override",
            "break","continue","else","if","for","return","switch","while",
            "case","default","instanceof","super","new","this","as"
            ,"then","begin","end","print"
         };
         String[] tipoToken = {"ID","NUM","OP","REL","STR"};
         String tipo= "NO ID";
         int c=0;
         
         for (int i=0; i < args.length; i++) {
            try {
               FileInputStream fin =  new FileInputStream(args[i]);
               BufferedReader myInput = new BufferedReader
                  (new InputStreamReader(fin));
               while ((linea = myInput.readLine()) != null) {  
                  linnum++;
                   System.out.println(linnum+" "+linea);
                   lines[linnum]=linea;
                  Tokenizador str = new Tokenizador(linea);        
                  while (str.tieneMasTokens()) {
                     bReservada=false;
                     String token = str.sigToken(); 
                     for (int j=0;j<=37;j++) //41
                     {
                        if (token.equals(Reservada[j])) 
                        {
                           if (token.equals("module")) {tipo="MODULE"; bReservada=true;}
                           if (token.equals("interface")) {tipo="INTERFACE"; bReservada=true;}
                           if (token.equals("implements")) {tipo="IMPLEMENTS"; bReservada=true;}
                           if (token.equals("const")) {tipo="CONST"; bReservada=true;}
                           if (token.equals("integer")) {tipo="INTEGER"; bReservada=true;}
                           if (token.equals("float")) {tipo="FLOAT"; bReservada=true;}
                           if (token.equals("boolean")) {tipo="BOOLEAN"; bReservada=true;}
                           if (token.equals("import")) {tipo="IMPORT"; bReservada=true;}
                           if (token.equals("init")) {tipo="INIT"; bReservada=true;}
                           if (token.equals("if")) {tipo="IF"; bReservada=true;}
                           if (token.equals("for")) {tipo="FOR"; bReservada=true;}
                           if (token.equals("switch")) {tipo="SWITCH"; bReservada=true;}
                           if (token.equals("while")) {tipo="WHILE"; bReservada=true;}
                           if (token.equals("return")) {tipo="RETURN"; bReservada=true;}
                           if (token.equals("break")) {tipo="BREAK"; bReservada=true;}
                           if (token.equals("object")) {tipo="OBJECT"; bReservada=true;}
                           if (token.equals("continue")) {tipo="CONTINUE"; bReservada=true;}
                           if (token.equals("case")) {tipo="CASE"; bReservada=true;}
                           if (token.equals("default")) {tipo="DEFAULT"; bReservada=true;}
                           if (token.equals("as")) {tipo="AS"; bReservada=true;}
                           if (token.equals("void")) {tipo="VOID"; bReservada=true;}
                           if (token.equals("class")) {tipo="CLASS"; bReservada=true;}
                           if (token.equals("constructors")) {tipo="CONSTRUCTORS"; bReservada=true;}
                           if (token.equals("fields")) {tipo="FIELDS"; bReservada=true;}
                           if (token.equals("methods")) {tipo="METHODS"; bReservada=true;}
                           if (token.equals("null")) {tipo="NULL"; bReservada=true;}
                           if (token.equals("override")) {tipo="OVERRIDE"; bReservada=true;}
                           if (token.equals("else")) {tipo="ELSE"; bReservada=true;}
                           if (token.equals("new")) {tipo="NEW"; bReservada=true;}
                           if (token.equals("this")) {tipo="THIS"; bReservada=true;}
                           if (token.equals("extends")) {tipo="EXTENDS"; bReservada=true;}
                           if (token.equals("super")) {tipo="SUPER"; bReservada=true;}
                           if (token.equals("true")) {tipo="TRUE"; bReservada=true;}
                           if (token.equals("false")) {tipo="FALSE"; bReservada=true;}
                           if (token.equals("instanceof")) {tipo="INSTANCEOF"; bReservada=true;}
                        
                        //                       if (token.equals("then")) {tipo="THEN"; bReservada=true;}
                        //                       if (token.equals("print")) {tipo="PRINT"; bReservada=true;}
                        //                       if (token.equals("begin")) {tipo="BEGIN"; bReservada=true;}
                        //                       if (token.equals("end")) {tipo="END"; bReservada=true;}
                        
                        //tipo = token.toUpperCase().toString();
                           bReservada=true;
                        }   
                     }  
                     if (bReservada==false)
                     {
                        ok=false;
                     
                        if (token.equals("<")) {tipo="LT"; ok=true;}
                        if (token.equals(">")) {tipo="GT"; ok=true;}
                        if (token.equals("=")) {tipo="EQ"; ok=true;}
                        if (token.equals("/")) {tipo="OVER"; ok=true;}
                        if (token.equals("+")) {tipo="PLUS"; ok=true;}
                        if (token.equals("-")) {tipo="MINUS"; ok=true;}
                        if (token.equals("(")) {tipo="LPAREN"; ok=true;}
                        if (token.equals(")")) {tipo="RPAREN"; ok=true;}
                        if (token.equals(";")) {tipo="SEMI"; ok=true;}
                        if (token.equals("*")) {tipo="TIMES"; ok=true;}
                        if (token.equals("[")) {tipo="LCORCH"; ok=true;}
                        if (token.equals("]")) {tipo="RCORCH"; ok=true;}
                        if (token.equals("{")) {tipo="LLLAVE"; ok=true;}
                        if (token.equals("}")) {tipo="RLLAVE"; ok=true;}
                        if (token.equals(".")) {tipo="DOT"; ok=true;}
                        if (token.equals(",")) {tipo="COMA"; ok=true;}
                        if (token.equals(":")) {tipo="DOSP"; ok=true;}
                        if (token.equals("%")) {tipo="PER"; ok=true;}
                        if (token.equals("!")) {tipo="NOTOP"; ok=true;}
                     
                        if (token.equals("++")) {tipo="PPLUS"; ok=true;}
                        if (token.equals("--")) {tipo="MMINUS"; ok=true;}
                     
                        if (token.equals("&&")) {tipo="ANDOP"; ok=true;}
                        if (token.equals("||")) {tipo="OROP"; ok=true;}
                        if (token.equals("<=") || token.equals(">=") || 
                           token.equals("==") || token.equals("!=")) 
                        {
                           tipo="OPREL";
                           ok=true;
                        }
                        if (Tokenizador.tipo==0 || Tokenizador.tipo==1) 
                        {
                           tipo=(tipoToken[Tokenizador.tipo]);
                           ok=true;
                        }
                        if (Tokenizador.tipo==5) 
                        {
                           tipo="ID";
                           ok=true;
                        }                       
                        if (ok==false) {tipo="NO_ID";}
                     }
                     listaTokens[c]=token;           
                     listaTipos[c]=tipo;
                     listLines[c]=linnum;
                     listPos[c]=str.PosActual;
                     
                     c++;            
                  }
               }
            }
               catch (Exception e) {
                  e.printStackTrace();
               }
         }           
      }
   }