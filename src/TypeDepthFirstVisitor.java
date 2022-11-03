public class TypeDepthFirstVisitor implements TypeVisitor{
    
    //Basic Productions
    
    public Type visit(AccMod n){
        // protected
        return null;       
    }
    
    public Type visit(BooLit n){
        // true | false
        return null;        
    } 
    
    public Type visit(NulLit n){
        //null
        return null;        
    }
    
    //public Type visit(Numb n); **abstract
    
    public Type visit(Inte n){
        n.f0.toString(); //Integer
        return null;
    }
    
    public Type visit(Doub n){
        n.f0.toString(); //Double
        return null;
    }
    
    public Type visit(Iden n){
        n.s.toString(); //String   id                      toSting()
        System.out.println("TypeDepthFirstVisitor * Id * " + n.s.toString());
        return null;
    }
    
    //public Type visit(Lite n); **abstract 
    
    public Type visit(QuaIde n){
        n.i1.accept(this); // Iden
                           // .
        n.i2.accept(this); // Iden
        return null;
    } 
    
    public Type visit(ParIde n){
        n.f0.accept(this); // Iden
                           // <
        for ( int i = 0; i < n.f1.size(); i++ ) { // TypeList
            n.f1.elementAt(i).accept(this);
        }
                           // >
        return null;
    }
    
    //public Type visit(TypNam n); abstract
    
    public Type visit(Obje n){
        n.toString(); // String   object               toSting()
        return null;
    }
    
    public Type visit(BasTyp n){
        n.s.toString(); // String (int float bool)     toSting()
        return null;
    }
    
    //public Type visit(Type n); **abstract
    
    public Type visit(TypeDim n){
        // n * []
        return null;
    }
    
    public Type visit(TypVoi n){
        // void
        return null;
    }
    
    
    //Conpilation unit productions
    
    //public Type visit(AST n); //**abstract raiz del árbol
    
    public Type visit(Prog n){
        if (n.a!=null) n.a.accept(this); //ModInt
        if (n.b!=null) n.b.accept(this); //ModImp
        return null;
    }
    
    
    
    public Type visit(ModInt n){
                          // module interface
        n.a.accept(this); // Iden
        n.b.accept(this); // ModBlo
        return null;
    }
    
    public Type visit(ModImp n){
                          // module
        n.a.accept(this); // Iden
        n.b.accept(this); // ModInt
        n.c.accept(this); // ModBlo
        return null;
    }
   
    public Type visit(ModBlo n){
                                                 // { 
        for ( int i = 0; i < n.a.size(); i++ ) { // IDL
            n.a.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.b.size(); i++ ) { // MDL
            n.b.elementAt(i).accept(this);
        }
        if (n.c!=null) n.c.accept(this);         // ModIni
                                                 // }
        return null;
    }
    
    //public Type visit(ModDec n); **abstract
    
    public Type visit(ModInts n){
                                                 // implements
        for ( int i = 0; i < n.a.size(); i++ ) { // IL
            n.a.elementAt(i).accept(this);
        }
        return null;
    }
    
    public Type visit(ImpDec n){
        n.a.accept(this);                 // Iden
        if (n.b!=null) n.b.accept(this);  // . Iden
        if (n.c!=null) n.c.accept(this);  // as Iden
        return null;
    }
    
    public Type visit(ModIni n){
                          //init
        n.a.accept(this); //Bloc
        return null;
    }
    
    public Type visit(ConDec n){
                           //const
        n.a.accept(this);  //Type
        n.b.accept(this);  //Iden
        n.c.accept(this);  // = ConExp
        return null;
    }
    
    public Type visit(GFD n){
        if (n.a!=null) n.a.accept(this); //Type | void
        n.b.accept(this);                //Iden
        if (n.c!=null) n.c.accept(this); //TypPar
        n.d.accept(this);                //ForPar
        if (n.e!=null) n.e.accept(this); // ; | Bloc
        return null;
    }
    
    //public Type visit(TypDec n); **abstract    
    
    //public Type visit(TD n); **abstract
    
    public Type visit(TDCD n){
        n.a.accept(this); //CDL
        return null;
    }
    
    public Type visit(TDFT n){
        n.a.accept(this); // FTL
        return null;
    }
    
    public Type visit(TDID n){
        n.a.accept(this); // IDL
        return null;
    }  
    
    public Type visit(VarDec n){
        n.a.accept(this); // Type
        n.b.accept(this); // Iden
        n.c.accept(this); // = Expr
        return null;
    }
    
    public Type visit(ForPar n){
                                                 // (
        for ( int i = 0; i < n.a.size(); i++ ) { // Pars
            n.a.elementAt(i).accept(this);
        }
                                                 // )
        return null;
    }
    
    public Type visit(Para n){
        n.a.accept(this); // Type
        n.b.accept(this); // Iden
        return null;
    }
    
    
    
    //Type Productions
    
    public Type visit(ClaDec n){
                                         // class
        n.a.accept(this);                // iden
        if (n.b!=null) n.b.accept(this); // TypPar
        if (n.c!=null) n.c.accept(this); // SupCla
        if (n.d!=null) n.d.accept(this); // Ints          ¿null?
        n.e.accept(this);                // CBD 
        return null;
    }
    
    public Type visit(IntDec n){
                                          // class interface
        n.a.accept(this);                 // iden
        if (n.b!=null) n.b.accept(this);  // TypPars
        if (n.c!=null) n.c.accept(this);  // ExtInt
        n.d.accept(this);                 // InL
        return null;
    }
    
    public Type visit(FunTyp n){
                           // function
        n.a.accept(this);  // Type | void
        n.b.accept(this);  // Iden
        n.c.accept(this);  // ForPars
        return null;
    }
    
    public Type visit(SupCla n){
                           // extends
        n.a.accept(this);  // ITP
        return null;
    }
    
    public Type visit(Ints n){
                                                 // implements
        for ( int i = 0; i < n.a.size(); i++ ) { // InL
            n.a.elementAt(i).accept(this);
        }
        return null;
    }
    
    public Type visit(ExtInt n){
                                                 // extends
        for ( int i = 0; i < n.a.size(); i++ ) { // InL
            n.a.elementAt(i).accept(this);
        }
        return null;
    }
    
    public Type visit(CBD n){
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
        return null;
    }
    
    public Type visit(IBD n){
                                                 // {
        for ( int i = 0; i < n.a.size(); i++ ) { // FMDL
            n.a.elementAt(i).accept(this);
        }
                                                 // }
        return null;
    }
    
    public Type visit(ITP n){
        n.a.accept(this);                // Iden
        if (n.b!=null) n.b.accept(this); // TypPars
        return null;
    }
    
    public Type visit(TypPars n){
        for ( int i = 0; i < n.a.size(); i++ ) { // TPL
            n.a.elementAt(i).accept(this);
        }
        return null;
    }
    
    public Type visit(TypPar n){
        n.a.accept(this); // TypVar
        n.b.accept(this); // Boun
        return null;
    }
    
    public Type visit(TypVar n){
        n.a.accept(this); // Iden
        return null;
    }
    
    public Type visit(Boun n){
        if (n.a!=null) n.a.accept(this); // Ints
        if (n.b!=null) n.b.accept(this); // SupCla
        return null;
    }
    
    public Type visit(ClaVar n){
        n.a.accept(this); // VarDec
        return null;
    }
    
    public Type visit(FieDec n){
                          // shadow                    ?
        n.a.accept(this); // Type
        n.b.accept(this); // Iden
                          // = 
        n.c.accept(this); // Expr
        return null;
    }
    
    public Type visit(CtrDec n){
        n.a.accept(this);                // Iden
        n.b.accept(this);                // ForPars
        if (n.c!=null) n.c.accept(this); // Bloc | :
        return null;
    }
    
    public Type visit(MetDec n){
        if (n.a!=null) n.a.toString(); // override | shadow     ¿toSting()?
        n.b.accept(this);              // FMD
        return null;
    }
    
    public Type visit(FMD n){
        if (n.a!=null) n.a.accept(this); // AccMod
        if (n.b!=null) n.b.accept(this); // Type | void
        n.c.accept(this);                // Iden
        n.d.accept(this);                // ForPars
        if (n.e!=null) n.e.accept(this); // Bloc | ;
        return null;
    }
    
    public Type visit(Bloc n){
        for ( int i = 0; i < n.a.size(); i++ ) { //LVDL
            n.a.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.b.size(); i++ ) { //SL
            n.b.elementAt(i).accept(this);
        }
        return null;
    }
    
    public Type visit(LVD n){
        n.a.accept(this);                // Type
        n.b.accept(this);                // Iden
        if (n.c!=null) n.c.accept(this); // = Expr
        return null;
    }
    
    
    
    //Statement productions
    
    //public Type visit(Stat n); **abstract
    
    public Type visit(AsiSta n){
        n.a.accept(this);  // Expr
                           // =
        n.b.accept(this);  // Expr
        return null;        
    }
    
    public Type visit(BreSta n){
        // break
        return null;
    }
    
    public Type visit(ConSta n){
        // continue
        return null;
    }
    
    public Type visit(Else n){
        for ( int i = 0; i < n.a.size(); i++ ) { // SL
            n.a.elementAt(i).accept(this);
        }
        return null;
    }
    
    public Type visit(ExpSta n){
        n.a.accept(this); // Expr
        return null;
    }
    
    public Type visit(ForSta n){
                                         // for (
        if (n.a!=null) n.a.accept(this); // ForIni ;
        if (n.b!=null) n.b.accept(this); // Expr ;
        if (n.c!=null) n.c.accept(this); // ForUpd 
                                         // )
        n.d.accept(this);                // Stat
        return null;
    }
    
    public Type visit(CalSta n){
        n.a.accept(this);                        // Expr
                                                 // (
        for ( int i = 0; i < n.b.size(); i++ ) { // APL
            n.b.elementAt(i).accept(this);
        }
                                                 // )
        return null;
    }
    
    public Type visit(IfSta n){
                                         // if
        n.a.accept(this);                // ( Expr )
                                         // {
        n.b.accept(this);                // Stat
        if (n.c!=null) n.c.accept(this); // ; Else
                                         // }
        return null;
    }
    
    public Type visit(RetSta n){
        n.a.accept(this); // Expr
        return null;
    }
    
    public Type visit(SwiSta n){
                          // switch
        n.a.accept(this); // Expr
        n.b.accept(this); // SwiBlo
        return null;
    }
    
    public Type visit(WhiSta n){
                          // while
        n.a.accept(this); // Expr
        n.b.accept(this); // Stat
        return null;
    }
    
    public Type visit(Case n){
                                                  // case
        for ( int i = 0; i < n.a.size(); i++ ) {  // CoL 
            n.a.elementAt(i).accept(this);        // :
        }
        n.s.accept(this);                         // Stat
        return null;
    }
    
    public Type visit(DefSta n){
                           // default :
        n.a.accept(this);  // Stat
        return null;
    }
    
    public Type visit(Desi n){
        n.a.accept(this); // Iden
        return null;
    }
    
    public Type visit(ForIni n){
        n.a.accept(this); // Type
        n.b.accept(this); // Iden
                          // =
        n.c.accept(this); // Expr
        return null;
    }
    
    public Type visit(ForUpd n){
        n.a.accept(this); // Iden
                          // =
        n.b.accept(this); // Expr
        return null;
    }
    
    public Type visit(SwiBlo n){
                          // {
        n.a.accept(this); // CL
        n.b.accept(this); // DefSta
                          // }
        return null;
    }
    
    
    
    //Expression productions
    
    //public Type visit(Expr n); **abstract    
    
    public Type visit(ConExp n){
        n.a.accept(this); //Expr
        return null;
    }
    
    public Type visit(OrExp n){
        n.a.accept(this);                // AndExp
        if (n.b!=null) n.b.accept(this); // AndExp
        return null;
    }
    
    public Type visit(AndExp n){
        n.a.accept(this);                // NegExp
        if (n.b!=null) n.b.accept(this); // NegExp
        return null;
    }
    
    public Type visit(NegExp n){
        n.a.accept(this);                // RelExp
        return null;
    }
    
    public Type visit(RelExp n){
        n.a.accept(this);                // AddExp
        if (n.b!=null) n.b.accept(this); // RelOp
        if (n.c!=null) n.c.accept(this); // AddExp
        return null;
    }
    
    public Type visit(AddExp n){
        n.a.accept(this);                // MulExp
        if (n.b!=null) n.b.accept(this); // MulExp
        return null;
    }
    
    public Type visit(MulExp n){
        n.a.accept(this);                // UnaExp
        if (n.b!=null) n.b.accept(this); // UnaExp
        return null;
    }
    
    public Type visit(UnaExp n){
        n.a.accept(this);                // OUExp
        return null;
    }
    
    public Type visit(InsExp n){
        n.a.accept(this);                // UnaExp
                                         // instanceof
        if (n.b!=null) n.b.accept(this); // Type
        return null;
    }
    
    public Type visit(OUExp n){
        n.a.accept(this);                // PriExp
        
        return null;
    }
    
    public Type visit(Inc n){
        n.a.toString();                    // ++ | --         ¿toSting()?
        return null;
    } 
    
    //public Type visit(PriExp n); **abstract
    
    public Type visit(Pare n){
        n.a.accept(this);                  // ( Expr )
        return null;
    }
    
    public Type visit(PriExpSel n){
        if (n.a!=null) n.a.accept(this);            // PriExp
        for ( int i = 0; i < n.b.size(); i++ ) {    // SeleL
            n.b.elementAt(i).accept(this);
        }
        for ( int i = 0; i < n.c.size(); i++ ) {    // IncL
            n.c.elementAt(i).accept(this);
        }
        return null;
    }
    
    public Type visit(This n){
        if (n.a!=null) {
                                                     // this
            for ( int i = 0; i < n.a.size(); i++ ) { // APL
                n.a.elementAt(i).accept(this);
            }
        }
        return null;
    }
    
    public Type visit(Supe n){
                          // super
        n.a.accept(this); // SupSuf
        return null;
    }   

    //public Type visit(New n); **abstract
    
    public Type visit(NewTyp n){
                          // new
        n.a.accept(this); // Type
        return null;
    }    
        
    public Type visit(NewExp n){
                          // new
        n.a.accept(this); // Expr
        return null;
    }
    
    //public Type visit(Sele n); **abstract
    
    public Type visit(SeleAP n){
                                                 // {
        for ( int i = 0; i < n.a.size(); i++ ) { // APL
            n.a.elementAt(i).accept(this);
        }
                                                 // }
        return null;
    }
    
    public Type visit(SeleDot n){
                           // .
        n.a.accept(this);  // Expr
        return null;
    }
    
    public Type visit(ArrAcc n){
                                                 
        for ( int i = 0; i < n.a.size(); i++ ) { // [ Expr ]
            n.a.elementAt(i).accept(this);
        }
        return null;                      
    }
    
    public Type visit(CasExp n){
                          // (
        n.a.accept(this); // Expr | Type
                          // )
        n.b.accept(this); // UnaExp
        return null;
    }   
    
    //public Type visit(SupSuf n); **abstract
    
    public Type visit(SupIden n){
                                                 // .
        n.a.accept(this);                        // Iden
        for ( int i = 0; i < n.b.size(); i++ ) { // APL
            n.b.elementAt(i).accept(this);
        }
        return null;
    }
    
    public Type visit(SupPar n){
        for ( int i = 0; i < n.a.size(); i++ ) { // APL
            n.a.elementAt(i).accept(this);
        }
        return null;
    }
    
    public Type visit(RelOp n){
        n.a.toString();  //  < | >                           ¿toSting()?
        return null;
    }
    
}