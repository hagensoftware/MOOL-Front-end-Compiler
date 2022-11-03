   public class ModImp {
   
      public Iden a;
      public ModInts b;
      public ModBlo c;
      public ModImp(Iden i, ModInts s, ModBlo bl) {
         a=i; b=s; c=bl;
      }
   
      public String toString() {
         String regreso="";
         if (c.importa()!=null) {regreso=regreso.concat(c.importa());}
         regreso=regreso.concat("\r\n public class ");
         if (a!=null) {regreso=regreso.concat(a.toString());}
         //if (b!=null) {regreso=regreso.concat(" implements ");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (c!=null) {regreso=regreso.concat(c.toString());}
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
