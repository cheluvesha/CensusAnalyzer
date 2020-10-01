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
      CensusAnalyzerObj.loadCSVInfo("./src/scala/CensusAnalyzerProject/Resources/IndiaStateCensusData.csv")
    }
    assert(thrown.getMessage === CensusAnalyzerExceptionEnum.InCorrectPath.toString)
  }
}
