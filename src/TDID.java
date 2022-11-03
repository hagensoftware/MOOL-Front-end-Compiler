   public class TDID extends TD{
   
    //private Iden a;
    //private TypPar b;
    //private ExtInt c;
    //private IBD d;
      public IntDec a;
    //public TDID(Iden i, TypPar t, ExtInt e, IBD ibd) {
      public TDID(IntDec i) {        
         a=i; 
      }
   
      public String toString(){
         String regreso="\r\n TDID ";
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
