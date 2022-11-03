public class DepthFirstVisitor implements Visitor{
    
    //Basic Productions
    
    public void visit(AccMod n){
        // protected
               
    }
    
    public void visit(BooLit n){
        // true | false
                
    } 
    
    public void visit(NulLit n){
        //null
                
    }
    
    //public void visit(Numb n); **abstract
    
    public void visit(Inte n){
        n.f0.toString(); //Integer
        
    }
    
    public void visit(Doub n){
        n.f0.toString(); //Double
        
    }
    
    public void visit(Iden n){
        n.s.toString(); //String   id                      toSting()
        //System.out.println("DepthFirstVisitor * Id * " + n.s.toString());
        
    }
    
    //public void visit(Lite n); **abstract 
    
    public void visit(QuaIde n){
        n.i1.accept(this); // Iden
                           // .
        n.i2.accept(this); // Iden
        
    } 
    
    public void visit(ParIde n){
        n.f0.accept(this); // Iden
                           // <
        for ( int i = 0; i < n.f1.size(); i++ ) { // TypeList
            n.f1.elementAt(i).accept(this);
        }
                           // >
        
    }
    
    //public void visit(TypNam n); abstract
    
    public void visit(Obje n){
        n.toString(); // String   object               toSting()
        
    }
    
    public void visit(BasTyp n){
        n.s.toString(); // String (int float bool)     toSting()
        
    }
    
    //public void visit(Type n); **abstract
    
    public void visit(TypeDim n){
        // n * []
        
    }
    
    public void visit(TypVoi n){
        // void
        
    }
    
    
    //Conpilation unit productions
    
    //public void visit(AST n); //**abstract raiz del árbol
    
    public void visit(Prog n){
        if (n.a!=null) n.a.accept(this); //ModInt
        if (n.b!=null) n.b.accept(this); //ModImp
        
    }
    
    
    
    public void visit(ModInt n){
                          // module interface
        n.a.accept(this); // Iden
        n.b.accept(this); // ModBlo
        
    }
    
    public void visit(ModImp n){
                          // module
        n.a.accept(this); // Iden
        n.b.accept(this); // ModInt
        n.c.accept(this); // ModBlo
        
    }
   
    public void visit(ModBlo n){
                                                 // { 
        for ( int i = 0; i < n.a.size(); i++ ) { // IDL
            n.a.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.b.size(); i++ ) { // MDL
            n.b.elementAt(i).accept(this);
        }
        if (n.c!=null) n.c.accept(this);         // ModIni
                                                 // }
        
    }
    
    //public void visit(ModDec n); **abstract
    
    public void visit(ModInts n){
                                                 // implements
        for ( int i = 0; i < n.a.size(); i++ ) { // IL
            n.a.elementAt(i).accept(this);
        }
        
    }
    
    public void visit(ImpDec n){
        n.a.accept(this);                 // Iden
        if (n.b!=null) n.b.accept(this);  // . Iden
        if (n.c!=null) n.c.accept(this);  // as Iden
        
    }
    
    public void visit(ModIni n){
                          //init
        n.a.accept(this); //Bloc
        
    }
    
    public void visit(ConDec n){
                           //const
        n.a.accept(this);  //Type
        n.b.accept(this);  //Iden
        n.c.accept(this);  // = ConExp
        
    }
    
    public void visit(GFD n){
        if (n.a!=null) n.a.accept(this); //Type | void
        n.b.accept(this);                //Iden
        if (n.c!=null) n.c.accept(this); //TypPar
        n.d.accept(this);                //ForPar
        if (n.e!=null) n.e.accept(this); // ; | Bloc
        
    }
    
    //public void visit(TypDec n); **abstract    
    
    //public void visit(TD n); **abstract
    
    public void visit(TDCD n){
        n.a.accept(this); //CDL
        
    }
    
    public void visit(TDFT n){
        n.a.accept(this); // FTL
        
    }
    
    public void visit(TDID n){
        n.a.accept(this); // IDL
        
    }  
    
    public void visit(VarDec n){
        n.a.accept(this); // Type
        n.b.accept(this); // Iden
        n.c.accept(this); // = Expr
        
    }
    
    public void visit(ForPar n){
                                                 // (
        for ( int i = 0; i < n.a.size(); i++ ) { // Pars
            n.a.elementAt(i).accept(this);
        }
                                                 // )
        
    }
    
    public void visit(Para n){
        n.a.accept(this); // Type
        n.b.accept(this); // Iden
        
    }
    
    
    
    //Type Productions
    
    public void visit(ClaDec n){
                                         // class
        n.a.accept(this);                // iden
        if (n.b!=null) n.b.accept(this); // TypPar
        if (n.c!=null) n.c.accept(this); // SupCla
        if (n.d!=null) n.d.accept(this); // Ints          ¿null?
        n.e.accept(this);                // CBD 
        
    }
    
    public void visit(IntDec n){
                                          // class interface
        n.a.accept(this);                 // iden
        if (n.b!=null) n.b.accept(this);  // TypPars
        if (n.c!=null) n.c.accept(this);  // ExtInt
        n.d.accept(this);                 // InL
        
    }
    
    public void visit(FunTyp n){
                           // function
        n.a.accept(this);  // Type | void
        n.b.accept(this);  // Iden
        n.c.accept(this);  // ForPars
        
    }
    
    public void visit(SupCla n){
                           // extends
        n.a.accept(this);  // ITP
        
    }
    
    public void visit(Ints n){
                                                 // implements
        for ( int i = 0; i < n.a.size(); i++ ) { // InL
            n.a.elementAt(i).accept(this);
        }
        
    }
    
    public void visit(ExtInt n){
                                                 // extends
        for ( int i = 0; i < n.a.size(); i++ ) { // InL
            n.a.elementAt(i).accept(this);
        }
        
    }
    
    public void visit(CBD n){
                                                 // {
        for ( int i = 0; i < n.a.size(); i++ ) { // CVL
            n.a.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.b.size(); i++ ) { // FL
            n.b.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.c.size(); i++ ) { // CtrL
            n.c.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.d.size(); i++ ) { // ML
            n.d.elementAt(i).accept(this);
        }
        
    }
    
    public void visit(IBD n){
                                                 // {
        for ( int i = 0; i < n.a.size(); i++ ) { // FMDL
            n.a.elementAt(i).accept(this);
        }
                                                 // }
        
    }
    
    public void visit(ITP n){
        n.a.accept(this);                // Iden
        if (n.b!=null) n.b.accept(this); // TypPars
        
    }
    
    public void visit(TypPars n){
        for ( int i = 0; i < n.a.size(); i++ ) { // TPL
            n.a.elementAt(i).accept(this);
        }
        
    }
    
    public void visit(TypPar n){
        n.a.accept(this); // TypVar
        n.b.accept(this); // Boun
        
    }
    
    public void visit(TypVar n){
        n.a.accept(this); // Iden
        
    }
    
    public void visit(Boun n){
        if (n.a!=null) n.a.accept(this); // Ints
        if (n.b!=null) n.b.accept(this); // SupCla
        
    }
    
    public void visit(ClaVar n){
        n.a.accept(this); // VarDec
        
    }
    
    public void visit(FieDec n){
                          // shadow                    ?
        n.a.accept(this); // Type
        n.b.accept(this); // Iden
                          // = 
        n.c.accept(this); // Expr
        
    }
    
    public void visit(CtrDec n){
        n.a.accept(this);                // Iden
        n.b.accept(this);                // ForPars
        if (n.c!=null) n.c.accept(this); // Bloc | :
        
    }
    
    public void visit(MetDec n){
        if (n.a!=null) n.a.toString(); // override | shadow     ¿toSting()?
        n.b.accept(this);              // FMD
        
    }
    
    public void visit(FMD n){
        if (n.a!=null) n.a.accept(this); // AccMod
        if (n.b!=null) n.b.accept(this); // Type | void
        n.c.accept(this);                // Iden
        n.d.accept(this);                // ForPars
        if (n.e!=null) n.e.accept(this); // Bloc | ;
        
    }
    
    public void visit(Bloc n){
        for ( int i = 0; i < n.a.size(); i++ ) { //LVDL
            n.a.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.b.size(); i++ ) { //SL
            n.b.elementAt(i).accept(this);
        }
        
    }
    
    public void visit(LVD n){
        n.a.accept(this);                // Type
        n.b.accept(this);                // Iden
        if (n.c!=null) n.c.accept(this); // = Expr
        
    }
    
    
    
    //Statement productions
    
    //public void visit(Stat n); **abstract
    
    public void visit(AsiSta n){
        n.a.accept(this);  // Expr
                           // =
        n.b.accept(this);  // Expr
                
    }
    
    public void visit(BreSta n){
        // break
        
    }
    
    public void visit(ConSta n){
        // continue
        
    }
    
    public void visit(Else n){
        for ( int i = 0; i < n.a.size(); i++ ) { // SL
            n.a.elementAt(i).accept(this);
        }
        
    }
    
    public void visit(ExpSta n){
        n.a.accept(this); // Expr
        
    }
    
    public void visit(ForSta n){
                                         // for (
        if (n.a!=null) n.a.accept(this); // ForIni ;
        if (n.b!=null) n.b.accept(this); // Expr ;
        if (n.c!=null) n.c.accept(this); // ForUpd 
                                         // )
        n.d.accept(this);                // Stat
        
    }
    
    public void visit(CalSta n){
        n.a.accept(this);                        // Expr
                                                 // (
        for ( int i = 0; i < n.b.size(); i++ ) { // APL
            n.b.elementAt(i).accept(this);
        }
                                                 // )
        
    }
    
    public void visit(IfSta n){
                                         // if
        n.a.accept(this);                // ( Expr )
                                         // {
        n.b.accept(this);                // Stat
        if (n.c!=null) n.c.accept(this); // ; Else
                                         // }
        
    }
    
    public void visit(RetSta n){
        n.a.accept(this); // Expr
        
    }
    
    public void visit(SwiSta n){
                          // switch
        n.a.accept(this); // Expr
        n.b.accept(this); // SwiBlo
        
    }
    
    public void visit(WhiSta n){
                          // while
        n.a.accept(this); // Expr
        n.b.accept(this); // Stat
        
    }
    
    public void visit(Case n){
                                                  // case
        for ( int i = 0; i < n.a.size(); i++ ) {  // CoL 
            n.a.elementAt(i).accept(this);        // :
        }
        n.s.accept(this);                         // Stat
        
    }
    
    public void visit(DefSta n){
                           // default :
        n.a.accept(this);  // Stat
        
    }
    
    public void visit(Desi n){
        n.a.accept(this); // Iden
        
    }
    
    public void visit(ForIni n){
        n.a.accept(this); // Type
        n.b.accept(this); // Iden
                          // =
        n.c.accept(this); // Expr
        
    }
    
    public void visit(ForUpd n){
        n.a.accept(this); // Iden
                          // =
        n.b.accept(this); // Expr
        
    }
    
    public void visit(SwiBlo n){
                          // {
        n.a.accept(this); // CL
        n.b.accept(this); // DefSta
                          // }
        
    }
    
    
    
    //Expression productions
    
    //public void visit(Expr n); **abstract    
    
    public void visit(ConExp n){
        n.a.accept(this); //Expr
        
    }
    
    public void visit(OrExp n){
        n.a.accept(this);                // AndExp
        if (n.b!=null) n.b.accept(this); // AndExp
        
    }
    
    public void visit(AndExp n){
        n.a.accept(this);                // NegExp
        if (n.b!=null) n.b.accept(this); // NegExp
        
    }
    
    public void visit(NegExp n){
        n.a.accept(this);                // RelExp
        
    }
    
    public void visit(RelExp n){
        n.a.accept(this);                // AddExp
        if (n.b!=null) n.b.accept(this); // RelOp
        if (n.c!=null) n.c.accept(this); // AddExp
        
    }
    
    public void visit(AddExp n){
        n.a.accept(this);                // MulExp
        if (n.b!=null) n.b.accept(this); // MulExp
        
    }
    
    public void visit(MulExp n){
        n.a.accept(this);                // UnaExp
        if (n.b!=null) n.b.accept(this); // UnaExp
        
    }
    
    public void visit(UnaExp n){
        n.a.accept(this);                // OUExp
        
    }
    
    public void visit(InsExp n){
        n.a.accept(this);                // UnaExp
                                         // instanceof
        if (n.b!=null) n.b.accept(this); // Type
        
    }
    
    public void visit(OUExp n){
        n.a.accept(this);                // PriExp
        
        
    }
    
    public void visit(Inc n){
        n.a.toString();                    // ++ | --         ¿toSting()?
        
    } 
    
    //public void visit(PriExp n); **abstract
    
    public void visit(Pare n){
        n.a.accept(this);                  // ( Expr )
        
    }
    
    public void visit(PriExpSel n){
        if (n.a!=null) n.a.accept(this);            // PriExp
        for ( int i = 0; i < n.b.size(); i++ ) {    // SeleL
            n.b.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.c.size(); i++ ) {    // IncL
            n.c.elementAt(i).accept(this);
        }
        
    }
    
    public void visit(This n){
        if (n.a!=null) {
                                                     // this
            for ( int i = 0; i < n.a.size(); i++ ) { // APL
                n.a.elementAt(i).accept(this);
            }
        }
        
    }
    
    public void visit(Supe n){
                          // super
        n.a.accept(this); // SupSuf
        
    }   

    //public void visit(New n); **abstract
    
    public void visit(NewTyp n){
                          // new
        n.a.accept(this); // Type
    }    
          
    public void visit(NewExp n){
                          // new
        n.a.accept(this); // Expr
        
    }
    
    //public void visit(Sele n); **abstract
    
    public void visit(SeleAP n){
                                                 // {
        for ( int i = 0; i < n.a.size(); i++ ) { // APL
            n.a.elementAt(i).accept(this);
        }
                                                 // }
        
    }
    
    public void visit(SeleDot n){
                           // .
        n.a.accept(this);  // Expr
        
    }
    
    public void visit(ArrAcc n){
                                                 
        for ( int i = 0; i < n.a.size(); i++ ) { // [ Expr ]
            n.a.elementAt(i).accept(this);
        }
                              
    }
    
    public void visit(CasExp n){
                          // (
        n.a.accept(this); // Expr | Type
                          // )
        n.b.accept(this); // UnaExp
        
    }   
    
    //public void visit(SupSuf n); **abstract
    
    public void visit(SupIden n){
                                                 // .
        n.a.accept(this);                        // Iden
        for ( int i = 0; i < n.b.size(); i++ ) { // APL
            n.b.elementAt(i).accept(this);
        }
        
    }
    
    public void visit(SupPar n){
        for ( int i = 0; i < n.a.size(); i++ ) { // APL
            n.a.elementAt(i).accept(this);
        }
        
    }
    
    public void visit(RelOp n){
        n.a.toString();  //  < | >                           ¿toSting()?
        
    }
    
}