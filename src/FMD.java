   public class FMD {
   
      public AccMod a;
      public Type b;
      public Iden c;
      public ForPar d;
      public Bloc e;
      public FMD(AccMod am, Type ty, Iden id, ForPar fo, Bloc bl) {
         a=am; b=ty; c=id; d=fo; e=bl;
      }
   
      public String toString(){
         String regreso="";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (a!=null) {regreso=regreso.concat(" ");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (b!=null) {regreso=regreso.concat(" ");}
         if (c!=null) {regreso=regreso.concat(c.toString());}
         if (c!=null) {regreso=regreso.concat(" ");}
         if (d!=null) {regreso=regreso.concat(d.toString());}
         //if (d!=null) {regreso=regreso.concat(" ");}
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
