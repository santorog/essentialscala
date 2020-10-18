package setup

import org.scalatest.FunSuite

class SetupTest extends FunSuite {
  test("Setup.cube") {
    assert(Setup.cube(3) == 27)
  }
}


