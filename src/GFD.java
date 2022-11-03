   public class GFD extends ModDec{
      public Type a;
      public Iden b;
      public TypPars c;
      public ForPar d;
      public Bloc e;
      public GFD(Type t, Iden i, TypPars tp, ForPar f, Bloc bl) {
         a=t; b=i; c=tp; d=f; e=bl;
      }
   
      public String toString(){
         String regreso="\r\n    public static ";
         
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(" ");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         //if (c!=null) {regreso=regreso.concat(" ");}
         if (c!=null) {regreso=regreso.concat(c.toString());}
         //if (d!=null) {regreso=regreso.concat(" ");}
         if (d!=null) {regreso=regreso.concat(d.toString());} 
         //if (e!=null) {regreso=regreso.concat(" ");}
         if (e==null) {regreso=regreso.concat(";");} 
         else{ 
         //if (e!=null) {
             regreso=regreso.concat(e.toString());
             //regreso=regreso.concat(";");
         }
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
