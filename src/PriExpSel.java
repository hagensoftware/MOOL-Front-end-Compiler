   public class PriExpSel extends Expr{
      public PriExp a;
      public SeleL b;
      public IncL c;
      public PriExpSel(PriExp p, SeleL sl, IncL il) {
         a=p; b=sl; c=il;
      }
      public String toString(){
         String regreso="";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (regreso.length()>12){
             String l=regreso.substring(0,12);
             String r=regreso.substring(12);
             if (l.equals("IO.printLine")) 
                 regreso="System.out.println"+r;
             if (l.equals("IO.writeLine")) 
                 regreso="System.in.read"+r;             
         }
         if (c!=null) {regreso=regreso.concat(c.toString());}
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
