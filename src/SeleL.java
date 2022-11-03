   import java.util.*;
   public class SeleL {
   
      private Vector list;
      public SeleL() {
         list = new Vector();
      }
      public void addElement (Sele s) {
         list.addElement(s);
      }
      public Sele elementAt(int i) {
         return (Sele)list.elementAt(i);
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