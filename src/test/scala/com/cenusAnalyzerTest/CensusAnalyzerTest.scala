package com.cenusAnalyzerTest

import com.censusAnalyzer.{CensusAnalyzer, CensusAnalyzerExceptionEnums, Country, IndiaCensusDTO}
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
  val USCensusCSVFilePath = "/home/cheluvesha/IdeaProjects/CensusAnalyzer/src/test/Resources/USCensusData.csv"
  val CensusObj = new CensusAnalyzer()

  test("given_IndianCensusCSVFile_ShouldReturnCorrectRecords") {
    assert(CensusObj.loadCensusData(Country.India,IndiaCensusCSVFilePath,IndiaStateCodeCSVFilePath) === 29)
  }

  test("givenIndianCensusDataCSVFile_whenWithWrongFilePath_ShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadCensusData(Country.India,IndiaCensusWrongCSVFilePath,IndiaCensusWrongCSVFilePath)
    }
    assert(throws.getMessage == CensusAnalyzerExceptionEnums.InCorrectFilePath.toString)
  }

  test("givenIndianCensusDataCSVFile_whenWithWrongFileType_ShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadCensusData(Country.India,IndiaCensusWrongCSVFileTypePath,IndiaCensusWrongCSVFileTypePath)
    }
    assert(throws.getMessage == CensusAnalyzerExceptionEnums.InCorrectFileType.toString)
  }

  test("givenIndianCensusDataCSVFile_whenWithWrongDelimiters_shouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadCensusData(Country.India,IndiaCensusInvalidDelimiterFilePath,IndiaCensusInvalidDelimiterFilePath)
    }
    assert(throws.getMessage == CensusAnalyzerExceptionEnums.UnableToParse.toString)
  }

  test("givenIndianCensusDataCSVFile_WhenWithWrongHeaders_ShouldThrowException") {
    val throws = intercept[Exception] {
      CensusObj.loadCensusData(Country.India,IndiaCensusInvalidHeaderFilePath,IndiaCensusInvalidHeaderFilePath)
    }
    assert(throws.getMessage == CensusAnalyzerExceptionEnums.UnableToParse.toString)
  }

  test("givenIndianCensusData_whenSortedByState_shouldReturnSortedResult") {
    CensusObj.loadCensusData(Country.India,IndiaCensusCSVFilePath,IndiaStateCodeCSVFilePath)
    val sortedCensusData = CensusObj.getStateWiseSortedCensusData
    val censusCSV = new Gson().fromJson(sortedCensusData, classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state == "Andhra Pradesh")
    assert(censusCSV.last.state == "West Bengal")
  }

  test("givenIndianCensusData_whenEmptyData_shouldReturnException") {
    val CensusObj1 = new CensusAnalyzer()
    val throws = intercept[Exception] {
      CensusObj1.getStateCodeWiseSortedCensusData
    }
    assert(throws.getMessage == CensusAnalyzerExceptionEnums.NoCensusData.toString)
  }

  test("givenIndianCensusDataAndStateData_whenSortedByState_shouldReturnSortedResult") {
    CensusObj.loadCensusData(Country.India,IndiaCensusCSVFilePath,IndiaStateCodeCSVFilePath)
    val sortedCensusData = CensusObj.getStateCodeWiseSortedCensusData
    val censusCSV = new Gson().fromJson(sortedCensusData, classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state == "Andhra Pradesh")
    assert(censusCSV.last.state == "West Bengal")
  }

  test("givenIndianStateData_whenEmptyData_shouldReturnException") {
    val CensusObj1 = new CensusAnalyzer()
    val throws = intercept[Exception] {
      CensusObj1.getStateCodeWiseSortedCensusData
    }
    assert(throws.getMessage == CensusAnalyzerExceptionEnums.NoCensusData.toString)
  }

  test("givenIndianCensusDataAndStateData_whenSortedByPopulationDensity_shouldReturnSortedResult") {
    CensusObj.loadCensusData(Country.India,IndiaCensusCSVFilePath,IndiaStateCodeCSVFilePath)
    val sortedCensusData = CensusObj.getPopulationDensityWiseSortedCensusData
    val censusCSV = new Gson().fromJson(sortedCensusData, classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state == "Bihar")
    assert(censusCSV.last.state == "Arunachal Pradesh")
  }

  test("givenIndianCensusDataAndStateData_whenSortedByPopulation_shouldReturnSortedResult") {
    CensusObj.loadCensusData(Country.India,IndiaCensusCSVFilePath,IndiaStateCodeCSVFilePath)
    val sortedCensusData = CensusObj.getPopulationWiseSortedCensusData
    val censusCSV = new Gson().fromJson(sortedCensusData, classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state == "Uttar Pradesh")
    assert(censusCSV.last.state == "Sikkim")
  }

  test("givenIndianStateData_whenEmptyDataPopulation_shouldReturnException") {
    val CensusObj1 = new CensusAnalyzer()
    val throws = intercept[Exception] {
      CensusObj1.getPopulationWiseSortedCensusData
    }
    assert(throws.getMessage == CensusAnalyzerExceptionEnums.NoCensusData.toString)
  }

  test("givenIndianCensusDataAndStateData_whenSortedByArea_shouldReturnSortedResult") {
    CensusObj.loadCensusData(Country.India,IndiaCensusCSVFilePath,IndiaStateCodeCSVFilePath)
    val sortedCensusData = CensusObj.getAreaWiseSortedCensusData
    val censusCSV = new Gson().fromJson(sortedCensusData, classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state == "Rajasthan")
    assert(censusCSV.last.state == "Goa")
  }

  test("givenIndianStateData_whenEmptyDataArea_shouldReturnException") {
    val CensusObj1 = new CensusAnalyzer()
    val throws = intercept[Exception] {
      CensusObj1.getAreaWiseSortedCensusData
    }
    assert(throws.getMessage == CensusAnalyzerExceptionEnums.NoCensusData.toString)
  }

  test("given_USCensusCSVFile_ShouldReturnCorrectRecords"){
    assert(CensusObj.loadCensusData(Country.USA,USCensusCSVFilePath) == 51)
  }

  test("givenUSCensusData_whenSortedByPopulation_shouldReturnSortedResult") {
    CensusObj.loadCensusData(Country.USA,USCensusCSVFilePath)
    val sortedCensusData = CensusObj.getPopulationWiseSortedCensusData
    val censusCSV = new Gson().fromJson(sortedCensusData, classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state == "California")
    assert(censusCSV.last.state == "Wyoming")
  }
  test("givenUSCensusData_whenSortedByArea_shouldReturnSortedResult"){
    CensusObj.loadCensusData(Country.USA,USCensusCSVFilePath)
    val sortedCensusData = CensusObj.getAreaWiseSortedCensusData
    val censusCSV = new Gson().fromJson(sortedCensusData,classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state == "Alaska")
    assert(censusCSV.last.state == "District of Columbia")
  }

  test("givenUSCensusData_whenSortedByPopulationDensity_shouldReturnSortedResult"){
    CensusObj.loadCensusData(Country.USA,USCensusCSVFilePath)
    val sortedCensusData = CensusObj.getPopulationDensityWiseSortedCensusData

    val censusCSV = new Gson().fromJson(sortedCensusData,classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state == "District of Columbia")
    assert(censusCSV.last.state == "Alaska")
  }

  test("givenUSCensusData_whenSortedByStateWiseSorted_shouldReturnSortedResult"){
    CensusObj.loadCensusData(Country.USA,USCensusCSVFilePath)
    val sortedCensusData = CensusObj.getStateWiseSortedCensusData
    val censusCSV = new Gson().fromJson(sortedCensusData,classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state == "Alabama")
    assert(censusCSV.last.state == "Wyoming")
  }

  test("givenUSCensusData_whenSortedByStateCodeWiseSorted_shouldReturnSortedResult"){
    CensusObj.loadCensusData(Country.USA,USCensusCSVFilePath)
    val sortedCensusData = CensusObj.getStateCodeWiseSortedCensusData
    val censusCSV = new Gson().fromJson(sortedCensusData,classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state == "Alaska")
    assert(censusCSV.last.state == "Wyoming")
  }

  test("givenIndiaCensus&USCensusData_whenSortedByPopulationDensity_shouldReturnSortedResult") {
    CensusObj.loadCensusData(Country.USA, USCensusCSVFilePath)
    val sortedCensusData = CensusObj.getPopulationDensityWiseSortedCensusData
    val censusCSV = new Gson().fromJson(sortedCensusData, classOf[Array[IndiaCensusDTO]])
    assert(censusCSV(0).state === "District of Columbia")

    CensusObj.loadCensusData(Country.India, IndiaCensusCSVFilePath, IndiaStateCodeCSVFilePath)
    val sortedCensusDataIndia = CensusObj.getPopulationDensityWiseSortedCensusData
    val censusCSVIndia = new Gson().fromJson(sortedCensusDataIndia, classOf[Array[IndiaCensusDTO]])
    assert(censusCSVIndia(0).state === "Bihar")
  }

}
