   import java.io.*;
   import java.util.*;

   public class parser{
      final int MODULE=1, IMPLEMENTATION=2, INTERFACE=3, PUBLIC=4, 
      IMPLEMENTS=5, COMA=6, LLLAVE=7, RLLAVE=8, CONST=9, 
      EQ=10, ID=11, INTEGER=12, FLOAT=13, BOOLEAN=14,
      SEMI=15, NUMBER=16, IMPORT=17, INIT=18, DOT=19, 
      TYPE=20, VOID=21, CLASS=22, FUNCTION=23, LPAREN=24,
      RPAREN=25, LCORCH=26, RCORCH=27, BREAK=28, OBJECT=29,
      CASE=30, DEFAULT=31, DOSP=32, SWITCH=33, WHILE=34,
      RETURN=35, FOR=36, IF=37, CONTINUE=38, PROTECTED=39,
      TRUE=40, NULL=41, LT=42, GT=43, EXTENDS=44, FIELDS=45,
      CONSTRUCTORS=46, METHODS=47, OPREL=48, OROP=49, 
      ANDOP=50, NOTOP=51, ADDOP=52, MULOP=53, THIS=54,
      SUPER=55, NEW=56, TIMES=57, OVER=58, PER=59,
      PLUS=60, MINUS=61, AS=62, SHADOW=63, FALSE=64,
      OVERRIDE=65, ELSE=66, PPLUS=67, MMINUS=68, INSTANCEOF=69;
   
      int tok=getToken();    
      int err=0;
      int c=-1;
      //Identation iscope=new Identation();
      //public int iscope=0;
      //public boolean bModInt=false;
      
      boolean debugRoute =true;
      boolean debugAST =false; 
      boolean debugSymTab=false;
      boolean debugLook=false;
      boolean debugJump=false;
      boolean debugListaTokens=false;
      boolean debugToken=false;
      boolean debugScope=false;
      
      //Clase classTable;

      
      //Table table; //=new Table();
      public AST ast;
      public String fileInt;
      public String fileImp;
      public String treeInt;
      public String treeImp;
      //public Prog prog;
   
      public String toString(){
         return ast.toString();}

      public String fileIntname(){
         return fileInt.toString();}
      public String fileImpname(){
         return fileImp.toString();}

      public String treeInt(){
         return ModuleInterface().toString();} //.toString();}
      public String treeImp(){
         return ModuleImplementation().toString();} //.toString();}
      
      void advance() {
         tok = getToken();  
      }
   
      void eat(int t) {
         if (tok==t) 
            advance();
         else {
             int ln=analizador.listLines[c];
             //String sln=;
            System.out.print(ln); //line
            System.out.println (analizador.lines[ln]);
            String s="";
            for(int i=0;i<analizador.listPos[c-1];i++){    
                s=s.concat(" ");
            }
            s=s.concat("^");
            System.out.println (ln+s+"-- Syntax error. Expected '" + getTokenName(t) + "' found '"+getTokenName(tok)+"'");
            //System.out.print ("-- Syntax error. Expected " + getTokenName(t) + " found "+getTokenName(tok));
            error();
            //tok=t; //fix error & continue
         }
      }  
   
      public parser(String[] args){
         new analizador(args);
         for (int i=0; i < analizador.listaTipos.length; i++) {
            if (analizador.listaTipos[i]!=null)
               if (debugListaTokens)System.out.println (analizador.listaTipos[i] + "(" +
                                  analizador.listaTokens[i] + ")");  
         }  
         if (debugListaTokens)System.out.println ("**********FIN**TIPO(token)************");
         advance();
         try {
            //while(tok==MODULE){
             //Table t=new Table();
             /*
             Symbol s=Symbol.symbol("ok");
             Symbol x=Symbol.symbol("ok2");
             //t.put(x,"00");             
            
             t.put(s,"12");
             t.beginScope();
             t.put(x,"23");
             t.endScope();
             t.beginScope();
             x=Symbol.symbol("ok3");
             t.put(x,"34");
             t.endScope();
             System.out.println ("s>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + t.get(s)+s.toString());
             System.out.println ("x>>>>>>>>>>>>>>>>>>>>" + t.get(x)+x.toString());
             //System.out.println ("y>>>>>>>>>>>>>>>>>>>>" + t.get(y)+y.toString());
             */
               ast=Ast();
               //ast.accept(new TypeDepthFirstVisitor());
               System.out.println("BuildSymbolTable---------------------");
               BuildSymbolTableVisitor v1=new BuildSymbolTableVisitor();
               ast.accept(v1);
               System.out.println("TypeCheckStatements------------------");
               ast.accept(new TypeCheckVisitor(v1.getSymTab()));
                //a=new AST(p);
            
            //}
            //for(int i=0; i<p)
         }
            catch (Exception e) {
               e.printStackTrace();
            }
         if (debugToken) System.out.println("**********************************");
         if (debugToken) System.out.println("Token = " + tok); 
         System.out.println(err + " error(s) ");
      }
   
      TypVoi Void(){
        if (debugRoute) System.out.println("Void() ");
        eat(VOID);
        TypVoi v=new TypVoi(true);
        if (debugAST) System.out.println(v);
        if (debugSymTab) System.out.println("void");
        return v;          
      }

      
      AccMod AccessModifier(){
         if (debugRoute) System.out.println("AccessModifier()");
         eat(PROTECTED);
         AccMod a=new AccMod();
         if (debugAST) System.out.println(a);
         return a;
      }
      BooLit BooleanLiteral(){
        if (debugRoute) System.out.println("BooleanLiteral()");
        BooLit b=null;
        if (tok==TRUE) {eat(TRUE); b=new BooLit(true);}
        else if (tok==FALSE) {eat(FALSE); b=new BooLit(false);}
        else error();
        if (debugAST) System.out.println(b);
        if (debugSymTab) System.out.println("Bool --->         " + 
analizador.listaTokens[c-1]);
        return b;
    }
    
    NulLit NullLiteral(){
        if (debugRoute) System.out.println("NullLiteral() ");
        eat(NULL);
        NulLit n=new NulLit();
        if (debugAST) System.out.println(n);
        if (debugSymTab) System.out.println("Null --->         " + 
analizador.listaTokens[c-1]);
        return n;
    }
    
    Numb Number(){
        if (debugRoute) System.out.println("Number()*******");
        //switch(tok){      
           Numb n;
           String num="";
           String Sig = look(1);
            if (Sig=="DOT"){
                if (debugRoute)System.out.println("Float");
                eat(NUMBER);
                eat(DOT);
                eat(NUMBER);
                if (look(-4)=="MINUS"){
                    num=analizador.listaTokens[c-4];
                }
                //System.out.println("minus?    --->"+look(-4));
                num = num+analizador.listaTokens[c-3]+"."+analizador.listaTokens[c-1];
                n=new Doub(num);
            }
            else{
                eat(NUMBER);
                if (look(-2)=="MINUS"){
                    num=analizador.listaTokens[c-2];
                }
                num = num+analizador.listaTokens[c-1];
                n=new Inte(num);
            }
           if (debugAST) System.out.println(n);
           if (debugSymTab) System.out.println("Num --->         "+num);
            return n;
       // }
    }
    
    
    Iden Identifier(){
        if (debugRoute) System.out.println("Identifier()");
        eat(ID);
        Iden i=new Iden(analizador.listaTokens[c-1]);
        if (debugSymTab) System.out.println("ID  --->         " + analizador.listaTokens[c-1]);
        if (debugAST) System.out.println(i);
        return i;
    }    

   
      Lite Literal(){
         if (debugRoute) System.out.println("Literal()");
         BooLit b;
         NulLit n;
         Numb m;
         Lite l=null;
         switch(tok){
            case NUMBER:
               l=Number();
            //l=new Inte(m);
               break;
            case TRUE: case FALSE:
               l=BooleanLiteral();
               //l=new BooLit(true);
               break;
            case NULL:
               l=NullLiteral();
               break;
            default: error();    
         }
         if (debugAST) System.out.println(l);
         return l;
      }        
   
      QuaIde QualifiedIdentifier(){
         if (debugRoute) System.out.println("QualifiedIdentifier()");
         QuaIde q;
         Iden a;
         Iden b=null;
         a=Identifier();
         if (tok==DOT){
            eat(DOT);
            b=Identifier();
         }
         q=new QuaIde(a,b);
         if (debugAST) System.out.println(q);
         return q;
      }
   
      ParIde ParameterizedIdentifier(){
         if (debugRoute) System.out.println("ParameterizedIdentifier()");
         ParIde p;
         Iden i=Identifier();
         eat(LT);
         TL tl=TypeList();
         eat(GT);
         p=new ParIde(i,tl);
         if (debugAST) System.out.println(p);
         return p;
      }    
   
      TypNam TypeName(){
         if (debugRoute) System.out.println("TypeName()");
         TypNam t=null;
         QuaIde q;
         ParIde p;
         switch(tok){
            case OBJECT:
               if (debugRoute) System.out.println("type object");
               eat(OBJECT);
               t=new Obje();
               break;
            case ID:
               if (debugRoute) System.out.println("type Id");
               if (look(1)=="DOT") {
                  t=QualifiedIdentifier();
                   //t=new QuaIde(q);
               }
               else if(look(1)=="LT"){
                  t=ParameterizedIdentifier();
                        //t=new ParIde(p);
               }
               else {
                  t=QualifiedIdentifier();
                    //t=new QuaIde(q);
               }
            
               break;
            default: error();          
         }
         if (debugAST) System.out.println(t);
         return t;
      }
   
      IL IdentifierList(){
         IL il=new IL();
         Iden a,b;
         switch(tok){
            case ID:
               if (debugRoute) System.out.println("IdentifierList()");
               a=Identifier(); 
               il.addElement(a);
               while (tok==COMA){
                  eat(COMA);
                  b=Identifier();
                  il.addElement(b);
               }
               break;
            default: //error();
         }
         if (debugAST) System.out.println(il);
         return il;
      }    
   
      BasTyp BasicType(){
        //System.out.println("BasicType()");    
         BasTyp b=null; //=new BasTyp();
         switch(tok){
            case INTEGER:
               if (debugRoute) System.out.println("BasicType(INTEGER)");
               eat(INTEGER);
               b=new BasTyp("int");
               break;            
            case FLOAT:
               if (debugRoute) System.out.println("BasicType(FLOAT)");
               eat(FLOAT);
               b=new BasTyp("float");
               break;
            case BOOLEAN:
               if (debugRoute) System.out.println("BasicType(BOOLEAN)");
               eat(BOOLEAN);
               b=new BasTyp("boolean");  // true o false 
               break;
            default: 
               if (debugRoute) System.out.println("BasicType(***error!***)");        
               error();
         }
         if (debugAST) System.out.println(b);
         return b;
      }    
   
      Type Type(){
         int n=0;
         Type t;
         TypeDim td;
         BasTyp bt;
         TypNam tn;
         if (debugRoute) System.out.println("Type()");
         if (tok==INTEGER || tok==FLOAT || tok==BOOLEAN)
            t=BasicType();
         else 
            t=TypeName();
      
         while(tok==LCORCH){
            if (debugRoute) System.out.println("[]");
            eat(LCORCH);
            eat(RCORCH);
            n=n+1;
         }
         t=new TypeDim(t,n);
         
         if (debugAST) System.out.println(t);
         return t;
      }
   
      TL TypeList(){
         TL tl=new TL();
         Type a;
         if (debugRoute) System.out.println("TypeList()");
         a=Type();
         tl.addElement(a);
         while (tok==COMA){
            eat(COMA);
            a=Type();
            tl.addElement(a);
         }
         if (debugAST) System.out.println(tl);
         return tl;
      }
      
      AST Ast(){
          AST ast=ProgramUnit();
          if (debugAST) System.out.println(ast);
          return ast;
      }
   
      Prog ProgramUnit(){
         if (debugRoute) System.out.println("ProgramUnit()");
         Prog p;
        ModImp m=null;
        ModInt n=null;
        while (tok==MODULE){
        switch(tok){
            case MODULE:
               eat(MODULE);
               if (tok==ID){
                  m=ModuleImplementation();
                  break;
               }
               else if (tok==INTERFACE)
               {
                  n=ModuleInterface();
                  break;
               }
            default: error();}
          }
         p=new Prog(n,m);
      //        for(int i=0; i<ast)
         if (debugAST) System.out.println(p);
         return p;
      
      }
   
      ModInt ModuleInterface(){
         if (debugRoute) System.out.println("ModuleInterface()");
         //bModInt=true;
         
         ModInt m;
         Iden i=null;
         ModBlo mb=null;
         switch(tok){
            case INTERFACE:
               eat(INTERFACE);
               i=Identifier(); 
               //table.beginScope(); iscope++;
               if (debugScope) System.out.println("BeginScope");  
               mb=ModuleBlock();
               //table.endScope(); iscope--;
               if (debugScope) System.out.println("EndScope");  
               break;
            default: error();};
         //Symbol s=Symbol.symbol(i.toString());
         //table.put(s,"ModInt");
         //System.out.println (iscope+"symbol >>>>>>>>>>>>>>>> " + table.get(s)+" "+s.toString());
         
         //table.beginScope();
         m=new ModInt(i,mb);
         //table.endScope();
         fileInt=i.toString();
         treeInt=m.toString();
         if (debugAST) System.out.println(m);
         return m;
      }
   
   
      ModImp ModuleImplementation(){
         if (debugRoute) System.out.println("ModuleImplementation()");
         //bModInt=false;
         //table= new Table();
         ModImp m;
         Iden i=null;
         ModInts mi=null;
         ModBlo mb=null;
         switch(tok){
            case ID:
               i=Identifier(); 
               mi=ModuleInterfaces();
               if (debugScope) System.out.println("BeginScope");  
               //table.beginScope();iscope++;
               mb=ModuleBlock();
               if (debugScope) System.out.println("EndScope");  
               //table.endScope();iscope--;
               break;
            default: error();};
            
         //Symbol s=Symbol.symbol(i.toString());
         //table.put(s,"ModImp");
         //System.out.println (iscope+"symbol >>>>>>>>>>>>>>>> " + table.get(s)+" "+s.toString());            
         fileImp=i.toString();
         
         m=new ModImp(i,mi,mb);
         
         treeImp=m.toString();
         if (debugAST) System.out.println(m);
         return m;
      }
   
      ModBlo ModuleBlock(){
         if (debugRoute) System.out.println("ModuleBlock Begin()");
         ModBlo m=null;
         IDL idl=new IDL();
         MDL mdl=new MDL();
         ModIni mi=null;
         ImpDec id;
         ModDec md;
         switch(tok){
            case LLLAVE:
               eat(LLLAVE);
               while (tok!=RLLAVE)
               {
                  switch(tok){
                     case IMPORT:
                        if (debugRoute) System.out.println("MB {ImportDeclaration}()");
                        id=ImportDeclaration();
                        idl.addElement(id);
                     //ModuleBlock();
                        break;
                  
                     case INIT:
                        if (debugRoute) System.out.println("MB [ModuleInit]()");
                        mi=ModuleInit();
                        if (tok!=RLLAVE) {
                           if (debugRoute) System.out.println("INIT ERROR"); 
                           error();
                        }
                        break;
                  
                     case INTEGER: case FLOAT: case BOOLEAN: case VOID:
                     case CLASS: case FUNCTION:                
                      case CONST: case OBJECT:
                        if (debugRoute) System.out.println("MB {ModuleDeclarations}()");
                        
                        tableL tables=new tableL();
                        
                        md=ModuleDeclarations();
                        mdl.addElement(md);
                        
//                        System.out.print(tables.size());
//                        tables.addElement(classTable);
//                        System.out.print(tables.size());
//                        Clase c=tables.elementAt(0);
//                        System.out.print(c);
                        break;
                  //                case LLLAVE:
                  //                    System.out.println("error? (Checar LLLAVE)");
                  //                    ModuleBlock();
                  //                    break;
                  
                     default:
                        System.out.println("default error salir ModuleBlock().......() "+tok);
                        break;
                  }
               }   
               eat(RLLAVE);
               if (debugRoute) System.out.println("ModuleBlock end.......()");  
         }
         m=new ModBlo(idl, mdl, mi);
         if (debugAST) System.out.println(m);
         return m;
      }
   
      ModDec ModuleDeclarations(){
        //CDL cdl=new CDL();
         ModDec md=null;
        //ConDec cd;
        //GFD gfd;
        //VarDec vd;
         Iden i;
         Type t;
         if (debugRoute)System.out.println("ModuleDeclarations()");
         switch(tok){
            case CONST:
               if (debugRoute) System.out.println("MB {ModuleDeclarations} ConstantDeclaration()");
               md=ConstantDeclaration();
               break;
         
            case ID:
            case INTEGER: case FLOAT: case BOOLEAN: 
            case VOID: 
            
            
               if (debugRoute) System.out.println("MB {GenericFunction | Variable Declaration}");
            //                    if (tok==VOID) {
            //                        eat(VOID);
            //                    }
            //                    else {t=Type();}
            //                        i=Identifier();
                        //md=GenericFunctionDeclaration();
                        //break;
                    //}
                    //t=Type();
                    //i=Identifier();
               if (look(2)=="SEMI" | look(2)=="EQ") {md=VariableDeclaration();}
               else {md=GenericFunctionDeclaration();}
               break;
         
            case CLASS: case FUNCTION:
               if (debugRoute) System.out.println("MB {TypesDeclaration}()");
               md=TypesDeclaration();
               break;        
         
         /*            
         case CONST:
            ConstantDeclaration();
            break;
         case INTEGER: case FLOAT: case BOOLEAN: case VOID:
            if (debugRoute) System.out.println("GenericFunctionDeclaration()+++++++++++++++++++++++++++");
            //GenericFunctionDeclaration(); 
            break;
         case CLASS: case FUNCTION:
            if (debugRoute) System.out.println("TypesDeclaration()------checar-------------");
            TypesDeclaration();
         */
         }
       //if (debugAST) System.out.println(md); 
         return md;
      }
   
      ModInts ModuleInterfaces(){
         if (debugRoute) System.out.println("ModuleInterfaces()");
         ModInts m=null;
         switch(tok){
            case IMPLEMENTS:
               eat(IMPLEMENTS);
               IL il=IdentifierList();
               m=new ModInts(il);
               break;
            default: error();};
         if (debugAST) System.out.println(m);
         return m;
      }
   
      ImpDec ImportDeclaration(){
         ImpDec id;
         if (debugRoute) System.out.println("ImportDeclaration()");
         Iden a;
         Iden b=null,c=null;
         eat(IMPORT);
         a=Identifier();
         if (tok==DOT){
            eat(DOT);
            b=Identifier();
         }
         if (tok==AS){
            eat(AS);
            c=Identifier();
         }
         eat(SEMI);
         id=new ImpDec(a,b,c);
         if (debugAST) System.out.println(id);
         return id;
      }
   
      ModIni ModuleInit(){
         if (debugRoute) System.out.println("ModuleInit() ");
         ModIni mi;
         eat(INIT);
         Bloc b=Block();
         mi=new ModIni(b);
         if (debugAST) System.out.println(mi);
         return mi;
      }    
   
      ConDec ConstantDeclaration(){
         ConDec cd;            
         if (debugRoute) System.out.println("ConstantDeclaration()");
         
         eat(CONST);
         Type t=Type();
         Iden i=Identifier(); 
         //Symbol s=Symbol.symbol(i.toString());
         //table.put(s,t.toString());
         //System.out.println (iscope+"symbol >>>>>>>>>>>>>>>> " + table.get(s)+" "+s.toString());            
         eat(EQ);
         ConExp ce=ConstExpression();    
         eat(SEMI);
         cd=new ConDec(t,i,ce);
         if (debugAST) System.out.println(cd);
         return cd;
      }
   
      GFD GenericFunctionDeclaration(){
         if (debugRoute) System.out.println("Generic Function Declaration()");
         Iden i;
         TypPars tp=null;
         ForPar fp;
         Bloc b=null;
         Type t=null;
         GFD gfd;
         if (tok==VOID) {t=Void();} //{eat(VOID);}
         else {t=Type();}
         i=Identifier();
         //Symbol s=Symbol.symbol(i.toString());
//         classTable.addMethod(i.toString(), t);
         //table.put(s,t.toString());
         //System.out.println (iscope+"symbol >>>>>>>>>>>>>>>> " + table.get(s)+" "+s.toString());            
         if (tok==LT){ 
            //table.beginScope();
            tp=TypeParameters();
            //table.endScope();
         }
         fp=FormalParameters();
         if (tok==LLLAVE) {
//             if (debugScope) System.out.println("BeginScope");  
             //table.beginScope();iscope++;
             b=Block(); 
//             if (debugScope) System.out.println("EndScope");  
             //table.beginScope();iscope--;
         }
         else eat(SEMI);
         gfd=new GFD(t,i,tp,fp,b);
         if (debugAST) System.out.println(gfd);
         return gfd;
      }
   
      TD TypesDeclaration(){
         if (debugRoute) System.out.println("TypesDeclaration()");
         TD td=null;
         if (tok==CLASS && look(1)=="INTERFACE") td=InterfaceDeclaration(); 
         else if (tok==CLASS && look(1)=="ID") td=ClassDeclaration(); 
         else if (tok==FUNCTION) td=FunctionType();
         if (debugAST) System.out.println(td);
         return td;
      }
   
      VarDec VariableDeclaration(){
         if (debugRoute) System.out.println("VariableDeclaration()");
         VarDec v;
         Type t=Type();
         Iden i=Identifier();
 //        classTable.addVar(i.toString(), t);
         //Symbol s=Symbol.symbol(i.toString());
         //table.put(s,t.toString());
//         System.out.println ("VARDEC >>>>>>>>>>>>>>>> " + classTable.getVar(i.toString()));            
         Expr e=null;
         if (tok==EQ){
            eat(EQ);
            e=Expression();
         }
         eat(SEMI);
         v=new VarDec(t,i,e);
         if (debugAST) System.out.println(v);
         return v;
      }
   
      ForPar FormalParameters(){
         ForPar f;
         PL pl=new PL();
         if (debugRoute) System.out.println("FormalParameters()");        
         eat(LPAREN);
         //if (debugScope) System.out.println("BeginScope");  
         //table.beginScope();iscope++;
         if (tok!=RPAREN) pl=Parameters();
         //table.endScope();iscope--;
         //if (debugScope) System.out.println("EndScope");  
         eat(RPAREN);
         f=new ForPar(pl);
         if (debugAST) System.out.println(f);
         return f;
      }
   
      PL Parameters(){
         if (debugRoute) System.out.println("Parameters()");        
         PL pl=new PL();
         Para p;
         p=Parameter();
         pl.addElement(p);
         while(tok==COMA){
            eat(COMA);
            p=Parameter();
            pl.addElement(p);
         }
         if (debugAST) System.out.println(pl);
         return pl;
      }
   
      Para Parameter(){
         if (debugRoute) System.out.println("Parameter()");        
         Para p;
         Type t=Type();
         Iden i=Identifier();
         //Symbol s=Symbol.symbol(i.toString());
         //table.put(s,t.toString());  
         //System.out.println (iscope+"symbol >>>>>>>>>>>>>>>> " + table.get(s)+" "+s.toString());            
         p=new Para(t,i);
         if (debugAST) System.out.println(p);
         return p;
      }    
   
      ClaDec ClassDeclaration(){
         if (debugRoute) System.out.println("ClassDeclaration() Begin");
         ClaDec c;
         TypPars tp=null;
         SupCla sc=null;;
         Ints is=null;;
         CBD cbd;
         eat(CLASS);
         Iden i=Identifier();
         //Symbol s=Symbol.symbol(i.toString());
         //classTable.put(s,"ClaDec");
//         classTable=new Clase(i.toString(),"Parent");
         
//         System.out.println ("class >>>>>>>>>>>>>>>> " + classTable.getId()+" "+classTable.parent());            
         if(tok==LT) tp=TypeParameters();
         if (tok==EXTENDS) sc=SuperClass();
         if (tok==IMPLEMENTS) is=Interfaces();
         cbd=ClassBodyDec();        
         if (debugRoute) System.out.println("ClassDeclaration() End");               
         c=new ClaDec(i,tp,sc,is,cbd);
         if (debugAST) System.out.println(c);
         return c;
      }
   
   
      IntDec InterfaceDeclaration(){
         if (debugRoute) System.out.println("InterfaceDeclaration()"); 
         IntDec id;
         TypPars tp=null;
         ExtInt ei=null;
         IBD ibd;
         eat(CLASS);
         eat(INTERFACE);
         Iden i=Identifier();
         //Symbol s=Symbol.symbol(i.toString());
         //table.put(s,"IntDec");
         //System.out.println (iscope+"symbol >>>>>>>>>>>>>>>> " + table.get(s)+" "+s.toString());            
         if(tok==LT) tp=TypeParameters();
         if(tok==EXTENDS) ei=ExtendsInterfaces();
         ibd=InterfaceBodyDec();
         id=new IntDec(i,tp,ei,ibd);
         if (debugAST) System.out.println(id);
         return id;
      }
   
      FunTyp FunctionType(){
         if (debugRoute) System.out.println("FunctionType()");         
         FunTyp f;
         Type t=null;
         eat(FUNCTION);
      //        eat(INTERFACE);
         if (tok==VOID) {t=Void();} //{eat(VOID);}
         else Type(); 
         Iden i=Identifier();
         //Symbol s=Symbol.symbol(i.toString());
         //table.put(s,t.toString());
         //System.out.println (iscope+"symbol >>>>>>>>>>>>>>>> " + table.get(s)+" "+s.toString());            
         ForPar fp=FormalParameters();
         eat(SEMI);
         f=new FunTyp(t,i,fp);
         if (debugAST) System.out.println(f);
         return f;
      }
   
      SupCla SuperClass(){
         SupCla s;
         eat(EXTENDS);
         ITP itp=IdentifierTypeParameter();
         s=new SupCla(itp);
         if (debugAST) System.out.println(s);
         return s;
      }
   
      Ints Interfaces(){
         Ints i;
         InL inl;
         eat(IMPLEMENTS);
         inl=InterfacesList();
         i=new Ints(inl);
         if (debugAST) System.out.println(i);
         return i;
      }
   
      ExtInt ExtendsInterfaces(){
         ExtInt e;
         InL inl;
         eat(EXTENDS);
         inl=InterfacesList();
         e=new ExtInt(inl);
         if (debugAST) System.out.println(e);
         return e;
      }
   
      CBD ClassBodyDec(){
         if (debugRoute) System.out.println("ClassBodyDec() Begin");
         CBD cbd;
         CVL cvl=new CVL();
         ClaVar cv;
         FL fl=new FL();
         CtrL ctrl=new CtrL();
         ML ml=new ML();
         eat(LLLAVE);
//         iscope.beginScope();
         while(tok!=FIELDS && tok!=CONSTRUCTORS){
            cv=ClassVariables();
            cvl.addElement(cv);
         }
         if (tok==FIELDS) fl=FieldsList();
         ctrl=ConstructorsList();        
         if (tok==METHODS) ml=MethodsList();
         eat(RLLAVE);       
//         iscope.endScope();
         if (debugRoute) System.out.println("ClassBodyDec() End");        
         cbd=new CBD(cvl,fl,ctrl,ml);
         if (debugAST) System.out.println(cbd);
         return cbd;
      }
   
      IBD InterfaceBodyDec(){
         IBD ibd;
         FMD fmd=null;
         FMDL fmdl=new FMDL();
         if (tok==SEMI) eat(SEMI); 
         else {
            eat(LLLAVE);
//            iscope.beginScope();
            while (tok!=RLLAVE){
               fmd=FunctionMethodDeclaration();
               fmdl.addElement(fmd);
            }
            eat(RLLAVE);
//            iscope.endScope();
         }
         ibd=new IBD(fmdl);
         if (debugAST) System.out.println(ibd);
         return ibd;
      }
   
      InL InterfacesList(){
         InL inl=new InL();
         ITP itp=IdentifierTypeParameter();
         inl.addElement(itp);
         while (tok==COMA){ 
            eat(COMA);
            itp=IdentifierTypeParameter();
            inl.addElement(itp);
         }
         if (debugAST) System.out.println(inl);
         return inl;
      }
   
      ITP IdentifierTypeParameter(){
         ITP itp;
         TypPars tp=null;
         if (debugRoute) System.out.println("IdentifierTypeParameter()");
         Iden i=Identifier();
         if(tok==LT) tp=TypeParameters();
         itp=new ITP(i,tp);
         if (debugAST) System.out.println(itp);
         return itp;
      }    
   
      TypPars TypeParameters(){
         if (debugRoute) System.out.println("TypeParameters()");
         TypPars tp;
         TPL tpl;
         eat(LT);
         tpl=TypeParameterList();
         eat(GT);
         tp=new TypPars(tpl);
         if (debugAST) System.out.println(tp);
         return tp;
      }        
   
      TPL TypeParameterList(){
         TPL tpl=new TPL();
         TypPar a;
         if (debugRoute) System.out.println("TypeParameterList()");
         a=TypeParameter();
         tpl.addElement(a);
         if (tok==COMA) {
            eat(COMA);
            a=TypeParameter();
            tpl.addElement(a);
         }
         if (debugAST) System.out.println(tpl);
         return tpl;
      }            
   
      TypPar TypeParameter(){
         if (debugRoute) System.out.println("TypeParameter()");
         TypPar tp;
         TypVar tv=TypeVariable();
         Boun b=Bounds();
         tp=new TypPar(tv,b);
         if (debugAST) System.out.println(tp);
         return tp;
      }                
   
   
      TypVar TypeVariable(){
         if (debugRoute) System.out.println("TypeVariable()");
         TypVar tv;
         Iden i=Identifier();
         tv=new TypVar(i);
         if (debugAST) System.out.println(tv);
         return tv;
      }                    
   
      Boun Bounds(){
         Boun b;
         SupCla s=null;
         Ints i=null;
         if (debugRoute) System.out.println("Bounds()");
         if (tok==EXTENDS) s=SuperClass();
        // &  
         if (tok==IMPLEMENTS) i=Interfaces();
         b=new Boun(s,i);
         if (debugAST) System.out.println(b);
         return b;
      }
   
      ClaVar ClassVariables(){
         if (debugRoute) System.out.println("ClassVariables()");
         ClaVar cv;
         VarDec vd;
         vd=VariableDeclaration();
         cv=new ClaVar(vd);
         
         if (debugAST) System.out.println(cv);
         return cv;
      }
   
      FL FieldsList(){
         if (debugRoute) System.out.println("FieldsList()");
         FL fl=new FL();
         FieDec fd;
         eat(FIELDS);
         fd=FieldDeclaration();
         fl.addElement(fd);
         while (tok!=CONSTRUCTORS){
            if (debugRoute) System.out.println("otro FieldDeclaration");
            fd=FieldDeclaration();
            fl.addElement(fd);
         }   
         if (debugAST) System.out.println(fl);
         return fl;
      }
   
      FieDec FieldDeclaration(){
         if (debugRoute) System.out.println("FieldDeclaration()");        
         FieDec fd;
         if (tok==SHADOW) eat(SHADOW);
         Type t=Type();
         Iden i=Identifier();
         //Symbol s=Symbol.symbol(i.toString());
         //table.put(s,t.toString());
         //System.out.println (iscope+"symbol >>>>>>>>>>>>>>>> " + table.get(s)+" "+s.toString());            
             //Variable v=new Variable(i.toString(),t);
             //String s;
             //s=classTable.getVar(i.toString());
             

//         if (classTable.addVar(i.toString(), t)) 
//            System.out.println ("FIEDEC >>>>>>>>>>>>>>>> " + classTable.getVar(i.toString()).toString());            
//         else 
//             System.out.println ("error XXXXXXXXXXXXXXXXXXXXXXX " + classTable.getVar(i.toString()));                     
         
         eat(EQ);
         Expr e=Expression();
         eat(SEMI);
         fd=new FieDec(t,i,e);
         if (debugAST) System.out.println(fd);
         return fd;
      }
   
      CtrL ConstructorsList(){
         CtrL ctrl=new CtrL();
         CtrDec cd;
         if (debugRoute) System.out.println("ConstructorsList()");
         eat(CONSTRUCTORS);
         while(tok!=METHODS && tok!=RLLAVE){
            cd=ConstructorDeclaration();
            ctrl.addElement(cd);
         }
         if (debugAST) System.out.println(ctrl);
         return ctrl;
      }
   
      CtrDec ConstructorDeclaration(){
         if (debugRoute) System.out.println("ConstructorDeclaration()");
         CtrDec cd;
         Bloc b=null;
         Iden i=Identifier();
         ForPar fp=FormalParameters();
         if (tok!=SEMI) b=Block(); 
         else eat(SEMI);
         cd=new CtrDec(i,fp,b);
         if (debugAST) System.out.println(cd);
         return cd;
      }
   
      ML MethodsList(){
         ML ml=new ML();
         MetDec md;
         if (debugRoute) System.out.println("MethodsList()");
         eat(METHODS);
         md=MethodDeclaration();
         ml.addElement(md);
         while (tok!=RLLAVE){
            if (debugRoute) System.out.println("otro MethodDeclaration()");
            md=MethodDeclaration();
            ml.addElement(md);
         }
         if (debugAST) System.out.println(ml);
         return ml;
      }
   
      MetDec MethodDeclaration(){
         if (debugRoute) System.out.println("MethodDeclaration()");
         MetDec md;
         String s=null;
         if (tok==OVERRIDE) {
             eat(OVERRIDE);
             s=(analizador.listaTokens[c-1]);
         }
         else if (tok==SHADOW){
             eat(SHADOW);        
             s=(analizador.listaTokens[c-1]);
         }
         FMD fmd=FunctionMethodDeclaration();
         md=new MetDec(s,fmd);
         if (debugAST) System.out.println(md);
         return md;
      }    
   
      FMD FunctionMethodDeclaration(){
         if (debugRoute) System.out.println("FunctionMethodDeclaration()");
         FMD fmd;
         AccMod am=null;
         Type t=null;
         Bloc b=null;
         if (tok==PROTECTED) am=AccessModifier();
         if (tok==VOID) t=Void(); //eat(VOID); 
         else t=Type();
         Iden i=Identifier();
         ForPar fp=FormalParameters();
         if (tok==LLLAVE) b=Block(); 
         else eat(SEMI);
         fmd=new FMD(am,t,i,fp,b);
         if (debugAST) System.out.println(fmd);
         return fmd;
      }
   
      Bloc Block(){
         if (debugRoute) System.out.println("Block() Begin");        
         Bloc b;
         LVD lvd;
         LVDL lvdl=new LVDL();
         Stat s;
         SL sl=new SL();
         
         eat(LLLAVE);
//         iscope.beginScope();
         while (tok!=RLLAVE){    
            switch(tok){
               case INTEGER: case FLOAT: case BOOLEAN: //case VOID:
                  lvd=LocalVariableDeclaration();
                  lvdl.addElement(lvd);
                  break;
               case ID: case OBJECT: 
               case THIS: case SUPER: case NEW:  //TYPE:   
                  if (debugJump)System.out.println("look(1,true)="+look(1,true));
                  if (debugJump)System.out.println("look(2,true)="+look(2,true));
                  if ((tok==ID | tok==THIS) && look(1,true)=="EQ") {
                      s=Statement();
                      sl.addElement(s);
                  }
                  else if (look(2,true)=="EQ" || look(2,true)=="SEMI") {
                     lvd=LocalVariableDeclaration();
                     lvdl.addElement(lvd);
                  }
                  
                  else {
                      s=Statement();
                      sl.addElement(s);
                  }
                  break;
            
               case LLLAVE: case IF: case BREAK: case CONTINUE: case FOR:
               case SWITCH: case RETURN: case WHILE:
                  s=Statement();
                  sl.addElement(s);
                  break;
               default: 
                  {
                     if (debugRoute) System.out.println("Block error, tok="+tok);
                     error(); 
                     break;}//error();    
            }
         }
         if (debugRoute) System.out.println("Block() end");
         eat(RLLAVE);  
//         iscope.endScope();
         b=new Bloc(lvdl,sl);
         if (debugAST) System.out.println(b);
         return b;
      }
   
      LVD LocalVariableDeclaration(){
         if (debugRoute) System.out.println("LocalVariableDeclaration()");
         LVD lvd;
         Type t=Type();
         Iden i=Identifier(); 
//         if (classTable.addVar(i.toString(), t)) 
//            System.out.println ("LOCVARDEC >>>>>>>>>>>>>>>> " + classTable.getVar(i.toString()));            
//         else 
//             System.out.println ("error XXXXXXXXXXXXXXXXXXXXXXX " + classTable.getVar(i.toString()));            
             //error();
         //Symbol s=Symbol.symbol(i.toString());
         //table.put(s,t.toString());
         //System.out.println (iscope+"symbol >>>>>>>>>>>>>>>> " + table.get(s)+" "+s.toString());            
         Expr e=null;
         if(tok==EQ){
            eat(EQ);
            e=Expression();
         }
         eat(SEMI);
         lvd=new LVD(t,i,e);
         if (debugAST) System.out.println(lvd);
         return lvd;
      }
/*   
      SL Statements(){
         if (debugRoute) System.out.println("Statements()");    
         SL sl=new SL();
         while (tok==BREAK || tok==CONTINUE || tok==FOR || tok==IF || 
         tok==RETURN || tok==SWITCH || tok==WHILE || tok==LLLAVE ||
         tok==ID || tok==THIS || tok==SUPER || tok==NEW){
             Stat s=Statement();
             sl.addElement(s);
         }
         if (look(-1)!="RLLAVE") eat(SEMI);
        //System.out.println("look(-1) = " + look(-1));
         if (debugAST) System.out.println(sl);
         return sl;
      }
*/   
      Stat Statement(){
         if (debugRoute) System.out.println("Statement()");        
         Stat s;
         if(tok==BREAK){
            if (debugRoute) System.out.println("look "+look(1));    
            s=BreakStatement();
         }
         else if (tok==CONTINUE){
            if (debugRoute) System.out.println("look "+look(1));    
            s=ContinueStatement();
         }
         else if (tok==FOR){
            if (debugRoute) System.out.println("look "+look(1));    
            s=ForStatement();
         }
         else if (tok==IF){
            if (debugRoute) System.out.println("look "+look(1));    
            s=IfStatement();
         }
         else if (tok==RETURN){
            if (debugRoute) System.out.println("look "+look(1));    
            s=ReturnStatement();
         }
         else if (tok==SWITCH){
            if (debugRoute) System.out.println("look "+look(1));    
            s=SwitchStatement();
         }
         else if (tok==WHILE){
            if (debugRoute) System.out.println("look "+look(1));    
            s=WhileStatement();
         }
         else if (tok==LLLAVE){
            s=Block();
         }
         else{
            //if (debugRoute) System.out.println("tok = " + tok);   
            if ((tok==ID | tok==THIS)&& look(1,true)=="EQ") 
                s=AssignmentStatement();
             
            else if (tok==ID && look(1)=="LPAREN") 
                s=CallStatement();
            else {s=ExpressionStatement();}
         }
         if (look(-1)!="RLLAVE") 
             eat(SEMI);
         if (debugAST) System.out.println(s);
         return s;
      }
   
      AsiSta AssignmentStatement(){
         if (debugRoute) System.out.println("AssigmentStatement()");
         AsiSta as;
         Expr a=Expression(); 
         AssignOperator();
            //if (debugRoute) System.out.println("exp2=");
         Expr b=Expression();
         as=new AsiSta(a,b);
         if (debugAST) System.out.println(as);
         return as;
      }
   
      BreSta BreakStatement(){
         if (debugRoute) System.out.println("BreakStatement()");
         BreSta bs;
         eat(BREAK);
         bs=new BreSta();
         if (debugAST) System.out.println(bs);
         return bs;
      }    
   
      ConSta ContinueStatement(){
         if (debugRoute) System.out.println("ContinueStatement()");
         ConSta cs;
         eat(CONTINUE);
         cs=new ConSta();
         if (debugAST) System.out.println(cs);
         return cs;
      }        
   
      Else ElseClause(){
         if (debugRoute) System.out.println("ElseClause()");
         SL sl=new SL();
         Else e;
         if(tok==ELSE){
            eat(ELSE);
            //sl=Statements();

            
         //if (debugRoute) System.out.println("ElseClause()");    
         //SL sl=new SL();
         while (tok==BREAK || tok==CONTINUE || tok==FOR || tok==IF || 
         tok==RETURN || tok==SWITCH || tok==WHILE || tok==LLLAVE ||
         tok==ID || tok==THIS || tok==SUPER || tok==NEW){
             Stat s=Statement();
             sl.addElement(s);
         }
         if (look(-1)!="RLLAVE") eat(SEMI);
        //System.out.println("look(-1) = " + look(-1));
         if (debugAST) System.out.println(sl);
         e=new Else(sl);
         return e;
                  
            
            
            
         }
         else System.out.println("error!--ElseClause()---checar");
         e=new Else(sl);
         if (debugAST) System.out.println(e);
         return e;
      }            
   
      ExpSta ExpressionStatement(){
         if (debugRoute) System.out.println("ExpressionStatement()");
         Expr e;
         ExpSta es;
         e=Expression();  
         es=new ExpSta(e);
         if (debugAST) System.out.println(es);
         return es;
      }        
   
      ForSta ForStatement(){
         if (debugRoute) System.out.println("ForStatement()");
         ForSta fs;
         eat(FOR);
         eat(LPAREN);
         ForIni fi=ForInit();
         eat(SEMI);
         Expr e=Expression();
         eat(SEMI);
         ForUpd fu=ForUpdate();
         eat(RPAREN);  
//         iscope.beginScope();
         Stat s=Statement();
//         iscope.endScope();
         fs=new ForSta(fi,e,fu,s);
         if (debugAST) System.out.println(fs);
         return fs;
      }        
   
      CalSta CallStatement(){
         if (debugRoute) System.out.println("CallStatement()");
         CalSta cs;
            //Expression(); original
         Iden i=Identifier();
         eat(LPAREN);
         APL apl=ActualParameters();
         eat(RPAREN);            
         cs=new CalSta(i,apl);
         if (debugAST) System.out.println(cs);
         return cs;
      }       
   
      IfSta IfStatement(){
         if (debugRoute) System.out.println("IfStatement()");
         IfSta is;
         Else ec=null;
         eat(IF);
         eat(LPAREN);
         Expr e=Expression();
         eat(RPAREN);
         if (debugRoute) System.out.println("IfStatement Block Begin ");    
         eat(LLLAVE);
//         iscope.beginScope();
         Stat s=Statement();
         //if (tok==SEMI && look(1)=="ELSE"){
         //   eat(SEMI);
         if (tok==ELSE){
            ec=ElseClause();
         }
         else if (tok!=RLLAVE) eat(SEMI);
         
         if (debugRoute) System.out.println("IfStatement Block End ");            
         eat(RLLAVE);
//         iscope.endScope();
         is=new IfSta(e,s,ec);
         if (debugAST) System.out.println(is);
         return is;
      }           
   
      RetSta ReturnStatement(){
         if (debugRoute) System.out.println("ReturnStatement()");
         RetSta rs;
         eat(RETURN);
         Expr e=Expression();
         rs=new RetSta(e);
         if (debugAST) System.out.println(rs);
         return rs;
      }       
   
      SwiSta SwitchStatement(){
         if (debugRoute) System.out.println("SwitchStatement()");
         SwiSta ss;
         SwiBlo sb;
         eat(SWITCH);
         eat(LPAREN);
         Expr e=Expression();
         eat(RPAREN);
         sb=SwitchBlock();
         ss=new SwiSta(e,sb);
         if (debugAST) System.out.println(ss);
         return ss;
      }       
   
      WhiSta WhileStatement(){
         if (debugRoute) System.out.println("SwitchStatement()");
         WhiSta ws;
         eat(WHILE);
         eat(LPAREN);
         Expr e=Expression();
         eat(RPAREN);
         Stat s=Statement();
         ws=new WhiSta(e,s);
         if (debugAST) System.out.println(ws);
         return ws;
      }           
   
      APL ActualParameters(){
         if (debugRoute) System.out.println("ActualParameters()");
         APL apl=new APL();
         Expr e;
         while(tok!=RPAREN){
            switch(tok){
               case ID: case NUMBER:
                  e=Expression();
                  apl.addElement(e);
                  if (tok!=RPAREN) eat(COMA);
                  break;
            
               case NOTOP: 
                  eat(NOTOP);
                  break;
            
               case THIS: case SUPER: case NEW:
               case NULL: case PPLUS: case MMINUS: 
               
               default: error();                    
            }
         }
         //apl=new APL();
         if (debugAST) System.out.println(apl);
         return apl;
      }           
   
      Case Case(){
         if (debugRoute) System.out.println("Case()");
         Case c;
         eat(CASE);
         CoL col=ConstList();
         eat(DOSP);
         Stat s=Statement();
         c=new Case(col,s);
         if (debugAST) System.out.println(c);
         return c;
      }            
   
      CoL ConstList(){
         if (debugRoute) System.out.println("ConstList()");
         CoL col=new CoL();
         Lite l;
         l=Literal();
         if (tok==COMA){
            eat(COMA);
            l=Literal();
            col.addElement(l);
         }
         if (debugAST) System.out.println(col);
         return col;
      }    
   
      DefSta DefaultStatement(){
         if (debugRoute) System.out.println("DefaultStatement()");
         DefSta ds;
         eat(DEFAULT);
         eat(DOSP);
         Stat s=Statement();
         ds=new DefSta(s);
         if (debugAST) System.out.println(ds);
         return ds;
      }        
   
      Desi Designator(){
         if (debugRoute) System.out.println("Designator()");
         Desi d;
         Iden i=Identifier();
         d=new Desi(i);
         if (debugAST) System.out.println(d);
         return d;
      }      
   
      ForIni ForInit(){
         if (debugRoute) System.out.println("ForInit()");
         ForIni fi;
         Type t=Type();
         Iden i=Identifier();
         eat(EQ);
         Expr e=Expression();
         fi=new ForIni(t,i,e);
         if (debugAST) System.out.println(fi);
         return fi;
      }
   
      ForUpd ForUpdate(){
         if (debugRoute) System.out.println("ForUpdate()");
         ForUpd fu;
         Iden i=Identifier();
         eat(EQ);
         Expr e=Expression();
         fu=new ForUpd(i,e);
         if (debugAST) System.out.println(fu);
         return fu;
      }    
   
      SwiBlo SwitchBlock(){
         if (debugRoute) System.out.println("SwitchBlock()");
         SwiBlo sb=null;
         eat(LLLAVE);
//         iscope.beginScope();
         Case();
         DefaultStatement();
         eat(RLLAVE);
//         iscope.endScope();;
         if (debugAST) System.out.println(sb);
         return sb;
      }           
   
      ConExp ConstExpression(){
         if (debugRoute) System.out.println("ConstExpression()");
         //ConExp ce=null;
         Expr e=Expression();
         ConExp ce=new ConExp(e);
         if (debugAST) System.out.println(ce);
         return ce;
      }
   
      OrExp Expression(){
         if (debugRoute) System.out.println("Expression()");
         OrExp o=null;
         AndExp a;
         AndExp b=null;
         if (debugRoute) System.out.println("Expression()  Begin----------->>>>");
         a=AndExpression();
         while (tok==OROP){
            if (debugRoute) System.out.println("AndExp OROP AndExp");
            eat(OROP);
            b=AndExpression();
            
         }
         o=new OrExp(a,b);
         if (debugRoute) System.out.println("Expression()  End<<<-------------");
         if (debugAST) System.out.println(o);
         return o;
      }
   
      AndExp AndExpression(){
         if (debugRoute) System.out.println("AndExpresion()");
         AndExp ae=null;
         NegExp a;
         NegExp b=null;
         a=NegExpression();
         while (tok==ANDOP){
            if (debugRoute) System.out.println("NegExp ANDOP NegExp");
            eat(ANDOP);
            b=NegExpression();
            ae=new AndExp(a,b);
            a=b;
            //return ae;
         }
         ae=new AndExp(a,b);
         if (debugAST) System.out.println(ae);
         return ae;
      }
   
      NegExp NegExpression(){
         if (debugRoute) System.out.println("NegExpresion()");
         NegExp ne;
         while (tok==NOTOP){
            if (debugRoute) System.out.println("NOTOP RelExp");
            eat(NOTOP);
         }
         RelExp e=RelExpression();
         ne=new NegExp(e);
         if (debugAST) System.out.println(ne);
         return ne;
      }
   
      RelExp RelExpression(){
         if (debugRoute) System.out.println("RelExpresion()");
         RelExp re=null;
         AddExp a;
         RelOp b=null;
         AddExp c=null;
         a=AddExpression();
         while (tok==OPREL || tok==LT || tok==GT){
            if (debugRoute) System.out.println("AddExp OPREL AddExp");
            //if (tok==OPREL) 
                b=RelationalOperator(); //eat(OPREL);
            //else if (tok==LT) eat(LT);
            //else if (tok==GT) eat(GT);
            c=AddExpression();
            
         }  
         re=new RelExp(a,b,c);
         if (debugAST) System.out.println(re);
         return re;
      }    
   
      AddExp AddExpression(){
         if (debugRoute) System.out.println("AddExpresion()");
         AddExp ae=null;
         MulExp a;
         MulExp b=null;
         a=MultExpression();
         while (tok==ADDOP){
            if (debugRoute) System.out.println("MulExp ADDOP MulExp");
            eat(ADDOP);
            b=MultExpression();
            
         }  
         ae=new AddExp(a,b);
         if (debugAST) System.out.println(ae);
         return ae;
      }    
   
      MulExp MultExpression(){
         if (debugRoute) System.out.println("MultExpresion()");
         MulExp me;
         UnaExp a;
         UnaExp b=null;
         InsExp i;
         a=UnaryExpression();
         while (tok==MULOP){
            if (debugRoute) System.out.println("UnaExp MULOP UnaExp");
            eat(MULOP);
            b=UnaryExpression();
         }
         if (tok==INSTANCEOF) {
            InstanceExpression();
         }     
         me=new MulExp(a,b);
         if (debugAST) System.out.println(me);
         return me;
      }    
   
      UnaExp UnaryExpression(){
         if (debugRoute) System.out.println("UnaryExpresion()");
         UnaExp ue;
         OUExp oue;
         if (tok==PPLUS) eat(PPLUS);
         else if (tok==MMINUS) eat(MMINUS);
         while (tok==PLUS) eat(PLUS);
         while (tok==MINUS) eat(MINUS);
         oue=OtherUnaryExpression();
         ue=new UnaExp(oue);
         if (debugAST) System.out.println(ue);
         return ue;
      }    
   
      InsExp InstanceExpression(){
         if (debugRoute) System.out.println("InstanceExpression()");
         InsExp ie=null;
         eat(INSTANCEOF);
         Type t=Type();
         ie=new InsExp(ie,t);
         if (debugAST) System.out.println(ie);
         return ie;
      }    
   
   
      OUExp OtherUnaryExpression(){
         if (debugRoute) System.out.println("OtherUnaryExpresion()");
         OUExp oue;
         CasExp ce;
         PriExpSel pes;
         PriExp pe=null;
         Sele s=null;
         SeleL sl=new SeleL();
         Inc inc=null;
         IncL incl=new IncL();

/*         
         if (tok==LPAREN) {
             String a=look(1,true);
             System.out.println (a);
             ce=CastExpression();
         }
         else{
 */
            pe=PrimaryExpression();
            while (tok==DOT || tok==LPAREN || tok==LCORCH){
               s=Selector();
               sl.addElement(s);
            }
            while (tok==PPLUS){
               eat(PPLUS);
               inc=new Inc("++");
               incl.addElement(inc);
            }
            while (tok==MMINUS){
               eat(MMINUS);
               inc=new Inc("--");
               incl.addElement(inc);
            }                    
//         }
         pes=new PriExpSel(pe,sl,incl);
         oue=new OUExp(pes);
         if (debugAST) System.out.println(oue);
         return oue;
      }    
   
      PriExp PrimaryExpression(){
         if (debugRoute) System.out.println("PrimaryExpresion()");
         PriExp pe=null;
         Iden i=null;
         Lite l;
         Expr e;
         Type t;
         APL apl=null;
         SupSuf s;
         if (tok==ID) {
            pe=Identifier();
            
         }
         else if (tok==NUMBER || tok==NULL || tok==TRUE || tok==FALSE) 
            pe=Literal();
         
         else if (tok==LPAREN) { // && look(2)=="RPAREN") {
            eat(LPAREN);
                //if (debugRoute) System.out.println("expression()*******************************");
            e=Expression();
            eat(RPAREN);
            pe=new Pare(e);
         }
         else if (tok==THIS) {
            eat(THIS);
            if (tok==LPAREN){
               eat(LPAREN);
               apl=ActualParameters();
               eat(RPAREN);
            }
            pe=new This(apl);
            
//            else if (tok==DOT){
               //QualifiedIdentifier();
//               eat(DOT);
//               pe=Identifier();
//            }
         }
         else if (tok==SUPER){
            eat(SUPER);
            s=SuperSuffix();
            pe=new Supe(s);
         }
         else if (tok==NEW){
            eat(NEW);
            
            if (look(1)=="LT" || look(1)=="DOT" || tok==INTEGER || tok==FLOAT || tok==BOOLEAN){
                //eat(NEW);
                t=Type();
                pe=new NewTyp(t);
            }
            else{
              
                //eat(NEW);
                e=Expression();
                pe=new NewExp(e); 
            }
            /*
            if (tok==LT){
               eat(LPAREN);
               apl=ActualParameters();
               eat(RPAREN);
            }            
            ParIde p=ParameterizedIdentifier();
            pe=new ParIde(p,);
             */
            
         }
         if (debugAST) System.out.println(pe);
         return pe;
      }
   
      Sele Selector(){
         if (debugRoute) System.out.println("Selector()");
         Sele s=null;
         //Expr e=null;
         if (tok==LCORCH){
            s=ArrayAccess();
         }
         
         else if (tok==LPAREN){
            eat(LPAREN);
            APL apl=ActualParameters();
            eat(RPAREN);
            s=new SeleAP(apl);
         }
         else if (tok==DOT){
            eat(DOT);
//            if (look(1)=="EQ") AssignmentStatement(); 
//            else
               Expr e=Expression();
               s=new SeleDot(e);
         }   
         if (debugAST) System.out.println(s);
         return s;
      }
   
      ArrAcc ArrayAccess(){
         if (debugRoute) System.out.println("ArrayAccess()");
         ArrAcc aa=null;
         Expr e;
         EL el=new EL();
         eat(LCORCH);
         e=Expression();
         el.addElement(e);
         eat(RCORCH);
         while (tok==LCORCH){
            eat(LCORCH);
            e=Expression();
            el.addElement(e);
            eat(RCORCH);
         }
         aa=new ArrAcc(el);
         if (debugAST) System.out.println(aa);
         return aa;
      }
   
      CasExp CastExpression(){
         if (debugRoute) System.out.println("CastExpression()");
         CasExp ce;
         eat(LPAREN);
         //Expr e=Expression();
        // Type | Expr();
         Type t=Type();
         eat(RPAREN);
         UnaExp u=UnaryExpression();
         ce=new CasExp(t,u);
         if (debugAST) System.out.println(ce);
         return ce;
      }
   
      SupSuf SuperSuffix(){
         if (debugRoute) System.out.println("SuperSuffix()");
         SupSuf s=null;
         if (tok==LPAREN){
            eat(LPAREN);
            APL apl=ActualParameters();
            s=new SupPar(apl);
            eat(RPAREN);}
         else if (tok==DOT){
            eat(DOT);
            Iden i=Identifier();
            APL apl=new APL();
            if (tok==LPAREN){
               eat(LPAREN);
               apl=ActualParameters();
               eat(RPAREN);
            }
            s=new SupIden(i, apl);
         }
         if (debugAST) System.out.println(s);
         return s;
      }
   
      void AssignOperator(){
         if (debugRoute) System.out.println("AssignOperator()");
         eat(EQ);
      }
   
//      void RelationalOperator(){
//         if (debugRoute) System.out.println("RelationalOperator()");
//         eat(OPREL);
//      }    

      RelOp RelationalOperator(){
        if (debugRoute) System.out.println("RelationalOperator()");
        
        if (tok==OPREL) eat(OPREL);
        else if (tok==LT) eat(LT);
        else if (tok==GT) eat(GT);
        RelOp r=new RelOp(analizador.listaTokens[c-1]);
        if (debugSymTab) System.out.println("OPREL  --->      " + analizador.listaTokens[c-1]);
        if (debugAST) System.out.println(r);
        return r;
      }      
      
      void OrOperator(){
         if (debugRoute) System.out.println("OrOperator()");
         eat(OROP);
      }        
   
      void AndOperator(){
         if (debugRoute) System.out.println("AndOperator()");
         eat(ANDOP);
      }        
   
      void NotOperator(){
         if (debugRoute) System.out.println("NotOperator()");
         eat(NOTOP);
      }        
   
      void AddOperator(){
         if (debugRoute) System.out.println("AddOperator()");
         eat(ADDOP);
      }        
   
      void MultiOperator(){
         if (debugRoute) System.out.println("MultiOperator()");
         eat(MULOP);
            // | eat(DIVOP); | eat (PEROP);
      }        
   
      String look(int pos){
         return analizador.listaTipos[c+pos];
      }
   
      String look(int pos, boolean jump){
         String t=analizador.listaTipos[c+1];
         int j=1;
         if (jump==true){
            if (t=="LCORCH"){
               while (t!="RCORCH"){
                  j=j+1;
                  t=analizador.listaTipos[j+c];
                  if (debugJump)System.out.println("[]jump " + t);
               }
               j=j+1;
            }  
            else if (t=="DOT"){
               while (t=="DOT"){
                  j=j+1;
                  t=analizador.listaTipos[j+c];
                  if (debugJump)System.out.println(".jump " + t);
               }
               j=j+1;
            } 
            else if (t=="LT"){
               while (t!="GT"){
                  j=j+1;
                  t=analizador.listaTipos[j+c];
                  if (debugJump)System.out.println("<>jump " + t);
               }
               j=j+1;
            }             
/*
            else if (t=="LPAREN"){
               while (t!="RPAREN"){
                  j=j+1;
                  t=analizador.listaTipos[j+c];
                  if (debugJump)System.out.println("()jump " + t);
               }
               j=j+1;
            }  
 */
         }
         t=analizador.listaTipos[j+c+pos-1];
         if (debugLook) System.out.println ("to " +t);
         return t; 
      }    
      

   
      int getToken() {
         c++;    
         tok=0;
         String tip=analizador.listaTipos[c];
         if (tip=="MODULE") {tok=MODULE;}
         else if (tip=="IMPLEMENTATION") {tok=IMPLEMENTATION;}
         else if (tip=="INTERFACE") {tok=INTERFACE;}
         else if (tip=="PUBLIC") {tok=PUBLIC;}
         else if (tip=="IMPLEMENTS") {tok=IMPLEMENTS;}        
         else if (tip=="COMA") {tok=COMA;}
         else if (tip=="LLLAVE") {tok=LLLAVE;}  
         else if (tip=="RLLAVE") {tok=RLLAVE;}
         else if (tip=="CONST") {tok=CONST;}  
         else if (tip=="EQ") {tok=EQ;}  
         else if (tip=="ID") {tok=ID;}  
         else if (tip=="INTEGER"){tok=INTEGER;}  
         else if (tip=="FLOAT") {tok=FLOAT;}  
         else if (tip=="BOOLEAN"){tok=BOOLEAN;}          
         else if (tip=="SEMI") {tok=SEMI;}  
         else if (tip=="NUM") {tok=NUMBER;}  
         else if (tip=="IMPORT"){tok=IMPORT;}  
         else if (tip=="INIT") {tok=INIT;}          
         else if (tip=="DOT") {tok=DOT;}          
         else if (tip=="TYPE"){tok=TYPE;}  
         else if (tip=="VOID"){tok=VOID;}  
         else if (tip=="CLASS"){tok=CLASS;}          
         else if (tip=="FUNCTION"){tok=FUNCTION;}  
         else if (tip=="LCORCH"){tok=LCORCH;}  
         else if (tip=="RCORCH"){tok=RCORCH;}
         else if (tip=="LPAREN"){tok=LPAREN;}  
         else if (tip=="RPAREN"){tok=RPAREN;}        
         else if (tip=="BREAK"){tok=BREAK;}  
         else if (tip=="OBJECT"){tok=OBJECT;}
         else if (tip=="CASE"){tok=CASE;}  
         else if (tip=="DEFAULT"){tok=DEFAULT;}   
         else if (tip=="DOSP"){tok=DOSP;}  
         else if (tip=="SWITCH"){tok=SWITCH;}
         else if (tip=="WHILE"){tok=WHILE;}  
         else if (tip=="RETURN"){tok=RETURN;}           
         else if (tip=="FOR"){tok=FOR;}  
         else if (tip=="IF"){tok=IF;}
         else if (tip=="CONTINUE"){tok=CONTINUE;}  
         else if (tip=="PROTECTED"){tok=PROTECTED;}  
         else if (tip=="TRUE"){tok=TRUE;}
         else if (tip=="FALSE"){tok=FALSE;}
         else if (tip=="NULL"){tok=NULL;}  
         else if (tip=="LT"){tok=LT;}           //LT
         else if (tip=="GT"){tok=GT;}           //GT
         else if (tip=="EXTENDS"){tok=EXTENDS;}
         else if (tip=="FIELDS"){tok=FIELDS;}  
         else if (tip=="CONSTRUCTORS"){tok=CONSTRUCTORS;}  
         else if (tip=="METHODS"){tok=METHODS;}
         else if (tip=="OPREL"){tok=OPREL;}  
         else if (tip=="OROP"){tok=OROP;}           
         else if (tip=="ANDOP"){tok=ANDOP;}  
         else if (tip=="NOTOP"){tok=NOTOP;}
         else if (tip=="ADDOP"){tok=ADDOP;}  
         else if (tip=="MULOP"){tok=MULOP;} 
         else if (tip=="THIS"){tok=THIS;} 
         else if (tip=="SUPER"){tok=SUPER;} 
         else if (tip=="NEW"){tok=NEW;} 
         else if (tip=="TIMES"){tok=MULOP;} 
         else if (tip=="OVER"){tok=MULOP;} 
         else if (tip=="PER"){tok=MULOP;}         
         else if (tip=="PLUS"){tok=ADDOP;}         
         else if (tip=="MINUS"){tok=ADDOP;}     
         else if (tip=="AS"){tok=AS;}     
         else if (tip=="SHADOW"){tok=SHADOW;}             
         else if (tip=="TRUE"){tok=TRUE;}      
         else if (tip=="FALSE"){tok=FALSE;}              
         else if (tip=="OVERRIDE"){tok=OVERRIDE;}           
         else if (tip=="ELSE"){tok=ELSE;}                   
         //else if (tip=="THIS"){tok=THIS;}     
         else if (tip=="PPLUS"){tok=PPLUS;}                   
         else if (tip=="MMINUS"){tok=MMINUS;} 
         else if (tip=="INSTANCEOF"){tok=INSTANCEOF;} 
         
         else if (tip=="STR"){tok=ID;}     //quote
         
         else if (tip=="NO_ID"){error();}
           //System.out.println(analizador.listaTipos[c]);
         if (debugToken) System.out.println ("**"+analizador.listaTipos[c] + "(" +
                            analizador.listaTokens[c] + ")**");           
         return tok;
      }    
      
      String getTokenName(int t) {
          
      String toknam="";
         if (t==MODULE) {toknam="MODULE";}
         else if (t==IMPLEMENTATION) {toknam="IMPLEMENTATION";}
         else if (t==INTERFACE) {toknam="INTERFACE";}
         else if (t==PUBLIC) {toknam="PUBLIC";}
         else if (t==IMPLEMENTS) {toknam="IMPLEMENTS";}        
         else if (t==COMA) {toknam=",";}
         else if (t==LLLAVE) {toknam="{";}  
         else if (t==RLLAVE) {toknam="}";}
         else if (t==CONST) {toknam="CONST";}  
         else if (t==EQ) {toknam="=";}  
         else if (t==ID) {toknam="IDENTIFIER";}  
         else if (t==INTEGER){toknam="INTEGER";}  
         else if (t==FLOAT) {toknam="FLOAT";}  
         else if (t==BOOLEAN){toknam="BOOLEAN";}          
         else if (t==SEMI) {toknam=";";}  
         else if (t==NUMBER) {toknam="NUMBER";}  
         else if (t==IMPORT){toknam="IMPORT";}  
         else if (t==INIT) {toknam="INIT";}          
         else if (t==DOT) {toknam=".";}          
         else if (t==TYPE){toknam="TYPE";}  
         else if (t==VOID){toknam="VOID";}  
         else if (t==CLASS){toknam="CLASS";}          
         else if (t==FUNCTION){toknam="FUNCTION";}  
         else if (t==LCORCH){toknam="[";}  
         else if (t==RCORCH){toknam="]";}
         else if (t==LPAREN){toknam="(";}  
         else if (t==RPAREN){toknam=")";}        
         else if (t==BREAK){toknam="BREAK";}  
         else if (t==OBJECT){toknam="OBJECT";}
         else if (t==CASE){toknam="CASE";}  
         else if (t==DEFAULT){toknam="DEFAULT";}   
         else if (t==DOSP){toknam=":";}  
         else if (t==SWITCH){toknam="SWITCH";}
         else if (t==WHILE){toknam="WHILE";}  
         else if (t==RETURN){toknam="RETURN";}           
         else if (t==FOR){toknam="FOR";}  
         else if (t==IF){toknam="IF";}
         else if (t==CONTINUE){toknam="CONTINUE";}  
         else if (t==PROTECTED){toknam="PROTECTED";}  
         else if (t==TRUE){toknam="TRUE";}
         else if (t==FALSE){toknam="FALSE";}
         else if (t==NULL){toknam="NULL";}  
         else if (t==LT){toknam="<";}           //LT
         else if (t==GT){toknam=">";}           //GT
         else if (t==EXTENDS){toknam="EXTENDS";}
         else if (t==FIELDS){toknam="FIELDS";}  
         else if (t==CONSTRUCTORS){toknam="CONSTRUCTORS";}  
         else if (t==METHODS){toknam="METHODS";}
         else if (t==OPREL){toknam="RELATIONAL OPERATOR";}  
         else if (t==OROP){toknam="||";}           
         else if (t==ANDOP){toknam="&&";}  
         else if (t==NOTOP){toknam="!";}
         else if (t==ADDOP){toknam="+";}  
         else if (t==MULOP){toknam="*";} 
         else if (t==THIS){toknam="THIS";} 
         else if (t==SUPER){toknam="SUPER";} 
         else if (t==NEW){toknam="NEW";} 
         else if (t==TIMES){toknam="*";} 
         else if (t==OVER){toknam="/";} 
         else if (t==PER){toknam="%";}         
         else if (t==PLUS){toknam="+";}         
         else if (t==MINUS){toknam="-";}     
         else if (t==AS){toknam="AS";}     
         else if (t==SHADOW){toknam="SHADOW";}             
         else if (t==TRUE){toknam="TRUE";}      
         else if (t==FALSE){toknam="FALSE";}              
         else if (t==OVERRIDE){toknam="OVERRIDE";}           
         else if (t==ELSE){toknam="ELSE";}                   
         else if (t==PPLUS){toknam="++";}                   
         else if (t==MMINUS){toknam="--";} 
         else if (t==INSTANCEOF){toknam="INSTANCEOF";} 
         
         //else if (t==STR){toknam="ID";}     //quote
         
         //else if (t==NO_ID){toknam="NO ID";}
           //System.out.println(analizador.listaTipos[c]);
         if (debugToken) System.out.println ("**"+analizador.listaTipos[c] + "(" +
                            analizador.listaTokens[c] + ")**");           
         return toknam;          
      }
   
      void error() {
         System.out.println ("error!");
         err++;
         if (err>4) {
             System.out.println( err + " errors");
             System.exit(-1);
         }
      }
   }