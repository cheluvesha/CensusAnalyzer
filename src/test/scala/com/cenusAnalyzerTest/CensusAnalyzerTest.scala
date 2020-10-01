package com.cenusAnalyzerTest

import org.scalatest.FunSuite
import com.censusAnalyzer.CensusAnalyzer
import com.censusAnalyzer.CensusAnalyzerExceptionEnum

class CensusAnalyzerTest extends FunSuite {
  val IndiaCensusCSVFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.csv"
  val WrongCSVFilePath = "/home/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.csv"
  val WrongCSVFileTypePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.pdf"
  val InvalidDelimiterFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusDataDelimeter.csv"
  val InvalidHeaderFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusDataInvalidField.csv"
  val CensusAnalyzerObj = new CensusAnalyzer()

  test("MatchingNumberOfRows_Input_CSVFileWithRightPath_ReturnNumberOfRows"){
    assert(CensusAnalyzerObj.loadCSVInfo(IndiaCensusCSVFilePath) === 29)
  }

  test("IfFilePathIsWrong_ReturnsIncorrectFilePathException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVInfo(WrongCSVFilePath)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectPath.toString)
  }

  test("IfFileTypeIsWrong_ReturnsIncorrectFileException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVInfo(WrongCSVFileTypePath)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectFile.toString)
  }

  test("IfFileDelimiterWrong_ReturnsIncorrectDelimiterException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVInfo(InvalidDelimiterFilePath)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectDelimiter.toString)
  }

  test("IfInputFileFieldsWrong_ReturnsIncorrectFieldsException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVInfo(InvalidHeaderFilePath)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectFields.toString)
  }

}
