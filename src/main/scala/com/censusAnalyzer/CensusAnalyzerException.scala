package com.censusAnalyzer


class CensusAnalyzerException(message:CensusAnalyzerExceptionEnum.Value) extends Exception(message.toString) {}


object CensusAnalyzerExceptionEnum extends Enumeration {
  type CensusAnalyzerException = Value
  val InCorrectPath: CensusAnalyzerExceptionEnum.Value = Value("Incorrect Path Specified")
  val InCorrectFile: CensusAnalyzerExceptionEnum.Value = Value("Incorrect File Specified")
  val UnableToParse: CensusAnalyzerExceptionEnum.Value = Value("Not able to Parse Invalid Delimiter or Fields")
}
