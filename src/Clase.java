public class Clase {

    //private String name;
    //private Symbol (String n) {name=n;}
    private static java.util.Dictionary metDict =new java.util.Hashtable();    
    private static java.util.Dictionary varDict =new java.util.Hashtable();    
    
  //private String i;
  public String i;
  private String p;
  private Type t;
  public Clase(String id, String parent){
      i=id; p=parent;
  }

  public String getId(){
      String s = (String)metDict.get(i);
      return s;
  }

  public Type type(){
      return t;
  }

  public boolean addMethod(String id, Type type){
        String i= id.intern();
        Type t=type;
        Method m=(Method)metDict.get(i);
        //Method m;
        boolean add=false;
        if (m==null) {
            m=new Method(i,t); 
            metDict.put(i,m); 
            add=true;
            System.out.println ("METHOD*******"+i.toString()+" "+metDict.size());
        }
        return add;      
  }
  
  public Method getMethod(String id){
       Method m = (Method)metDict.get(id);
       if (m==null) return null;
       else return m;
  }

  public boolean containsMethod(String id){
      return false;
  }

  public boolean addVar(String id, Type type){
        //String i= id.intern();
        String i=id;
        Type t=type;
        Variable v=(Variable)varDict.get(i);
        boolean add=false;
        if (v==null) {
            v=new Variable(i,t); 
            varDict.put(i,v); 
            add=true;
            System.out.println ("VAR******"+i.toString()+" "+varDict.size());
        }
        return add;      
  }

  public Variable getVar(String id){
       Variable v = (Variable)varDict.get(id);
       if (v==null) return null;
       else return v;      
      //return null;
  }

  public boolean containsVar(String id){
      return false; 
  }

  public String parent(){
      return p;
  }

}