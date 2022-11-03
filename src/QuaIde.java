   public class QuaIde extends TypNam{
      public Iden i1,i2;
      public QuaIde(Iden a, Iden b) {
         i1=a; i2=b;
      }
   
      public String toString(){
         String regreso="";
         if (i1!=null) {regreso=regreso.concat(i1.toString());}
         if (i2!=null) {regreso=regreso.concat(".");}
         if (i2!=null) {regreso=regreso.concat(i2.toString());}

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
