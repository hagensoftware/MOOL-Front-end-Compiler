   public class BasTyp extends Type{
      public String s;
      public BasTyp(String bt) {
         s=bt;
      }
   
      public String toString(){
          if (s=="float") {s="double";}
         return s;}
      
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
