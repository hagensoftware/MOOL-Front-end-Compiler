   import java.util.*;
   public class IDL {
   
      private Vector list;
      public IDL() {
         list = new Vector();
      }
      public void addElement (ImpDec n) {
         list.addElement(n);
      }
      public ImpDec elementAt(int i) {
         return (ImpDec)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat(list.elementAt(i).toString());
            regreso=regreso.concat("; \r\n");
         }
         return regreso;}
      

   
   }
