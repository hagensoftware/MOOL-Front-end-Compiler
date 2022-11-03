public interface Visitor {  
    //Basic Productions
    public void visit(AccMod n);
    
    public void visit(BooLit n); 
    
    public void visit(NulLit n);
    
    //public void visit(Numb n); **abstract
    
    public void visit(Inte n);
        
    public void visit(Doub n);
        
    public void visit(Iden n);
       
    //public void visit(Lite n); **abstract 
    
    public void visit(QuaIde n);
        
    public void visit(ParIde n);
        
    //public void visit(TypNam n); abstract
    
    public void visit(Obje n);
        
    public void visit(BasTyp n);
        
    //public void visit(Type n); **abstract
    
    public void visit(TypeDim n);
    
    public void visit(TypVoi n);
    
    
    //Conpilation unit productions
    
    //public void visit(AST n); //**abstract raiz del árbol
    
    public void visit(Prog n);
    
    public void visit(ModInt n);
    
    public void visit(ModImp n);
    
    public void visit(ModBlo n);
    
    //public void visit(ModDec n); **abstract
    
    public void visit(ModInts n);
    
    public void visit(ImpDec n);
    
    public void visit(ModIni n);
    
    public void visit(ConDec n);
    
    public void visit(GFD n);
    
    //public void visit(TypDec n); **abstract    
    
    //public void visit(TD n); **abstract
    
    public void visit(TDCD n);
    
    public void visit(TDFT n);
    
    public void visit(TDID n);  
    
    public void visit(VarDec n);
    
    public void visit(ForPar n);
    
    public void visit(Para n);
    
    
    
    //Type Productions
    
    public void visit(ClaDec n);
    
    public void visit(IntDec n);
    
    public void visit(FunTyp n);
    
    public void visit(SupCla n);
    
    public void visit(Ints n);
    
    public void visit(ExtInt n);
    
    public void visit(CBD n);
    
    public void visit(IBD n);
    
    public void visit(ITP n);
    
    public void visit(TypPars n);
    
    public void visit(TypPar n);
    
    public void visit(TypVar n);
    
    public void visit(Boun n);
    
    public void visit(ClaVar n);
    
    public void visit(FieDec n);
    
    public void visit(CtrDec n);
    
    public void visit(MetDec n);
    
    public void visit(FMD n);
    
    public void visit(Bloc n);
    
    public void visit(LVD n);
    
    
    
    //Statement productions
    
    //public void visit(Stat n); **abstract
    
    public void visit(AsiSta n);
    
    public void visit(BreSta n);
    
    public void visit(ConSta n);
    
    public void visit(Else n);
    
    public void visit(ExpSta n);
    
    public void visit(ForSta n);
    
    public void visit(CalSta n);
    
    public void visit(IfSta n);
    
    public void visit(RetSta n);
    
    public void visit(SwiSta n);
    
    public void visit(WhiSta n);
    
    public void visit(Case n);
    
    public void visit(DefSta n);
    
    public void visit(Desi n);
    
    public void visit(ForIni n);
    
    public void visit(ForUpd n);
    
    public void visit(SwiBlo n);
    
    
    
    //Expression productions
    
    //public void visit(Expr n); **abstract    
    
    public void visit(ConExp n);
    
    public void visit(OrExp n);
    
    public void visit(AndExp n);
    
    public void visit(NegExp n);
    
    public void visit(RelExp n);
    
    public void visit(AddExp n);
    
    public void visit(MulExp n);
    
    public void visit(UnaExp n);
    
    public void visit(InsExp n);
    
    public void visit(OUExp n);
    
    public void visit(Inc n); 
    
    //public void visit(PriExp n); **abstract
    
    public void visit(Pare n);
    
    public void visit(PriExpSel n);
    
    public void visit(This n);
    
    public void visit(Supe n);
    
    //public void visit(New n); **abstract
    
    public void visit(NewTyp n);
    
    public void visit(NewExp n);
    
    //public void visit(Sele n); **abstract
    
    public void visit(SeleAP n);
    
    public void visit(SeleDot n);
    
    public void visit(ArrAcc n);
    
    public void visit(CasExp n);   
    
    //public void visit(SupSuf n); **abstract
    
    public void visit(SupIden n);
    
    public void visit(SupPar n);
    
    public void visit(RelOp n);
    
}
