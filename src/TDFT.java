   public class TDFT extends TD{
      public FunTyp a;
      public TDFT(FunTyp f) {
         a=f;
      }
      public String toString(){
         String regreso="\r\n TDFT ";
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
