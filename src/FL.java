   import java.util.*;
   public class FL {
   
      private Vector list;
      public FL() {
         list = new Vector();
      }
      public void addElement (FieDec n) {
         list.addElement(n);
      }
      public FieDec elementAt(int i) {
         return (FieDec)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat("\r\n        ");
            regreso=regreso.concat(list.elementAt(i).toString());
            regreso=regreso.concat(";");
         }
         return regreso;}
      

   
   }