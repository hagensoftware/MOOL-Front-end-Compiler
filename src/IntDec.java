   public class IntDec extends TD{
   
      public Iden a;
      public TypPars b;
      public ExtInt c;
      public IBD d;
      public IntDec(Iden i, TypPars tp, ExtInt ei, IBD ibd) {
         a=i; b=tp; c=ei; d=ibd;
      }
   
      public String toString(){
         String regreso="\r\n    interface ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(" ");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (c!=null) {regreso=regreso.concat(" ");}
         if (c!=null) {regreso=regreso.concat(c.toString());}
         if (d!=null) {regreso=regreso.concat(" ");}
         if (d!=null) {regreso=regreso.concat(d.toString());} 
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
