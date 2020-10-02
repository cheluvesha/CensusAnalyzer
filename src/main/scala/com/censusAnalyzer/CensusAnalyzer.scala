package com.censusAnalyzer

import java.nio.file.{Files, Paths}
import java.util
class CensusAnalyzer {
  def loadCSVDataIndiaStateCensus(filePath:String): Int = {
    try {
      if(!filePath.endsWith(".csv")) {
        throw new CensusAnalyzerException(CensusAnalyzerExceptionEnum.InCorrectFile)
      }
      val reader = Files.newBufferedReader(Paths.get(filePath))
      val csvBuilder = CSVBuilderFactory.createCSVBuilder()
      val censusCSVList = csvBuilder.getList(reader,classOf[IndiaStateCensus])
      censusCSVList.size()
    }
    catch {
      case _:java.nio.file.NoSuchFileException => throw new CensusAnalyzerException(CensusAnalyzerExceptionEnum.InCorrectPath)
      case _:CSVBuilderException => throw new CensusAnalyzerException(CensusAnalyzerExceptionEnum.UnableToParse)
    }
  }

  def loadCSVDataIndiaStateCode(filePath:String):Int = {
    try {
      if (!filePath.endsWith(".csv")) {
        throw new CensusAnalyzerException(CensusAnalyzerExceptionEnum.InCorrectFile)
      }
      val fileReader = Files.newBufferedReader(Paths.get(filePath))
      val csvBuilder = CSVBuilderFactory.createCSVBuilder()
      val censusCSVList = csvBuilder.getList(fileReader,classOf[StateCode])
      censusCSVList.size()
    }
    catch {
      case _: java.nio.file.NoSuchFileException => throw new CensusAnalyzerException(CensusAnalyzerExceptionEnum.InCorrectPath)
      case _:CSVBuilderException => throw new CensusAnalyzerException(CensusAnalyzerExceptionEnum.UnableToParse)
    }
  }

  def getCountRows[T](fileIterator: util.Iterator[T]):Int = {
    var countRows = 0
    while(fileIterator.hasNext) {
      countRows += 1
      fileIterator.next()
    }
    countRows
  }
}