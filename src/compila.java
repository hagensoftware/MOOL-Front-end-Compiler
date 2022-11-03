   import java.io.*;

   public class compila {
      static String[] arg= new String[1];
      static parser resul;
      
      static boolean toFile=false;
      
      public compila() {}
   
      public static void main(String[] args) throws IOException {

         if (args.length>0)
             resul=new parser(args);
         else 
             MenuPrincipal(); 
         System.out.println("Empieza el toString");
         System.out.println(resul.fileInt+".java");
         System.out.println(resul.fileImp+".java");
         System.out.println(resul);
         FileWriter Int=null;
         FileWriter Imp=null;
         if (toFile){
         if (resul.fileInt != null) {
             Int=new FileWriter("c:/javas/"+resul.fileInt+".java");
             Int.write(resul.treeInt+"\r\n");
             Int.close();
         }
         if (resul.fileImp != null) {
             Imp=new FileWriter("c:/javas/"+resul.fileImp+".java");
             Imp.write(resul.treeImp+"\r\n");
             Imp.close();
         }
         }
      
      }
   
      public static void MenuPrincipal() throws IOException{
         BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
         int op;
         int E=0;
         while(true)
         {
            System.out.println("*****MENU*****");
            System.out.println("1.- Ejemplo 1");
            System.out.println("2.- Ejemplo 2");
            System.out.println("3.- Salir");
            System.out.println("4.- Ejemplo 4");
            System.out.println("5.- Ejemplo 5");
            System.out.println("6.- Ejemplo 6");
            System.out.println("7.- Ejemplo 7");
            System.out.println("8.- Ejemplo 8");
            System.out.println("9.- Ejemplo 9");
            System.out.println("0.- Ejemplo 10");
            System.out.println("Presione cualquier otro numero para salir");        
            op=Integer.parseInt(stdin.readLine());
            if ((int)op<-1 || (int)op>9) System.exit(0);
               //break;
            if (op==1)
            {
               arg[0] ="c:/javas/ejemplo1.txt";
            }
            else if (op==2)
            {
               arg[0] ="c:/javas/ejemplo2.txt";              
            }
            else if (op==3)
            {
                System.exit(0);
              //arg[0] ="c:/java/ejemplo_IF.txt";              
            }
            else if (op==4)
            {
               arg[0] ="c:/javas/ejemplo4.txt";              
            }
            else if (op==5)
            {
               arg[0] ="c:/javas/ejemplo5.txt";              
            }
            else if (op==6)
            {
               arg[0] ="c:/javas/ejemplo6.txt";              
            }
            else if (op==7)
            {
               arg[0] ="c:/javas/ejemplo7.txt";              
            }
            else if (op==8)
            {
               arg[0] ="c:/javas/ejemplo8.txt";              
            }
            else if (op==9)
            {
               arg[0] ="c:/javas/ejemplo9.txt";              
            }
            else if (op==0)
            {
               arg[0] ="c:/javas/ejemplo10.txt";              
            }
            else 
                System.exit(0);

            if (arg[0]!=""){
               resul=new parser(arg); 
               break;}
            else 
                //System.exit(0);
               break;
         }        
      
      }
   
   }
