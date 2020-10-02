package com.censusAnalyzer

import com.censusAnalyzer

class CensusAnalyzerException(message:CensusAnalyzerExceptionEnum.Value) extends Exception(message.toString) {}
object CensusAnalyzerExceptionEnum extends Enumeration {
  type CensusAnalyzerExceptionEnum = Value
    val InCorrectPath: censusAnalyzer.CensusAnalyzerExceptionEnum.Value = Value("Incorrect Path Specified")
    val InCorrectFile: censusAnalyzer.CensusAnalyzerExceptionEnum.Value = Value("Incorrect File Specified")
    val UnableToParse: censusAnalyzer.CensusAnalyzerExceptionEnum.Value = Value("Not able to Parse Invalid Delimiter or Fields")

}

