   import java.util.*;
   public class APL {
   
      private Vector list;
      public APL() {
         list = new Vector();
      }
      public void addElement (Expr n) {
         list.addElement(n);
      }
      public Expr elementAt(int i) {
         return (Expr)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
      
         String regreso="";
         for(int i=0;i<list.size();i++){
             if (i>0) regreso=regreso.concat(",");
            regreso=regreso.concat(list.elementAt(i).toString());}
         //regreso=regreso.concat(")" );
         return regreso;}

      
   
   }