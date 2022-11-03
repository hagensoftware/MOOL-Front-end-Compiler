   public class ModInt {
      public Iden a;
      public ModBlo b;
      public ModInt(Iden i, ModBlo m) {
         a=i; b=m;        
      }
   
      public String toString() {
         String regreso="";
         if (b.importa()!=null) {regreso=regreso.concat(b.importa());}
         regreso=regreso.concat("\r\n interface ");
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(b.toString());}
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
