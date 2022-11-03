   public class Doub extends Numb{
      public String f0;
      public Doub(String d) {
         f0=d;
      }
      public String eval() {
         return f0;
      }
   
      public String toString(){
         return String.valueOf(f0);}
      
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