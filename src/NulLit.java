   public class NulLit extends Lite{
   
      public NulLit() {
      }
      public String toString(){
         String regreso="null ";
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
