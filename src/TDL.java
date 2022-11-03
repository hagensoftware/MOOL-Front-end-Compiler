   import java.util.*;
   public class TDL {
   
      private Vector list;
      public TDL() {
         list = new Vector();
      }
      public void addElement (TD n) {
         list.addElement(n);
      }
      public TD elementAt(int i) {
         return (TD)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="\r\n TDL ";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat(list.elementAt(i).toString());}
         return regreso;}
      

   
   }
