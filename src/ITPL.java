   import java.util.*;
   public class ITPL {
   
      private Vector list;
      public ITPL() {
         list = new Vector();
      }
      public void addElement (ITP n) {
         list.addElement(n);
      }
      public ITP elementAt(int i) {
         return (ITP)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="\r\n ITPL ";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat(list.elementAt(i).toString());}
         return regreso;}
      

   
   }