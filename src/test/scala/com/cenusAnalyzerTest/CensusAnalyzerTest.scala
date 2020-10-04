package com.cenusAnalyzerTest

import org.scalatest.FunSuite
import com.censusAnalyzer.CensusAnalyzer
import com.censusAnalyzer.CensusAnalyzerExceptionEnum

class CensusAnalyzerTest extends FunSuite {
  val IndiaCensusCSVFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.csv"
  val WrongCSVFilePathIndia = "/home/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.csv"
  val WrongCSVFileTypePathIndia = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.pdf"
  val InvalidDelimiterFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusDataDelimeter.csv"
  val InvalidHeaderFilePathIndia = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusDataInvalidField.csv"
  val IndiaStateCodeCSVFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/StateCode.csv"
  val WrongCSVFilePathStateCode = "/home/IdeaProjects/CensusAnalyzer/src/test/Resources/StateCode.csv"
  val WrongStateCSVFileType = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/StateCode.pdf"
  val InvalidStateDelimiter = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/StateCodeDelimiter.csv"
  val InvalidHeaderFilePathState = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/StateCodeInvHeader.csv"
  val CensusAnalyzerObj = new CensusAnalyzer()

  test("givenIndiaStateCensusMatchingNumberOfRowsInputCSVFileWithRightPathShouldReturnNumberOfRows"){
    assert(CensusAnalyzerObj.loadCSVDataIndiaStateCensus(IndiaCensusCSVFilePath) === 29)
  }

  test("givenIndiaStateCensusInputFilePathWhenWrongShouldReturnIncorrectFilePathException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCensus(WrongCSVFilePathIndia)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectPath.toString)
  }

  test("givenIndiaStateCensusInputFileTypeWhenWrongShouldReturnIncorrectFileException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCensus(WrongCSVFileTypePathIndia)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectFile.toString)
  }

  test("givenIndiaStateCensusInputFileDelimiterWhenWrongShouldReturnIncorrectDelimiterException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCensus(InvalidDelimiterFilePath)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.UnableToParse.toString)
  }

  test("IndiaStateCensus_InputFileFieldsWrong_ReturnIncorrectFieldsException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCensus(InvalidHeaderFilePathIndia)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.UnableToParse.toString)
  }

  test("givenIndiaStateCodeMatchingNumberOfRowsWhenInputCSVFileWithRightPathShouldReturnNumberOfRows"){
    assert(CensusAnalyzerObj.loadCSVDataIndiaStateCode(IndiaStateCodeCSVFilePath) === 37)
  }

  test("givenInputFilePathWhenWrongShouldReturnIncorrectFilePathException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCode(WrongCSVFilePathStateCode)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectPath.toString)
  }

  test("givenInputFileTypeWhenWrongShouldReturnIncorrectFileException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCode(WrongStateCSVFileType)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectFile.toString)
  }

  test("InputFileDelimiterWrong_ReturnIncorrectDelimiterException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCode(InvalidStateDelimiter)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.UnableToParse.toString)
  }

  test("givenInputFileFieldsWhenWrongShouldReturnIncorrectFieldsException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCensus(InvalidHeaderFilePathState)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.UnableToParse.toString)
  }

}
