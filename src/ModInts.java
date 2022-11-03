   public class ModInts {
      public IL a;
      public ModInts(IL il) {
         a=il;
      }
   
   
      public String toString(){
         String regreso=" implements ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (a.toString().matches("IMain") )
             {regreso = "";}
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
