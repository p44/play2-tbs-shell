import play.api.test._
import play.api.test.Helpers._
import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AppControllerSpec extends SpecificationWithJUnit {
  
  import controllers._

  step { println("AppSpec step") }
  
  "The Application Controller" should {
    
    val clist:List[String] = Application.listConfig
    println("clist:  " + clist.mkString(" "))
    
    // step is run here
    
    "Return a config list" in {
      println("clist.size:  %s".format(clist.size))
      clist.size > 0
    }
    
    "Contain my.environment" in {
      val b = clist.exists(_.contains("my.environment"))
      println("Config contains \"my.environment\" == " + b)
      b
    }
  }
  
}