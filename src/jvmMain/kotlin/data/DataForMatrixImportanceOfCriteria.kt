package data

import models.AlternativeAndCriteriaCell
import models.LinguisticTermCell

val setFor3LinguisticTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Low","L","0","0","50"),
    LinguisticTermCell("Medium","M","0","50","100"),
    LinguisticTermCell("High","H","50","100","100"),
)
val setFor4LinguisticTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Very low","VL","0","0","33"),
    LinguisticTermCell("Low","L","0","33","66"),
    LinguisticTermCell("Medium","M","33","66","100"),
    LinguisticTermCell("High","H","66","100","100"),
)
val setFor5LinguisticTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Low","L","0","0","25"),
    LinguisticTermCell("Medium low","ML","0","25","50"),
    LinguisticTermCell("Medium","M","25","50","75"),
    LinguisticTermCell("Medium high","MH","50","75","100"),
    LinguisticTermCell("High","H","75","100","100"),
)
val setFor6LinguisticTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Very low","VL","0","0","20"),
    LinguisticTermCell("Low","L","0","20","40"),
    LinguisticTermCell("Medium low","ML","20","40","60"),
    LinguisticTermCell("Medium","M","40","60","80"),
    LinguisticTermCell("Medium high","MH","60","80","100"),
    LinguisticTermCell("High","H","80","100","100"),
)
val setFor7LinguisticTerm = mutableListOf<LinguisticTermCell>(
    LinguisticTermCell("Very low","VL","0","0","16"),
    LinguisticTermCell("Low","L","0","16","32"),
    LinguisticTermCell("Medium low","ML","16","32","48"),
    LinguisticTermCell("Medium","M","32","48","64"),
    LinguisticTermCell("Medium high","MH","48","64","80"),
    LinguisticTermCell("High","H","64","80","100"),
    LinguisticTermCell("Very high","VH","80","100","100"),
)
