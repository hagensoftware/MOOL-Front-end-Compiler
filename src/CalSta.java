   public class CalSta extends Stat{
   
      public Iden a;
      public APL b;
      public CalSta(Iden i, APL apl) {
         a=i; b=apl;
      }
   
      public String toString(){
         String regreso="";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat("(");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (b!=null) {regreso=regreso.concat(")");}
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
