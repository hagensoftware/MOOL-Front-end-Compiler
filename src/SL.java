   import java.util.*;
   public class SL {
   
      private Vector list;
      public SL() {
         list = new Vector();
      }
      public void addElement (Stat n) {
         list.addElement(n);
      }
      public Stat elementAt(int i) {
         return (Stat)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="";
         for(int i=0;i<list.size();i++){
            regreso=regreso+"\r\n            ";
            regreso=regreso.concat(list.elementAt(i).toString());
            //regreso=regreso.concat(";");
         }
         return regreso;}
      

   
   }