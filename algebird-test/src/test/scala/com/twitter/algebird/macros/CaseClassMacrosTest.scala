package com.twitter.algebird.macros

import com.twitter.algebird._
import com.twitter.algebird.macros.caseclass._
import com.twitter.algebird.macros.ArbitraryCaseClassMacro.arbitrary

import org.scalacheck.{ Properties, Arbitrary }
import org.scalacheck.Prop.forAll

object CaseClassMacrosTest extends Properties("Case class macros") {
  import BaseProperties._

  implicit val arbitraryFoo: Arbitrary[Foo] = arbitrary[Foo]
  implicit val arbitraryBar: Arbitrary[Bar] = arbitrary[Bar]

  case class Foo(a: Int, b: Short, c: Long)
  case class Bar(a: Boolean, foo: Foo)

  property("Foo is a Semigroup") = semigroupLaws[Foo]
  property("Foo is a Monoid") = monoidLaws[Foo]
  property("Foo is a Group") = groupLaws[Foo]
  property("Foo is a Ring") = ringLaws[Foo]

  property("Bar is a Semigroup") = semigroupLaws[Bar]
  property("Bar is a Monoid") = monoidLaws[Bar]
  property("Bar is a Group") = groupLaws[Bar]
  property("Bar is a Ring") = ringLaws[Bar]
}
