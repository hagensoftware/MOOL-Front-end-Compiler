public interface StringVisitor {  

    //Basic Productions
    public String visit(AccMod n); 
    public String visit(BooLit n); 
    public String visit(NulLit n); 
    //public String visit(Numb n); **abstract
    public String visit(Inte n);  
    public String visit(Doub n); 
    public String visit(Iden n); 
    //public String visit(Lite n); **abstract 
    public String visit(QuaIde n); 
    public String visit(ParIde n); 
    //public String visit(TypNam n); abstract
    public String visit(Obje n);
    public String visit(BasTyp n);
    //public String visit(Type n); **abstract
    public String visit(TypeDim n);
    public String visit(TypVoi n); 
    
    //Conpilation unit productions
    //public String visit(AST n); //**abstract raiz del árbol
    public String visit(Prog n);
    public String visit(ModInt n);
    public String visit(ModImp n);
    public String visit(ModBlo n);
    //public String visit(ModDec n); **abstract
    public String visit(ModInts n);
    public String visit(ImpDec n);
    public String visit(ModIni n);
    public String visit(ConDec n);
    public String visit(GFD n);    
    //public String visit(TypDec n); **abstract    
    //public String visit(TD n); **abstract
    public String visit(TDCD n);
    public String visit(TDFT n);
    public String visit(TDID n);      
    public String visit(VarDec n);
    public String visit(ForPar n);
    public String visit(Para n);
    
    //Type Productions
    public String visit(ClaDec n);
    public String visit(IntDec n);
    public String visit(FunTyp n);
    public String visit(SupCla n);
    public String visit(Ints n);
    public String visit(ExtInt n);
    public String visit(CBD n);
    public String visit(IBD n);
    public String visit(ITP n);
    public String visit(TypPars n);
    public String visit(TypPar n);
    public String visit(TypVar n);
    public String visit(Boun n);
    public String visit(ClaVar n);
    public String visit(FieDec n);
    public String visit(CtrDec n);
    public String visit(MetDec n);
    public String visit(FMD n);
    public String visit(Bloc n);
    public String visit(LVD n);
    
    //Statement productions
    //public String visit(Stat n); **abstract
    public String visit(AsiSta n);
    public String visit(BreSta n);
    public String visit(ConSta n);
    public String visit(Else n);
    public String visit(ExpSta n);
    public String visit(ForSta n);
    public String visit(CalSta n);
    public String visit(IfSta n);
    public String visit(RetSta n);
    public String visit(SwiSta n);
    public String visit(WhiSta n);
    public String visit(Case n);
    public String visit(DefSta n);
    public String visit(Desi n);
    public String visit(ForIni n);
    public String visit(ForUpd n);
    public String visit(SwiBlo n);
    
    //Expression productions
    //public String visit(Expr n); **abstract    
    public String visit(ConExp n);
    public String visit(OrExp n);
    public String visit(AndExp n);
    public String visit(NegExp n);
    public String visit(RelExp n);
    public String visit(AddExp n);
    public String visit(MulExp n);
    public String visit(UnaExp n);
    public String visit(InsExp n);
    public String visit(OUExp n);
    public String visit(Inc n);    
    //public String visit(PriExp n); **abstract
    public String visit(Pare n);
    public String visit(PriExpSel n);
    public String visit(This n);
    public String visit(Supe n);    
    public String visit(New n);
    //public String visit(Sele n); **abstract
    public String visit(SeleAP n);
    public String visit(SeleDot n);
    public String visit(ArrAcc n);
    public String visit(CasExp n);    
    //public String visit(SupSuf n); **abstract
    public String visit(SupIden n);
    public String visit(SupPar n);
    public String visit(RelOp n);
     
}