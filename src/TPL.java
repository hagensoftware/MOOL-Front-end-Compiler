   import java.util.*;
   public class TPL {
   
      private Vector list;
      public TPL() {
         list = new Vector();
      }
      public void addElement (TypPar n) {
         list.addElement(n);
      }
      public TypPar elementAt(int i) {
         return (TypPar)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat(list.elementAt(i).toString());}
         return regreso;}
      

   
   }