package com.cenusAnalyzerTest

import com.censusAnalyzer.{CensusAnalyzer, CensusAnalyzerExceptionEnums, IndiaStateCensus}
import com.google.gson.Gson
import org.scalatest.FunSuite

class CensusAnalyzerTest extends FunSuite {

  val IndiaCensusCSVFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.csv"
  val IndiaCensusWrongCSVFilePath = "./resources/IndiaStateCensusData.csv"
  val IndiaCensusWrongCSVFileTypePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCensusData.txt"
  val IndiaCensusInvalidDelimiterFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/InvalidDelimitersIndiaStateCensusData.csv"
  val IndiaCensusInvalidHeaderFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/InvalidHeadersIndiaStateCensusData.csv"
  val IndiaStateCodeCSVFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCode.csv"
  val IndiaStateCodeWrongCSVFilePath = "./src/resources/IndiaStateCode.csv"
  val IndiaStateCodeWrongCSVFileTypePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/IndiaStateCode.txt"
  val IndiaStateCodeInvalidCSVDelimiterFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/InvalidDelimitersIndiaStateCode.csv"
  val IndiaStateCodeInvalidCSVHeaderFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/InvalidHeadersIndiaStateCode.csv"
  val CensusObj = new CensusAnalyzer()

  test("givenIndianCensusCSVFileShouldReturnCorrectRecords") {

    assert(CensusObj.loadIndiaCensusData(IndiaCensusCSVFilePath) === 29)
  }

  test("givenIndianCensusDataCSVFileWhenWithWrongFilePathShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadIndiaCensusData(IndiaCensusWrongCSVFilePath)
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.InCorrectFilePath.toString)
  }

  test("givenIndianCensusDataCSVFileWhenWithWrongFileTypeShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadIndiaCensusData(IndiaCensusWrongCSVFileTypePath)
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.InCorrectFileType.toString)
  }

  test("givenIndianCensusDataCSVFileWhenWithWrongDelimitersShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadIndiaCensusData(IndiaCensusInvalidDelimiterFilePath)
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.UnableToParse.toString)
  }

  test("givenIndianCensusDataCSVFileWhenWithWrongHeadersShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadIndiaCensusData(IndiaCensusInvalidHeaderFilePath)
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.UnableToParse.toString)
  }

  test("givenIndiaStateCodeCSVFileShouldReturnCorrectRecords") {
    assert(CensusObj.loadIndiaStateCode(IndiaStateCodeCSVFilePath) == 37)
  }
  test("givenIndianStateCodeCSVFileWhenWithWrongPathShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadIndiaStateCode(IndiaStateCodeWrongCSVFilePath)
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.InCorrectFilePath.toString)
  }

  test("givenIndianStateCodeCSVFileWhenWithWrongFileTypeShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadIndiaStateCode(IndiaStateCodeWrongCSVFileTypePath)
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.InCorrectFileType.toString)
  }

  test("givenIndianStateCodeCSVFileWhenWithWrongDelimitersShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadIndiaStateCode(IndiaStateCodeInvalidCSVDelimiterFilePath)
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.UnableToParse.toString)
  }

  test("givenIndianStateCodeCSVFileWhenWithWrongHeadersShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadIndiaStateCode(IndiaStateCodeInvalidCSVHeaderFilePath)
    }
    assert(throws.getMessage == CensusAnalyzerExceptionEnums.UnableToParse.toString)
  }

  test("givenIndianCensusDataWhenSortedByStateShouldReturnSortedResult"){
    CensusObj.loadIndiaCensusData(IndiaCensusCSVFilePath)
    val sortedCensusData = CensusObj.getStateWiseSortedCensusData()

    val censusCSV = new Gson().fromJson(sortedCensusData,classOf[Array[IndiaStateCensus]])
    assert(censusCSV(0).state === "Andhra Pradesh")
    assert(censusCSV.last.state === "West Bengal")
  }

  test("givenIndianCensusDataWhenEmptyDataShouldReturnException"){
    val objCensus = new CensusAnalyzer()
    val throws = intercept[Exception]{
      objCensus.getStateCodeWiseSortedCensusData()
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.NoCensusData.toString)
  }

  test("givenIndianCensusDataAndStateDateWhenSortedByStateShouldReturnSortedResult"){
    CensusObj.loadIndiaCensusData(IndiaCensusCSVFilePath)
    CensusObj.loadIndiaStateCode(IndiaStateCodeCSVFilePath)

    val sortedCensusData = CensusObj.getStateCodeWiseSortedCensusData()

    val censusCSV = new Gson().fromJson(sortedCensusData,classOf[Array[IndiaStateCensus]])
    assert(censusCSV(0).state === "Andhra Pradesh")
    assert(censusCSV.last.state === "West Bengal")
  }

  test("givenIndianStateDataWhenEmptyDataShouldReturnException"){
    val objCensus = new CensusAnalyzer()
    val throws = intercept[Exception]{
      objCensus.getStateCodeWiseSortedCensusData()
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.NoCensusData.toString)
  }

  test("givenIndianCensusDataAndStateDateWhenSortedByPopulationDensityShouldReturnSortedResult"){
    CensusObj.loadIndiaCensusData(IndiaCensusCSVFilePath)
    val sortedCensusData = CensusObj.getPopulationDensityWiseSortedCensusData()
    val censusCSV = new Gson().fromJson(sortedCensusData,classOf[Array[IndiaStateCensus]])
    assert(censusCSV(0).state === "Bihar")
    assert(censusCSV.last.state === "Arunachal Pradesh")
  }
  test("givenIndianCensusDataAndStateDateWhenSortedByPopulationShouldReturnSortedResult"){
    CensusObj.loadIndiaCensusData(IndiaCensusCSVFilePath)
    val sortedCensusData = CensusObj.getPopulationWiseSortedCensusData()
    val censusCSV = new Gson().fromJson(sortedCensusData,classOf[Array[IndiaStateCensus]])
    assert(censusCSV(0).state === "Uttar Pradesh")
    assert(censusCSV.last.state === "Sikkim")
  }

  test("givenIndianStateDataWhenEmptyDataPopulationShouldReturnException"){
    val objCensus = new CensusAnalyzer()
    val throws = intercept[Exception]{
      objCensus.getPopulationWiseSortedCensusData()
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.NoCensusData.toString)
  }

  test("givenIndianCensusDataAndStateDateWhenSortedByAreaShouldReturnSortedResult"){
    CensusObj.loadIndiaCensusData(IndiaCensusCSVFilePath)
    val sortedCensusData = CensusObj.getAreaWiseSortedCensusData()
    val censusCSV = new Gson().fromJson(sortedCensusData,classOf[Array[IndiaStateCensus]])
    assert(censusCSV(0).state === "Rajasthan")
    assert(censusCSV.last.state === "Goa")
  }

  test("givenIndianStateDataWhenEmptyDataAreaShouldReturnException"){
    val objCensus = new CensusAnalyzer()
    val throws = intercept[Exception]{
      objCensus.getAreaWiseSortedCensusData()
    }
    assert(throws.getMessage === CensusAnalyzerExceptionEnums.NoCensusData.toString)
  }
}
