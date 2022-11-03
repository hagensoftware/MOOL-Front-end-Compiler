   public class ClaDec extends TD{
   
      public Iden a;
      public TypPars b;
      public SupCla c;
      public Ints d;
      public CBD e;
      public ClaDec(Iden i, TypPars tp, SupCla s, Ints n, CBD cbd) {
         a=i; b=tp; c=s; d=n; e=cbd;
      }
   
      public String toString(){
         //String regreso="\r\n    private class "; 
         String regreso="\r\n    public class "; 
         if (a!=null) {regreso=regreso.concat(a.toString());}
         //if (b!=null) {regreso=regreso.concat(" ");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         //if (c!=null) {regreso=regreso.concat(" extends ");}
         if (c!=null) {regreso=regreso.concat(c.toString());}
         //if (d!=null) {regreso=regreso.concat(" implements ");}
         if (d!=null) {regreso=regreso.concat(d.toString());}
         if (e!=null) {regreso=regreso.concat(e.toString());}
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
