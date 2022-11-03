   public class ImpDec {
      public Iden a,b,c;
      public ImpDec(Iden i1, Iden i2, Iden i3) {
         a=i1; b=i2; c=i3;
      }
   
      public String toString(){
         String regreso="import ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(".");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (b!=null) {regreso=regreso.concat(" as ");}
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
