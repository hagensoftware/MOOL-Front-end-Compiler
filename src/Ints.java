   public class Ints {
   
      public InL a;
      public Ints(InL inl) {
         a=inl;
      }
   
      public String toString(){
         String regreso=" implements ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
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
