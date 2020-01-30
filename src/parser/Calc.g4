grammar Calc;

// syntactic rules
body     : varDef* expression EOF
         ;
varDef   : variableId '=' expression
         ;
expression : LITERAL                                                        #IntLit
           | variableId                                                     #Var
           | ('true' | 'false')                                             #BoolLit
           | '(' expression ')'                                             #ParExp
           | (MINUS | NOT) expression                                       #UnExp
           | expression  MULTIPLICATIVE expression                          #BinExpTimes
           | expression (MINUS | PLUS) expression                           #BinExpPlus
           | expression RELATIONAL expression                               #RelationalExp
           | expression EQUALITY expression                                 #EqualExp
           | expression LOGICAL_AND expression                              #AndExp
           | expression LOGICAL_OR expression                               #OrExp
           | <assoc = right> expression '?' expression ':' expression       #CondExp
           ;
variableId : IDENTIFIER
           ;

// lexical rules
MINUS    : '-'
         ;
NOT      : '!'
         ;
PLUS     : '+'
         ;
MULTIPLICATIVE : '*' | '/'
         ;
RELATIONAL     : '<' | '>' | '<=' | '>='
         ;
EQUALITY : '==' | '!='
         ;
LOGICAL_AND    : '&&'
         ;
LOGICAL_OR : '||'
         ;
IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
LITERAL  : '0' | ('1'..'9')('0'..'9')*              
         ;
WS       : [ \t\n\r]+ -> channel(HIDDEN)
         ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN)
         ;