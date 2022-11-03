
   public class AccMod {
   
      public AccMod() {
      }
   
      public String toString(){
         //System.out.print(parser.iscope);
          
         //String s=Prog.iscope.getScope();
         String a="PROTECTED ";
         return a;}
      
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
