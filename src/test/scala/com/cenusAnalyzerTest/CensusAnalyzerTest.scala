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

  test("givenIndianCensusCSVFileShouldReturnCorrectRecords"){
    assert(CensusAnalyzerObj.loadIndiaCensusData(IndiaCensusCSVFilePath) === 29)
  }

  test("givenIndiaStateCensusInputFilePathIsWrongShouldReturnIncorrectFilePathException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadIndiaCensusData(WrongCSVFilePathIndia)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectPath.toString)
  }

  test("givenIndiaStateCensusInputFileTypeWhenWrongShouldReturnIncorrectFileException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadIndiaCensusData(WrongCSVFileTypePathIndia)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectFile.toString)
  }

  test("givenIndiaStateCensusInputFileDelimiterWhenWrongShouldReturnIncorrectDelimiterException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadIndiaCensusData(InvalidDelimiterFilePath)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.UnableToParse.toString)
  }

  test("givenIndiaStateCensusInputFileFieldsWhenWrongShouldReturnIncorrectFieldsException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadIndiaCensusData(InvalidHeaderFilePathIndia)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.UnableToParse.toString)
  }

  test("givenIndiaStateCodeMatchingNumberOfRowsInputCSVFileWithRightPathShouldReturnNumberOfRows"){
    assert(CensusAnalyzerObj.loadIndiaStateCode(IndiaStateCodeCSVFilePath) === 37)
  }

  test("givenInputFilePathIsWhenWrongShouldReturnIncorrectFilePathException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadIndiaStateCode(WrongCSVFilePathStateCode)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.UnableToParse.toString)
  }

  test("givenInputFileTypeWhenWrongShouldReturnIncorrectFileException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadIndiaStateCode(WrongStateCSVFileType)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectFile.toString)
  }

  test("InputFileDelimiterWrong_ReturnIncorrectDelimiterException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadIndiaStateCode(InvalidStateDelimiter)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.UnableToParse.toString)
  }

  test("givenInputFileFieldsWhenWrongShouldReturnIncorrectFieldsException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadIndiaStateCode(InvalidHeaderFilePathState)
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.UnableToParse.toString)
  }



}
