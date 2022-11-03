
   public class TDCD extends TD{
   
    //private Iden a;
    //private TypPar b;
    //private SupCla c;
    //private Ints d;
    //private CBD e;
      public ClaDec a;
      public TDCD(ClaDec c) {
         a=c;
      }
   
      public String toString(){
      
         String regreso="\r\n TDCD ";
      
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
