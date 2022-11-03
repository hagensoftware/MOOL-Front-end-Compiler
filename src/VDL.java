   import java.util.*;
   public class VDL {
   
      private Vector list;
      public VDL() {
         list = new Vector();
      }
      public void addElement (VarDec n) {
         list.addElement(n);
      }
      public VarDec elementAt(int i) {
         return (VarDec)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="\r\n VDL ";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat(list.elementAt(i).toString());}
         return regreso;}
      

   
   }
