   import java.util.*;
   public class GFDL {
   
      private Vector list;
      public GFDL() {
         list = new Vector();
      }
      public void addElement (GFD n) {
         list.addElement(n);
      }
      public GFD elementAt(int i) {
         return (GFD)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="\r\n GFDL ";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat(list.elementAt(i).toString());}
         return regreso;}
      

   
   }
