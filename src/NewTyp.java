   public class NewTyp extends New{
   
      public Type a;
      public NewTyp(Type e) {
         a=e;
      }
   
      public String toString(){
         String regreso="new ";
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