   import java.util.*;
   public class CoL {
   
      private Vector list;
      public CoL() {
         list = new Vector();
      }
      public void addElement (Lite n) {
         list.addElement(n);
      }
      public Lite elementAt(int i) {
         return (Lite)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   	
   	public String toString(){
              
         String regreso="\r\n CoL ";
         for(int i=0;i<list.size();i++){
             if (i>0) regreso=regreso.concat(",");
            regreso=regreso.concat(list.elementAt(i).toString());}
         return regreso;}
        


   }