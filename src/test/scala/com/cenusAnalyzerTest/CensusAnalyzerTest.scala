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

  test("IndiaStateCensus_MatchingNumberOfRows_Input_CSVFileWithRightPath_ReturnNumberOfRows"){
    assert(CensusAnalyzerObj.loadCSVDataIndiaStateCensus(IndiaCensusCSVFilePath) === 29)
  }

  test("IndiaStateCensus_InputFilePathIsWrong_ReturnIncorrectFilePathException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCensus(WrongCSVFilePathIndia)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectPath.toString)
  }

  test("IndiaStateCensus_InputFileTypeIsWrong_ReturnIncorrectFileException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCensus(WrongCSVFileTypePathIndia)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectFile.toString)
  }

  test("IndiaStateCensus_InputFileDelimiterWrong_ReturnIncorrectDelimiterException") {
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

  test("IndiaStateCode_MatchingNumberOfRows_Input_CSVFileWithRightPath_ReturnNumberOfRows"){
    assert(CensusAnalyzerObj.loadCSVDataIndiaStateCode(IndiaStateCodeCSVFilePath) === 37)
  }

  test("InputFilePathIsWrong_ReturnIncorrectFilePathException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCode(WrongCSVFilePathStateCode)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectPath.toString)
  }

  test("InputFileTypeIsWrong_ReturnIncorrectFileException") {
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

  test("InputFileFieldsWrong_ReturnIncorrectFieldsException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVDataIndiaStateCensus(InvalidHeaderFilePathState)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.UnableToParse.toString)
  }



}
