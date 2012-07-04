package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
class IntegrationSpec extends Specification {
  
  "Application" should {
    
    "work from within a browser index" in {
      running(TestServer(3333), HTMLUNIT) { browser =>

        browser.goTo("http://localhost:3333/")

        browser.pageSource must contain("Ready for scala coding!")
       
      }
    }
    
    "work from within a browser configdisplay " in {
      running(TestServer(3333), HTMLUNIT) { browser =>

        browser.goTo("http://localhost:3333/configdisplay")

        browser.pageSource must contain("my.environment")
       
      }
    }
    
    "work from within a browser homeforms" in {
      running(TestServer(3333), HTMLUNIT) { browser =>

        browser.goTo("http://localhost:3333/homeforms")

        browser.pageSource must contain("helper.twitterBootstrap")
       
      }
    }
    
    "work from within a browser homeajax" in {
      running(TestServer(3333), HTMLUNIT) { browser =>

        browser.goTo("http://localhost:3333/homeajax")

        browser.pageSource must contain("Ajax")
       
      }
    }
    
  }
  
}