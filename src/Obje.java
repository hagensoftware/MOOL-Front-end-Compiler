   public class Obje extends TypNam{
   
      public Obje() {
      }
   
      public String toString(){
         String regreso="Object ";
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
