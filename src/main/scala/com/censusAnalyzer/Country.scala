package com.censusAnalyzer
import com.censusAnalyzer
/***
 * Country class Which provides Enum type for CensusAnalyzer
 */
object Country extends Enumeration {
  type Country = Value
  val India: censusAnalyzer.Country.Value = Value("India")
  val USA: censusAnalyzer.Country.Value = Value("USA")
}
