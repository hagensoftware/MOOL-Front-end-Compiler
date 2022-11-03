   public class Inte extends Numb{
      public String f0;
      public Inte (String i) {
         f0=i;
      }
      public String eval() {
         return f0;
      }
   
      public String toString(){
          return f0;  
         //return String.valueOf(f0);
      } 
      
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
