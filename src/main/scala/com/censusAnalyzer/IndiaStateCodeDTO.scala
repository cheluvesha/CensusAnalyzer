package com.censusAnalyzer


import com.opencsv.bean.CsvBindByName

class IndiaStateCodeDTO {


  @CsvBindByName(column = "SrNo", required = true)
  var SrNo: String = _
  @CsvBindByName(column = "State Name", required = true)
  var stateName: String = _
  @CsvBindByName(column = "TIN", required = true)
  var TIN: Int = 0
  @CsvBindByName(column = "StateCode", required = true)
  var stateCode: String = _

  override def toString: String = "IndiaStateCodeCSV{" +
    "SrNo='" + SrNo + '\'' +
    ", state='" + stateName + '\'' +
    ", TIN='" + TIN + '\'' +
    ", stateCode='" + stateCode + '\'' + '}'
}
