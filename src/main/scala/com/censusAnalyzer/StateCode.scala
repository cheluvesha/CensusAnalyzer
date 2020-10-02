package com.censusAnalyzer
import com.opencsv.bean.CsvBindByName

case class StateCode() {
  @CsvBindByName(column = "SrNo", required = true) var SrNo: String = null
  @CsvBindByName(column = "State Name", required = true) var state: String = null
  @CsvBindByName(column = "TIN", required = true) var TIN: Int = 0
  @CsvBindByName(column = "StateCode", required = true) var stateCode: String = null

  override def toString: String = "StateCode{" + "SrNo='" + SrNo + '\''+ ", state='" + state + '\'' + ", TIN='" + TIN + '\'' + ", stateCode='" + stateCode + '\'' + '}'
}