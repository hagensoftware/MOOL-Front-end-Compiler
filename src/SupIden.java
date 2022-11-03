   public class SupIden extends SupSuf{
   
      public Iden a;
      public APL b;
      public SupIden(Iden i, APL apl) {
          a=i;
          b=apl;
      }
   
      public String toString(){
         String regreso="\r\n SupIden ";
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
