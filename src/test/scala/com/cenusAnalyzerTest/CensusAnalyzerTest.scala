package com.cenusAnalyzerTest

import org.scalatest.FunSuite
import com.censusAnalyzer.CensusAnalyzer
import com.censusAnalyzer.CensusAnalyzerExceptionEnum

class CensusAnalyzerTest extends FunSuite {
  val CensusAnalyzerObj = new CensusAnalyzer()
  test("MatchingNumberOfRows_Input_CSVFileWithRightPath_ReturnNumberOfRows"){
    assert(CensusAnalyzerObj.loadCSVInfo("/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.csv") === 29)
  }

  test("IfFilePathIsWrong_ReturnsIncorrectFilePathException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVInfo("/home/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.csv")
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectPath.toString)
  }

  test("IfFileTypeIsWrong_ReturnsIncorrectFileException") {
    val thrown = intercept[Exception] {
      val objCensus = new CensusAnalyzer()
      objCensus.loadCSVInfo("/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.pdf")
    }
    assert(thrown.getMessage == CensusAnalyzerExceptionEnum.InCorrectFile.toString)
  }
}
