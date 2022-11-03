   import java.util.*;
   public class CL {
   
      private Vector list;
      public CL() {
         list = new Vector();
      }
      public void addElement (Case c) {
         list.addElement(c);
      }
      public Case elementAt(int i) {
         return (Case)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="\r\n CL ";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat(list.elementAt(i).toString());}
         return regreso;}
      

   
   }