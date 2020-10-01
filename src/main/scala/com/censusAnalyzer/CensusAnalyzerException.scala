package com.censusAnalyzer

import com.censusAnalyzer

class CensusAnalyzerException(message:CensusAnalyzerExceptionEnum.Value) extends Exception(message.toString) {}
object CensusAnalyzerExceptionEnum extends Enumeration {
  type CensusAnalyzerExceptionEnum = Value
  val InCorrectFile: censusAnalyzer.CensusAnalyzerExceptionEnum.Value = Value("Incorrect File")
  val InCorrectPath: censusAnalyzer.CensusAnalyzerExceptionEnum.Value = Value("Incorrect path")
  val InCorrectDelimiter: censusAnalyzer.CensusAnalyzerExceptionEnum.Value = Value("Incorrect Delimiter mentioned")
  val InCorrectFields: censusAnalyzer.CensusAnalyzerExceptionEnum.Value = Value("Incorrect Fields mentioned")
}

