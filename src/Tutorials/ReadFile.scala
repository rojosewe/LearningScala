

/**
 * @author sensefields
 */

package Tutorials

import java.io._
import java.io.IOException

class ReadFile(filePath:String) {

  private val in = new BufferedReader(new FileReader(filePath))
  
  @throws(classOf[IOException])
  def read() = in.read()
}