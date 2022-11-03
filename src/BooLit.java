
   public class BooLit extends Lite{
      public boolean a;
      public BooLit(boolean b) {
         a=b;
      }
   
      public String toString(){
         String regreso="true";
         if (a==false) {regreso="false";}
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
