   public class Supe extends PriExp{
      public SupSuf a;
      public Supe(SupSuf s) {
         a=s;
      }
   
      public String toString(){
         String regreso="\r\n super";
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
