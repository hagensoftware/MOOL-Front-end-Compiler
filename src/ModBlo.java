   public class ModBlo {
      public IDL a;
      public MDL b;
      public ModIni c;
      public ModBlo(IDL idl, MDL mdl, ModIni i) {
         a=idl; b=mdl; c=i;
      }
   
      public String toString(){
         String regreso="{ \r\n";
         //if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (c!=null) {regreso=regreso.concat(c.toString());}
         regreso=regreso.concat("\r\n }");         
         return regreso;}
   
      public String importa(){
         String regreso="";

         if (a!=null) {regreso=regreso.concat(a.toString());}
             if (regreso.length()>7){
             String l=regreso.substring(7,13);
             String r=regreso.substring(0,7);
             if (l.equals("System")) 
                 regreso=r+"java.io.*;";
             //if (l.equals("IO.writeLine")) 
             //    regreso="System.in.write"+r;
             }
         return regreso;}
      
      public String accept(StringVisitor v){
          return v.visit(this);
      }

      public Type accept(TypeVisitor v){
          return v.visit(this);
      }      
   
      public void accept(Visitor v){
          v.visit(this);
      }  
   
   
   }
