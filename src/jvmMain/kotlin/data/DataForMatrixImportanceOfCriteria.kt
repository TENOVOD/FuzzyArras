package data

import models.AlternativeAndCriteriaCell
import models.LinguisticTermCell

val setFor3LinguisticTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Низький","Н","0","0","50"),
    LinguisticTermCell("Середній","С","0","50","100"),
    LinguisticTermCell("Високий","В","50","100","100"),
)
val setFor4LinguisticTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Дуже низький","ДН","0","0","33"),
    LinguisticTermCell("Низький","Н","0","33","66"),
    LinguisticTermCell("Середній","С","33","66","100"),
    LinguisticTermCell("Високий","В","66","100","100"),
)
val setFor5LinguisticTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Низький","Н","0","0","25"),
    LinguisticTermCell("Середньо-низький ","СН","0","25","50"),
    LinguisticTermCell("Середній","С","25","50","75"),
    LinguisticTermCell("Середньо-високий","СВ","50","75","100"),
    LinguisticTermCell("Високий","В","75","100","100"),
)
val setFor6LinguisticTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Дуже низький","ДН","0","0","20"),
    LinguisticTermCell("Низький","Н","0","20","40"),
    LinguisticTermCell("Середньо-низький","СН","20","40","60"),
    LinguisticTermCell("Середній","С","40","60","80"),
    LinguisticTermCell("Середньо-високий","СВ","60","80","100"),
    LinguisticTermCell("Високий","В","80","100","100"),
)
val setFor7LinguisticTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Дуже низький","ДН","0","0","10"),
    LinguisticTermCell("Низький","Н","0","10","30"),
    LinguisticTermCell("Середньо-низький","СН","10","30","50"),
    LinguisticTermCell("Середній","С","30","50","70"),
    LinguisticTermCell("Середньо-високий","СВ","50","70","90"),
    LinguisticTermCell("Високий","В","70","70","100"),
    LinguisticTermCell("Дуже високий","ДВ","90","100","100"),
)

val setFor3AlternativeTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Низький","Н","0","0","50"),
    LinguisticTermCell("Середній","С","0","50","100"),
    LinguisticTermCell("Високий","В","50","100","100"),
)
val setFor4AlternativeTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Дуже низький","ДН","0","0","33"),
    LinguisticTermCell("Низький","Н","0","33","66"),
    LinguisticTermCell("Середній","С","33","66","100"),
    LinguisticTermCell("Високий","В","66","100","100"),
)
val setFor5AlternativeTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Низький","Н","0","0","25"),
    LinguisticTermCell("Середньо-низький ","СН","0","25","50"),
    LinguisticTermCell("Середній","С","25","50","75"),
    LinguisticTermCell("Середньо-високий","СВ","50","75","100"),
    LinguisticTermCell("Високий","В","75","100","100"),
)
val setFor6AlternativeTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Дуже низький","ДН","0","0","20"),
    LinguisticTermCell("Низький","Н","0","20","40"),
    LinguisticTermCell("Середньо-низький","СН","20","40","60"),
    LinguisticTermCell("Середній","С","40","60","80"),
    LinguisticTermCell("Середньо-високий","СВ","60","80","100"),
    LinguisticTermCell("Високий","В","80","100","100"),
)
val setFor7AlternativeTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Дуже низький","ДН","0","0","10"),
    LinguisticTermCell("Низький","Н","0","10","30"),
    LinguisticTermCell("Середньо-низький","СН","10","30","50"),
    LinguisticTermCell("Середній","С","30","50","70"),
    LinguisticTermCell("Середньо-високий","СВ","50","70","90"),
    LinguisticTermCell("Високий","В","70","70","100"),
    LinguisticTermCell("Дуже високий","ДВ","90","100","100"),
)