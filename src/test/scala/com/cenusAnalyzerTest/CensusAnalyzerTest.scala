package com.cenusAnalyzerTest

import org.scalatest.FunSuite
import com.censusAnalyzer.CensusAnalyzer

class CensusAnalyzerTest extends FunSuite {

  test("MatchingNumberOfRows_Input_CSVFileWithRightPath_ReturnNumberOfRows"){
    val objCensus = new CensusAnalyzer()
    assert(objCensus.loadCSVInfo("/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.csv") === 29)
  }

}
