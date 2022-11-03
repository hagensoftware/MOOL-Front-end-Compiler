   import java.util.*;
   public class EL {
   
      private Vector list;
      public EL() {
         list = new Vector();
      }
      public void addElement (Expr n) {
         list.addElement(n);
      }
      public Expr elementAt(int i) {
         return (Expr)list.elementAt(i);
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